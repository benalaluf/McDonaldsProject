package com.example.mcdonaldsui;

import com.myProject.SelfServicesMechin.SelfServicesMechanic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class McDonaldsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ben.fxml")));
        stage.setTitle("McDonalds");
        stage.setScene(new Scene(root));
        stage.show();
    }


    public static void main(String[] args) {
       launch();
//        SelfServicesMechanic selfServicesMechanic = new SelfServicesMechanic();
//        selfServicesMechanic.load();
//
//
//        selfServicesMechanic.orderDish("mcNuggets","regular");
        //selfServicesMechanic.orderMeal("mcNuggets", "spicy","snacks","potato fries","beverage", "lean");
        // selfServicesMechanic.orderDish("mcNuggets", "spicy");
        //selfServicesMechanic.orderSideDish("beverage","lean");
}}