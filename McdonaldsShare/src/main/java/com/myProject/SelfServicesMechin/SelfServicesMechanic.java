package com.myProject.SelfServicesMechin;

import com.myProject.IndividualDishes.Dessert;
import com.myProject.IndividualDishes.Dish;
import com.myProject.Meal.MealBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class SelfServicesMechanic {

    private final Random rnd = new Random();
    private final Scanner scn = new Scanner(System.in);
    private final int[] orderNumberArray = new int[10];
    private int orderNumber;
    private String clientName;
    private String currentDateAndTime;
    private double totalPrice;

    public SelfServicesMechanic() {
    }


    public void order(MealBase meal) {
        setTotalPrice(meal.getPrice());
        askClientName();
        setOrderNumber();
        setCurrentDateAndTime();
        recipe();
    }

    public void order(Dish dish) {
        setTotalPrice(dish.getPrice());
        askClientName();
        setOrderNumber();
        setCurrentDateAndTime();
        recipe();

    }

    public void order(Dessert dessert) {
        setTotalPrice(dessert.getPrice());
        askClientName();
        setOrderNumber();
        setCurrentDateAndTime();
        recipe();
    }

    public void recipe() {
        //TODO make GUI
        System.out.println("ORDER NUMBER - " + orderNumber);
        System.out.println("---------------------------------");
        System.out.println("client name - " + clientName);
        System.out.println("time of deal - " + currentDateAndTime);
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
