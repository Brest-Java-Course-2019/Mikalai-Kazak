package com.epam.brest.cources;

import java.math.BigDecimal;

/**
 * The type Delivery cost.
 */
class DeliveryCost {

    private double weight;

    private double distance;

    private double coefficient;

    /**
     * Instantiates a new Delivery cost.
     *
     * @param weight the weight
     * @param distance the distance
     * @param coefficient the coefficient
     */
    public DeliveryCost(double weight, double distance, double coefficient) {
        if (weight <= 0 || distance <= 0 || coefficient < 0) {
            throw new IllegalArgumentException("Parameters can't be negative or zero");
        }
        this.coefficient = coefficient;
        this.weight = weight;
        this.distance = distance;
    }

    /**
     * Instantiates a new Delivery cost.
     *
     * @param weight the weight
     * @param distance the distance
     */
    public DeliveryCost(double weight, double distance) {
        if (weight <= 0 || distance <= 0) {
            throw new IllegalArgumentException("Parameters can't be negative or zero");
        }
        this.weight = weight;
        this.distance = distance;
    }

    /**
     * Instantiates a new Delivery cost.
     */
    public DeliveryCost() {

    }

    /**
     * Gets coefficient.
     *
     * @return the coefficient
     */
    public double getCoefficient() {
        return coefficient;
    }

    /**
     * Sets coefficient.
     *
     * @param coefficient the coefficient
     */
    public void setCoefficient(double coefficient) {
        if (coefficient <= 0) {
            throw new IllegalArgumentException("The coefficient can't be negative");
        }
        this.coefficient = coefficient;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setWeight(double weight) throws IllegalArgumentException {
      if (weight <= 0) {
            throw new IllegalArgumentException("The weight can't be negative");
        }
        this.weight = weight;
    }

    /**
     * Gets distance.
     *
     * @return the distance
     */
    public double getDistance() {
        return this.distance;
    }

    /**
     * Sets distance.
     *
     * @param distance the distance
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setDistance(double distance) throws IllegalArgumentException {
        if (distance <= 0) {
            throw new IllegalArgumentException("The distance can't be negative");
        }
        this.distance = distance;
    }

    /**
     * Calculate delivery cost big decimal.
     *
     * @return the big decimal
     */
    public BigDecimal calculateDeliveryCost() {
        return BigDecimal.valueOf((distance + weight) * coefficient);
    }


}