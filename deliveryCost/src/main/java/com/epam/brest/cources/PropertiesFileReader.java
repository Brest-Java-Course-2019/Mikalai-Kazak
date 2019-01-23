package com.epam.brest.cources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Objects;

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
    String paths = Objects.requireNonNull(PropertiesFileReader.class.getClassLoader().getResource("cost.properties")).getPath();
    FileInputStream fileInputStream = new FileInputStream(paths);
    Properties property = new Properties();
    property.load(fileInputStream);
    return Double.parseDouble(property.getProperty(prop));
  }
}
