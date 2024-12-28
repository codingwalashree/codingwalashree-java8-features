package org.cws.streams.part3.repositories;

import org.cws.streams.part3.model.Address;
import org.cws.streams.part3.model.Department;
import org.cws.streams.part3.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Dummy Repository layer for managing Employees
 * */
public class EmployeeRepository {
    private static final List<Employee> data = new ArrayList<>();

    static {
        data.add(new Employee(1, "Rajesh", Address.inMumbai("address1"), javaDeveloperSkills(), Department.IT, 80000.0, 3.3));
        data.add(new Employee(2, "Shiven", Address.inPune("address2"), javaFullstackReactSkills(), Department.IT, 90000.0, 5.2));
        data.add(new Employee(3, "Preeti", Address.inMumbai("address3"), Arrays.asList("React", "Angular", "NodeJS"), Department.IT, 65000.0, 2.0));
        data.add(new Employee(4, "Avani", Address.inMumbai("address4"), javaFullstackAngularSkills(), Department.IT, 75000.0, 4.5));
        data.add(new Employee(5, "Santosh", Address.inPune("address5"), coreHrSkills(), Department.HR, 55000.0, 5.0));
        data.add(new Employee(6, "Santosh", Address.inPune("address6"), hrManagerSkills(), Department.HR, 95000.0, 8.0));
        data.add(new Employee(7, "Pradeep", Address.inMumbai("address7"), javaFullstackAngularSkills(), Department.IT, 110000.0, 10));
    }

    // filter, collect
    public List<Employee> findByNameContains(String text) {
        // TODO: Yet to be implemented
        return null;
    }

    // filter, collect
    public List<Employee> findByCity(String city) {
        // TODO: Yet to be implemented
        return null;
    }

    // filter, collect
    public List<Employee> findByDepartmentId(long deptId) {
        // TODO: Yet to be implemented
        return null;
    }

    /**
     * filter, mapToDouble, average
     * */
    public double calculateAverageSalary() {
        // TODO: Yet to be implemented
        return 0.0;
    }

    /**
     * Given a department ID, returns total salary required to be paid to all employees in the department.
     * filter, reduce
     * */
    public double calculateTotalSalaryForDepartment(long deptId) {
        OptionalDouble optSum = data.stream()
                .filter(e -> e.getDepartment().getId() == deptId)
                .mapToDouble(Employee::getSalary)
                // .sum() -- directly returns sum of all elements
                .reduce(Double::sum);
        double sum = optSum.orElse(0);
        System.out.println("Sum of salaries of all departments = " + sum);

        return sum;
    }

    public Map<Department, List<Employee>> aggregateByDepartment() {
        Map<Department, List<Employee>> departmentWiseEmployeeMap = data.stream()
                .filter(e -> e.getSalary() > 85000)
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("----------------------------------------");
        departmentWiseEmployeeMap.forEach((dept, employees) -> {
            System.out.println("Employees in department: " + dept.toString());
            employees.forEach(System.out::println);
            System.out.println("----------------------------------------");
        });

        return departmentWiseEmployeeMap;
    }

    /**
     * Department wise average, min, max, sum of salary
     * */
    public Map<Department, DoubleSummaryStatistics> getDepartmentWiseSummaryStatistics() {
        Map<Department, DoubleSummaryStatistics> departmentWiseEmployeeMap = data.stream()
                .filter(e -> e.getSalary() > 85000)
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summarizingDouble(Employee::getSalary)));
        System.out.println("----------------------------------------");
        departmentWiseEmployeeMap.forEach((dept, stats) -> {
            System.out.println("Employees in department: " + dept.toString());
            System.out.println(stats.toString());
            System.out.println("----------------------------------------");
        });

        return departmentWiseEmployeeMap;
    }

    /**
     * Department wise sum of salary for all departments
     * */
    public Map<Department, Double> getDepartmentWiseTotalSalary() {
        Map<Department, Double> departmentWiseSalaryMap = data.stream()
                .filter(e -> e.getSalary() > 85000)
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        System.out.println("----------------------------------------");
        departmentWiseSalaryMap.forEach((dept, totalSalary) -> {
            System.out.println("Department: " + dept.toString() + "; Total Salary = " + totalSalary.toString());
        });
        System.out.println("----------------------------------------");
        return departmentWiseSalaryMap;
    }

    public static Employee employeeIdentity() {
        return new Employee(0, "", Address.inMumbai(""), Collections.singletonList(""), new Department(0, ""), 0, 0);
    }

    public static List<String> javaDeveloperSkills() {
        return Arrays.asList("Java", "Spring Boot", "Hibernate");
    }

    public static List<String> javaFullstackReactSkills() {
        List<String> skills = new ArrayList<>(javaDeveloperSkills());
        skills.addAll(coreWebDevelopmentSkills());
        skills.add("React");

        return skills;
    }

    public static List<String> javaFullstackAngularSkills() {
        List<String> skills = new ArrayList<>(javaDeveloperSkills());
        skills.addAll(coreWebDevelopmentSkills());
        skills.add("Angular");

        return skills;
    }

    public static List<String> coreWebDevelopmentSkills() {
        return Arrays.asList("JavaScript", "HTML", "CSS", "HTTP");
    }

    public static List<String> coreHrSkills() {
        return Arrays.asList("Recruitment", "Screening", "Onboarding");
    }

    public static List<String> hrManagerSkills() {
        List<String> skills = new ArrayList<>(coreHrSkills());
        skills.add("People Management");

        return skills;
    }
}
