package com.myProject.IndividualDishes;

public abstract class Dish {

    private String name;
    private String type;
    private double price;

    public Dish(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
