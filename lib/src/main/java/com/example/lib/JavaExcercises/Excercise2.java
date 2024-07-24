package com.example.lib.JavaExcercises;

import java.util.*;

public class Excercise2 {
    public static void main(String[] args) {
        double r;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter radius of the circle : ");
        r = in.nextInt();
        System.out.println("The area of the circle = " + Math.PI*r*r);
        System.out.println("The perimeter of the circle = " + Math.PI*r*2);
    }
}
