package com.example.lib.JavaTut;

public class Car extends Vehicle{
//    **********************************
//    Old Code :
//
//    private int modelYear;
//    private String color;
//
//    public int getModelYear(){
//        return modelYear;
//    }
//
//    public String getColor(){
//        return color;
//    }
//
//    public void setModelYear(int x){
//        modelYear = x;
//    }
//
//    public void setColor(String x){
//        color = x;
//    }
//    public void drive(){
//        System.out.println("Driving.");
//    }
//    public Car(String color, int modelYear){
//        this.color = color;
//        this.modelYear = modelYear;
//    *********************************************


    private double weight;
    private String color;
    private int year;

    public double getWeight(){
        return weight;
    }
    public String getColor(){
        return color;
    }
    public int getYear(){
        return year;
    }

    public void setWeight(float x){
        weight = x;
    }
    public void setColor(String x){
        color = x;
    }
    public void setYear(int x){
        year = x;
    }

    public Car(double weight, String color, int year){
        this.weight = weight;
        this.color = color;
        this.year = year;
    }
}

