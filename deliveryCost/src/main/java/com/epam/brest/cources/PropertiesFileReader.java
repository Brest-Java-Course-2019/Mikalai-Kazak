package com.epam.brest.cources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Properties file reader.
 */
class PropertiesFileReader {

  /**
   * Gets property value.
   *
   * @param prop the prop
   * @return the property value
   * @throws IOException the io exception
   */
  public double getPropertyValue(String prop) throws IOException {
    File file = new File("../Mikalai-Kazak/deliveryCost/src/main/resources/cost.properties");
    FileInputStream fileInputStream = new FileInputStream(file);
    Properties property = new Properties();
    property.load(fileInputStream);
    return Double.parseDouble(property.getProperty(prop));
  }
}