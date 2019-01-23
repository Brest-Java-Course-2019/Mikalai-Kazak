package com.epam.brest.cources.calculator;

import com.epam.brest.cources.item.DeliveryData;
import java.math.BigDecimal;

/**
 * The type Application.
 */
public class CalculatorImpl implements Calculator {

    @Override
    public BigDecimal calculateCost(DeliveryData deliveryData) {
        return deliveryData.getWeight()
                .add(deliveryData.getDistance().multiply(deliveryData.getCoefficient()));
    }

    @Override
    public BigDecimal calculateCost(BigDecimal weight, BigDecimal distance,
            BigDecimal coefficient) {
        return weight.add(distance).multiply(coefficient);
    }

}
