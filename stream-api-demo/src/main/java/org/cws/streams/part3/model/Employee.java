package org.cws.streams.part3.model;

import java.util.List;

/**
 * @author CodingWalaShree
 * Employee entity
 * */
public class Employee {
    /**
     * Member variables of Employee class
     * */
    private long id;
    private String name;
    private Address address;

    private List<String> skills;

    private Department department;
    private double salary;
    private double experienceInYears = 0;

    /**
     * Parameterized All Arguments Constructor
     * */
    public Employee(long id, String name, Address address, List<String> skills, Department department, double salary, double experienceInYears) {
        this.address = address;
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.department = department;
        this.salary = salary;
        this.experienceInYears = experienceInYears;
    }

    /**
     * Getters and Setters
     * */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(double experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", address=").append(address);
        sb.append(", skills=").append(skills);
        sb.append(", department=").append(department);
        sb.append(", salary=").append(salary);
        sb.append(", experienceInYears=").append(experienceInYears);
        sb.append('}');
        return sb.toString();
    }
}
