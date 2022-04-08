package com.myProject.SelfServicesMechin;

import com.myProject.IndividualDishes.Dessert;
import com.myProject.IndividualDishes.Dish;
import com.myProject.IndividualDishes.MainDish;
import com.myProject.Meal.MealBase;

import java.text.SimpleDateFormat;
import java.util.*;

public class SelfServicesMechanic {

    private final Random rnd = new Random();
    private final Scanner scn = new Scanner(System.in);
    private final int[] orderNumberArray = new int[10];
    private int orderNumber;
    private String clientName;
    private String currentDateAndTime;
    private double totalPrice;
    private List<Dessert> desserts = new ArrayList<>();
    private List<MainDish> mainDishes = new ArrayList<>();

    private HashMap<String, HashMap<String, Double>> dessertsByName = new HashMap<>();
    private HashMap<String, HashMap<String, Double>> mainDishSByName = new HashMap<>();
    private HashMap<String, Double> dessertTypes = new HashMap<>();
    private HashMap<String, Double> mainDishTypes = new HashMap<>();

    public SelfServicesMechanic() {
    }

    public void load() {


        //main dish
        mainDishTypes.put("Spicy", 5.0);
        mainDishTypes.put("Regular", 4.0);
        mainDishSByName.put("Nuggets", mainDishTypes);

        mainDishTypes = new HashMap<>();
        mainDishTypes.put("BigMac", 6.0);
        mainDishTypes.put("CheeseBurger", 5.0);
        mainDishSByName.put("McBurger", mainDishTypes);

        //desserts
        dessertTypes.put("regular", 1.0);
        dessertsByName.put("Vanilla cone", dessertTypes);

        dessertTypes = new HashMap<>();
        dessertTypes.put("oreo", 3.5);
        dessertTypes.put("mnm", 4.0);
        dessertsByName.put("McFlurry", dessertTypes);
        //.....
        //desserts.put("Shake", 1.0);
        //desserts.put("Sundae", 1.0);
        for (var v : dessertsByName.entrySet()) {
            for (var pricesByTypes : v.getValue().entrySet()) {
                desserts.add(new Dessert(v.getKey(), pricesByTypes.getKey(), (pricesByTypes.getValue())));
            }
        }
    }


    public void orderMainDish(String name, String type) {
        if (!(null == mainDishSByName.get(name)) && !(null == mainDishSByName.get(name).get(type))) {
            setTotalPrice(mainDishSByName.get(name).get(type));
            askClientName();
            setOrderNumber();
            setCurrentDateAndTime();
            recipe(name, type);
        } else {
            System.out.println("you enter invalid name/type of desserts aka null");
        }
    }

    public void orderDessert(String name, String type) {
        if (!(null == dessertsByName.get(name)) && !(null == dessertsByName.get(name).get(type))) {
            setTotalPrice(dessertsByName.get(name).get(type));
            askClientName();
            setOrderNumber();
            setCurrentDateAndTime();
            recipe(name,type);
        }else {
            System.out.println("you enter invalid name/type of desserts aka null");
        }
    }

    public void recipe(String name, String type) {
        //TODO make GUI
        System.out.println("ORDER NUMBER - " + orderNumber);
        System.out.println("---------------------------------");
        System.out.println("client name - " + clientName);
        System.out.println("time of deal - " + currentDateAndTime);
        System.out.println("ordering details - ");
        System.out.println("1 x "+ name+" type:" +type);
        System.out.println("THE TOTAL PRICE IS " + totalPrice + "$");
        System.out.println("---------------------------------");

    }

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
