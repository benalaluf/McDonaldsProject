package com.myProject.IndividualDishes.McNuggets;

import com.myProject.IndividualDishes.Dish;


public class McNuggets extends Dish {

    public void setMcNuggetsType(McNuggetsType mcNuggetsType) {
        this.mcNuggetsType = mcNuggetsType;
    }

    private McNuggetsType mcNuggetsType;

    private final int pieces;
    private final double fourNuggetsPrice = 4;
    private final double sixNuggetsPrice = 6;
    private final double tenNuggetsPrice = 10;
    private final double twentyNuggetsPrice = 20;


    public McNuggets(McNuggetsType mcNuggetsType, int pieces) {
        this.mcNuggetsType = mcNuggetsType;
        this.pieces = pieces;
    }

    public McNuggetsType getType() {
        return mcNuggetsType;
    }

    public int getPieces() {
        return pieces;
    }

    public double getPrice() {
        double price = 0;
        switch (pieces) {
            default -> price = fourNuggetsPrice;
            case 6 -> price = sixNuggetsPrice;
            case 10 -> price = tenNuggetsPrice;
            case 20 -> price = twentyNuggetsPrice;
        }
        //Spicy nugget cost 10% more than regular
        price *= mcNuggetsType == McNuggetsType.SPICY ? 1.1 : 1;
        return price;
    }

    //TODO add souse feature
    public void setSouse() {

    }
}
