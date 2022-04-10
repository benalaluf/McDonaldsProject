package com.myProject.Meal;

import com.myProject.BeveragesAndSides.Beverages;
import com.myProject.BeveragesAndSides.Snack;
import com.myProject.IndividualDishes.MainDish;

public class MealBase implements Meal {

    private final MainDish mainDish;
    private final Snack snack;
    private final Beverages beverages;

    //meal size multiply value
    private final double regularMealMultiply = 1;
    private final double bigMealMultiply = 1.3;
    private final double enormousMealMultiply = 1.6;
    private double mealSizeMultiply;

    public MealBase(MainDish mainDish, Snack snack, Beverages beverages, double mealSizeMultiply) {
        this.mainDish = mainDish;
        this.snack = snack;
        this.beverages = beverages;
        this.mealSizeMultiply = mealSizeMultiply;
    }

}
