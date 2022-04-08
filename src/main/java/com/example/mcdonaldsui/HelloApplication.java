package com.example.mcdonaldsui;

import com.myProject.Meal.Main;
import com.myProject.Meal.Meal;
import com.myProject.Meal.MealBase;
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
        Meal d = new MealBase(null,null,null,null);
    }


    public static void main(String[] args) {
      //  launch();
        //TODO figure out how the fuck i syso this
        // i did it ezzzz
        SelfServicesMechanic selfServicesMechanic = new SelfServicesMechanic();
        selfServicesMechanic.load();
        //TODO make order one method
        selfServicesMechanic.order("vanilla cone","regular");
        selfServicesMechanic.order("mcNuggets", "oreo");
    }
}