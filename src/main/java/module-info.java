module com.example.mcdonaldsui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires McdonaldsShare;

    opens com.example.mcdonaldsui to javafx.fxml;

    exports com.example.mcdonaldsui;

}