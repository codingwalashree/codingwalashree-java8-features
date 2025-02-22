package org.cws.streams;

import org.cws.streams.domain.repositories.DatabaseProxy;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author CodingWalaShree
 */
public class StreamLinkedinDemo {

    public static void main(String[] args) {
        sortedWithComparableDemo();
        sortingPrimitivesDemo();
    }

    public static void sortedWithComparableDemo() {
        System.out.println("Applying sorted() on Employees (after implementing Comparable)..");
        DatabaseProxy.getEmployees()
                .stream()
                .sorted()
                .forEach(System.out::println);
    }

    public static void sortingPrimitivesDemo() {
        System.out.println("Applying sorted() on Integers..");
        List<Integer> integers = Stream.of(2, 5, 1, 3)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted Integers: " + integers);

        System.out.println("Applying sorted() on Strings..");
        List<String> strings = Stream.of("Orange", "Apple", "Pineapple", "Kiwi")
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted Strings: " + strings);

        System.out.println("Applying sorted() on BigDecimals..");
        List<BigDecimal> bigDecimals = Stream.of(BigDecimal.valueOf(10.5),
                        BigDecimal.valueOf(7.5),
                        BigDecimal.valueOf(30.5))
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted BigDecimals: " + bigDecimals);
    }
}
