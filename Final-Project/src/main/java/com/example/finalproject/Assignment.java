package com.example.finalproject;

public class Assignment {
    // Fields
    private String assignmentName;
    private double assignmentMark;
    private double assignmentWeight;

    // Methods

    // Requires: assignment name as a string, assignment mark as a double, and assignment weight as a double
    // Modifies: this
    // Effects: Assignment constructor
    public Assignment(String assignmentName, double assignmentMark, double assignmentWeight){
        this.assignmentName = assignmentName;
        this.assignmentMark = assignmentMark;
        this.assignmentWeight = assignmentWeight;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns assignment name as a string
    public String getAssignmentName() {
        return assignmentName;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns assignment mark as a double
    public double getAssignmentMark() {
        return assignmentMark;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns assignment weight as a double
    public double getAssignmentWeight(){
        return assignmentWeight;
    }

}
