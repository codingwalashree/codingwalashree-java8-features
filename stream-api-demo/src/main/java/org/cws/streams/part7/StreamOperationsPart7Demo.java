package org.cws.streams.part7;

import org.cws.streams.domain.services.EmployeeService;

import java.util.Arrays;
import java.util.List;

/**
 * @author CodingWalaShree
 * Application or Client for EmployeeService and DepartmentService -- Part 7
 * Terminal Operations covered -- findFirst(), findAny(), allMatch(), anyMatch(), noneMatch()
 * Logical flow / project structure:
 * Application Layer --> Service Layer --> Repository Layer --> Database / DatabaseProxy
 */
public class StreamOperationsPart7Demo {
    private final static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        // findDemo();
        matchDemo();
    }

    /**
     * findFirst() - Returns an Optional describing the FIRST element of
     *               this stream, or an empty Optional if the stream is empty.
     * findAny() - Returns an Optional describing SOME element of the stream,
     *              or an empty Optional if the stream is empty.
     * */
    public static void findDemo() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        // Ex1. Find first number and any number from stream of integers
        numbers.stream()
                .findFirst()
                .ifPresent(e -> System.out.println("findFirst(): First element = " + e));

        numbers.stream()
                .parallel()
                .findAny()
                .ifPresent(e -> System.out.println("findAny(): Returned element = " + e));

        // Ex2. Find first employee and any employee having experience less than 10 years
        employeeService.getEmployeesWithExperienceLessThan(10)
                .stream()
                .findFirst()
                .ifPresent(e -> System.out.println("First employee having experience less than 10 years = " + e));

        employeeService.getEmployeesWithExperienceLessThan(10)
                .stream()
                .parallel()
                .findAny()
                .ifPresent(e -> System.out.println("findAny(): Selected employee having experience less than 10 years = " + e));

    }

    /**
     * anyMatch() - Returns boolean - whether ANY elements of this stream match
     *              the provided predicate.
     * allMatch() - Returns boolean - whether ALL elements of this stream match
     *              the provided predicate.
     * noneMatch() - Returns boolean - whether NO elements of this stream match
     *               the provided predicate.
     * For all match methods:
     *      - Return boolean value (true/false)
     *      - May not evaluate the predicate on all elements if not
     *        necessary for determining the result.
     *      - If the stream is empty then false is returned and
     *        the predicate is not evaluated.
     * */
    public static void matchDemo() {
        // Ex1. Are there any/all/no even numbers from stream of integers?
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        boolean isGreaterThan5 = numbers.stream()
                .anyMatch(e -> e > 5);
        System.out.println("Is any number greater than 5? : " + isGreaterThan5);
        System.out.println("Is any number greater than 10? : " + numbers.stream().anyMatch(e -> e > 10));

        System.out.println("Are there all numbers greater than 5? : " + numbers.stream().allMatch(e -> e > 5));
        System.out.println("Are there all numbers greater than 0? : " + numbers.stream().allMatch(e -> e > 0));

        System.out.println("Aren't there any number greater than 10? : " + numbers.stream().noneMatch(e -> e > 10));
        System.out.println("Aren't there any number less than 0? : " + numbers.stream().noneMatch(e -> e < 0));
        System.out.println("Aren't there any number less than 5? : " + numbers.stream().noneMatch(e -> e > 5));

        // Ex2. Are there any/all/no employees having experience less than 10 years?
        boolean anyMatchSalary = employeeService.getEmployeesWithExperienceLessThan(10)
                .stream()
                .anyMatch(e -> e.getSalary() > 20000);
        System.out.println("Is there any employee having salary > 20000?: " + anyMatchSalary);

        boolean allMatchSalary = employeeService.getEmployeesWithExperienceLessThan(10)
                .stream()
                .allMatch(e -> e.getSalary() > 20000);
        System.out.println("Are all employees having salary > 20000?: " + allMatchSalary);

        boolean noneMatchSalary = employeeService.getEmployeesWithExperienceLessThan(10)
                .stream()
                .noneMatch(e -> e.getSalary() > 20000);
        System.out.println("Isn't there any employee having salary > 20000?: " + noneMatchSalary);

        boolean noneMatchNegativeSalary = employeeService.getEmployeesWithExperienceLessThan(10)
                .stream()
                .noneMatch(e -> e.getSalary() < 0);
        System.out.println("Isn't there any employee having negative salary?: " + noneMatchNegativeSalary);
    }
}
