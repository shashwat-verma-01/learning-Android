package com.example.lib.JavaTut;

public class HelloAnimal {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
//        Animal dog2 = new Animal();
        Animal2 dog3 = new Dog();
        Cat cat1 = new Cat();
//        Animal cat2 = new Animal();
        Animal2 cat3 = new Cat();
        dog1.animalSound();
//        dog2.animalSound();
        dog3.animalSound();
        cat1.animalSound();
//        cat2.animalSound();
        cat3.animalSound();
    }
}
