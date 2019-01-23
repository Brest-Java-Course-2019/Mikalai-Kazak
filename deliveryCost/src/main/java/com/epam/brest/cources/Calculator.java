package com.epam.brest.cources;

import com.epam.brest.cources.parser.FileParser;
import com.epam.brest.cources.parser.PropertyFileParserImpl;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * The type Application.
 */
public class Calculator {

  /**
   * Get coefficient from properties.
   *
   * @param weight the param
   * @return {double} coefficient
   * @throws IOException - exception
   */
  private BigDecimal selectPriceValue(BigDecimal weight) throws IOException {
    FileParser<String, BigDecimal> propertyFileParser = new PropertyFileParserImpl();
    Map<String, BigDecimal> valuesMap = propertyFileParser.getMapFromFile("cost.properties");

    if (weight.doubleValue() < 15) {
      return valuesMap.get("coef.min");
    } else if (weight.doubleValue() >= 15 && weight.doubleValue() < 30) {
      return valuesMap.get("coef.middle");
    } else {
      return valuesMap.get("coef.max");
    }
  }

  /**
   * Delivery calculate.
   */
  public void deliveryCalculate() {
    try {
      Scanner scanner = new Scanner(System.in);
      DeliveryData deliveryData = new DeliveryData();
      System.out.println("Enter weight: ");
      BigDecimal weight = scanner.nextBigDecimal();
      deliveryData.setWeight(weight);
      System.out.println("Enter distance: ");
      BigDecimal distance = scanner.nextBigDecimal();
      deliveryData.setDistance(distance);
      BigDecimal coefficient = selectPriceValue(weight);
      deliveryData.setCoefficient(coefficient);
      System.out.println(
          "Price for delivery: " + deliveryData.calculateDeliveryCost().toPlainString()
              + "$");

    } catch (InputMismatchException | IllegalArgumentException | IOException ex) {
      System.err.println("Fail: " + ex.getMessage());
    }
  }
}
