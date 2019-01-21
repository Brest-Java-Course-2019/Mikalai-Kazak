package com.epam.brest.cources;

import java.math.BigDecimal;

class DeliveryCost {

    private double weight;

    private double distance;

    private double coefficient;

    public DeliveryCost(double weight, double distance, double coefficient) {
        if (weight <= 0 || distance <= 0 || coefficient < 0) {
            throw new IllegalArgumentException("Parameters can't be negative or zero");
        }
        this.coefficient = coefficient;
        this.weight = weight;
        this.distance = distance;
    }

    public DeliveryCost(double weight, double distance) {
        if (weight <= 0 || distance <= 0) {
            throw new IllegalArgumentException("Parameters can't be negative or zero");
        }
        this.weight = weight;
        this.distance = distance;
    }

    public DeliveryCost() {

    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        if (coefficient <= 0) {
            throw new IllegalArgumentException("The coefficient can't be negative");
        }
        this.coefficient = coefficient;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) throws IllegalArgumentException {
      if (weight <= 0) {
            throw new IllegalArgumentException("The weight can't be negative");
        }
        this.weight = weight;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) throws IllegalArgumentException {
        if (distance <= 0) {
            throw new IllegalArgumentException("The distance can't be negative");
        }
        this.distance = distance;
    }

    public BigDecimal calculateDeliveryCost() {
        return BigDecimal.valueOf((distance + weight) * coefficient);
    }


}