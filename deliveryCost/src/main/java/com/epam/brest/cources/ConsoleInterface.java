package com.epam.brest.cources;

import com.epam.brest.cources.item.DeliveryData;
import com.epam.brest.cources.parser.FileParser;
import com.epam.brest.cources.parser.PropertyFileParser;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

/**
 * The type Console interface.
 */
public class ConsoleInterface {

    private static final String PREFIX = "Enter ";
    private static final String[] MESSAGES = {"weight in kg", "distance in km"};
    private Scanner scanner;
    private FileParser<String, BigDecimal> fileParser;
    private DeliveryData deliveryData;

    /**
     * Instantiates a new Console interface.
     */
    public ConsoleInterface() {
        this.fileParser = new PropertyFileParser();
        this.scanner = new Scanner(System.in);
        this.deliveryData = new DeliveryData();
    }

    private BigDecimal receiveValueFromConsole(String message) {
        System.out.println(message);
        return scanner.nextBigDecimal();
    }

    /**
     * Gets delivery data.
     *
     * @return the delivery data
     * @throws IOException the io exception
     */
    public DeliveryData getDeliveryData() throws IOException {
        BigDecimal weight = receiveValueFromConsole(PREFIX + MESSAGES[0]);
        deliveryData.setWeight(weight);
        BigDecimal distance = receiveValueFromConsole(PREFIX + MESSAGES[1]);
        deliveryData.setDistance(distance);
        Map<String, BigDecimal> map = fileParser.getMapFromFile("cost.properties");
        BigDecimal coefficient = selectPriceValue(map, weight);
        deliveryData.setCoefficient(coefficient);
        return deliveryData;
    }

    /**
     * Get coefficient.
     *
     * @param valuesMap the map
     * @param weight the weight
     * @return the coefficient
     */
    private BigDecimal selectPriceValue(Map<String, BigDecimal> valuesMap, BigDecimal weight) {
        if (weight.doubleValue() < 15) {
            return valuesMap.get("coef.min");
        } else if (weight.doubleValue() >= 15 && weight.doubleValue() < 30) {
            return valuesMap.get("coef.middle");
        } else {
            return valuesMap.get("coef.max");
        }
    }
}
