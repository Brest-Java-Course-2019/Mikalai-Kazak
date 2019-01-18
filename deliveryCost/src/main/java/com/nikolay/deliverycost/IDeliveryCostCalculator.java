package com.nikolay.deliverycost;

public interface IDeliveryCostCalculator {

    void printResult(double result);

    double calculateCost(DeliveryCost deliveryCost);
}
