package com.example.finalproject;

public class Assignment {
    // Fields
    private String assignmentName;
    private double assignmentMark;
    private double assignmentWeight;

    // Methods

    public Assignment(String assignmentName, double assignmentMark, double assignmentWeight){
        this.assignmentName = assignmentName;
        this.assignmentMark = assignmentMark;
        this.assignmentWeight = assignmentWeight;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public double getAssignmentMark() {
        return assignmentMark;
    }

    public double getAssignmentWeight(){
        return assignmentWeight;
    }

}
