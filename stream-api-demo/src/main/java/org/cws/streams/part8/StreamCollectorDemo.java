package org.cws.streams.part8;

import java.util.*;

public class StreamCollectorDemo {
    /**
     * Overloads of collect() operation
     * */
    public static void collectDemo() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> outcome = numbers.parallelStream()
                //.filter(x -> x % 2 == 0)
                .collect(ArrayList::new, // created an array list
                        (list, ele) -> {
                            if(ele % 2 == 1) {
                                list.add(ele);
                            }
                        }, // determine how to accumulate elements in the array list -- accumulator
                        ArrayList::addAll); // how two array lists should be combined

        List<String> strings = Arrays.asList("A", "B", "B", "C", "A", "B", "D", "D", "B", "ABC");

        Map<String, Integer> stringCounts = strings.parallelStream()
                //.filter(x -> x % 2 == 0)
                .collect(HashMap::new, // created an array list
                        (map, ele) -> {
                            Integer count = map.getOrDefault(ele, 1);
                            map.put(ele, count);
                        }, // determine how to accumulate elements in the array list -- accumulator
                        (map1, map2) -> {
                            map2.forEach((key, value) -> {
                                Integer count = map1.getOrDefault(key, 0) + map2.getOrDefault(key, 1);
                                map1.put(key, count);
                            });
                        }); // how two array lists should be combined
        System.out.println("Outcome of collecting even numbers: " + outcome);
        System.out.println("Outcome of collecting numbers and their occurrences: " + stringCounts);

    }
}
