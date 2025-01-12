package org.cws.optionals;

import org.cws.optionals.model.Car;
import org.cws.optionals.model.Insurance;
import org.cws.optionals.model.Person;

import java.util.Optional;

public class OptionalClassDemo {
    public static void main(String[] args) {
        // createOptionals();
        // getIfPresentDemo();
        // filterMapDemo();
        flatMapDemo();
    }

    static void flatMapDemo() {
        Insurance insurance = new Insurance("ABC Insurance Ltd.");
        Car car = new Car(insurance);
        Person person = new Person(car);

        int length = Optional.of(person)
                .flatMap(p -> p.getCar())
                .flatMap(c -> c.getInsurance())
                .map(i -> i.getName().length())
                .orElse(0);

        System.out.println("Company name length = " + length);
    }

    static void filterMapDemo() {
        Insurance insurance = new Insurance("ZABC Insurance Ltd.");
        // company name starts with letter 'A'
        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance)
                .filter(i -> i.getName().startsWith("A"));
                //.ifPresent(i -> System.out.println("Company name contains A; company name is " + i.getName()));
        System.out.println(optionalInsurance);

        // let's map Optional of Insurance to Optional of String
        Optional<Insurance> optionalInsurance1 = Optional.of(insurance);
        Optional<String> optionalString = optionalInsurance1.map(insurance1 -> insurance1.getName());
        System.out.println(optionalString);
        System.out.println("-----------------------------------------------");

        Insurance insurance1 = new Insurance("ZABC");
        int companyNameLength = Optional.of(insurance1)
                .map(i -> i.getName())
                .map(s -> s.toUpperCase())
                .map(s -> {
                    System.out.println("Mapped value is " + s);
                    System.out.println("Calculating length of mapped value");
                    return s.length();
                })
                .filter(i -> i > 5) // company name should be of at least 5 characters
                //.ifPresent(i -> System.out.println("Length of company name is :" + i));
                .orElse(0);
        System.out.println("Length of company name matching the criteria: " + companyNameLength);
    }

    static void createOptionals() {
        Optional<String> stringOptional = Optional.empty();
        System.out.println("Optional instance: " + stringOptional);
        System.out.println("Is value present in the Optional? : "+ stringOptional.isPresent());

        Optional<String> stringOptional1 = Optional.of("Coding wala Shree");
        System.out.println("Optional instance: " + stringOptional1);
        System.out.println("Is value present in the Optional? : "+ stringOptional1.isPresent());

//        Optional<String> stringOptional2 = Optional.of(null); // Throws NullPointerException
//        System.out.println("Optional instance: " + stringOptional2);
//        System.out.println("Is value present in the Optional? : "+ stringOptional2.isPresent());

        Optional<String> stringOptional3 = Optional.ofNullable(null);
        System.out.println("Optional instance: " + stringOptional3);
        System.out.println("Is value present in the Optional? : "+ stringOptional3.isPresent());
    }

    static void getIfPresentDemo() {
        Optional<String> stringOptional1 = Optional.ofNullable("coding wala shree");
        System.out.println("Optional instance: " + stringOptional1);
        System.out.println("Is value present in the Optional? : "+ stringOptional1.isPresent());

//        String value;
//        if(stringOptional1.isPresent())
//            value = stringOptional1.get();
//        else
//            value = "Unknown";
        System.out.println("-------------------- get() ---------------------");
        String valueFromGet = stringOptional1.get();
        System.out.println("Value from get() : " + valueFromGet);

        System.out.println("------------------- orElse() ----------------------");
        String value = stringOptional1.orElse("Unknown");
        System.out.println("Value fetched by orElse() : " + value);

        System.out.println("------------------ ifPresent() -----------------------");
        stringOptional1.ifPresent(t -> {
            System.out.println("In consumer of ifPresent method");
            System.out.println("Value present in optional is : " + t);
        });

        System.out.println("------------------- orElseGet() ----------------------");
        Optional<String> stringOptional2 = Optional.ofNullable(null);
        String value1 = stringOptional2.orElseGet(() -> {
            System.out.println("Running some logic in a supplier of orElseGet()");
            return "Unknown";
        });
        System.out.println("Value from orElseGet() : " + value1);

        System.out.println("------------------- orElseThrow() ----------------------");
        Optional<String> stringOptional3 = Optional.ofNullable(null);
        stringOptional3.orElseThrow(() -> {
            System.out.println("In supplier of exception - orElseThrow");
            return new RuntimeException("Exception thrown using orElseThrow");
        });
        System.out.println(stringOptional3);
    }
}
