package com.epam.brest.cources.calculator;

import com.epam.brest.cources.item.DeliveryData;

import java.math.BigDecimal;

/**
 * The interface Calculator.
 */
public interface Calculator {

    /**
     * Calculate cost big decimal.
     *
     * @param deliveryData the delivery data
     * @return the big decimal
     */
    BigDecimal calculateCost(DeliveryData deliveryData);

    /**
     * Calculate cost big decimal.
     *
     * @param weight      the weight
     * @param distance    the distance
     * @param coefficient the coefficient
     * @return the big decimal
     */
    BigDecimal calculateCost(BigDecimal weight, BigDecimal distance, BigDecimal coefficient);

}

