package com.example.lib.JavaTut;

public class Rectangle implements Shape{
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double CalculateArea() {
        return width*height;
    }

    @Override
    public double CalculatePerimeter() {
        return 2*(width + height);
    }
}
