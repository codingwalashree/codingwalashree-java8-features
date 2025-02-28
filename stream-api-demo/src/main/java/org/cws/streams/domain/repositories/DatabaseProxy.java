package org.cws.streams.domain.repositories;

import org.cws.streams.domain.model.Address;
import org.cws.streams.domain.model.Department;
import org.cws.streams.domain.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CodingWalaShree
 * Dummy Repository layer -- acts like database to us!
 */
public class DatabaseProxy {
    /**
     * data represents storage or database.
     * This is the data to play around!
     */
    private static final List<Employee> employees = new ArrayList<>();

    private static final List<Department> departments = new ArrayList<>();

    /**
     * Belongs to DatabaseProxy class.
     * Static constants for pre-defined Department objects for the demo
     */
    public static final Department IT = new Department(1, "IT");
    public static final Department HR = new Department(2, "HR");
    public static final Department FINANCE = new Department(3, "Finance");

    static {
        departments.add(IT);
        departments.add(HR);

        employees.add(new Employee(1, "Rajesh", Address.inMumbai("address1"), javaDeveloperSkills(), IT, 80000.0, 3));
        employees.add(new Employee(2, "Shiven", Address.inPune("address2"), javaFullstackReactSkills(), IT, 90000.0, 3));
        employees.add(new Employee(3, "Preeti", Address.inMumbai("address3"), Arrays.asList("React", "Angular", "NodeJS"), IT, 65000.0, 2.0));
        employees.add(new Employee(4, "Avani", Address.inMumbai("address4"), javaFullstackAngularSkills(), IT, 75000.0, 4.5));
        employees.add(new Employee(5, "Santosh", Address.inPune("address5"), coreHrSkills(), HR, 55000.0, 5.0));
        employees.add(new Employee(6, "Snehal", Address.inPune("address6"), hrManagerSkills(), HR, 95000.0, 8.0));
        employees.add(new Employee(7, "Pradeep", Address.inMumbai("address7"), javaFullstackAngularSkills(), IT, 110000.0, 10));
        employees.add(new Employee(8, "Sakshi", Address.inNewYork("address8"), coreHrSkills(), HR, 150000.0, 13.5));
        employees.add(new Employee(9, "Nishant", Address.inNewYork("address9"), hrManagerSkills(), HR, 140000.0, 15.0));
        employees.add(new Employee(10, "Vivansh", Address.inMumbai("address10"), javaFullstackReactSkills(), IT, 150000.0, 11));
        employees.add(new Employee(11, "Riya", Address.inPune("address11"), javaDeveloperSkills(), IT, 880000.0, 4));
        employees.add(new Employee(12, "Atharva", Address.inPune("address12"), javaFullstackAngularSkills(), IT, 118000.0, 12));
        employees.add(new Employee(13, "Preeti", Address.inPune("address13"), Arrays.asList("Accounting", "Taxation and Compliance", "Risk Management"), FINANCE, 75000.0, 10));
        employees.add(new Employee(14, "Santosh", Address.inMumbai("address14"), Arrays.asList("Accounting", "Risk Management"), FINANCE, 58000.0, 8));
        employees.add(new Employee(15, "Jitesh", Address.inMumbai("address15"), Arrays.asList("Accounting"), FINANCE, 20000.0, 1.5));
    }

    public static List<Department> getDepartments() {
        return departments;
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Utility method returns basic java developer skills
     */
    public static List<String> javaDeveloperSkills() {
        return Arrays.asList("Java", "Spring Boot", "Hibernate");
    }

    /**
     * Utility method returns java fullstack react developer skills
     */
    public static List<String> javaFullstackReactSkills() {
        List<String> skills = new ArrayList<>(javaDeveloperSkills());
        skills.addAll(coreWebDevelopmentSkills());
        skills.add("React");

        return skills;
    }

    /**
     * Utility method returns java fullstack angular developer skills
     */
    public static List<String> javaFullstackAngularSkills() {
        List<String> skills = new ArrayList<>(javaDeveloperSkills());
        skills.addAll(coreWebDevelopmentSkills());
        skills.add("Angular");

        return skills;
    }

    /**
     * Utility method returns basic core web developer skills
     */
    public static List<String> coreWebDevelopmentSkills() {
        return Arrays.asList("JavaScript", "HTML", "CSS", "HTTP");
    }

    /**
     * Utility method returns basic HR skills
     */
    public static List<String> coreHrSkills() {
        return Arrays.asList("Recruitment", "Screening", "Onboarding");
    }

    /**
     * Utility method returns HR manager skills
     */
    public static List<String> hrManagerSkills() {
        List<String> skills = new ArrayList<>(coreHrSkills());
        skills.add("People Management");

        return skills;
    }
}
