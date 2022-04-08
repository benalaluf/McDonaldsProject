package com.myProject.IndividualDishes.McBurger;

import com.myProject.IndividualDishes.Dish;

public class McBurger extends Dish {

    private final McBurgerType mcBurgerType;

    private final double bigMacPrice = 5;
    private final double cheeseBurgerPrice = 7;
    private final double doubleBigMacPrice = 10;
    private double price;

    public McBurger(McBurgerType mcBurgerType) {
        this.mcBurgerType = mcBurgerType;
    }

    public McBurgerType getMcBurgerType() {
        return mcBurgerType;
    }

    public void setPrice() {
        switch (mcBurgerType){
            default -> price = bigMacPrice;
            case CHEESE_BURGER -> price = cheeseBurgerPrice;
            case DOUBLE_BIG_MAC -> price =doubleBigMacPrice;

        }
    }

    @Override
    public double getPrice() {
        setPrice();
        return price;
    }
}
