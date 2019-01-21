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
        try {
            System.out.println("Enter distance: ");
            double distance = in.nextDouble();
            System.out.println("Enter weight: ");
            double weight = in.nextDouble();
            double coefficient = calculateCoefficient(weight);
            DeliveryCost deliveryCost = new DeliveryCost(weight, distance, coefficient);
            System.out.println(
                "Price for delivery: " + deliveryCost.calculateDeliveryCost().toPlainString()
                    + "$");

        } catch (InputMismatchException | IllegalArgumentException | IOException ex) {
            System.err.println("Fail: " + ex.getMessage());
        }
    }

    public static double calculateCoefficient(double weight) throws IOException {
        PropertiesFileReader propertiesFileReader = new PropertiesFileReader();
        if (weight < 15) {
            return propertiesFileReader.getPropertyValue("coef.min");
        } else if (weight >= 15 && weight < 30) {
            return propertiesFileReader.getPropertyValue("coef.middle");
        } else {
            return propertiesFileReader.getPropertyValue("coef.max");
        }
    }
}
