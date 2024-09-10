package com.example.gameofchancehigherorlower;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    public double bankBalance;
    public double gambleAmount;
    public double rollNum;
    public String gambleState;
    public static final String LOWER = "Lower";
    public static final String HIGHER = "Higher";
    public static final String NONE = "None";
    public int winCount;
    public int lossCount;
    public double earnings;
    public double losses;

    public Label lblBankBalance;
    public TextField textGambleAmount;
    public Label lblGambleAmount;
    public Label lblGambleAmountError;
    public Label lblResult;
    public Label lblRollNum;
    public Label lblScore;
    public Button btnLower;
    public Button btnHigher;

    // Requires: nothing
    // Modifies: this and javafx objects
    // Effects: Creates default fields and sets correct text for given javafx objects
    public void initialize() {
        bankBalance = 10000;
        lblBankBalance.setText("$" + bankBalance);
        gambleAmount = 500;
        lblGambleAmount.setText("$" + gambleAmount);

        rollNum = Math.round(Math.random() * 100);
        lblRollNum.setText(Double.toString(rollNum));

        gambleState = NONE;
        btnHigher.setStyle("");
        btnLower.setStyle("");

        winCount = 0;
        lossCount = 0;
        earnings = 0;
        losses = 0;
        lblResult.setText("");
        updateScore();
    }

    // Requires: Clicking on updateGambleAmount btn
    // Modifies: this and javafx objects
    // Effects: updates the gambling amount, as long as it is acceptable. Also, sets correct text for given javafx objects
    public void updateGambleAmount(ActionEvent actionEvent) {
        try{ // I use a try statement in case the user puts a non-numbered string
            double potentialGambleAmount = Math.round(Double.parseDouble(textGambleAmount.getText()));
            if (potentialGambleAmount < 0){
                lblGambleAmountError.setText("You cannot gamble with negative money");
            } else if (potentialGambleAmount > bankBalance){
                lblGambleAmountError.setText("You do not have enough money");
            } else{
                gambleAmount = potentialGambleAmount;
                lblGambleAmountError.setText("");
                lblGambleAmount.setText("$" + gambleAmount);
            }
        } catch (Exception e) {
            lblGambleAmountError.setText("Not a number");
        }
        textGambleAmount.clear();
    }

    // Requires: Clicking on roll btn
    // Modifies: this and javafx objects
    // Effects: Rolls and checks if the new number is higher or lower than the previous -> handles the result. Also, sets correct text for given javafx objects
    public void roll(ActionEvent actionEvent) {
        if (gambleState.equals(NONE)){
            lblResult.setText("Please select higher or lower before playing");
        } else{
            double previousRollNum = rollNum;
            rollNum = Math.round(Math.random() * 100);
            lblRollNum.setText(Double.toString(rollNum));
            switch (gambleState) {
                case HIGHER: {
                    if (rollNum > previousRollNum) {
                        handleResult("Won");
                    } else {
                        handleResult("Loss");
                    }
                    break;
                }
                case LOWER: {
                    if (rollNum < previousRollNum) {
                        handleResult("Won");
                    } else {
                        handleResult("Loss");
                    }
                    break;
                }
            }
        }
    }

    // Requires: Result as a string
    // Modifies: this and javafx objects
    // Effects: updates bank balance based on your result and gamble amount. Also, sets correct text for given javafx objects
    public void handleResult(String result){
        if (result.equals("Won")){
            bankBalance += gambleAmount;
            winCount++;
            earnings += gambleAmount;
            if (bankBalance == 0){
                lblResult.setText("YOU WON!!!\nYOU'RE POOR!!! You can keep gambling for fun or restart.");
            } else{
                lblResult.setText("YOU WON!!!");
            }
        } else if (result.equals("Loss")){
            bankBalance -= gambleAmount;
            lossCount++;
            losses += gambleAmount;
            if (bankBalance == 0){
                lblResult.setText("YOU LOST!!!\nYOU'RE POOR!!! You can keep gambling for fun or restart.");
            } else{
                lblResult.setText("YOU LOST!!!");
            }
        }
        // Making sure gamble amount cannot be over bank balance
        if (bankBalance < gambleAmount){
            gambleAmount = bankBalance;
            lblGambleAmount.setText("$" + gambleAmount);
        }

        updateScore();
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: Sets correct text for given javafx objects
    public void updateScore(){
        lblBankBalance.setText("$" + bankBalance);
        lblScore.setText("Win count: " + winCount + " Earnings: $" + earnings + "\nLoss count: " + lossCount + " Losses: $" + losses);
    }

    // Requires: Clicking on gamble lower btn
    // Modifies: this and javafx objects
    // Effects: Updates gamble state to lower. Also, sets correct text and style for given javafx objects
    public void gambleLower(ActionEvent actionEvent) {
        gambleState = LOWER;
        btnHigher.setStyle("");
        btnLower.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
    }
    // Requires: Clicking on gambleHigher btn
    // Modifies: this and javafx objects
    // Effects: Updates gamble state to higher. Also, sets correct text and style for given javafx objects
    public void gambleHigher(ActionEvent actionEvent) {
        gambleState = HIGHER;
        btnLower.setStyle("");
        btnHigher.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
    }
}
