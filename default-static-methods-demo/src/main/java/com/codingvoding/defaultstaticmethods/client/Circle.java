package com.codingvoding.defaultstaticmethods.client;

import com.codingvoding.defaultstaticmethods.math.Printable;
import com.codingvoding.defaultstaticmethods.math.Shape;

import java.util.List;

public class Circle implements Shape, Printable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {

        final double PI = 3.14;
        return PI * radius * radius;
    }

    public void print() {
        // System.out.println("Printing the circle with area: " + area());
        Printable.super.print();
        Shape.super.print();
    }
}