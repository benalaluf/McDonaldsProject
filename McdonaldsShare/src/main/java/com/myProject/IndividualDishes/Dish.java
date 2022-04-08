package com.myProject.IndividualDishes;

public abstract class Dish {

    private double price;
    private String name;
    private String type;

    public Dish(double price, String name, String type) {
        this.price = price;
        this.name = name;
        this.type = type;
    }

    public double getPrice(){
        return price;
    }

    public String getName() {
        return name;
    }
}
