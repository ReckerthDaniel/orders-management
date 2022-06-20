package utils;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Utility class to write to a file.
 *
 * @author Daniel Reckerth
 */
public class FileWriter {

  /**
   * Writes a given text string to a file.
   *
   * @param fileName the name of the file
   * @param content  the content to write to the file
   */
  public static void writeToFile(String fileName, String content) {
    try (BufferedWriter br = new BufferedWriter(new java.io.FileWriter(fileName, true))) {
      br.write(content);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
