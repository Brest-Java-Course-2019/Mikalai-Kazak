package com.epam.brest.cources.calculator;

import com.epam.brest.cources.item.DeliveryData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

/**
 * The type Calculator.
 */
public class CalculatorImpl implements Calculator {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public BigDecimal calculateCost(DeliveryData deliveryData) {
        LOGGER.debug("calculateCost({})", deliveryData);
        return deliveryData.getWeight()
                .add(deliveryData.getDistance().multiply(deliveryData.getCoefficient()));
    }

    @Override
    public BigDecimal calculateCost(BigDecimal weight, BigDecimal distance,
                                    BigDecimal coefficient) {
        LOGGER.debug("calculateCost({}, {}, {})", weight, distance, coefficient);
        return weight.add(distance.multiply(coefficient));
    }

}
