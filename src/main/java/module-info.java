module com.example.broodjeszaakapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.broodjeszaakapp to javafx.fxml;
    exports com.example.broodjeszaakapp;
}