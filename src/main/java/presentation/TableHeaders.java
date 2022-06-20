package presentation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Generate JTable column headers and data rows using reflection.
 *
 * @author Daniel Reckerth
 */
public class TableHeaders {

  /**
   * Generate JTable column headers using reflection
   *
   * @param object Object to generate column headers for. Can be Client, Order, Product, PurchaseOrder
   * @return List of column headers
   */
  public static String[] generateTableHeaders(Object object) {
    List<String> headers = new ArrayList<>();
    for (Field field : object.getClass().getDeclaredFields()) {
      headers.add(field.getName());
    }
    return headers.toArray(new String[0]);
  }

  /**
   * Generate JTable data row using reflection
   *
   * @param object Object to generate data row for. Can be Client, Order, Product, PurchaseOrder
   * @return List of data row
   */
  public static List<String> generateTableRow(Object object) {
    List<String> row = new ArrayList<>();
    for (Field field : object.getClass().getDeclaredFields()) {
      field.setAccessible(true);
      try {
        row.add(String.valueOf(field.get(object)));
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    return row;
  }
}
