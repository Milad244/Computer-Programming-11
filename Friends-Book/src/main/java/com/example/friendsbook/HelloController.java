package com.example.friendsbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class HelloController {

    //fields
    // friends array list
    private ArrayList<Friend> friends;

    // Javafx objects
    public TextField textNewName;
    public TextField textNewAge;
    public TextField textNewFavFood;
    public Label lblCreateError;
    public VBox vboxFriendsList;
    public Label lblFriendInfo;
    public TextField textNewFriendLvl;
    public HBox hboxFriendButtons;

    //methods

    // Requires: nothing
    // Modifies: this
    // Effects: creates friends arraylist
    public void initialize(){
        friends = new ArrayList<>();
    }

    // Requires: clicking on create new friend btn
    // Modifies: this and javafx objects
    // Effects: creates a new friend if params from user pass checks
    public void createNewFriend(ActionEvent actionEvent) {
        String name = textNewName.getText();
        String age = textNewAge.getText();
        String favFood = textNewFavFood.getText();
        String friendLvl = textNewFriendLvl.getText();
        textNewName.clear();
        textNewAge.clear();
        textNewFavFood.clear();
        textNewFriendLvl.clear();

        if (nameCheck(name) && ageCheck(age) && favFoodCheck(favFood) && friendLvlCheck(friendLvl)){
            int ageInt = Integer.parseInt(age);
            int friendLvlInt = Integer.parseInt(friendLvl);
            friends.add(new Friend(name, ageInt, favFood, friendLvlInt));
            displayFriendsList();
            lblCreateError.setText("");
        }
    }

    // Requires: name as a string
    // Modifies: this and javafx objects
    // Effects: returns true if name passes all the checks. If not, returns false and gives the user an error msg
    private boolean nameCheck(String name){
        if (name.length() > 15){
            lblCreateError.setText("Name can't be over 15 characters");
            return false;
        } else if (name.isEmpty()){
            lblCreateError.setText("Name can't be empty");
            return false;
        } else{
            for (Friend friend : friends){
                    if (friend.getName().equals(name)){
                        lblCreateError.setText("Name cannot be a duplicate of another");
                        return false;
                }
            }
            return true;
        }
    }

    // Requires: age as a string
    // Modifies: this and javafx objects
    // Effects: returns true if age passes all the checks. If not, returns false and gives the user an error msg
    private boolean ageCheck(String age){
        try{
            int potentialAge = Integer.parseInt(age);
            if (potentialAge < 0){
                lblCreateError.setText("Age can't be negative");
                return false;

            } else if (potentialAge > 150){
                lblCreateError.setText("Age can't be over 150");
                return false;
            } else{
                return true;
            }
        } catch (Exception e){
            lblCreateError.setText("Age must be a number");
            return false;
        }
    }

    // Requires: favourite food as a string
    // Modifies: this and javafx objects
    // Effects: returns true if favourite food passes all the checks. If not, returns false and gives the user an error msg
    private boolean favFoodCheck(String favFood){
        if (favFood.length() > 20){
            lblCreateError.setText("Favourite food can't be over 20 characters");
            return false;
        } else if (favFood.isEmpty()){
            lblCreateError.setText("Favourite food can't be empty");
            return false;
        } else{
            return true;
        }
    }

    // Requires: friend level as a string
    // Modifies: this and javafx objects
    // Effects: returns true if friend level passes all the checks. If not, returns false and gives the user an error msg
    private boolean friendLvlCheck(String friendLvl){
        try{
            int potentialFriendLvl = Integer.parseInt(friendLvl);
            if (potentialFriendLvl < 1 || potentialFriendLvl > 5){
                lblCreateError.setText("Friend level is only from 1 to 5");
                return false;
            } else{
                return true;
            }
        } catch (Exception e){
            lblCreateError.setText("Friend level must be a number");
            return false;
        }
    }

    // Requires: nothing
    // Modifies: javafx objects
    // Effects: creates a button for every friend you have. For each button, clicking will result in calling handleFriend-
    // which then shows that specific friend's properties and options.
    private void displayFriendsList(){
        vboxFriendsList.getChildren().clear(); //clears previous friend list
        for (Friend friend : friends){
            Button friendButton = new Button(friend.getName());
            friendButton.setStyle("-fx-font-size: 15px");

            friendButton.setOnAction(event -> {
                handleFriend(friend);
            });

            vboxFriendsList.getChildren().add(friendButton);
        }
    }

    // Requires: friend as a Friend
    // Modifies: javafx objects
    // Effects: displays the given friend's properties and options.
    private void handleFriend(Friend friend){
        exitFriend(); //exits previous friend that was handled
        lblFriendInfo.setText("Your " + friend.getFriendLvlString() + " " + friend.getName() + " is " + friend.getAge() +
                " and loves " + friend.getFavouriteFood() + "!");

        // Upgrade friend button
        Button upgradeFriendBtn = new Button("Upgrade Friend");
        upgradeFriendBtn.setOnAction(event -> {
            upgradeFriend(friend);
        });
        hboxFriendButtons.getChildren().add(upgradeFriendBtn);

        // Downgrade friend button
        Button downgradeFriendBtn = new Button("Downgrade Friend");
        downgradeFriendBtn.setOnAction(event -> {
            downgradeFriend(friend);
        });
        hboxFriendButtons.getChildren().add(downgradeFriendBtn);

        // Birthday friend button
        Button birthdayFriendBtn = new Button("Friend had Birthday!");
        birthdayFriendBtn.setOnAction(event -> {
            birthday(friend);
        });
        hboxFriendButtons.getChildren().add(birthdayFriendBtn);

        // Delete friend button
        Button deleteFriendBtn = new Button("Delete Friend");
        deleteFriendBtn.setOnAction(event -> {
            deleteFriend(friend);
        });
        hboxFriendButtons.getChildren().add(deleteFriendBtn);
    }

    // Requires: nothing
    // Modifies: javafx objects
    // Effects: removes the friend that is currently displayed and its given option buttons also resets error messages.
    private void exitFriend(){
        lblFriendInfo.setText("");
        hboxFriendButtons.getChildren().clear();
        lblCreateError.setText("");
    }

    // Requires: friend as a Friend
    // Modifies: this
    // Effects: deletes the given friend from the friends arraylist. Then calls functions to reload the javafx objects.
    private void deleteFriend(Friend friend){
        friends.remove(friend);
        exitFriend();
        displayFriendsList();
    }

    // Requires: friend as a Friend
    // Modifies: this and javafx objects
    // Effects: if allowed, upgrades friend lvl. Then calls functions to reload the javafx objects. If not, gives error msg.
    private void upgradeFriend(Friend friend){
        if (friend.getFriendLvl() < 5){
            friend.upgradeFriend();
            exitFriend();
            handleFriend(friend);
        } else{
            lblCreateError.setText("Friend is already at the max level");
        }
    }

    // Requires: friend as a Friend
    // Modifies: this
    // Effects: if allowed, downgrades friend lvl. Then calls functions to reload the javafx objects. If not, gives error msg.
    private void downgradeFriend(Friend friend){
        if (friend.getFriendLvl() > 1){
            friend.downgradeFriend();
            exitFriend();
            handleFriend(friend);
        } else{
            lblCreateError.setText("Friend is already at the lowest level");
        }
    }

    // Requires: friend as a Friend
    // Modifies: this and javafx objects
    // Effects: if allowed, increases friends age. Then calls functions to reload the javafx objects. If not, gives error msg.
    private void birthday(Friend friend){
        if (friend.getAge() < 150){
            friend.increaseAge();
            exitFriend();
            handleFriend(friend);
        } else{
            lblCreateError.setText("Friend is already at the max age");
        }
    }
}