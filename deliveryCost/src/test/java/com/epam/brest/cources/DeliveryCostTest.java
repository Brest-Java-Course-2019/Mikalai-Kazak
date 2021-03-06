package com.epam.brest.cources;

import com.epam.brest.cources.calculator.Calculator;
import com.epam.brest.cources.calculator.CalculatorImpl;
import com.epam.brest.cources.item.DeliveryData;
import com.epam.brest.cources.parser.FileParser;
import com.epam.brest.cources.parser.PropertyFileParser;
import com.epam.brest.cources.service.CoefficientSelector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;


/**
 * The type Delivery cost test.
 */
public class DeliveryCostTest {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String FILE_PATH = "cost.properties";
    private static final BigDecimal CORRECT_COEFFICIENT = BigDecimal.valueOf(1.2);
    private static final BigDecimal CORRECT_WEIGHT = new BigDecimal(8);
    private ConsoleInterface ci = new ConsoleInterface();
    private BigDecimal negativeValue = BigDecimal.valueOf(-20);
    private BigDecimal correctValue = BigDecimal.valueOf(2);
    private BigDecimal minMax = BigDecimal.valueOf(2.45);
    private CoefficientSelector coefficientSelector = new CoefficientSelector();


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
    public void testDeliveryCostCalculatorWithOneParam() {
        LOGGER.debug("testDeliveryCostCalculator()");
        Calculator calculator = new CalculatorImpl();
        DeliveryData deliveryData = new DeliveryData(correctValue, correctValue, correctValue);
        BigDecimal actualResult = calculator.calculateCost(deliveryData);
        BigDecimal correctResult = new BigDecimal(6);
        Assertions.assertEquals(correctResult.compareTo(actualResult), 0);
    }

    /**
     * Test delivery cost calculator.
     */
    @Test
    public void testDeliveryCostCalculator() {
        LOGGER.debug("testDeliveryCostCalculator()");
        Calculator calculator = new CalculatorImpl();
        BigDecimal actualResult = calculator.calculateCost(correctValue, correctValue, correctValue);
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

    /**
     * Test property file parser.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testPropertyFileParser() throws IOException {
        LOGGER.debug("testPropertyFileParser()");
        FileParser<Integer, BigDecimal> fileParser = new PropertyFileParser();
        Map<Integer, BigDecimal> valuesMap = fileParser.getMapFromFile(FILE_PATH);
        Assertions.assertEquals(3, valuesMap.size());

    }

    /**
     * Test check input value.
     */
    @Test
    public void testCheckInputValue() {
        LOGGER.debug("testCheckInputValue()");
        ConsoleInterface consoleInterface = new ConsoleInterface();
        Boolean resultValue = consoleInterface.checkInputValue(new BigDecimal(20));
        Assertions.assertTrue(resultValue);
    }


    /**
     * Test select coefficient value from file.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testSelectCoefficientValueFromFile() throws IOException {
        LOGGER.debug("testSelectCoefficientValueFromFile()");
        BigDecimal coef = coefficientSelector.selectCoefficientValueFromFile(FILE_PATH, CORRECT_WEIGHT);
        Assertions.assertEquals(CORRECT_COEFFICIENT, coef);
    }


}
