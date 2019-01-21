package com.epam.brest.cources;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The type Application.
 */
public class Application {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        PropertiesFileReader propertiesFileReader = new PropertiesFileReader();

        DeliveryCost deliveryCost;

        try {
            System.out.println("Enter distance: ");
            double distance = in.nextDouble();
            System.out.println("Enter weight: ");
            double weight = in.nextDouble();

            deliveryCost = new DeliveryCost(weight, distance);

            double minCoef = propertiesFileReader.getPropertyValue("coef.min");
            double middleCoef = propertiesFileReader.getPropertyValue("coef.middle");
            double maxCoef = propertiesFileReader.getPropertyValue("coef.max");

            if (weight < 15) {
                deliveryCost.setCoefficient(minCoef);
            } else if (weight >= 15 && weight < 30) {
                deliveryCost.setCoefficient(middleCoef);
            } else {
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
