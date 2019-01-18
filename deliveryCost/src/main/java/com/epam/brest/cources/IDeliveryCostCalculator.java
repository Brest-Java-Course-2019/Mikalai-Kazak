package com.epam.brest.cources;

public interface IDeliveryCostCalculator {

    void printResult(double result);

    double calculateCost(DeliveryCost deliveryCost);
}
