package com.example.lib.JavaExcercises;

import java.util.Scanner;

public class Excercise4 {
    public static void main(String[] args) {
        String s;
        int count = 0;
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        for(int i = 0; i<s.length(); i++){
            count++;
        }
        System.out.println("The total number of characters is : " + count);
    }
}
