package com.myProject.Meal;

import com.myProject.IndividualDishes.Dessert;
import com.myProject.IndividualDishes.MainDish;
import com.myProject.SelfServicesMechin.SelfServicesMechanic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {
    public enum DessertType {
        VanillaCone, McFlurry, Shake, Sundae;
    }

    static HashMap<String, HashMap<String, Double>> dessertsByTypes = new HashMap<>();
    static HashMap<String, HashMap<String,Double>> mainDishSByTypes = new HashMap<>();

    static List<Dessert> desserts = new ArrayList<>();

    public static void main(String[] args) {

        //maindish
        HashMap<String,Double> mainDishTypes = new HashMap<>();
        mainDishTypes.put("Spicy", 5.0);
        mainDishTypes.put("Regular", 4.0);
        mainDishSByTypes.put("Nuggets", mainDishTypes);

        mainDishTypes = new HashMap<>();
        mainDishTypes.put("BigMac", 6.0);
        mainDishTypes.put("CheeseBurger",5.0);
        mainDishSByTypes.put("McBurger", mainDishTypes);

        //desserts
        HashMap<String, Double> dessertTypes = new HashMap<>();
        dessertTypes.put("regular", 1.0);
        dessertsByTypes.put("Vanilla cone", dessertTypes);

        dessertTypes = new HashMap<>();
        dessertTypes.put("oreo", 3.5);
        dessertTypes.put("mnm", 4.0);
        dessertsByTypes.put("McFlurry", dessertTypes);
        //.....
        //desserts.put("Shake", 1.0);
        //desserts.put("Sundae", 1.0);
        for (var v : dessertsByTypes.entrySet()) {
            for (var pricesByTypes : v.getValue().entrySet()) {
                desserts.add(new Dessert(v.getKey(), pricesByTypes.getKey(), (pricesByTypes.getValue())));
            }
        }
        //TODO figure out how the fuck i syso this


        SelfServicesMechanic selfServicesMechanic = new SelfServicesMechanic();
        //TODO ask for input of these parameters
//        Dish dish = new McNuggets(McNuggetsType.REGULAR, 10);
//        MealBase meal = new MealBase(dish, DrinkType.SPRITE, ChipsType.POTATO, MealSizeType.BIG);
//        Dessert dessert = new McFlurry(McFlurryType.OREAO);
//        selfServicesMechanic.order(dish); //ordering dish
//        selfServicesMechanic.order(meal); //ordering meal
//        selfServicesMechanic.order(dessert); //ordering dessert


    }
}
