package org.cws.streams.part1;

import java.util.ArrayList;
import java.util.List;

public class StreamPart1Demo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n + 1)
                .forEach(System.out::println);
                //.collect(Collectors.toList());

        System.out.println(".............................");
        List<Integer> newNumbers = new ArrayList<>();
        for(Integer n: numbers) {
            if(n % 2 == 0) {
                newNumbers.add(n + 1);
            }
        }

        for (Integer n : newNumbers) {
            System.out.println(n);
        }
    }
}
