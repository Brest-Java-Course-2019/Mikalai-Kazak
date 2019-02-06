package com.epam.brest.cources.item;

import java.math.BigDecimal;

/**
 * The type Delivery data.
 */
public class DeliveryData {

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
   */
  public void setWeight(BigDecimal weight) {
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
   */
  public void setDistance(BigDecimal distance) {
    this.distance = distance;
  }

  @Override
  public String toString() {
    return "DeliveryData: " +
        " weight = " + weight.toString() +
        ", distance = " + distance.toString() +
        ", coefficient = " + coefficient.toString();
  }
}