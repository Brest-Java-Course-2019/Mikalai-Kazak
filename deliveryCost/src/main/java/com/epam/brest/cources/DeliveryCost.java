package com.epam.brest.cources;

class DeliveryCost {

    private double price;

    private double weight;

    private double distance;

    public DeliveryCost(double price, double weight, double distance) {
        if (price < 0 || weight < 0 || distance < 0) {
            throw new IllegalArgumentException("Parameters can't be negative");
        }
        this.price = price;
        this.weight = weight;
        this.distance = distance;
    }

    public DeliveryCost() {

    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) throws IllegalArgumentException {
        if (price < 0) {
            throw new IllegalArgumentException("The price can't be negative");
        }
        this.price = price;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) throws IllegalArgumentException {
        if (weight < 0) {
            throw new IllegalArgumentException("The weight can't be negative");
        }
        this.weight = weight;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) throws IllegalArgumentException {
        if (distance < 0) {
            throw new IllegalArgumentException("The distance can't be negative");
        }
        this.distance = distance;
    }

}