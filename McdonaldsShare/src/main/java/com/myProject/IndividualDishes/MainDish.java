package com.myProject.IndividualDishes;

public class MainDish extends Dish{
    public MainDish(String name, String type, double price) {
        super(name, type, price);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getType() {
        return super.getType();
    }

    public void syso() {
        System.out.println(getName() + "," + getType() + " - " + getPrice() + "$");
    }
}
