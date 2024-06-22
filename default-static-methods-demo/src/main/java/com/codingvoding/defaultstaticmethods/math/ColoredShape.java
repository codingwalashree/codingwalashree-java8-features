package com.codingvoding.defaultstaticmethods.math;

public interface ColoredShape extends Shape {
    void paint();
    String getColor();

    default void print() {
        System.out.println("Printing the shape with area: " + area() + " with color: " + getColor());
    }
}
