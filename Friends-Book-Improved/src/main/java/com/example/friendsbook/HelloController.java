package com.example.friendsbook;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.*;
import java.util.ArrayList;

public class HelloController {

    public TextField textFileName;
    //fields
    private ArrayList<FriendGroup> friendGroups;
    private FriendGroup currentFriendGroup;

    // Javafx objects
    public TextField textNewName;
    public TextField textNewAge;
    public TextField textNewFavFood;
    public Label lblError;
    public ListView listviewFriendsList;
    public Label lblFriendInfo;
    public TextField textNewFriendLvl;
    public HBox hboxFriendOptions;
    public TextField textNewFriendGroup;
    public ListView listviewFriendGroupList;
    public HBox hboxGroupOptions;

    //methods

    // Requires: nothing
    // Modifies: this
    // Effects: creates a starting friend group and displays it
    public void initialize(){
        friendGroups = new ArrayList<>();
        FriendGroup startingGroup = new FriendGroup("General Friends");
        friendGroups.add(startingGroup);
        currentFriendGroup = startingGroup;
        displayGroupList();
    }

    // Requires: clicking on create new friend group btn
    // Modifies: this and javafx objects
    // Effects: creates a new friend group and displays it if the name passes the check
    public void createNewFriendGroup(ActionEvent actionEvent) {
        String groupName = textNewFriendGroup.getText();
        textNewFriendGroup.clear();

        if (groupNameCheck(groupName)){
            friendGroups.add(new FriendGroup(groupName));
            displayGroupList();
            lblError.setText("");
        }
    }

    // Requires: name as a string
    // Modifies: this and javafx objects
    // Effects: returns true if the group name passes all the checks. If not, returns false and gives the user an error msg
    private boolean groupNameCheck(String name){
        if (name.length() > 15){
            lblError.setText("Group name can't be over 15 characters");
            return false;
        } else if (name.isEmpty()){
            lblError.setText("Group name can't be empty");
            return false;
        } else{
            for (FriendGroup friendGroup : friendGroups){
                if (friendGroup.getGroupName().equals(name)){
                    lblError.setText("Group name cannot be a duplicate of another");
                    return false;
                }
            }
            return true;
        }
    }

    // Requires: clicking on create new friend btn
    // Modifies: this and javafx objects
    // Effects: creates a new friend in the current friend group and displays it if params from user pass checks
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
            currentFriendGroup.addFriend(new Friend(name, ageInt, favFood, friendLvlInt));
            displayFriendsList();
            lblError.setText("");
        }
    }

    // Requires: name as a string
    // Modifies: this and javafx objects
    // Effects: returns true if name passes all the checks. If not, returns false and gives the user an error msg
    private boolean nameCheck(String name){
        if (name.length() > 15){
            lblError.setText("Name can't be over 15 characters");
            return false;
        } else if (name.isEmpty()){
            lblError.setText("Name can't be empty");
            return false;
        } else{
            for (FriendGroup friendGroup : friendGroups) {
                for (Friend friend : friendGroup.getFriends()){
                    if (friend.getName().equals(name)){
                        lblError.setText("Name cannot be a duplicate of another");
                        return false;
                    }
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
                lblError.setText("Age can't be negative");
                return false;

            } else if (potentialAge > 150){
                lblError.setText("Age can't be over 150");
                return false;
            } else{
                return true;
            }
        } catch (Exception e){
            lblError.setText("Age must be a number");
            return false;
        }
    }

    // Requires: favourite food as a string
    // Modifies: this and javafx objects
    // Effects: returns true if favourite food passes all the checks. If not, returns false and gives the user an error msg
    private boolean favFoodCheck(String favFood){
        if (favFood.length() > 20){
            lblError.setText("Favourite food can't be over 20 characters");
            return false;
        } else if (favFood.isEmpty()){
            lblError.setText("Favourite food can't be empty");
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
                lblError.setText("Friend level is only from 1 to 5");
                return false;
            } else{
                return true;
            }
        } catch (Exception e){
            lblError.setText("Friend level must be a number");
            return false;
        }
    }

    // Requires: nothing
    // Modifies: javafx objects
    // Effects: Adds each friend in the current group to the friends list. Clicking a friend will result in calling handleFriend-
    // which then shows that specific friend's properties and options.
    private void displayFriendsList(){
        exitFriend();
        listviewFriendsList.getItems().clear();
        for (Friend friend : currentFriendGroup.getFriends()){
            listviewFriendsList.getItems().add(friend.getName());
        }

        listviewFriendsList.setOnMouseClicked(event -> {
            String selectedFriendName = (String) listviewFriendsList.getSelectionModel().getSelectedItem(); //gets the selected name
            for (Friend friend : currentFriendGroup.getFriends()){
                if (friend.getName().equals(selectedFriendName)){ //finds the friend by checking each name until it equals the selected one
                    handleFriend(friend);
                    break;
                }
            }
        });
    }

    // Requires: nothing
    // Modifies: javafx objects
    // Effects: Adds each friend group to the friends group list. Clicking on a friend group will result in displaying the given friends list
    private void displayGroupList(){
        listviewFriendGroupList.getItems().clear();
        for (FriendGroup friendGroup : friendGroups){
            listviewFriendGroupList.getItems().add(friendGroup.getGroupName());
        }

        listviewFriendGroupList.setOnMouseClicked(event -> {
            String selectedFriendGroupName = (String) listviewFriendGroupList.getSelectionModel().getSelectedItem();
            for (FriendGroup friendGroup : friendGroups){
                if (friendGroup.getGroupName().equals(selectedFriendGroupName)){
                    currentFriendGroup = friendGroup;
                    displayFriendsList();
                    break;
                }
            }
        });
        displayFriendsList();
    }

    // Requires: friend as a Friend
    // Modifies: javafx objects
    // Effects: creates and displays the given friend's properties and options.
    private void handleFriend(Friend friend){
        exitFriend();
        lblFriendInfo.setText(friend.toString());

        // Upgrade friend button
        Button upgradeFriendBtn = new Button("Upgrade Friend");
        upgradeFriendBtn.setOnAction(event -> {
            upgradeFriend(friend);
        });
        hboxFriendOptions.getChildren().add(upgradeFriendBtn);

        // Downgrade friend button
        Button downgradeFriendBtn = new Button("Downgrade Friend");
        downgradeFriendBtn.setOnAction(event -> {
            downgradeFriend(friend);
        });
        hboxFriendOptions.getChildren().add(downgradeFriendBtn);

        // Birthday friend button
        Button birthdayFriendBtn = new Button("Friend had Birthday!");
        birthdayFriendBtn.setOnAction(event -> {
            birthday(friend);
        });
        hboxFriendOptions.getChildren().add(birthdayFriendBtn);

        // Delete friend button
        Button deleteFriendBtn = new Button("Delete Friend");
        deleteFriendBtn.setOnAction(event -> {
            deleteFriend(friend);
        });
        hboxFriendOptions.getChildren().add(deleteFriendBtn);

        // Delete group button
        Button deleteGroupBtn = new Button("Delete Current Friend Group");
        deleteGroupBtn.setOnAction(event -> {
            deleteGroup(currentFriendGroup);
        });
        hboxGroupOptions.getChildren().add(deleteGroupBtn);
    }

    // Requires: nothing
    // Modifies: javafx objects
    // Effects: removes the friend that is currently displayed and its given option buttons also resets error messages.
    private void exitFriend(){
        lblFriendInfo.setText("");
        hboxFriendOptions.getChildren().clear();
        hboxGroupOptions.getChildren().clear();
        lblError.setText("");
    }

    // Requires: friend as a Friend
    // Modifies: this
    // Effects: deletes the given friend from the current friend group. Then re-display the friends list.
    private void deleteFriend(Friend friend){
        currentFriendGroup.removeFriend(friend);
        displayFriendsList();
    }

    // Requires: friend as a Friend
    // Modifies: this and javafx objects
    // Effects: if allowed, upgrades friend lvl.Then, re-handles the given friend. If not, gives error msg.
    private void upgradeFriend(Friend friend){
        if (friend.getFriendLvl() < 5){
            friend.upgradeFriend();
            handleFriend(friend);
        } else{
            lblError.setText("Friend is already at the max level");
        }
    }

    // Requires: friend as a Friend
    // Modifies: this
    // Effects: if allowed, downgrades friend lvl. Then, re-handles the given friend. If not, gives error msg.
    private void downgradeFriend(Friend friend){
        if (friend.getFriendLvl() > 1){
            friend.downgradeFriend();
            handleFriend(friend);
        } else{
            lblError.setText("Friend is already at the lowest level");
        }
    }

    // Requires: friend as a Friend
    // Modifies: this and javafx objects
    // Effects: if allowed, increases friends age. Then, re-handles the given friend. If not, gives error msg.
    private void birthday(Friend friend){
        if (friend.getAge() < 150){
            friend.increaseAge();
            handleFriend(friend);
        } else{
            lblError.setText("Friend is already at the max age");
        }
    }

    // Requires: friend group as a FriendGroup
    // Modifies: this and javafx objects
    // Effects: if allowed, deletes friend group. Then, re-displays friend groups. If not, gives error msg.
    private void deleteGroup(FriendGroup friendGroup){
        if (friendGroups.size() > 1){
            friendGroups.remove(friendGroup);
            currentFriendGroup = friendGroups.getFirst();
            displayGroupList();
        } else{
            lblError.setText("You must have another friend group before you delete this one");
        }
    }

    // Requires: text file name as a string
    // Modifies: text file
    // Effects: stores all the fields of friendsGroups into the given text file
    private void saveFriendStorage(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);

        for (FriendGroup fg : friendGroups){
            bw.write(fg.getGroupName() + "\r");

            for (Friend f : fg.getFriends()){
                bw.write(f.getName() + "\r");
                bw.write(f.getAge() + "\r");
                bw.write(f.getFavouriteFood() + "\r");
                bw.write(f.getFriendLvl() + "\r");
            }

            bw.write("End Friends\r");
        }

        bw.write("End");
        bw.close();
    }

    // Requires: text file name as a string
    // Modifies: this
    // Effects: If existing, retrieves all the fields of friendsGroups from the given text file.
    // Then, the current friendGroups get replaced by the retrieved ones. If the file does not exist, it gives error msg.
    private void loadFriendStorage(String fileName) throws IOException {
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            ArrayList<FriendGroup> newFriendGroups = new ArrayList<>();
            String line;
            FriendGroup currentFriendGroupIteration = null;

            while ((line = br.readLine()) != null){
                if (line.equals("End")){
                    break;
                } else if (line.equals("End Friends")){
                    if (currentFriendGroupIteration != null) {
                        newFriendGroups.add(currentFriendGroupIteration);
                        currentFriendGroup = currentFriendGroupIteration;
                        currentFriendGroupIteration = null;
                    }
                } else if (currentFriendGroupIteration == null) {
                    currentFriendGroupIteration = new FriendGroup(line);
                } else{
                    String friendName = line;
                    int friendAge = Integer.parseInt(br.readLine());
                    String friendFavouriteFood = br.readLine();
                    int friendLevel = Integer.parseInt(br.readLine());

                    Friend friend = new Friend(friendName, friendAge, friendFavouriteFood, friendLevel);
                    currentFriendGroupIteration.addFriend(friend);
                }
            }

            friendGroups = newFriendGroups;
            displayGroupList();
        } catch (Exception e){
            lblError.setText("Save file does not exist");
        }
    }

    // Requires: clicking on load button
    // Modifies: javafx objects
    // Effects: Retrieves the file name from the user text input.
    // Then, if the file name passes its check, it resets the error text and runs the method that loads the file.
    public void handleLoadFile(ActionEvent actionEvent) throws IOException {
        String fileName = textFileName.getText();
        if (fileNameCheck(fileName)){
            lblError.setText("");
            loadFriendStorage(fileName);
        }
    }

    // Requires: text file name as a string
    // Modifies: javafx objects
    // Effects: returns true if the text file name passes all the checks. If not, returns false and gives the user an error msg
    private boolean fileNameCheck(String fileName){
        if (fileName.length() > 15){
            lblError.setText("File name can't be over 15 characters");
            return false;
        } else if (fileName.isEmpty()){
            lblError.setText("File name can't be empty");
            return false;
        } else{
            return true;
        }
    }

    // Requires: clicking on save button
    // Modifies: javafx objects
    // Effects: Retrieves the file name from the user text input.
    // Then, if the file name passes its check, it resets the error text and runs the method that saves the file.
    public void handleSaveFile(ActionEvent actionEvent) throws IOException {
        String fileName = textFileName.getText();
        if (fileNameCheck(fileName)){
            lblError.setText("");
            saveFriendStorage(fileName);
        }
    }
}