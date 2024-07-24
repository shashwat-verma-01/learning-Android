package com.example.lib.JavaTut;

public class CodeTest {
    public static void main(String[] args) {
        Shape shape1 = new Circle(10, 10, 2);
        Shape shape2 = new Rectangle(5,7);
        Shape shape3 = new Triangle(7,4,4,5,6);

        System.out.println("Circle : " + shape1.CalculateArea());
        System.out.println("Rectangle : " + shape2.CalculateArea());
        System.out.println("Triangle : "+shape3.CalculateArea());
        System.out.println("Circle : "+shape1.CalculatePerimeter());
        System.out.println("Rectangle : "+shape2.CalculatePerimeter());
        System.out.println("Triangle : "+shape3.CalculatePerimeter());
    }
}
