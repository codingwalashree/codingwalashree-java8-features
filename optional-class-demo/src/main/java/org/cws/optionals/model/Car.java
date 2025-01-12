package org.cws.optionals.model;

import java.util.Optional;

// Person -> Car -> Insurance
public class Car {
    private Optional<Insurance> insurance;

    public Car(Insurance insurance) {
        this.insurance = Optional.ofNullable(insurance);
    }

    public Optional<Insurance> getInsurance() { return insurance; }
}
