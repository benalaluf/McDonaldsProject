package com.myProject.Meal;

import com.myProject.Desserts.Dessert;
import com.myProject.Desserts.McFlurry.McFlurry;
import com.myProject.Desserts.McFlurry.McFlurryType;
import com.myProject.IndividualDishes.Dish;
import com.myProject.IndividualDishes.McNuggets.McNuggets;
import com.myProject.IndividualDishes.McNuggets.McNuggetsType;
import com.myProject.Meal.MealBase;
import com.myProject.Meal.MealType.ChipsType;
import com.myProject.Meal.MealType.DrinkType;
import com.myProject.Meal.MealType.MealSizeType;
import com.myProject.SelfServicesMechin.SelfServicesMechanic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {
    public enum DessertType {
        VanillaCone, McFlurry, Shake, Sundae;
    }
    static HashMap<String, HashMap<String, Double>> dessertsByTypes = new HashMap<>();

    static List<Dessert> desserts = new ArrayList<>();
    public static void main(String[] args) {
        HashMap<String, Double> types = new HashMap<>();
        types.put("regular", 1.0);
        dessertsByTypes.put("Vanilla cone", types);

        types = new HashMap<>();
        types.put("oreo", 3.5);
        types.put("mnm", 4.0);
        dessertsByTypes.put("McFlurry", types);
        //.....
        //desserts.put("Shake", 1.0);
        //desserts.put("Sundae", 1.0);
        for (var v : dessertsByTypes.entrySet()) {
            for (var pricesByTypes : v.getValue().entrySet()) {
                desserts.add(new Dessert(pricesByTypes.getValue(), v.getKey(), pricesByTypes.getKey()));
            }
        }
        SelfServicesMechanic selfServicesMechanic = new SelfServicesMechanic();

        //TODO ask for input of these parameters
        Dish dish = new McNuggets(McNuggetsType.REGULAR, 10);
        MealBase meal = new MealBase(dish, DrinkType.SPRITE, ChipsType.POTATO, MealSizeType.BIG);
        Dessert dessert = new McFlurry(McFlurryType.OREAO);
        selfServicesMechanic.order(dish); //ordering dish
        selfServicesMechanic.order(meal); //ordering meal
        selfServicesMechanic.order(dessert); //ordering dessert


    }
}
