package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import static connection.ConnectionFactory.close;
import static connection.ConnectionFactory.getConnection;

/**
 * Abstract Data Access Object (DAO)
 *
 * @param <T> Type of entity
 * @author Daniel Reckerth
 */
public class AbstractDAO<T> {
  protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
  private final Class<T> type;

  @SuppressWarnings("unchecked")
  public AbstractDAO() {
    this.type = (Class<T>) ((ParameterizedType) getClass()
        .getGenericSuperclass())
        .getActualTypeArguments()[0];
  }

  /**
   * Get all entities
   *
   * @return List of entities
   */
  public List<T> findAll() {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String query = "SELECT * FROM order_management.%s".formatted(type.getSimpleName());
    try {
      connection = getConnection();
      statement = connection.prepareStatement(query);
      resultSet = statement.executeQuery();
      return createObjects(resultSet);
    } catch (SQLException throwables) {
      LOGGER.warning(type.getName() + " DAO:findAll " + throwables.getMessage());
      throwables.printStackTrace();
    } finally {
      close(resultSet);
      close(statement);
      close(connection);
    }
    return null;
  }

  /**
   * Get entity by id
   *
   * @param id Id of entity
   * @return Entity found
   */
  public T findById(int id) {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String query = "SELECT * FROM order_management.%s WHERE id = ?".formatted(type.getSimpleName().toLowerCase());
    try {
      connection = getConnection();
      statement = connection.prepareStatement(query);
      statement.setInt(1, id);
      resultSet = statement.executeQuery();

      final List<T> objects = createObjects(resultSet);
      if (objects.size() > 0) {
        return objects.get(0);
      } else {
        return null;
      }
    } catch (SQLException e) {
      LOGGER.warning(type.getName() + " DAO:findById " + e.getMessage());
      e.printStackTrace();
    } finally {
      close(resultSet);
      close(statement);
      close(connection);
    }
    return null;
  }

  /**
   * Create entity
   *
   * @param object Object to create
   * @return True if created, false otherwise
   */
  public boolean save(T object) {
    Connection connection = null;
    PreparedStatement statement = null;
    String query = createInsertQuery(type.getSimpleName().toLowerCase(), getClassFieldsNameForQuery(object), type.getDeclaredFields().length);
    try {
      connection = getConnection();
      statement = connection.prepareStatement(query);
      int position = 1;
      for (Field field : type.getDeclaredFields()) {
        field.setAccessible(true);
        statement.setObject(position, field.get(object));
        position++;
      }
      statement.executeUpdate();
      return true;
    } catch (SQLException | IllegalAccessException throwables) {
      LOGGER.warning(type.getName() + " DAO:save " + throwables.getMessage());
      throwables.printStackTrace();
    } finally {
      close(statement);
      close(connection);
    }
    return false;
  }

  /**
   * Update entity
   *
   * @param id     Id of entity to update
   * @param object Updating object
   * @return True if updated, false otherwise
   */
  public boolean update(int id, T object) {
    Connection connection = null;
    PreparedStatement statement = null;
    String updateQuery = createUpdateQuery(type.getSimpleName().toLowerCase(), type.getDeclaredFields());
    try {
      connection = getConnection();
      statement = connection.prepareStatement(updateQuery);
      int position = 1;
      for (Field field : type.getDeclaredFields()) {
        field.setAccessible(true);
        statement.setObject(position, field.get(object));
        position++;
      }
      statement.setInt(position, id);
      statement.executeUpdate();
      return true;
    } catch (SQLException | IllegalAccessException throwables) {
      LOGGER.warning(type.getName() + " DAO:update " + throwables.getMessage());
      throwables.printStackTrace();
    } finally {
      close(statement);
      close(connection);
    }

    return false;
  }

  /**
   * Delete entity
   *
   * @param id Id of entity to delete
   * @return True if deleted, false otherwise
   */
  public boolean deleteById(int id) {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String query = "DELETE FROM order_management.%s WHERE id = ?".formatted(type.getSimpleName().toLowerCase());
    try {
      connection = getConnection();
      statement = connection.prepareStatement(query);
      statement.setInt(1, id);
      statement.executeUpdate();
      return true;
    } catch (SQLException e) {
      LOGGER.warning(type.getName() + " DAO:deleteById " + e.getMessage());
      e.printStackTrace();
    } finally {
      close(statement);
      close(connection);
    }
    return false;
  }

  /**
   * Create insert query
   *
   * @param className      Table name
   * @param valuesDeclared Fields of the table as string
   * @param numberOfFields Number of fields
   */
  private String createInsertQuery(String className, String valuesDeclared, int numberOfFields) {
    StringBuilder query = new StringBuilder("INSERT INTO order_management." + className + "(" + valuesDeclared + ") VALUES(");
    for (int i = 0; i < numberOfFields; i++) {
      query.append("?");
      if (i != numberOfFields - 1) {
        query.append(", ");
      }
    }
    query.append(")");
    return query.toString();
  }

  /**
   * Create update query
   *
   * @param className Table name
   * @param fields    Fields of the table
   */
  private String createUpdateQuery(String className, Field[] fields) {
    StringBuilder query = new StringBuilder("UPDATE order_management." + className + " SET ");
    for (int i = 0; i < fields.length; i++) {
      query.append(fields[i].getName()).append(" = ?");
      if (i != fields.length - 1) {
        query.append(", ");
      }
    }
    query.append(" WHERE id = ?");
    return query.toString();
  }

  /**
   * Get fields name of the table as string
   *
   * @param object Object to get fields name
   * @return Fields name of the table as string
   */
  private String getClassFieldsNameForQuery(T object) {
    Class<?> objectClass = object.getClass();
    Field[] classFields = objectClass.getDeclaredFields();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < classFields.length; i++) {
      stringBuilder.append(classFields[i].getName());
      if (i != classFields.length - 1) {
        stringBuilder.append(", ");
      }
    }
    return stringBuilder.toString();
  }

  /**
   * Create objects from result set
   *
   * @param resultSet Result set
   * @return List of objects
   */
  private List<T> createObjects(ResultSet resultSet) {
    List<T> list = new ArrayList<>();
    Constructor[] constructors = type.getDeclaredConstructors();
    Constructor constructor = null;

    for (Constructor item : constructors) {
      constructor = item;
      if (constructor.getGenericParameterTypes().length == 0) {
        break;
      }
    }

    try {
      while (resultSet.next()) {
        Objects.requireNonNull(constructor).setAccessible(true);
        T instance = (T) constructor.newInstance();
        for (Field field : type.getDeclaredFields()) {
          String fieldName = field.getName();
          Object value = resultSet.getObject(fieldName);
          if (value instanceof java.sql.Date) {
            value = ((Date) value).toLocalDate();
          }
          PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
          Method method = propertyDescriptor.getWriteMethod();
          method.invoke(instance, value);
        }
        list.add(instance);
      }
    } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException |
             IntrospectionException throwables) {
      throwables.printStackTrace();
    }
    return list;
  }

}
