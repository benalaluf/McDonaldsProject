package com.example.mcdonaldsui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class McDonaldsController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}