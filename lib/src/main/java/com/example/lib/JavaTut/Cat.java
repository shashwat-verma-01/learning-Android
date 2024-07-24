package com.example.lib.JavaTut;

public class Cat implements Animal2{
    @Override
    public void animalSound() {
        System.out.println("Cat says : Meow");
    }

    @Override
    public void Sleep() {
        System.out.println("Zzzzzz");
    }
}
