package com.epam.brest.cources.calculator;

import com.epam.brest.cources.item.DeliveryData;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    return weight.add(distance).multiply(coefficient);
  }

}
