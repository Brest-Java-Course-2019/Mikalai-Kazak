package com.epam.brest.cources;

import static org.junit.Assert.assertEquals;

import com.epam.brest.cources.DeliveryCost;
import com.epam.brest.cources.DeliveryCostCalculatorImpl;
import org.junit.Test;

public class DeliveryCostTest {

    private double correctResult = 9;

    @Test(expected = IllegalArgumentException.class)
    public void testInputNegativePrice() {
        DeliveryCost delivery = new DeliveryCost();
        delivery.setPrice(-20);
    }

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
        DeliveryCostCalculatorImpl deliveryCostCalculatorImpl = new DeliveryCostCalculatorImpl();
        DeliveryCost deliveryCost = new DeliveryCost(2, 3, 4);
        double actualResult = deliveryCostCalculatorImpl.calculateCost(deliveryCost);
        assertEquals(correctResult, actualResult, 0);
    }

}
