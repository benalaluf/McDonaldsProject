package com.example.mcdonaldsui;

import com.myProject.IndividualDishes.Dessert;
import com.myProject.IndividualDishes.Dish;
import com.myProject.IndividualDishes.MainDish;
import com.myProject.Meal.Main;
import com.myProject.Meal.Meal;
import com.myProject.Meal.MealBase;
import com.myProject.SelfServicesMechin.SelfServicesMechanic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class McDonaldsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, Color.GRAY);
        Image icon = new Image("file:src/mcdonad.png");

        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setWidth(420);
        stage.setHeight(420);
        stage.setFullScreen(false);
        stage.setFullScreenExitHint("Welcome to mcdonalds");
        stage.setTitle("McDonalds");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        //launch();
        SelfServicesMechanic selfServicesMechanic = new SelfServicesMechanic();
        selfServicesMechanic.load();
        //TODO The bug that make me order mcnuggets type oreo
        selfServicesMechanic.order("mcNuggets","spicy");
        selfServicesMechanic.order("mcNuggets", "spicy","snacks","potato fries","beverage", "lean");
}}