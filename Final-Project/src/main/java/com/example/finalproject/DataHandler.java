package com.example.finalproject;

import java.io.*;
import java.util.ArrayList;

public class DataHandler {
    // Fields
    private String dataPath;

    //Methods
    DataHandler() throws IOException {
        dataPath = "src\\main\\java\\com\\example\\finalproject\\data.txt";
    }

    // Requires: An arraylist of Class
    // Modifies: data.txt
    // Effects: saves the data from the arraylist into the data.txt file
    public void saveData(ArrayList<Class> classes) throws IOException {
        FileWriter fw = new FileWriter(dataPath);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Class c : classes){
            bw.write(c.getClassName() + "\r");
            bw.write(c.getTotalWeight() + "\r");
            bw.write(c.getClassCompleted() + "\r");

            for (Assignment a : c.getAssignments()){
                bw.write(a.getAssignmentName() + "\r");
                bw.write(a.getAssignmentMark() + "\r");
                bw.write(a.getAssignmentWeight() + "\r");
            }

            bw.write("End Assignments\r");
        }

        bw.write("End");
        bw.close();
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns the arraylist of Class from the data.txt file
    public ArrayList<Class> getData() throws IOException {
        FileReader fr = new FileReader(dataPath);
        BufferedReader br = new BufferedReader(fr);

        ArrayList<Class> classes = new ArrayList<>();
        String line;
        Class currentClass = null;

        while ((line = br.readLine()) != null){
            if (line.equals("End")){
                break;
            } else if (line.equals("End Assignments")){
                if (currentClass != null) {
                    classes.add(currentClass);
                    currentClass = null;
                }
            } else if (currentClass == null) {
                String className = line;
                double totalWeight = Double.parseDouble(br.readLine());
                boolean classCompleted = Boolean.parseBoolean(br.readLine());

                currentClass = new Class(className, totalWeight, classCompleted);
            } else{
                String assignmentName = line;
                double assignmentMark = Double.parseDouble(br.readLine());
                double assignmentWeight = Double.parseDouble(br.readLine());

                Assignment assignment = new Assignment(assignmentName, assignmentMark, assignmentWeight);
                currentClass.addAssignment(assignment);
            }
        }

        br.close();
        return classes;
    }
}
