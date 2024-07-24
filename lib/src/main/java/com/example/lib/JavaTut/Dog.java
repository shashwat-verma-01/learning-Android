package com.example.lib.JavaTut;

public class Dog implements Animal2{
    @Override
    public void animalSound() {
        System.out.println("Dog says : Bow");
    }

    @Override
    public void Sleep() {
        System.out.println("Zzzzz");
    }
}
