/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package userlogin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KanbanTest {

    private Kanban kanban;

    @Before
    public void setUp() {
        kanban = new Kanban();
    }

    @After
    public void tearDown() {
        kanban = null;
    }

    @Test
    public void testCheckTaskDescription_Valid() {
        // Test for a valid task description
        assertTrue(kanban.checkTaskDescription("Valid task description."));
    }

    @Test
    public void testCheckTaskDescription_Invalid() {
        // Test for an invalid task description (more than 50 characters)
        assertFalse(kanban.checkTaskDescription("This description is intentionally made too long for the sake of testing."));
    }

    @Test
    public void testCreateTaskID() {
        // Test creating a task ID
        String taskName = "Add Task Feature";
        int taskNumber = 1;
        String developerLastName = "Smith";
        String expectedID = "AD:1:ITH";  // Assuming the last 3 letters of Smith
        String result = kanban.createTaskID(taskName, taskNumber, developerLastName);
        assertEquals(expectedID, result);
    }

    @Test
    public void testPrintTaskDetails() {
        // Test printing task details
        String taskStatus = "To Do";
        String developerFirstName = "Robyn";
        String developerLastName = "Harrison";
        int taskNumber = 0;
        String taskName = "Login Feature";
        String taskDescription = "Create Login to authenticate users";
        String taskID = "LO:0:SON";  // Assuming proper ID format
        int taskDuration = 8;

        String expectedDetails = "Task Status: " + taskStatus + "\nDeveloper: " + developerFirstName + " " + developerLastName +
                "\nTask Number: " + taskNumber + "\nTask Name: " + taskName + "\nTask Description: " +
                taskDescription + "\nTask ID: " + taskID + "\nTask Duration: " + taskDuration + " hours";

        String result = kanban.printTaskDetails(taskStatus, developerFirstName, developerLastName, taskNumber,
                taskName, taskDescription, taskID, taskDuration);

        assertEquals(expectedDetails, result);
    }

    @Test
    public void testReturnTotalHours() {
        // Test calculating total hours
        int[] durations = {10, 12, 55, 11, 1}; // Example durations
        int expectedTotal = 89; // Expected total
        int result = kanban.returnTotalHours(durations);
        assertEquals(expectedTotal, result);
    }
    
    @Test
    public void testReturnTotalHours_Empty() {
        // Test for empty duration array
        int[] durations = {};
        int expectedTotal = 0;
        int result = kanban.returnTotalHours(durations);
        assertEquals(expectedTotal, result);
    }
}
