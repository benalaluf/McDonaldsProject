package com.example.mcdonaldsui;

import com.myProject.IndividualDishes.Dish;
import com.myProject.IndividualDishes.McBurger.McBurger;
import com.myProject.IndividualDishes.McBurger.McBurgerType;
import com.myProject.Meal.Meal;
import com.myProject.Meal.MealBase;
import com.myProject.Meal.MealType.ChipsType;
import com.myProject.Meal.MealType.DrinkType;
import com.myProject.Meal.MealType.MealSizeType;
import com.myProject.SelfServicesMechin.SelfServicesMechanic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        SelfServicesMechanic s = new SelfServicesMechanic();
        s.load();
        Dish d = new McBurger(McBurgerType.BIG_MAC);
        MealBase m = new MealBase(d, DrinkType.LEAN , ChipsType.POTATO, MealSizeType.BIG);
        s.order(m);



    }


    public static void main(String[] args) {
        launch();

    }
}