package com.myProject.Meal;

import com.myProject.IndividualDishes.Dish;
import com.myProject.Meal.MealType.ChipsType;
import com.myProject.Meal.MealType.DrinkType;
import com.myProject.Meal.MealType.MealSizeType;

public class MealBase implements Meal {

    private final Dish dish;

    private DrinkType drink;
    private ChipsType chips;
    private MealSizeType mealSize;
    private double price;

    //drinks price
    private final double colaPrice = 3;
    private final double spritePrice = 3;
    private final double fantaPrice = 3;
    private final double leanPrice = 5;
    private double drinkPrice;

    //chips price
    private final double frenchChipsPrice = 4;
    private final double potatoChipsPrice = 5;
    private double chipsPrice;

    //meal size multiply value
    private final double regularMealMultiply = 1;
    private final double bigMealMultiply = 1.3;
    private final double enormousMealMultiply = 1.6;
    private double mealSizeMultiply;


    public MealBase(Dish dish, DrinkType drink, ChipsType chips, MealSizeType mealSize) {
        this.dish = dish;
        this.drink = drink;
        this.chips = chips;
        this.mealSize = mealSize;
    }

    @Override
    public DrinkType getDrinkType() {
        return drink;
    }

    @Override
    public ChipsType getChipsType() {
        return chips;
    }

    @Override
    public MealSizeType getMealSizeType() {
        return mealSize;
    }

    public void setDrinkPrice() {
        switch (drink){
            default -> drinkPrice = colaPrice;
            case SPRITE -> drinkPrice = spritePrice;
            case FANTA -> drinkPrice = fantaPrice;
            case LEAN -> drinkPrice = leanPrice;
        }
    }

    public void setChipsPrice() {
        switch (chips){
            default -> chipsPrice = frenchChipsPrice;
            case POTATO -> chipsPrice = potatoChipsPrice;
        }
    }

    public void setMealSizeMultiply() {
        switch (mealSize){
            default -> mealSizeMultiply = regularMealMultiply;
            case BIG -> mealSizeMultiply = bigMealMultiply;
            case ENORMOUS -> mealSizeMultiply = enormousMealMultiply;
        }
    }

    public void setPrice() {
        setDrinkPrice();
        setChipsPrice();
        setMealSizeMultiply();
        price = (drinkPrice + chipsPrice)*mealSizeMultiply + dish.getPrice() ;
    }

    public double getPrice() {
        setPrice();
        return price;
    }

    /**
     * set basic-meal things
     */
    public void setDrink(DrinkType drinkType) {
        drink = drinkType;
        //return;
        switch (drinkType) {
            case COLA -> {
                drink = DrinkType.COLA;
            }
            case SPRITE -> {
                drink = DrinkType.SPRITE;
            }
            case FANTA -> {
                drink = DrinkType.FANTA;
            }
            default -> {
                drink = DrinkType.LEAN;
            }
        }
    }

    public void setChips(ChipsType chipsType) {
        switch (chipsType) {
            case POTATO -> {
                chips = ChipsType.POTATO;
            }
            default -> {
                chips = ChipsType.FRENCH;
            }
        }
    }

    public void setMealSize(MealSizeType mealSizeType) {
        switch (mealSizeType) {
            case BIG -> {
                mealSize = MealSizeType.BIG;
            }
            case ENORMOUS -> {
                mealSize = MealSizeType.ENORMOUS;
            }
            default -> {
                mealSize = MealSizeType.REGULAR;
            }
        }

    }


    /**
     * meal ordering basic ignore
     */
    private void orderCrisps() {
        System.out.println("pls chose crisps - ");
        //    setChips();
    }

    private void orderDrink() {
        System.out.println("pls chose drink - ");
        //    setDrink();
    }

    private void chooseMealSize() {
        System.out.println("pls chose meal size - ");
        //   setMealSize();
    }
}
