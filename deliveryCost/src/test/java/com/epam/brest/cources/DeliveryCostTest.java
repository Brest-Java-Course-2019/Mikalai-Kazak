package com.epam.brest.cources;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class DeliveryCostTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInputNegativeWight() {
        DeliveryCost delivery = new DeliveryCost();
        delivery.setWeight(-20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputNegativeDistance() {
        DeliveryCost delivery = new DeliveryCost();
        delivery.setDistance(-20);
    }

    @Test
    public void testDeliveryCostCalculator() {
        DeliveryCost deliveryCost = new DeliveryCost(2, 3, 1.25);
        BigDecimal actualResult = deliveryCost.calculateDeliveryCost();
        BigDecimal correctResult = new BigDecimal(6.25);
        assertEquals(correctResult.compareTo(actualResult), 0);
    }

    @Test
    public void testGetProperty() throws IOException {
        PropertiesFileReader propertiesFileReader = new PropertiesFileReader();
        double actualValue = propertiesFileReader.getPropertyValue("coef.max");
        Assert.assertEquals(2.45, actualValue, 0);
    }

}
