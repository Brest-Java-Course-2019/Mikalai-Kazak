package com.epam.brest.cources;

import com.epam.brest.cources.calculator.Calculator;
import com.epam.brest.cources.calculator.CalculatorImpl;
import com.epam.brest.cources.item.DeliveryData;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * The type Runner.
 */
public class Runner {

  private static final Logger LOGGER = LogManager.getLogger();

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Calculator calculator = new CalculatorImpl();
    ConsoleInterface consoleInterface = new ConsoleInterface();
    DeliveryData deliveryData;
    try {
      deliveryData = consoleInterface.getDeliveryData();
      BigDecimal totalPrice = calculator.calculateCost(deliveryData);
      LOGGER.info("Total price = {}$", totalPrice.toPlainString());
    } catch (Exception e) {
      LOGGER.error("An error has occurred: {}", e.getLocalizedMessage());
    }
  }
}
