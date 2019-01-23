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

public class DeliveryCostTest {

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
    public void testInputNegativeWight() {
        DeliveryData delivery = new DeliveryData();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> delivery.setWeight(negativeValue));
    }

    @Test
    public void testInputNegativeDistance() {
        DeliveryData delivery = new DeliveryData();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> delivery.setDistance(negativeValue));
    }

    @Test
    public void testInputNegativeCoeff() {
        DeliveryData delivery = new DeliveryData();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> delivery.setCoefficient(negativeValue));
    }

    @Test
    public void testDeliveryCostCalculator() {
        Calculator calculator = new CalculatorImpl();
        DeliveryData deliveryData = new DeliveryData(correctValue, correctValue, correctValue);
        BigDecimal actualResult = calculator.calculateCost(deliveryData);
        BigDecimal correctResult = new BigDecimal(6);
        Assertions.assertEquals(correctResult.compareTo(actualResult), 0);
    }

    @Test
    public void testGetProperty() throws IOException {
        FileParser<String, BigDecimal> fileParser = new PropertyFileParser();
        Map<String, BigDecimal> mapValue = fileParser.getMapFromFile("cost.properties");
        BigDecimal actualValue = mapValue.get("coef.max");
        Assertions.assertEquals(minMax.compareTo(actualValue), 0);
    }

}
