package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    // Fields

    // Javafx objects
    public Label lblError;
    public ListView listviewClasses;
    public TextField textClassTitle;
    public ListView listviewAssignments;
    public TextField textAssignmentTitle;
    public TextField textAssignmentMark;
    public VBox vboxClassInfo;
    public VBox vboxAssignmentInfo;
    public TextField textClassTotalWeight;
    public TextField textAssignmentWeight;

    private ArrayList<Class> classes;
    public Class currentClass;
    private Assignment currentAssignment;
    private DataHandler dataHandler;

    // Methods

    // Requires: error text for the user as a string
    // Modifies: javafx objects
    // Effects: checks if the label exists. If so, gives the user the error msg. (lbl is null in my junit tests)
    public void setLblError(String errorText){
        if (lblError != null){
            lblError.setText(errorText);
        }
    }

    // Requires: nothing
    // Modifies: this
    // Effects: initializes the classes and dataHandler fields
    public void initialize() throws IOException{
        classes = new ArrayList<>();
        dataHandler = new DataHandler();
    }

    // Requires: nothing
    // Modifies: this
    // Effects: initializes the classes. (Made this for my Junit tests)
    public void initializeTest(){
        classes = new ArrayList<>();
    }

    // Requires: clicking on add class btn
    // Modifies: this and javafx objects
    // Effects: calls the commitAddClass function and displays the class if the params pass their respective checks
    public void addClass(ActionEvent actionEvent) {
        String newClassTitle = textClassTitle.getText();
        String stringNewTotalWeight = textClassTotalWeight.getText();
        textClassTitle.clear();
        textClassTotalWeight.clear();

        if (classTitleCheck(newClassTitle) && classTotalWeightCheck(stringNewTotalWeight)){
            commitAddClass(newClassTitle, stringNewTotalWeight);
            displayClasses();
        }
    }

    // Requires: new class title as a string and new class total weight as a string
    // Modifies: this and javafx objects
    // Effects: commits adding the class
    public void commitAddClass(String newClassTitle, String stringNewTotalWeight){
        setLblError("");
        double newTotalWeight = Double.parseDouble(stringNewTotalWeight);
        Class newClass = new Class(newClassTitle, newTotalWeight);
        classes.add(newClass);
    }

    // Requires: new class title as a string
    // Modifies: this and javafx objects
    // Effects: returns true if the new class title passes all the checks. If not, returns false and gives the user an error msg
    public boolean classTitleCheck(String newClassTitle){
        if (newClassTitle.length() > 15){
            setLblError("Class title can't be over 15 characters");
            return false;
        } else if (newClassTitle.isEmpty()){
            setLblError("Class title can't be empty");
            return false;
        } else{
            if (classes != null){
                for (Class c: classes){
                    if (c.getClassName().equals(newClassTitle)){
                        setLblError("Class title cannot be a duplicate of another");
                        return false;
                    }
                }
            }
            return true;
        }
    }

    // Requires: new total weight as a string
    // Modifies: this and javafx objects
    // Effects: returns true if the new total weight passes all the checks. If not, returns false and gives the user an error msg
    public boolean classTotalWeightCheck(String newTotalWeight){
        try{
            double potentialTotalMaxWeight = Double.parseDouble(newTotalWeight);
            if (potentialTotalMaxWeight < 0){
                setLblError("Total weight can't be below 0");
                return false;

            } else if (potentialTotalMaxWeight > 1000){
                setLblError("Total weight can't be over 1000");
                return false;
            } else{
                return true;
            }
        } catch (Exception e){
            setLblError("Total weight must be a number");
            return false;
        }
    }

    // Requires: clicking on add assignment btn
    // Modifies: this and javafx objects
    // Effects: calls the commitAddAssignment function and displays the assignment if the params pass their respective checks
    public void addAssignment(ActionEvent actionEvent) {
        String newAssignmentTitle = textAssignmentTitle.getText();
        String stringNewAssignmentMark = textAssignmentMark.getText();
        String stringNewAssignmentWeight = textAssignmentWeight.getText();
        textAssignmentTitle.clear();
        textAssignmentMark.clear();
        textAssignmentWeight.clear();

        if (assignmentTitleCheck(newAssignmentTitle) && assignmentMarkCheck(stringNewAssignmentMark) && assignmentWeightCheck(stringNewAssignmentWeight)){
            commitAddAssignment(newAssignmentTitle, stringNewAssignmentMark, stringNewAssignmentWeight);
            displayClasses();
        }
    }

    // Requires: new assignment title as a string, new assignment mark as a string, new assignment weight as a string.
    // Modifies: this and javafx objects
    // Effects: commits adding the assignment
    public void commitAddAssignment(String newAssignmentTitle, String stringNewAssignmentMark, String stringNewAssignmentWeight){
        setLblError("");
        double newAssignmentMark = Double.parseDouble(stringNewAssignmentMark);
        double newAssignmentWeight = Double.parseDouble(stringNewAssignmentWeight);
        currentClass.addAssignment(new Assignment(newAssignmentTitle, newAssignmentMark, newAssignmentWeight));
    }

    // Requires: new assignment title as a string
    // Modifies: this and javafx objects
    // Effects: returns true if the new assignment title passes all the checks. If not, returns false and gives the user an error msg
    public boolean assignmentTitleCheck(String newAssignmentTitle){
        if (newAssignmentTitle.length() > 15){
            setLblError("Assignment title can't be over 15 characters");
            return false;
        } else if (newAssignmentTitle.isEmpty()){
            setLblError("Assignment title can't be empty");
            return false;
        } else if (!selectedClassCheck()){
            return false;
        } else{
            for (Assignment a: currentClass.getAssignments()){
                if (a.getAssignmentName().equals(newAssignmentTitle)){
                    setLblError("Assignment title cannot be a duplicate of another");
                    return false;
                }
            }
            return true;
        }
    }

    // Requires: new assignment mark as a string
    // Modifies: this and javafx objects
    // Effects: returns true if the new assignment mark passes all the checks. If not, returns false and gives the user an error msg
    public boolean assignmentMarkCheck(String newAssignmentMark){
        try{
            double potentialNewMark = Double.parseDouble(newAssignmentMark);
            if (potentialNewMark < 0){
                setLblError("Mark can't be below 0 percent");
                return false;

            } else if (potentialNewMark > 100){
                setLblError("Mark can't be over 100 percent");
                return false;
            } else{
                return true;
            }
        } catch (Exception e){
            setLblError("Mark must be a number");
            return false;
        }
    }

    // Requires: new assignment weight as a string
    // Modifies: this and javafx objects
    // Effects: returns true if the new total weight passes all the checks. If not, returns false and gives the user an error msg
    public boolean assignmentWeightCheck(String newAssignmentWeight){
        try{
            int potentialNewAssignmentWeight = Integer.parseInt(newAssignmentWeight);
            if (potentialNewAssignmentWeight < 0){
                setLblError("Weight can't be below 0");
                return false;
            } else if (!selectedClassCheck()){
                return false;
            } else if ((currentClass.getTotalAssignmentWeight() + potentialNewAssignmentWeight) > currentClass.getTotalWeight()){
                setLblError("Weight is exceeding the total");
                return false;
            } else{
                return true;
            }
        } catch (Exception e){
            setLblError("Weight must be a number");
            return false;
        }
    }

    // Requires: nothing
    // Modifies: javafx objects
    // Effects: checks if currentClass is null. If so, returns false and gives the user an error msg. If not, returns true.
    public boolean selectedClassCheck(){
        if (currentClass == null) {
            setLblError("You have not selected a class");
            return false;
        } else{
            return true;
        }
    }

    // Requires: clicking on save button
    // Modifies: data.txt
    // Effects: calls function to save data from data.txt
    public void save(ActionEvent actionEvent) throws IOException{
        dataHandler.saveData(classes);
    }

    // Requires: clicking on load button
    // Modifies: this and javafx objects
    // Effects: calls function to load data from data.txt, then reloads the app
    public void load(ActionEvent actionEvent) throws IOException{
        classes = dataHandler.getData();
        reload();
    }

    // Requires: nothing
    // Modifies: this and javafx objects
    // Effects: re-displays the app
    private void reload(){
        currentClass = null;
        currentAssignment = null;
        displayClasses();
    }

    // Requires: nothing
    // Modifies: javafx objects
    // Effects: displays classes and calls functions to display classes info and assignments
    private void displayClasses(){
        listviewClasses.getItems().clear();

        if (classes != null){
            for (Class c: classes){
                listviewClasses.getItems().add(c.getClassName());
            }

            listviewClasses.setOnMouseClicked(event -> {
                String selectedClassName = (String) listviewClasses.getSelectionModel().getSelectedItem();
                for (Class c : classes){
                    if (c.getClassName().equals(selectedClassName)){
                        currentClass = c;
                        currentAssignment = null;
                        displayClassesInfo();
                        displayAssignments();
                        break;
                    }
                }
            });
        }
        displayClassesInfo();
        displayAssignments();
    }

    // Requires: nothing
    // Modifies: javafx objects
    // Effects: displays classes info
    private void displayClassesInfo(){
        vboxClassInfo.getChildren().clear();

        if (currentClass != null){
            // Class Title Label
            Label classTitle = new Label("Class Name: " + currentClass.getClassName());
            classTitle.setFont(new Font(25));
            vboxClassInfo.getChildren().add(classTitle);

            // Class Mark Labels
            double avgMark = (double) Math.round(currentClass.getAverageMark() * 100)/100;
            double minMark = (double) Math.round(currentClass.getMinimumMark() * 100)/100;
            double maxMark = (double) Math.round(currentClass.getMaximumMark() * 100)/100;
            String markText = "Minimum mark: " + minMark + "% Current mark: " + avgMark + "% Maximum mark: " + maxMark + "%";
            Label classMark = new Label(markText);
            classMark.setFont(new Font(25));
            vboxClassInfo.getChildren().add(classMark);

            // Class Weight Label
            Label classWeight = new Label("Weight: " + currentClass.getTotalAssignmentWeight() + " completed out of " + currentClass.getTotalWeight());
            classWeight.setFont(new Font(25));
            vboxClassInfo.getChildren().add(classWeight);

            // Class Completion Label
            Label classCompletion = new Label("Completion status: " + currentClass.getCompletionText());
            classCompletion.setFont(new Font(25));
            vboxClassInfo.getChildren().add(classCompletion);

            // Class Completion Button
            Button classCompletionButton;
            if (!currentClass.getClassCompleted()){
                classCompletionButton = new Button("Click here to mark class as completed");
                classCompletionButton.setFont(new Font(15));
                classCompletionButton.setOnAction(event -> {
                    currentClass.setClassCompleted(true);
                    displayClassesInfo();
                });
            } else{
                classCompletionButton = new Button("Click here to mark class as incomplete");
                classCompletionButton.setFont(new Font(15));
                classCompletionButton.setOnAction(event -> {
                    currentClass.setClassCompleted(false);
                    displayClassesInfo();
                });
            }
            vboxClassInfo.getChildren().add(classCompletionButton);

            // Delete Class button
            Button classDeleteButton = new Button("Delete this class");
            classDeleteButton.setFont(new Font(15));
            classDeleteButton.setOnAction(event -> {
                classes.remove(currentClass);
                reload();
            });
            vboxClassInfo.getChildren().add(classDeleteButton);
        }
    }

    // Requires: nothing
    // Modifies: javafx objects
    // Effects: displays assignments and calls function to display assignments info
    private void displayAssignments(){
        listviewAssignments.getItems().clear();

        if (currentClass != null){
            for (Assignment a : currentClass.getAssignments()){
                listviewAssignments.getItems().add(a.getAssignmentName());
            }

            listviewAssignments.setOnMouseClicked(event -> {
                String selectedAssignmentName = (String) listviewAssignments.getSelectionModel().getSelectedItem();
                for (Assignment a : currentClass.getAssignments()){
                    if (a.getAssignmentName().equals(selectedAssignmentName)){
                        currentAssignment = a;
                        displayAssignmentInfo();
                        break;
                    }
                }
            });
        }
        displayAssignmentInfo();
    }

    // Requires: nothing
    // Modifies: javafx objects
    // Effects: displays assignment info
    private void displayAssignmentInfo(){
        vboxAssignmentInfo.getChildren().clear();

        if (currentAssignment != null){
            // Assignment Title Label
            Label assignmentTitle = new Label("Assignment Name: " + currentAssignment.getAssignmentName());
            assignmentTitle.setFont(new Font(25));
            vboxAssignmentInfo.getChildren().add(assignmentTitle);

            // Assignment Mark Label
            Label assignmentMark = new Label("Mark: " + currentAssignment.getAssignmentMark() + "% Weight: " + currentAssignment.getAssignmentWeight());
            assignmentMark.setFont(new Font(25));
            vboxAssignmentInfo.getChildren().add(assignmentMark);

            // Assignment Delete Button
            Button assignmentDeleteButton = new Button("Delete this assignment");
            assignmentDeleteButton.setFont(new Font(15));
            assignmentDeleteButton.setOnAction(event -> {
                for (Class c : classes){
                    if (c == currentClass){
                        c.getAssignments().remove(currentAssignment);
                    }
                }
                reload();
            });
            vboxAssignmentInfo.getChildren().add(assignmentDeleteButton);
        }
    }
}