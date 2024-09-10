module com.example.guilesson {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.guilesson to javafx.fxml;
    exports com.example.guilesson;
}