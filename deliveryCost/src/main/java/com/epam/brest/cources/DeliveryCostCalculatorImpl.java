package com.epam.brest.cources;

class DeliveryCostCalculatorImpl implements IDeliveryCostCalculator {


    @Override
    public void printResult(double result) {
        System.out.print("All the cost " + result + " $ ");
    }

    @Override
    public double calculateCost(DeliveryCost deliveryCost) throws IllegalArgumentException {

        double price = deliveryCost.getPrice();
        double distance = deliveryCost.getDistance();
        double weight = deliveryCost.getWeight();
        return price + distance + weight;
    }

}