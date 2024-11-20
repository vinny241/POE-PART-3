/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package userlogin;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskManagerTest {
    
    private TaskManager taskManager;

    public TaskManagerTest() {
    }
    
    @Before
    public void setUp() {
        taskManager = new TaskManager();
        // Adding test data for tasks
        taskManager.addTask("Mike Smith", "Create Login", "1", 5, "To Do");
        taskManager.addTask("Edward Harrison", "Create Add Features", "2", 8, "Doing");
        taskManager.addTask("Samantha Paulson", "Create Reports", "3", 2, "Done");
        taskManager.addTask("Glenda Oberholzer", "Add Arrays", "4", 11, "To Do");
    }
    
    @After
    public void tearDown() {
        taskManager = null;
    }

    /**
     * Test of addTask method, of class TaskManager.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        String developer = "John Doe";
        String taskName = "New Task";
        String taskID = "5";
        int taskDuration = 6;
        String taskStatus = "To Do";
        taskManager.addTask(developer, taskName, taskID, taskDuration, taskStatus);
        
        String result = taskManager.searchTaskByName("New Task");
        assertEquals("Task: New Task, Developer: John Doe, Status: To Do", result);
    }

    /**
     * Test of getLongestTask method, of class TaskManager.
     */
    @Test
    public void testGetLongestTask() {
        System.out.println("getLongestTask");
        String expected = "Task with longest duration: Add Arrays, Developer: Glenda Oberholzer, Duration: 11 hours";
        String result = taskManager.getLongestTask();
        assertEquals(expected, result);
    }

    /**
     * Test of getTasksWithStatus method, of class TaskManager.
     */
    @Test
    public void testGetTasksWithStatus() {
        System.out.println("getTasksWithStatus");
        String status = "To Do";
        String expected = "Developer: Mike Smith, Task Name: Create Login, Duration: 5 hours\n" +
                          "Developer: Glenda Oberholzer, Task Name: Add Arrays, Duration: 11 hours\n";
        String result = taskManager.getTasksWithStatus(status);
        assertEquals(expected, result);
    }

    /**
     * Test of searchTaskByName method, of class TaskManager.
     */
    @Test
    public void testSearchTaskByName() {
        System.out.println("searchTaskByName");
        String taskName = "Create Login";
        String expected = "Task: Create Login, Developer: Mike Smith, Status: To Do";
        String result = taskManager.searchTaskByName(taskName);
        assertEquals(expected, result);
    }

    /**
     * Test of searchTasksByDeveloper method, of class TaskManager.
     */
    @Test
    public void testSearchTasksByDeveloper() {
        System.out.println("searchTasksByDeveloper");
        String developerName = "Samantha Paulson";
        String expected = "Task Name: Create Reports, Status: Done\n";
        String result = taskManager.searchTasksByDeveloper(developerName);
        assertEquals(expected, result);
    }

    /**
     * Test of deleteTask method, of class TaskManager.
     */
    @Test
    public void testDeleteTask() {
        System.out.println("deleteTask");
        String taskName = "Create Reports";
        taskManager.deleteTask(taskName);
        
        String result = taskManager.searchTaskByName("Create Reports");
        assertEquals("Task not found.", result);  // Ensure that the task is deleted and no longer found
    }

    /**
     * Test of getAllTasksReport method, of class TaskManager.
     */
    @Test
    public void testGetAllTasksReport() {
        System.out.println("getAllTasksReport");
        String expected = "Developer: Mike Smith, Task Name: Create Login, Task ID: 1, Duration: 5 hours, Status: To Do\n" +
                          "Developer: Edward Harrison, Task Name: Create Add Features, Task ID: 2, Duration: 8 hours, Status: Doing\n" +
                          "Developer: Samantha Paulson, Task Name: Create Reports, Task ID: 3, Duration: 2 hours, Status: Done\n" +
                          "Developer: Glenda Oberholzer, Task Name: Add Arrays, Task ID: 4, Duration: 11 hours, Status: To Do\n";
        String result = taskManager.getAllTasksReport();
        assertEquals(expected, result);
    }
}
