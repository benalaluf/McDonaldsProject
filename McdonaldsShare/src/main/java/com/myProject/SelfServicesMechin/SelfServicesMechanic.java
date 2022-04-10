package com.myProject.SelfServicesMechin;

import com.myProject.IndividualDishes.Dessert;
import com.myProject.IndividualDishes.Dish;

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

    private HashMap<String, HashMap<String, Double>> dishByName = new HashMap<>();
    //private HashMap<String, Double> dishTypes = new HashMap<>();

    public SelfServicesMechanic() {

    }

    public void load() {
        //TODO dont creat thousand hashmaps and be arab, type:gaza
        // we are not arabs we are better...
        //TODO find solution for the arab rookie mistake if i care?
        //main dish
        HashMap<String, Double> mcNuggetsTypes = new HashMap<>();
        mcNuggetsTypes.put("spicy", 5.0);
        mcNuggetsTypes.put("regular", 4.0);
        dishByName.put("mcNuggets", mcNuggetsTypes);

        HashMap<String, Double> mcBurgerTypes = new HashMap<>();
        mcBurgerTypes.put("bigMac", 6.0);
        mcBurgerTypes.put("cheeseBurger", 5.0);
        dishByName.put("mcBurger", mcBurgerTypes);

        //desserts
        HashMap<String, Double> vanillaConeTypes = new HashMap<>();
        vanillaConeTypes.put("regular", 1.0);
        dishByName.put("vanilla cone", vanillaConeTypes);

        HashMap<String, Double> mcFlurryTypes = new HashMap<>();
        mcFlurryTypes.put("oreo", 3.5);
        mcFlurryTypes.put("mnm", 4.0);
        dishByName.put("mcFlurry", mcFlurryTypes);

        HashMap<String, Double> ShakeTypes = new HashMap<>();
        ShakeTypes.put("strawBerry", 5.0);
        ShakeTypes.put("chocolate", 5.0);
        ShakeTypes.put("vanilla", 5.0);
        dishByName.put("Shake", ShakeTypes);

        for (var v : dishByName.entrySet()) {
            for (var pricesByTypes : v.getValue().entrySet()) {
                dishes.add(new Dessert(v.getKey(), pricesByTypes.getKey(), (pricesByTypes.getValue())));
            }
        }
    }

    public void order(Dish dish) {
        if (!(null == dishByName.get(dish.getName())) && !(null == dishByName.get(dish.getName()).get(dish.getType()))) {
            setTotalPrice(dishByName.get(dish.getName()).get(dish.getType()));
            askClientName();
            setOrderNumber();
            setCurrentDateAndTime();
            recipe(dish.getName(), dish.getType());
        } else {
            System.out.println("you enter invalid name/type of desserts aka null");
        }
    }

    public void order(String name, String type) {
        int valid = 0;
        for (int i = 0; i < dishes.size(); i++) {
            if ((dishes.get(i).getName()) == name && (dishes.get(i).getType()) == type) {
                askClientName();
                setOrderNumber();
                setCurrentDateAndTime();
                recipe(dishes.get(i).getName(), dishes.get(i).getType());
                valid++;
            }
        }
        if (valid != 1) {
            System.out.println("you entered unvalid shit");
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
