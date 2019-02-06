package com.epam.brest.cources;

import com.epam.brest.cources.calculator.Calculator;
import com.epam.brest.cources.calculator.CalculatorImpl;
import com.epam.brest.cources.item.DeliveryData;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The type Delivery cost test.
 */
public class DeliveryCostTest {

  private static final Logger LOGGER = LogManager.getLogger();

  private ConsoleInterface ci = new ConsoleInterface();

  private BigDecimal negativeValue = BigDecimal.valueOf(-20);
  private BigDecimal correctValue = BigDecimal.valueOf(2);
  private BigDecimal minMax = BigDecimal.valueOf(2.45);

  /**
   * Sets .
   */
  @BeforeAll
  static void setup() {
    System.out.println("@BeforeAll - executes once before all test methods in this class");
  }

  /**
   * Init.
   */
  @BeforeEach
  void init() {
    System.out.println("@BeforeEach - executes before each test method in this class");
  }

  /**
   * Test delivery cost calculator.
   */
  @Test
  public void testDeliveryCostCalculator() {
    LOGGER.debug("testDeliveryCostCalculator()");
    Calculator calculator = new CalculatorImpl();
    DeliveryData deliveryData = new DeliveryData(correctValue, correctValue, correctValue);
    BigDecimal actualResult = calculator.calculateCost(deliveryData);
    BigDecimal correctResult = new BigDecimal(6);
    Assertions.assertEquals(correctResult.compareTo(actualResult), 0);
  }

  /**
   * Test check correct input value method.
   */
  @Test
  public void testCheckCorrectInputValueMethod() {
    LOGGER.debug("testCheckCorrectInputValueMethod()");
    boolean actual = ci.checkInputValue(minMax);
    Assertions.assertTrue(actual);
  }

  /**
   * Test check negative input value method.
   */
  @Test
  public void testCheckNegativeInputValueMethod() {
    LOGGER.debug("testCheckNegativeInputValueMethod()");
    boolean actual = ci.checkInputValue(negativeValue);
    Assertions.assertFalse(actual);
  }
}
