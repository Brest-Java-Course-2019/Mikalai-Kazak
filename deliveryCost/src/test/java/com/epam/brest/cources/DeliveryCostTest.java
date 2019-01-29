package com.epam.brest.cources;

import com.epam.brest.cources.calculator.Calculator;
import com.epam.brest.cources.calculator.CalculatorImpl;
import com.epam.brest.cources.item.DeliveryData;
import com.epam.brest.cources.parser.FileParser;
import com.epam.brest.cources.parser.PropertyFileParser;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DeliveryCostTest {

    private static final Logger LOGGER = LogManager.getLogger();

    private ConsoleInterface ci = new ConsoleInterface();

    private BigDecimal negativeValue = BigDecimal.valueOf(-20);
    private BigDecimal correctValue = BigDecimal.valueOf(2);
    private BigDecimal minMax = BigDecimal.valueOf(2.45);

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - executes before each test method in this class");
    }

    @Test
    public void testDeliveryCostCalculator() {
        LOGGER.debug("testDeliveryCostCalculator()");
        Calculator calculator = new CalculatorImpl();
        DeliveryData deliveryData = new DeliveryData(correctValue, correctValue, correctValue);
        BigDecimal actualResult = calculator.calculateCost(deliveryData);
        BigDecimal correctResult = new BigDecimal(6);
        Assertions.assertEquals(correctResult.compareTo(actualResult), 0);
    }

    @Test
    public void testCheckCorrectInputValueMethod() {
        LOGGER.debug("testCheckCorrectInputValueMethod()");
        boolean actual = ci.checkInputValue(minMax);
        Assertions.assertTrue(actual);
    }

    @Test
    public void testCheckNegativeInputValueMethod() {
        LOGGER.debug("testCheckNegativeInputValueMethod()");
        boolean actual = ci.checkInputValue(negativeValue);
        Assertions.assertFalse(actual);
    }
}
