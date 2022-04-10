package com.myProject.BeveragesAndSides;

public abstract class Sides {

    String name;
    String kind;
    double price;

    public Sides(String name, String kind, double price) {
        this.name = name;
        this.kind = kind;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public double getPrice() {
        return price;
    }
}
