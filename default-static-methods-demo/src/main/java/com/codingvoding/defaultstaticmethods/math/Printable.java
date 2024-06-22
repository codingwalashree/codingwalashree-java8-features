package com.codingvoding.defaultstaticmethods.math;

public interface Printable {
    default void print() {
        System.out.println("Printing from printable.");
    }
}
