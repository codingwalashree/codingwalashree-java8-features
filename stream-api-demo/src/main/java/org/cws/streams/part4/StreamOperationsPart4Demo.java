package org.cws.streams.part4;

import org.cws.streams.domain.model.Address;
import org.cws.streams.domain.services.EmployeeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author CodingWalaShree
 * Application or Client for EmployeeService and DepartmentService -- Part 4 -- sorted method
 * Logical flow / project structure:
 * Application Layer --> Service Layer --> Repository Layer --> Database / DatabaseProxy
 */
public class StreamOperationsPart4Demo {
    private static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        basicSortingDemo();
        customSortingDemo();
    }

    public static void basicSortingDemo() {
        System.out.println("------------ Basic sorting with sorted() ------------------");
        List<Integer> numbers = Arrays.asList(2, 5, 1, 3);
        numbers.add(2);
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        Stream.of(2, 5, 1, 3)
                .sorted()
                .forEach(System.out::println);

        List<String> names = new ArrayList<>();
        names.add("BAC");
        names.add("AAC");
        names.add("4NC");
        names.add("BAC1");
        Stream.of("Orange", "Apple", "Pineapple", "Kiwi")
                .sorted()
                .forEach(System.out::println);

        System.out.println("Sorting by ID in given city");
        employeeService.getByCity(Address.CT_PUNE)
                .stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("Sorting by ID");
        employeeService.sortById()
                .forEach(System.out::println);
    }

    public static void customSortingDemo() {
        System.out.println("-------- sort by experience ascending -----");
        employeeService.sortByExperience()
                .forEach(System.out::println);

        System.out.println("-------- sort by experience descending -----");
        employeeService.sortByExperienceDescending()
                .forEach(System.out::println);

        System.out.println("-------- sort by experience and skill count ascending -----");
        employeeService.sortByExperienceAndSkillCount()
                .forEach(System.out::println);
    }
}
