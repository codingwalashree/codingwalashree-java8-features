package org.cws.optionals.model;

// Person -> Car -> Insurance
public class Person {
    private Car car;

    public Person(Car car) {
        this.car = car;
    }

    public Car getCar() { return car; }

    public String getInsuranceCompanyName() {
        // TODO: To be implemented
        return null;
    }
}
