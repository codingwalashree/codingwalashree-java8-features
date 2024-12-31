package org.cws.optionals.model;

// Person -> Car -> Insurance
public class Car {
    private Insurance insurance;

    public Car(Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getInsurance() { return insurance; }
}
