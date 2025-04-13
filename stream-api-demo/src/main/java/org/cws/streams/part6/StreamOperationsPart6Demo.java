package org.cws.streams.part6;

import org.cws.streams.domain.model.Employee;
import org.cws.streams.domain.services.EmployeeService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author CodingWalaShree
 * Application or Client for EmployeeService and DepartmentService -- Part 6
 * Terminal Operations covered -- forEach, forEachOrdered, count, min, max, toArray
 * Logical flow / project structure:
 * Application Layer --> Service Layer --> Repository Layer --> Database / DatabaseProxy
 */
public class StreamOperationsPart6Demo {
    private final static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        forEachDemo();
        countDemo();
        minMaxDemo();
        toArrayDemo();
    }

    /** forEach() -- Run Consumer for every element in the Stream
     * forEachOrdered() - Run Consumer for every element in the Stream
     * encounter order
     * Ex 1. Print numbers in the stream using forEach and forEachOrdered (use with parallel stream)
     * Ex 2. Print sorted employees using forEach and forEachOrdered
     */
    public static void forEachDemo() {
        System.out.println("forEach() demo..");

        // ------------------------------------------------------------------
        // Ex 1. Print numbers in the stream using forEach and forEachOrdered (use with parallel stream)
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("\nforEach() on sequential stream");
        numbers
                .stream()
                .forEach(System.out::println);

        System.out.println("\nforEachOrdered() on sequential stream");
        numbers
                .stream()
                .forEachOrdered(System.out::println);


        System.out.println("\nforEach() on parallel stream");
        numbers
                .stream()
                .parallel()
                .forEach(System.out::println);

        System.out.println("\nforEachOrdered() on parallel stream");
        numbers
                .parallelStream()
                .forEachOrdered(System.out::println);

        // ------------------------------------------------------------------
        // Ex 2. Print sorted employees using forEach and forEachOrdered
        System.out.println("\nPrinting sorted employees using forEach() on sequential stream");
        employeeService.sortById()
                        .stream()
                        .limit(5)
                        .forEach(System.out::println);

        System.out.println("\nPrinting sorted employees using forEach() on parallel stream");
        employeeService.sortById()
                .stream()
                .parallel()
                .limit(5)
                .forEach(System.out::println);

        System.out.println("\nPrinting sorted employees using forEachOrdered() on parallel stream");
        employeeService.sortById()
                .stream()
                .parallel()
                .limit(5)
                .forEachOrdered(System.out::println);
    }

    /** count() -- Returns number of elements in Stream
     * Ex 1. Count even numbers from stream of integers
     * Ex 2. Get count of employees having more than 5 years experience
     */
    public static void countDemo() {
        System.out.println("count() demo..");
        // Ex 1. Count even numbers from stream of integers
        long count = Stream.of(1, 2, 4, 5, 6, 8)
                .filter(e -> e % 2 == 0)
                .peek(System.out::println)
                .count();
        System.out.println("Even numbers count = " + count);
        // Ex 2. Get count of employees having more than 5 years experience
        System.out.println("Count of employees having more than 5 years experience = "
                + employeeService.countByExperienceLessThan(5));
    }

    /** min(Comparator) -- Returns the minimum element of this stream according to the provided Comparator.
     * max(Comparator) -- Returns the maximum element of this stream according to the provided Comparator.
     * Ex 1. Minimum and Maximum number from the stream of Doubles
     * Ex 2. Get the lowest and highest paid employee - Implement getLowestPaidEmployee and getHighestPaidEmployee
     */
    public static void minMaxDemo() {
        // Ex 1. Minimum and Maximum number from the stream of Doubles
        System.out.println("min() demo..");
        double min = Stream.of(1.0, 5.0, 3.0, 2.6, 0.5, 79.0, 3.3)
                    .mapToDouble(e -> e)
                    .min()
                    .getAsDouble();
        System.out.println("min of double stream = " + min);

        System.out.println("max() demo..");
        double max = Stream.of(1.0, 5.0, 3.0, 2.6, 0.5, 79.0, 3.3)
                .mapToDouble(e -> e)
                .max()
                .getAsDouble();
        System.out.println("max of double stream = " + max);

        // Ex 2. Get the lowest and highest paid employee - Implement getLowestPaidEmployee and getHighestPaidEmployee
        employeeService.getLowestPaidEmployee()
            .ifPresent(e -> System.out.println("Min salary employee: " + e));

        employeeService.getHighestPaidEmployee()
            .ifPresent(e -> System.out.println("Max salary employee: " + e));
    }

    /** toArray() -- Returns an array containing the elements of this stream
     * toArray(IntFunction) -- Returns an array containing the elements of this stream, using the provided generator function to allocate the returned array,
     * Ex 1. Get array of doubles from the stream of Doubles -- toArray()
     * Ex 2. Get array of employee IDs from employees -- toArray(IntFunction)
     */
    public static void toArrayDemo() {
        System.out.println("toArray() demo..");

        // Ex 1. Get array of doubles from the stream of Doubles -- toArray()
        Object[] numbers = Stream.of(1.2, 1.0, 4.0, 5.5)
                .toArray();
        for(Object number: numbers) {
            System.out.println(number);
        }

        // Ex 2. Get array of employee IDs from employees -- toArray(IntFunction)
        System.out.println("Get array of employee IDs for employees with experience less than 5 years");
        Long[] empIds = employeeService.getEmployeesWithExperienceLessThan(5)
                .stream()
                .map(Employee::getId)
                .toArray(Long[]::new);

        for(Long id: empIds) {
            System.out.println("Emp Id = " + id);
        }
    }
}
