package com.example.lib.JavaTut;

public class MyClass {
    public static void main(String[] args) {
//       ****************************************
//        Old Code : -
//
//        Car c1 = new Car("black", 2023);
//        System.out.println(c1.getColor());
//        System.out.println(c1.getModelYear());
//        c1.setColor("blue");
//        c1.setModelYear(2024);
//        System.out.println(c1.getColor());
//        System.out.println(c1.getModelYear());
//        c1.drive();
//        Scanner scanner = new Scanner(System.in);
//        String userName = scanner.nextLine();
//
//        System.out.println("Hello "+userName);
//        *********************************************

        Car Audi = new Car(1435.5,"Royal Blue", 2014);

        System.out.println(Audi.getColor());
        System.out.println(Audi.getWeight());
        System.out.println(Audi.getYear());
        Audi.horn();
    }
}