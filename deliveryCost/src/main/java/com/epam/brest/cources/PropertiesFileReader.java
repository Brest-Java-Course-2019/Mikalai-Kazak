package com.epam.brest.cources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class PropertiesFileReader {

  private Properties property = new Properties();
  private FileInputStream fileInputStream;

  public double getPropertyValue(String prop) throws IOException {
    fileInputStream = new FileInputStream(
        "/home/mikalai/IdeaProjects/Mikalai-Kazak/deliveryCost/src/main/resources/cost.properties");
    property.load(fileInputStream);

    return Double.parseDouble(property.getProperty(prop));
  }
}