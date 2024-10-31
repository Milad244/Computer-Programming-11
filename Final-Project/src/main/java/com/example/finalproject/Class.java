package com.example.finalproject;

import java.util.ArrayList;

public class Class {
    // Fields
    private String className;
    private boolean classCompleted;
    private ArrayList<Assignment> assignments;
    private double totalWeight;

    // Methods

    public Class(String className, double totalWeight){
        this.className = className;
        this.totalWeight = totalWeight;
        classCompleted = false;
        assignments = new ArrayList<>();
    }

    public Class(String className, double totalWeight, boolean classCompleted){
        this.className = className;
        this.totalWeight = totalWeight;
        this.classCompleted = classCompleted;
        assignments = new ArrayList<>();
    }

    public double getAverageMark(){
        double totalWeightGrade = 0;
        double totalAssignmentWeight = 0;
        for (Assignment assignment : assignments){
            totalWeightGrade += (assignment.getAssignmentMark() * assignment.getAssignmentWeight());
            totalAssignmentWeight += assignment.getAssignmentWeight();
        }
        return totalWeightGrade/totalAssignmentWeight;
    }

    public double getMinimumMark(){
        double totalWeightGrade = 0;
        for (Assignment assignment : assignments){
            totalWeightGrade += (assignment.getAssignmentMark() * assignment.getAssignmentWeight());
        }
        return totalWeightGrade/totalWeight;
    }

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

    public void addAssignment(Assignment newAssignment){
        assignments.add(newAssignment);
    }

    public void setClassCompleted(boolean classCompleted) {
        this.classCompleted = classCompleted;
    }

    public String getClassName() {
        return className;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public boolean getClassCompleted(){
        return classCompleted;
    }

    public String getCompletionText(){
        if (classCompleted){
            return "Completed";
        } else {
            return "Ongoing";
        }
    }

    public double getTotalWeight(){
        return totalWeight;
    }

    public double getTotalAssignmentWeight(){
        double totalWeight = 0;
        for (Assignment assignment : assignments){
            totalWeight += assignment.getAssignmentWeight();
        }
        return totalWeight;
    }

    @Override
    public String toString() {
        return className + " is currently " + getCompletionText() + " with an average grade of " + getAverageMark() + "%";
    }
}
