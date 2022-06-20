package connection;

import java.sql.*;
import java.util.logging.Logger;

/**
 * Factory for class responsible for database connection.
 *
 * @author Daniel Reckerth
 */
public class ConnectionFactory {
  private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
  private static final String DRIVER = "com.mysql.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost:3306/order_management";
  private static final String USER = "root";
  private static final String PASSWORD = "admin";

  private static final ConnectionFactory singleInstance = new ConnectionFactory();

  private ConnectionFactory() {
    try {
      Class.forName(DRIVER);
    } catch (ClassNotFoundException e) {
      LOGGER.severe("Driver not found");
    }
  }

  /**
   * Get single instance of connection factory.
   *
   * @return Single instance of connection factory
   */
  private Connection createConnection() {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (SQLException e) {
      LOGGER.warning("Connection failed");
      e.printStackTrace();
    }
    return connection;
  }

  /**
   * Get single instance of connection factory.
   *
   * @return Single instance of connection factory
   */
  public static Connection getConnection() {
    return singleInstance.createConnection();
  }

  /**
   * Close connection.
   *
   * @param connection Connection to close
   */
  public static void close(Connection connection) {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        LOGGER.warning("Connection close failed");
        e.printStackTrace();
      }
    }
  }

  /**
   * Close statement.
   *
   * @param statement Statement to close
   */
  public static void close(Statement statement) {
    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException e) {
        LOGGER.warning("Statement close failed");
        e.printStackTrace();
      }
    }
  }

  /**
   * Close result set.
   *
   * @param resultSet Result set to close
   */
  public static void close(ResultSet resultSet) {
    if (resultSet != null) {
      try {
        resultSet.close();
      } catch (SQLException e) {
        LOGGER.warning("ResultSet close failed");
        e.printStackTrace();
      }
    }
  }
}
