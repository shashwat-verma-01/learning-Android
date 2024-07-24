package com.example.lib.JavaExcercises;

import java.util.Scanner;

public class Excercise3 {
    public static void main(String[] args) {
        int decimal, rem, i =0, bin = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the decimal number : ");
        decimal = in.nextInt();
        while (decimal > 0){
            rem = decimal%2;
            bin += rem * Math.pow(10.0, i);
            decimal /= 2;
            i++;
        }
        System.out.println("That number in binary is : " + bin);
    }
}
