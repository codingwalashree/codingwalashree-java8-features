package org.cws.optionals.model;

// Person -> Car -> Insurance
public class Insurance {
    private String companyName;

    public Insurance(String companyName) {
        this.companyName = companyName;
    }

    public String getName() { return companyName; }
}
