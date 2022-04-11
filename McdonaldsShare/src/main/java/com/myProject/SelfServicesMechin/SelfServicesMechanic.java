package com.myProject.SelfServicesMechin;

import com.myProject.Meal.BeveragesAndSides.Beverages;
import com.myProject.Meal.BeveragesAndSides.Sides;
import com.myProject.Meal.BeveragesAndSides.Snack;
import com.myProject.IndividualDishes.Dessert;
import com.myProject.IndividualDishes.Dish;
import com.myProject.IndividualDishes.MainDish;
import com.myProject.Meal.Meal;

import java.text.SimpleDateFormat;
import java.util.*;

public class SelfServicesMechanic {

    private final Random rnd = new Random();
    private final Scanner scn = new Scanner(System.in);
    //TODO to use this array
    private final int[] orderNumberArray = new int[10];
    private int orderNumber;
    private String clientName;
    private String currentDateAndTime;
    private double totalPrice;

    public List<Dish> dishes = new ArrayList<>();
    public List<MainDish> mainDishes = new ArrayList<>();
    public List<Dessert> desserts = new ArrayList<>();
    public List<Sides> sides = new ArrayList<>();
    public List<Beverages> beverage = new ArrayList<>();
    public List<Snack> snack = new ArrayList<>();

    private HashMap<String, HashMap<String, Double>> mainDishByName = new HashMap<>();
    private HashMap<String, HashMap<String, Double>> dessertsByName = new HashMap<>();
    private HashMap<String, HashMap<String, Double>> beverageByName = new HashMap<>();
    private HashMap<String, HashMap<String, Double>> snackByName = new HashMap<>();

    public SelfServicesMechanic() {

    }

    public void load() {
        //TODO dont creat thousand hashmaps and be arab, type:gaza
        // we are not arabs we are better...
        //TODO find solution for the arab rookie mistake if i care?
        //TODO something is werid idont know waht
        //main dish
        HashMap<String, Double> mcNuggetsTypes = new HashMap<>();
        mcNuggetsTypes.put("spicy", 5.0);
        mcNuggetsTypes.put("regular", 4.0);
        mainDishByName.put("mcNuggets", mcNuggetsTypes);

        HashMap<String, Double> mcBurgerTypes = new HashMap<>();
        mcBurgerTypes.put("bigMac", 6.0);
        mcBurgerTypes.put("doubleBigMac", 8.0);
        mcBurgerTypes.put("cheeseBurger", 5.0);
        mainDishByName.put("mcBurger", mcBurgerTypes);

        for (var v : mainDishByName.entrySet()) {
            for (var pricesByTypes : v.getValue().entrySet()) {
                mainDishes.add(new MainDish(v.getKey(), pricesByTypes.getKey(), (pricesByTypes.getValue())) {});
                dishes.add(new Dish(v.getKey(), pricesByTypes.getKey(), (pricesByTypes.getValue())) {});
            }
        }

        //desserts
        HashMap<String, Double> vanillaConeTypes = new HashMap<>();
        vanillaConeTypes.put("regular", 1.0);
        dessertsByName.put("vanilla cone", vanillaConeTypes);

        HashMap<String, Double> mcFlurryTypes = new HashMap<>();
        mcFlurryTypes.put("oreo", 3.5);
        mcFlurryTypes.put("mnm", 4.0);
        dessertsByName.put("mcFlurry", mcFlurryTypes);

        HashMap<String, Double> ShakeTypes = new HashMap<>();
        ShakeTypes.put("strawBerry", 5.0);
        ShakeTypes.put("chocolate", 5.0);
        ShakeTypes.put("vanilla", 5.0);
        dessertsByName.put("Shake", ShakeTypes);

        for (var v : dessertsByName.entrySet()) {
            for (var pricesByTypes : v.getValue().entrySet()) {
                desserts.add(new Dessert(v.getKey(), pricesByTypes.getKey(), (pricesByTypes.getValue())) {});
                dishes.add(new Dish(v.getKey(), pricesByTypes.getKey(), (pricesByTypes.getValue())) {});
            }
        }

        //beverages
        HashMap<String, Double> beveragesTypes = new HashMap<>();
        beveragesTypes.put("cola", 3.0);
        beveragesTypes.put("sprite", 2.5);
        beveragesTypes.put("fanta", 2.5);
        beveragesTypes.put("lean", 6.9);
        beverageByName.put("beverage", beveragesTypes);

        for (var v : beverageByName.entrySet()) {
            for (var pricesByTypes : v.getValue().entrySet()) {
                beverage.add(new Beverages(v.getKey(), pricesByTypes.getKey(), (pricesByTypes.getValue())) {});
                sides.add(new Sides(v.getKey(), pricesByTypes.getKey(), (pricesByTypes.getValue())) {});
            }
        }

        //snacks
        HashMap<String, Double> SnackTypes = new HashMap<>();
        SnackTypes.put("french fries", 4.0);
        SnackTypes.put("potato fries", 6.0);
        SnackTypes.put("apple slices", 3.0);
        snackByName.put("snacks", SnackTypes);

        for (var v : snackByName.entrySet()) {
            for (var pricesByTypes : v.getValue().entrySet()) {
                snack.add(new Snack(v.getKey(), pricesByTypes.getKey(), (pricesByTypes.getValue())) {});
                sides.add(new Sides(v.getKey(), pricesByTypes.getKey(), (pricesByTypes.getValue())) {});
            }
        }
    }

    /**
     * //TODO
     * new idea make order inner class
     * and by that add a feture that you can order couple
     * individual dish in the same order!
     * now to order cola and nuggets is isnt possible to do in the same order
     * so this will solve all world problems
     */

    public void orderDish(String dishName, String type) {
        int valid = 0;
        for (Dish dish : dishes) {
            if ((dish.getName()) == dishName && (dish.getType()) == type) {
                askClientName();
                setOrderNumber();
                setCurrentDateAndTime();
                setTotalPrice(dish.getPrice());
                recipe(dish.getName(), dish.getType());
                valid++;
            }
        }
        if (valid != 1) {
            System.out.println("you entered invalid");
        }
    }

    public void orderSideDish(String sideName, String type) {
        int valid = 0;
        for (Sides sides : sides) {
            if ((sides.getName()) == sideName && (sides.getType()) == type) {
                askClientName();
                setOrderNumber();
                setCurrentDateAndTime();
                setTotalPrice(sides.getPrice());
                recipe(sides.getName(), sides.getType());
                valid++;
            }
        }
        if (valid != 1) {
            System.out.println("you entered invalid");
        }
    }

    public void orderMeal(String mainDish, String dishType, String snacks, String snackType, String beverages, String beveragesType) {
        int valid = 0;

        for (MainDish dish : mainDishes) {
            if ((dish.getName()) == mainDish && (dish.getType()) == dishType) {
                addToTotalPrice(dish.getPrice());
                valid++;
            }

        }

        for (Snack snack : snack) {
            if ((snack.getName()) == snacks && (snack.getType()) == snackType) {
                addToTotalPrice(snack.getPrice());
                valid++;
            }

        }

        for (Beverages beverages1 : beverage) {
            if ((beverages1.getName()) == beverages && (beverages1.getType()) == beveragesType) {
                addToTotalPrice(beverages1.getPrice());
                valid++;
            }
        }

        if (valid == 3) {
            askClientName();
            setOrderNumber();
            setCurrentDateAndTime();
            recipe(mainDish, dishType, snacks, snackType, beverages, beveragesType);
        } else {
            System.out.println("you entered invalid");
        }
    }

    public void recipe(String name, String type) {

        //TODO make GUI
        System.out.println("ORDER NUMBER - " + orderNumber);
        System.out.println("---------------------------------");
        System.out.println("client name - " + clientName);
        System.out.println("time of deal - " + currentDateAndTime);
        System.out.println("ordering details - ");
        System.out.println("1 x " + name + " type:" + type);
        System.out.println("THE TOTAL PRICE IS " + totalPrice + "$");
        System.out.println("---------------------------------");
    }

    public void recipe(String mainDish, String dishType, String snacks, String snackType, String beverages, String beveragesType) {
        double[] price = new double[3];
        for (MainDish dish : mainDishes) {
            if ((dish.getName()) == mainDish && (dish.getType()) == dishType) {
                price[0] = dish.getPrice();
            }

        }

        for (Snack snack : snack) {
            if ((snack.getName()) == snacks && (snack.getType()) == snackType) {
                price[1] = snack.getPrice();
            }

        }

        for (Beverages beverages1 : beverage) {
            if ((beverages1.getName()) == beverages && (beverages1.getType()) == beveragesType) {
                price[2] = beverages1.getPrice();
            }
        }
        //TODO make GUI
        System.out.println("ORDER NUMBER - " + orderNumber);
        System.out.println("---------------------------------");
        System.out.println("client name - " + clientName);
        System.out.println("time of deal - " + currentDateAndTime);
        System.out.println("ordering details - ");
        System.out.println("1 x " + mainDish + " type:" + dishType + " " + price[0] + "$");
        System.out.println("1 x " + snacks + " type:" + snackType + " " + price[1] + "$");
        System.out.println("1 x " + beverages + " type:" + beveragesType + " " + price[2] + "$");
        System.out.println("THE TOTAL PRICE IS " + totalPrice + "$");
        System.out.println("---------------------------------");
    }

    //TODO make it so that there is no way that two same order number
    public void setOrderNumber() {
        orderNumber = rnd.nextInt(101) + 1;
    }

    public void askClientName() {
        System.out.println("Pleas Enter Your Name - ");
        clientName = scn.next();

    }

    public void setTotalPrice(double price) {
        totalPrice = price;
    }

    public void addToTotalPrice(double price) {
        totalPrice += price;
    }

    public void setCurrentDateAndTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        currentDateAndTime = (formatter.format(date));
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public String getCurrentDateAndTime() {
        return currentDateAndTime;
    }
}
