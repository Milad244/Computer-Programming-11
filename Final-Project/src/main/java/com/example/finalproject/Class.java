package com.example.finalproject;

import java.util.ArrayList;

public class Class {
    // Fields
    private String className;
    private boolean classCompleted;
    private ArrayList<Assignment> assignments;
    private double totalWeight;

    // Methods

    // Requires: class name as a string and total weight of the class as a double
    // Modifies: this
    // Effects: Class constructor with classCompleted decided as false
    public Class(String className, double totalWeight){
        this.className = className;
        this.totalWeight = totalWeight;
        classCompleted = false;
        assignments = new ArrayList<>();
    }

    // Requires: class name as a string and total weight of the class as a double and whether the class is completed as a boolean
    // Modifies: this
    // Effects: Class constructor with classCompleted decided by the caller
    public Class(String className, double totalWeight, boolean classCompleted){
        this.className = className;
        this.totalWeight = totalWeight;
        this.classCompleted = classCompleted;
        assignments = new ArrayList<>();
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns the average mark based on the assignments grades and weight
    public double getAverageMark(){
        double totalWeightGrade = 0;
        double totalAssignmentWeight = 0;
        for (Assignment assignment : assignments){
            totalWeightGrade += (assignment.getAssignmentMark() * assignment.getAssignmentWeight());
            totalAssignmentWeight += assignment.getAssignmentWeight();
        }
        return totalWeightGrade/totalAssignmentWeight;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns the minimum mark possible based on the assignments grades and weight, as well as the total weight for the class.
    public double getMinimumMark(){
        double totalWeightGrade = 0;
        for (Assignment assignment : assignments){
            totalWeightGrade += (assignment.getAssignmentMark() * assignment.getAssignmentWeight());
        }
        return totalWeightGrade/totalWeight;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns the maximum mark possible based on the assignments grades and weight, as well as the total weight for the class.
    public double getMaximumMark(){
        double totalWeightGrade = 0;
        double totalAssignmentWeight = 0;
        for (Assignment assignment : assignments){
            totalWeightGrade += (assignment.getAssignmentMark() * assignment.getAssignmentWeight());
            totalAssignmentWeight += assignment.getAssignmentWeight();
        }
        double missingWeight = totalWeight-totalAssignmentWeight;
        totalWeightGrade += missingWeight * 100;
        return totalWeightGrade/totalWeight;
    }

    // Requires: an assignment as an Assignment
    // Modifies: this
    // Effects: adds an assignment to the Assignment arraylist
    public void addAssignment(Assignment newAssignment){
        assignments.add(newAssignment);
    }

    // Requires: whether the class is completed as a boolean
    // Modifies: this
    // Effects: sets this class completed to the new value of class completed
    public void setClassCompleted(boolean classCompleted) {
        this.classCompleted = classCompleted;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns class name as a string
    public String getClassName() {
        return className;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns assignments as an arraylist of Assignment
    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns classCompleted as a boolean
    public boolean getClassCompleted(){
        return classCompleted;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns classCompleted as a string
    public String getCompletionText(){
        if (classCompleted){
            return "completed";
        } else {
            return "currently ongoing";
        }
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns totalWeight as a double
    public double getTotalWeight(){
        return totalWeight;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns total weight of assignments as a double
    public double getTotalAssignmentWeight(){
        double totalWeight = 0;
        for (Assignment assignment : assignments){
            totalWeight += assignment.getAssignmentWeight();
        }
        return totalWeight;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns default text for a Class as a string
    @Override
    public String toString() {
        return className + " is " + getCompletionText() + " with an average grade of " + getAverageMark() + "%";
    }
}
