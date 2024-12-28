package org.cws.streams.part3.model;

public class Address {
    /**
     * Member variables of Address class
     * */
    private String line1;
    private String city;
    private String state; // or province
    private String country;

    /**
     * Static constants representing some Countries, Cities and States
     * */
    public static final String CN_INDIA = "India";
    public static final String CN_US = "US";

    public static final String ST_MAHARASHTRA = "Maharashtra";
    public static final String ST_NEW_YORK = "New York";

    public static final String CT_MUMBAI = "Mumbai";
    public static final String CT_PUNE = "Pune";
    public static final String CT_NEW_YORK = "New York";

    /**
     * Parameterized All Arguments Constructor
     * */
    public Address(String line1, String city, String state, String country) {
        this.line1 = line1;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    /**
     * Static utility methods to create Address objects
     * */
    public static Address inIndia(String line1, String city, String state) {
        return new Address(line1, city, state, CN_INDIA);
    }

    public static Address inMaharashtra(String line1, String city) {
        return new Address(line1, city, ST_MAHARASHTRA, CN_INDIA);
    }

    public static Address inUs(String line1, String city, String state) {
        return new Address(line1, city, state, CN_US);
    }

    public static Address inMumbai(String line1) {
        return new Address(line1, CT_MUMBAI, ST_MAHARASHTRA, CN_INDIA);
    }

    public static Address inPune(String line1) {
        return new Address(line1, CT_PUNE, ST_MAHARASHTRA, CN_INDIA);
    }

    public static Address inNewYork(String line1) {
        return new Address(line1, CT_NEW_YORK, ST_NEW_YORK, CN_INDIA);
    }

    /**
     * Getters and Setters
     * */
    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Address{");
        sb.append("line1='").append(line1).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
