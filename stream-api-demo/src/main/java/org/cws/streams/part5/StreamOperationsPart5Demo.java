package org.cws.streams.part5;

import org.cws.streams.domain.model.Department;
import org.cws.streams.domain.model.Employee;
import org.cws.streams.domain.services.DepartmentService;
import org.cws.streams.domain.services.EmployeeService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author CodingWalaShree
 * Application or Client for EmployeeService and DepartmentService -- Part 5 -- distinct, peek, limit, skip
 * Logical flow / project structure:
 * Application Layer --> Service Layer --> Repository Layer --> Database / DatabaseProxy
 */
public class StreamOperationsPart5Demo {
    private static DepartmentService departmentService = new DepartmentService();
    private static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        distinctPeekDemo();
        limitDemo();
        skipDemo();
        skipLimitDemo();
    }

    /** peek() - Debugging Stream Pipelines
     * distinct() - Removing duplicates -- distinct() uses equals() and hashCode()
     * Ex 1. Get distinct numbers
     * Ex 2. Get distinct departments for employees having experience less than given experience (DepartmentService)
     */
    public static void distinctPeekDemo() {
        System.out.println("distinct() and peek() demo..");
        // Ex 1. Get distinct numbers
        List<Integer> numbers = Arrays.asList(2, 3, 4, 2, 5, 7, 7, 8, 2);
        List<Integer> distinctNumbers = numbers.stream()
                .peek(n -> System.out.println("In peek, before distinct, n = " + n))
                .distinct()
                .peek(n -> System.out.println("In peek, after distinct, n = " + n))
                .collect(Collectors.toList());
        System.out.println("Distinct elements: " + distinctNumbers);

        //Ex 2. Get distinct departments for employees having experience less than given experience (DepartmentService)
        List<Department> departments = departmentService.getDepartmentsHavingExperienceLessThan(8);
        System.out.println("Calling distinct() on these departments:");
        departments.stream()
                .peek(d -> System.out.println("Department before distinct: " + d))
                .distinct()
                .forEach(d -> System.out.println("Department after distinct: " + d));
    }

    /**
     * limit() - Fetching a fixed number of records
     * Ex 1. Limit results from stream of strings
     * Ex 2. Get top 3 highest paid employees
     * */
    public static void limitDemo() {
        System.out.println("limit() demo..");

        // Ex 1. Limit results from stream of strings
        System.out.println("Trying to get 3 elements..");
        Stream.of("ABC", "AB", "A", "B", "C")
                .peek(s -> System.out.println("Element: " + s))
                .limit(3)
                .forEach(s -> System.out.println("After limit, element: " + s));

        System.out.println("Trying to get 10 elements..");
        Stream.of("ABC", "AB", "A", "B", "C")
                .peek(s -> System.out.println("Element: " + s))
                .limit(10)
                .forEach(s -> System.out.println("After limit, element: " + s));

        // Ex 2. Get top 3 highest paid employees
        List<Employee> top3Employees = employeeService.getTop3HighestPaidEmployees();
        System.out.println("Top 3 highest paid employees: " + top3Employees);

    }

    /**
     * skip() - Removes the first n elements from the stream
     * Ex 1. Limit results from stream of strings
     * Ex 2. Skip top 3 highest paid employees and get the remaining employees
     * */
    public static void skipDemo() {
        System.out.println("skip() demo..");

        // Ex 1. Limit results from stream of strings
        List<String> skippedStrings = Stream.of("ABC", "AB", "A", "B", "C")
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("skippedStrings = " + skippedStrings);

        // Ex 2. Skip top 3 highest paid employees and get the remaining employees
        System.out.println("Skip top 3 highest paid employees and get the remaining employees:");
        employeeService.getAllExceptTop3HighestPaidEmployees()
                .forEach(System.out::println);
    }

    /**
     * Scenario: The company has already shortlisted the top 3 highest-paid employees.
     * Now, we need to fetch the next 2 highest-paid employees for further evaluation.
     * Note: limit() and skip() methods are useful in implementing pagination.
     * */
    public static void skipLimitDemo() {
        System.out.println("skip() and limit() demo..Next top 2 employees with highest salary:");
        employeeService.getNextTop3Employees()
                .forEach(System.out::println);
    }
}
