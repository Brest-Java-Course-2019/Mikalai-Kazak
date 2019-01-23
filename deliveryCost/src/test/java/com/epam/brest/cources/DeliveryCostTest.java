package com.epam.brest.cources;

import com.epam.brest.cources.parser.FileParser;
import com.epam.brest.cources.parser.PropertyFileParserImpl;
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
        DeliveryData deliveryData = new DeliveryData(correctValue, correctValue, correctValue);
        BigDecimal actualResult = deliveryData.calculateDeliveryCost();
        BigDecimal correctResult = new BigDecimal(6.25);
        Assertions.assertEquals(correctResult.compareTo(correctResult), 0);
    }

    @Test
    public void testGetProperty() throws IOException {
        FileParser<String, BigDecimal> propertyFileParser = new PropertyFileParserImpl();
        Map<String, BigDecimal> mapValue = propertyFileParser.getMapFromFile("cost.properties");
        BigDecimal actualValue = mapValue.get("coef.max");
        Assertions.assertEquals(minMax.compareTo(actualValue), 0);
    }

}
