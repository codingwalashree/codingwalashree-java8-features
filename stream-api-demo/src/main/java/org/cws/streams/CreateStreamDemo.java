package org.cws.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamDemo {
    public static void main(String[] args) {
        createEmptyStream();
        createStreamFromArray();
        createStreamFromCollection();
        createStreamUsingStreamBuilder();
        createStreamUsingOf();
        createStreamFromGeneratorFunction();
        createStreamUsingIterate();
        createStreamOfPrimitives();
        createStreamFromFile();
    }

    /**
     * 1. Create empty stream using Stream.empty() i.e. stream with no elements.
     * */
    static void createEmptyStream() {
        System.out.println("Creating empty stream..");
        Stream<String> stringStream = Stream.empty();
        long count = stringStream.count();
        System.out.println("Elements in empty stream = " + count);
    }

    /**
     * 2. Create stream from array
     * */
    static void createStreamFromArray() {
        System.out.println("Creating stream from array..");
        String[] arr = {"A", "B", "C"};
        Stream<String> stringStream = Arrays.stream(arr);
        stringStream.forEach(System.out::println);

    }

    /**
     * 3. Create stream from Collection - List & Set
     * */
    static void createStreamFromCollection() {
        System.out.println("Creating stream from collection..");
        Set<String> strings = new HashSet<>();
        strings.add("Abcd");
        strings.add("BcdA");
        strings.add("ABC");

        Stream<String> stringStream = strings.stream();
        stringStream.filter(x -> x.contains("B"))
                .forEach(System.out::println);
    }

    /**
     * 4. Create stream using Stream Builder -- Stream.<Type>builder()
     * */
    static void createStreamUsingStreamBuilder() {
        System.out.println("Creating stream using Stream.builder()..");
        Stream.Builder<Integer> intStreamBuilder = Stream.builder();
        Stream<Integer> integerStream = intStreamBuilder.add(123)
                .add(345)
                .add(567)
                .add(58).build();
        integerStream.forEach(System.out::println);
    }

    /**
     * 5. Create stream using static method of() -- Stream.of()
     * */
    static void createStreamUsingOf() {
        System.out.println("Creating stream using Stream.of()..");
        Stream<Double> doubleStream = Stream.of(1.3, 1.1, 40.0);
        doubleStream.forEach(System.out::println);
        Stream<String> stringStream = Stream.of("ABC", "BBB");
        stringStream.forEach(System.out::println);
    }

    /**
     * 6. Create stream from generator function -- Stream.generate()
     * Supplier to generate an element and provide it to the stream
     * */
    static void createStreamFromGeneratorFunction() {
        System.out.println("Creating stream using Stream.generate()..");
        Random random = new Random();
        Stream<Integer> integerStream = Stream.generate(() -> random.nextInt(1000));
        integerStream
                .limit(20)
                .forEach(System.out::println);
    }

    /**
     * 7. Create stream from static method iterate -- Stream.iterate()
     * */
    static void createStreamUsingIterate() {
        System.out.println("Creating stream using Stream.iterate()..");
        Stream<Integer> evenStream = Stream.iterate(0, x -> x + 2);
        evenStream
                .limit(10)
                .forEach(System.out::println);
    }

    /**
     * 8. Create stream of primitive types -- IntStream, LongStream and DoubleStream
     * */
    static void createStreamOfPrimitives() {
        System.out.println("Creating streams of primitive types - IntStream, LongStream and DoubleStream..");
        IntStream intStream = Stream.of(1, 2, 3)
                .mapToInt(x -> x);
        intStream.forEach(System.out::println);

        DoubleStream ds = Stream.iterate(10, x -> x + 10)
                .limit(2)
                .mapToDouble(x -> x);

//      -- Results into exception - stream is already closed --
//        double avg = ds.peek(System.out::println)
//                .average()
//                .getAsDouble();
//
//        System.out.println("Average using DoubleStream.average() = " + avg);

        System.out.println("Sum = " + ds.sum());
        // IntStream not equal to Stream<Integer>
    }

    /**
     * 9. Create stream by reading a file -- Files.lines()
     * */
    static void createStreamFromFile() {
        System.out.println("Creating stream by reading a file..");
        String filePath = "stream-api-demo\\src\\main\\resources\\numbers.txt";
        Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path)) {
                lines
                    .mapToLong(CreateStreamDemo::tryParseLong)
                    .forEach(System.out::println);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private static Long tryParseLong(String x) {
        long result;
        try {
            result = Long.parseLong(x);
        } catch (NumberFormatException e) {
            result = 0;
        }
        return result;
    }
}
