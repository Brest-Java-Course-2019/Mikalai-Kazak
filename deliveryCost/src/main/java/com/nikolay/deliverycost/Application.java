package com.nikolay.deliverycost;

import java.util.InputMismatchException;

class Application {

    public static void main(String[] args) {

        InputUserData inputUserData = new InputUserData();

        try {

            double price = inputUserData.userInput("Input the price: ");

            double weight = inputUserData.userInput("Input the weight: ");

            double distance = inputUserData.userInput("Input the distance: ");

            DeliveryCost deliveryCost = new DeliveryCost(price, weight, distance);

            IDeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculatorImpl();

            double result = deliveryCostCalculator.calculateCost(deliveryCost);

            deliveryCostCalculator.printResult(result);

        } catch (InputMismatchException | IllegalArgumentException ex) {
            System.err.println("Failed " + ex.getMessage());
        }
    }
}
