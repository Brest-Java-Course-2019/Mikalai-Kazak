package com.epam.brest.cources;

import java.math.BigDecimal;

/**
 * The type Delivery data.
 */
class DeliveryData {

  private BigDecimal weight;

  private BigDecimal distance;

  private BigDecimal coefficient;

  /**
   * Instantiates a new Delivery data.
   *
   * @param weight the weight
   * @param distance the distance
   * @param coefficient the coefficient
   */
  public DeliveryData(BigDecimal weight, BigDecimal distance, BigDecimal coefficient) {
    if (weight.signum() <= 0 || distance.signum() <= 0 || coefficient.signum() < 0) {
      throw new IllegalArgumentException("Parameters can't be negative or zero");
    }
    this.coefficient = coefficient;
    this.weight = weight;
    this.distance = distance;
  }

  /**
   * Instantiates a new Delivery data.
   *
   * @param weight the weight
   * @param distance the distance
   */
  public DeliveryData(BigDecimal weight, BigDecimal distance) {
    if (weight.signum() <= 0 || distance.signum() <= 0) {
      throw new IllegalArgumentException("Parameters can't be negative or zero");
    }
    this.weight = weight;
    this.distance = distance;
  }

  /**
   * Instantiates a new Delivery data.
   */
  public DeliveryData() {

  }

  /**
   * Gets coefficient.
   *
   * @return the coefficient
   */
  public BigDecimal getCoefficient() {
    return coefficient;
  }

  /**
   * Sets coefficient.
   *
   * @param coefficient the coefficient
   */
  public void setCoefficient(BigDecimal coefficient) {
    if (coefficient.signum() <= 0) {
      throw new IllegalArgumentException("The coefficient can't be negative");
    }
    this.coefficient = coefficient;
  }

  /**
   * Gets weight.
   *
   * @return the weight
   */
  public BigDecimal getWeight() {
    return this.weight;
  }

  /**
   * Sets weight.
   *
   * @param weight the weight
   * @throws IllegalArgumentException the illegal argument exception
   */
  public void setWeight(BigDecimal weight) throws IllegalArgumentException {
    if (weight.signum() <= 0) {
      throw new IllegalArgumentException("The weight can't be negative");
    }
    this.weight = weight;
  }

  /**
   * Gets distance.
   *
   * @return the distance
   */
  public BigDecimal getDistance() {
    return this.distance;
  }

  /**
   * Sets distance.
   *
   * @param distance the distance
   * @throws IllegalArgumentException the illegal argument exception
   */
  public void setDistance(BigDecimal distance) throws IllegalArgumentException {
    if (distance.signum() <= 0) {
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
    return (weight.add(distance)).multiply(coefficient);
  }


}