package com.example.lib.JavaExcercises;

import java.util.*;

public class Excercise1 {
    public static void main(String[] args) {
        int a, b;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the first number : ");
        a = s1.nextInt();
        System.out.println("Enter the second number : ");
        b = s1.nextInt();

        System.out.println("Quotient = " + (float)a/b +"\nRemainder = " + a%b);
    }
}
