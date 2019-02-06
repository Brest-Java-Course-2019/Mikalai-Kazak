package com.epam.brest.cources;

import com.epam.brest.cources.item.DeliveryData;
import com.epam.brest.cources.service.CoefficientSelector;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Console interface.
 */
public class ConsoleInterface {

  private static final Logger LOGGER = LogManager.getLogger();

  private static final String PREFIX = "Enter ";
  private static final String[] MESSAGES = {"weight in kg", "distance in km"};
  private static final String PROPERTY_FILE = "cost.properties";

  private Scanner scanner;
  private DeliveryData deliveryData;

  /**
   * Instantiates a new Console interface.
   */
  public ConsoleInterface() {
    this.scanner = new Scanner(System.in);
    this.deliveryData = new DeliveryData();
  }

  private BigDecimal receiveValueFromConsole(String message) {
    LOGGER.debug("receiveValueFromConsole({})", message);
    System.out.println(message);
    BigDecimal inputValue = scanner.nextBigDecimal();
    if (checkInputValue(inputValue)) {
      return inputValue;
    } else {
      throw new IllegalArgumentException("Parameters can't be negative or zero");
    }
  }

  /**
   * Check input value boolean.
   *
   * @param inputValue the input value
   * @return the boolean
   */
  public boolean checkInputValue(BigDecimal inputValue) {
    LOGGER.debug("checkInputValue({})", inputValue);
    return inputValue.signum() > 0;
  }

  /**
   * Gets delivery data.
   *
   * @return the delivery data
   * @throws IOException the io exception
   * @throws IllegalAccessException the illegal access exception
   */
  DeliveryData getDeliveryData() throws IOException, IllegalAccessException {
    LOGGER.debug("getDeliveryData()");
    CoefficientSelector coefficientSelector = new CoefficientSelector();
    BigDecimal weight = receiveValueFromConsole(PREFIX + MESSAGES[0]);
    deliveryData.setWeight(weight);
    BigDecimal distance = receiveValueFromConsole(PREFIX + MESSAGES[1]);
    deliveryData.setDistance(distance);
    BigDecimal coefficient = coefficientSelector
        .selectCoefficientValueFromFile(PROPERTY_FILE, weight);
    deliveryData.setCoefficient(coefficient);
    return deliveryData;
  }
}
