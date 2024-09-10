package com.example.guilesson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    public TextField textGetName;
    public Button btnGetName;
    public TextField textAdd;
    public TextField textSubtract;
    public Label lblTotal;
    public double total = 0;

    public void printName(ActionEvent actionEvent) {
        String name = textGetName.getText();
        System.out.println(name);
    }

    public void add(ActionEvent actionEvent) {
        double num = Double.parseDouble(textAdd.getText());
        total += num;
        lblTotal.setText(Double.toString(total));
        textAdd.clear();
    }

    public void subtract(ActionEvent actionEvent) {
        double num = Double.parseDouble(textSubtract.getText());
        total -= num;
        lblTotal.setText(Double.toString(total));
        textSubtract.clear();
    }
}