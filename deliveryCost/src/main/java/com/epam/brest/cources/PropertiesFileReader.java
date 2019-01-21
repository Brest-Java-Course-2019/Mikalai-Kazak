package com.epam.brest.cources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Properties file reader.
 */
class PropertiesFileReader {

  private Properties property = new Properties();
  private FileInputStream fileInputStream;

  /**
   * Gets property value.
   *
   * @param prop the prop
   * @return the property value
   * @throws IOException the io exception
   */
  public double getPropertyValue(String prop) throws IOException {
    fileInputStream = new FileInputStream(
        "/home/mikalai/IdeaProjects/Mikalai-Kazak/deliveryCost/src/main/resources/cost.properties");
    property.load(fileInputStream);

    return Double.parseDouble(property.getProperty(prop));
  }
}