package com.example.finalproject;


import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SchoolManagerTest {

    HelloController testSet;

    @Before
    public void setUp() {
        // Setting up my testSet
        testSet = new HelloController();
        testSet.initializeTest();
    }

    @Test
    public void testClassChecks(){
        // Testing class title checks
        boolean titleGoodCheck = testSet.classTitleCheck("Good Title");
        assertTrue(titleGoodCheck);
        boolean titleEmptyCheck = testSet.classTitleCheck("");
        assertFalse(titleEmptyCheck);
        boolean titleLengthCheck = testSet.classTitleCheck("1234567890123456");
        assertFalse(titleLengthCheck);
        testSet.commitAddClass("Duplicate Name", "100");
        boolean titleDuplicateCheck = testSet.classTitleCheck("Duplicate Name");
        assertFalse(titleDuplicateCheck);
        boolean titleNonDuplicateCheck = testSet.classTitleCheck("Not Dup Name");
        assertTrue(titleNonDuplicateCheck);

        // Testing max weight checks
        boolean maxWeightGoodCheck = testSet.classMaxWeightCheck("50");
        assertTrue(maxWeightGoodCheck);
        boolean maxWeightNegativeCheck = testSet.classMaxWeightCheck("-50");
        assertFalse(maxWeightNegativeCheck);
        boolean maxWeightHighCheck = testSet.classMaxWeightCheck("1500");
        assertFalse(maxWeightHighCheck);
        boolean maxWeightStringCheck = testSet.classMaxWeightCheck("Haha");
        assertFalse(maxWeightStringCheck);
    }

    @Test
    public void testAssignmentChecks(){
        testSet.currentClass = new Class("Default Class", 500);
        // Testing assignment title checks
        boolean titleGoodCheck = testSet.assignmentTitleCheck("Good Title");
        assertTrue(titleGoodCheck);
        boolean titleEmptyCheck = testSet.assignmentTitleCheck("");
        assertFalse(titleEmptyCheck);
        boolean titleLengthCheck = testSet.assignmentTitleCheck("1234567890123456");
        assertFalse(titleLengthCheck);
        testSet.commitAddAssignment("Duplicate Name", "100", "100");
        boolean titleDuplicateCheck = testSet.assignmentTitleCheck("Duplicate Name");
        assertFalse(titleDuplicateCheck);
        boolean titleNonDuplicateCheck = testSet.assignmentTitleCheck("Not Dup Name");
        assertTrue(titleNonDuplicateCheck);

        // Testing mark checks
        boolean markGoodCheck = testSet.assignmentMarkCheck("50");
        assertTrue(markGoodCheck);
        boolean markNegativeCheck = testSet.assignmentMarkCheck("-50");
        assertFalse(markNegativeCheck);
        boolean markHighCheck = testSet.assignmentMarkCheck("150");
        assertFalse(markHighCheck);
        boolean markStringCheck = testSet.assignmentMarkCheck("Hahaha");
        assertFalse(markStringCheck);

        // Testing mark weight checks
        boolean weightGoodCheck = testSet.assignmentWeightCheck("300");
        assertTrue(weightGoodCheck);
        boolean weightNegativeCheck = testSet.assignmentWeightCheck("-50");
        assertFalse(weightNegativeCheck);
        boolean weightHighCheck = testSet.assignmentWeightCheck("600");
        assertFalse(weightHighCheck);
        boolean weightStringCheck = testSet.assignmentWeightCheck("Hahaha");
        assertFalse(weightStringCheck);
    }

    @Test
    public void testClassMarkCalculationAccuracy(){
        Class testClass = new Class ("Test Class", 100);
        // Adding assignments so I can test the mark calculation accuracy
        Assignment as1 = new Assignment("As1", 100, 50);
        testClass.addAssignment(as1);
        // Testing mark calculation accuracy
        double averageMark = testClass.getAverageMark();
        assertEquals(100, averageMark, 0);
        double maxMark = testClass.getMaximumMark();
        assertEquals(100, maxMark, 0);
        double minMark = testClass.getMinimumMark();
        assertEquals(50, minMark, 0);
        // Adding another assignment for my mark calculation accuracy tests
        Assignment as2 = new Assignment("As2", 0, 25);
        testClass.addAssignment(as2);
        // Testing mark calculation accuracy
        averageMark = testClass.getAverageMark();
        assertEquals(66.6, averageMark, 1);
        maxMark = testClass.getMaximumMark();
        assertEquals(75, maxMark, 0);
        minMark = testClass.getMinimumMark();
        assertEquals(50, minMark, 0);
        // Adding a final assignment for my mark calculation accuracy tests
        Assignment as3 = new Assignment("As3", 0, 25);
        testClass.addAssignment(as3);
        // Testing mark calculation accuracy
        averageMark = testClass.getAverageMark();
        assertEquals(50, averageMark, 0);
        maxMark = testClass.getMaximumMark();
        assertEquals(50, maxMark, 0);
        minMark = testClass.getMinimumMark();
        assertEquals(50, minMark, 0);
    }

    @Test
    public void testClassCompletedUsage(){
        // Testing default being class not completed
        Class testClass1 = new Class ("Test Class 1", 100);
        boolean classCompleted = testClass1.getClassCompleted();
        assertFalse(classCompleted);

        // Testing class being completed if set as complete
        Class testClass2 = new Class ("Test Class 2", 100);
        testClass2.setClassCompleted(true);
        classCompleted = testClass2.getClassCompleted();
        assertTrue(classCompleted);

        // Testing class being not complete if set as not complete
        testClass2.setClassCompleted(false);
        classCompleted = testClass2.getClassCompleted();
        assertFalse(classCompleted);
    }

    @Test
    public void testDataHandler() throws IOException {
        // Setting up makeshift data
        Class mathClass = new Class ("Math 12", 300);
        Assignment mathQuiz1 = new Assignment("Quiz 1", 100, 50);
        mathClass.addAssignment(mathQuiz1);
        Assignment mathQuiz2 = new Assignment("Quiz 2", 96, 50);
        mathClass.addAssignment(mathQuiz2);
        Assignment mathExam1 = new Assignment("Exam 1", 86, 150);
        mathClass.addAssignment(mathExam1);

        Class englishClass = new Class ("English 12", 100);
        Assignment englishEssay1 = new Assignment("Essay 1", 94, 40);
        englishClass.addAssignment(englishEssay1);
        Assignment englishEssay2 = new Assignment("Essay 2", 99, 60);
        englishClass.addAssignment(englishEssay2);
        englishClass.setClassCompleted(true);

        // Testing dataHandler accuracy
        ArrayList<Class> classes = new ArrayList<>();
        classes.add(mathClass);
        classes.add(englishClass);
        DataHandler dataHandler = new DataHandler();
        dataHandler.saveData(classes);

        ArrayList<Class> savedData = dataHandler.getData();

        for (int c = 0; c < savedData.size(); c++) {
            Class expectedClass = classes.get(c);
            Class actualClass = savedData.get(c);

            // Testing equal classes
            assertEquals(expectedClass.getClassName(), actualClass.getClassName());
            assertEquals(expectedClass.getClassCompleted(), actualClass.getClassCompleted());
            assertEquals(expectedClass.getCompletionText(), actualClass.getCompletionText());
            assertEquals(expectedClass.getTotalWeight(), actualClass.getTotalWeight(), 0);
            assertEquals(expectedClass.getTotalAssignmentWeight(), actualClass.getTotalAssignmentWeight(), 0);
            assertEquals(expectedClass.getAverageMark(), actualClass.getAverageMark(), 0);
            assertEquals(expectedClass.getMaximumMark(), actualClass.getMaximumMark(), 0);
            assertEquals(expectedClass.getMinimumMark(), actualClass.getMinimumMark(), 0);
            assertEquals(expectedClass.toString(), actualClass.toString());

            // Testing equal assignments
            for (int a = 0; a < expectedClass.getAssignments().size(); a++){
                Assignment expectedAssignment = classes.get(c).getAssignments().get(a);
                Assignment actualAssignment = classes.get(c).getAssignments().get(a);

                assertEquals(expectedAssignment.getAssignmentName(), actualAssignment.getAssignmentName());
                assertEquals(expectedAssignment.getAssignmentMark(), actualAssignment.getAssignmentMark(), 0);
                assertEquals(expectedAssignment.getAssignmentWeight(), actualAssignment.getAssignmentWeight(), 0);
            }
        }
    }
}

