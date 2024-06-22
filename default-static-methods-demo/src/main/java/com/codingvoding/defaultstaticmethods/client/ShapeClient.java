package com.codingvoding.defaultstaticmethods.client;

import com.codingvoding.defaultstaticmethods.math.Shape;

public class ShapeClient {
    public static void main(String[] args) {
        Circle circle1 = Shape.createCircle(10);
        circle1.print();

//        ColoredCircle coloredCircle = Shape.createColoredCircle(5, "Red");
//        coloredCircle.paint();
//        coloredCircle.print();
    }
}
