module com.example.gameofchancehigherorlower {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gameofchancehigherorlower to javafx.fxml;
    exports com.example.gameofchancehigherorlower;
}