package com.codingvoding.defaultstaticmethods.client;

import com.codingvoding.defaultstaticmethods.math.ColoredShape;

public class ColoredCircle extends Circle implements ColoredShape {
    private String color;

    public ColoredCircle(double radius, String color) {
        super(radius);
        this.color = color;
    }

    @Override
    public void paint() {
        System.out.println("Painting the colored circle with color: " + getColor());
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
