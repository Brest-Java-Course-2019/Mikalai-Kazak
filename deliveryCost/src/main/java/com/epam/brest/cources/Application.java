package com.epam.brest.cources;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The type Application.
 */
public class Application {

    public static void main(String[] args) {
        deliveryCalculate();
    }

    /**
     * Delivery calculate.
     */
    private static void deliveryCalculate() {

        Scanner in = new Scanner(System.in);
        PropertiesFileReader propertiesFileReader = new PropertiesFileReader();
        DeliveryCost deliveryCost;

        try {
            System.out.println("Enter distance: ");
            double distance = in.nextDouble();
            System.out.println("Enter weight: ");
            double weight = in.nextDouble();

            deliveryCost = new DeliveryCost(weight, distance);

            if (weight < 15) {
                double minCoef = propertiesFileReader.getPropertyValue("coef.min");
                deliveryCost.setCoefficient(minCoef);
            } else if (weight >= 15 && weight < 30) {
                double middleCoef = propertiesFileReader.getPropertyValue("coef.middle");
                deliveryCost.setCoefficient(middleCoef);
            } else {
                double maxCoef = propertiesFileReader.getPropertyValue("coef.max");
                deliveryCost.setCoefficient(maxCoef);
            }

            System.out.println(
                "Price for delivery: " + deliveryCost.calculateDeliveryCost().toPlainString()
                    + "$");

        } catch (InputMismatchException | IllegalArgumentException | IOException ex) {
            System.err.println("Fail: " + ex.getMessage());
        }
    }
}
