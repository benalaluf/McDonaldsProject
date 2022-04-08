package com.myProject.Meal;

import com.myProject.Meal.MealType.ChipsType;
import com.myProject.Meal.MealType.DrinkType;
import com.myProject.Meal.MealType.MealSizeType;

public interface Meal {


    DrinkType getDrinkType();

    ChipsType getChipsType();

    MealSizeType getMealSizeType();

    void setDrink(DrinkType drinkType);

    void setChips(ChipsType chipsType);

    void setMealSize(MealSizeType sizeType);
}
