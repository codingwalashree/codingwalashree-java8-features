package org.cws.streams.part8;

import org.cws.streams.domain.services.EmployeeService;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author CodingWalaShree
 * Application or Client for EmployeeService and DepartmentService -- Part 8
 * Terminal Operations covered -- Overloads of reduce and collect
 * Logical flow / project structure:
 * Application Layer --> Service Layer --> Repository Layer --> Database / DatabaseProxy
 */
public class StreamOperationsPart8Demo {
    private final static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        reduceDemo();
    }

    /**
     * Overloads of reduce() operation
     * */
    public static void reduceDemo() {

        List<Integer> numbers = Arrays.asList(11, 2, 4, 67, 1, 40);
        numbers.stream()
                .reduce((n1, n2) -> n1 > n2 ? n1 : n2)
                .ifPresent(max -> System.out.println("Max number is " + max));

        // Get senior-most employee
        employeeService.getAll()
                .stream()
                .reduce((e1, e2) -> e1.getExperienceInYears() > e2.getExperienceInYears() ? e1 : e2)
                .ifPresent(System.out::println);

        Map<String, Integer> countMap = new HashMap<>();

        Stream.of("ABC", "XYZ", "PQR", "ABC", "PQR")
                .reduce(countMap,
                        (map, s) -> {
                            map.compute(s, (k, v) -> map.getOrDefault(k, v == null ? 0 : v) + 1);
                            return map;
                        },
                        (m1, m2) -> {
                            m1.forEach((k, v) -> {
                                int newValue = m1.getOrDefault(k, 0) + m2.getOrDefault(k, 0);
                                m1.put(k, newValue);
                            });
                            m2.forEach((k, v) -> {
                                int newValue = m1.getOrDefault(k, 0) + m2.getOrDefault(k, 0);
                                m1.putIfAbsent(k, newValue);
                            });
                            return m1;
                        })
                        .forEach((k, v) -> System.out.println("["+k+"] : ["+v+"]"));

    }

    /**
     * Overloads of collect() operation
     * */
    public static void collectDemo() {

    }
}
