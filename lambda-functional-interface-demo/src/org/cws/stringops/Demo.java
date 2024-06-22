package org.cws.stringops;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Demo {
    public static void main(String[] args) {
        StringOperation so = new StringOperation();
//        System.out.println(so.toSpecialUpperCase(""));
//        System.out.println(so.toSpecialUpperCase(null));
//        System.out.println(so.toSpecialUpperCase("CodingWalaShree"));

        StringOp stringOp = input ->{
            if(input == null || input.isEmpty()) {
                return "EMPTY";
            }
            return input.toUpperCase();
        };
        //System.out.println(stringOp.perform("CodingWalaShree"));

        Displayer printer = s -> System.out.println(s);
        printer.display("CodingWalaShree");

        BinaryOperation binaryOperation = (n1,n2) -> n1 + n2;
        System.out.println(binaryOperation.perform(10, 20));

        Function<String, String> stringFunction = input ->{
            if(input == null || input.isEmpty()) {
                return "EMPTY";
            }
            return input.toUpperCase();
        };
        System.out.println(stringFunction.apply("CodingWalaShree - Function"));
        Consumer<String> consumer = s -> System.out.println("From consumer lambda:" + s);
        consumer.accept("CodingWalaShree");
//        Printer p = (Printer) consumer;
//        p.print("Casted to printer - CodingWalaShree");
        BiFunction<Integer, Integer, Integer> biFunction = (n1, n2) -> n1 + n2;
        System.out.println("Testing BiFunction: " + biFunction.apply(10, 20));

        Predicate<String> stringPredicate = s -> s.contains("A");
        System.out.println(stringPredicate.test("asdf"));
        System.out.println(stringPredicate.test("asAdf"));

        runLambda(s -> System.out.println(s));
    }

    public static void runLambda(Displayer displayerLambda) {
        displayerLambda.display("Hello from runLambda!");

    }
}