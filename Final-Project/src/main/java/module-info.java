module com.example.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
}