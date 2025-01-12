package org.cws.optionals.model;

import java.util.Optional;

// Person -> Car -> Insurance
public class Person {
    private Optional<Car> car;

    public Person(Car car) {
        this.car = Optional.ofNullable(car);
    }

    public Optional<Car> getCar() { return car; }

    public String getInsuranceCompanyName() {
        // TODO: To be implemented
        return null;
    }
}
