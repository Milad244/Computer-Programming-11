package com.example.finalproject;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SchoolManagerTest {

    HelloController testSet;

    @Before
    public void setUp() {
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

        // Testing mark weight
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
    public void testClassMarkCalculations(){
        Class testClass = new Class ("Test Class", 500);
        // Adding assignments so I can test the mark calculations
        Assignment as1 = new Assignment("As1", 100, 100);
        testClass.addAssignment(as1);
        Assignment as2 = new Assignment("As2", 88, 44);
        testClass.addAssignment(as2);
        Assignment as3 = new Assignment("As3", 50, 39);
        testClass.addAssignment(as3);
        Assignment as4 = new Assignment("As4", 96, 225);
        testClass.addAssignment(as4);
        Assignment as5 = new Assignment("As5", 21, 50);
        testClass.addAssignment(as5);
        // Testing mark calculations
        double averageMark = testClass.getAverageMark();
        assertEquals(84, averageMark, 0);
        double maxMark = testClass.getAverageMark();
        assertEquals(0, maxMark, 0); //TBD
        double minMark = testClass.getAverageMark();
        assertEquals(0, minMark, 0); //TBD
    }
}

