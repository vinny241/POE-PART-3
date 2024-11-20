/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package userlogin;

/**
 *
 * @author RC_Student_lab
 */

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class UserLogin {
    public static void main(String[] args) {
        Methods methods = new Methods();
        Kanban kanban = new Kanban();
        TaskManager taskManager = new TaskManager();  // Instantiate TaskManager to manage tasks
        Scanner input = new Scanner(System.in);

        // Registration Process
        System.out.println("Register..........");
        System.out.print("Enter First Name: ");
        methods.firstName = input.next();
        System.out.print("Enter Last Name: ");
        methods.surname = input.next();
        System.out.print("Enter Username: ");
        methods.userName = input.next();
        System.out.print("Enter Password: ");
        
        methods.password = input.next();

        System.out.println(methods.registerUser());

        // Ensure valid username and password complexity
        while (!methods.checkUsername() || !methods.checkPasswordComplexity()) {
            System.out.println("Try to register again!!!!!");
            System.out.print("Enter Username: ");
            methods.userName = input.next();
            System.out.print("Enter Password: ");
            methods.password = input.next();
            System.out.println(methods.registerUser());
        }

        // Login Process
        System.out.println("Login..........");
        System.out.print("Enter Username: ");
        methods.enteredUserName = input.next();
        System.out.print("Enter Password: ");
        methods.enteredPassword = input.next();
        System.out.println(methods.returnLoginStatus());

        while (!methods.loginUser()) {
            System.out.println("Try to Login again ..........");
            System.out.print("Enter Username: ");
            methods.enteredUserName = input.next();
            System.out.print("Enter Password: ");
            methods.enteredPassword = input.next();
            System.out.println(methods.returnLoginStatus());
        }

        if (methods.loginUser()) {
            final JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(dialog, "Welcome To EasyKanban");

            int choice;
            do {
                kanban.input = JOptionPane.showInputDialog(dialog, "Choose an option:\n1. Add tasks\n2. Show report\n3. Quit");
                choice = Integer.parseInt(kanban.input);

                switch (choice) {
                    case 1:
                        int numTasks = Integer.parseInt(JOptionPane.showInputDialog(dialog, "Enter the number of tasks:"));
                        int totalHours = 0;

                        for (int i = 0; i < numTasks; i++) {
                            String taskName = JOptionPane.showInputDialog(dialog, "Enter task name:");
                            String taskDescription = JOptionPane.showInputDialog(dialog, "Enter task description:");
                            String developerFirstName = JOptionPane.showInputDialog(dialog, "Enter developer’s first name:");
                            String developerLastName = JOptionPane.showInputDialog(dialog, "Enter developer’s last name:");
                            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(dialog, "Enter task duration:"));

                            String taskID = kanban.createTaskID(taskName, i, developerLastName);
                            String taskStatus = "";

                            int option = Integer.parseInt(JOptionPane.showInputDialog(dialog, "Please choose the Status of this task:\n1. To Do\n2. Doing\n3. Done"));

                            switch (option) {
                                case 1:
                                    taskStatus = "To Do";
                                    break;
                                case 2:
                                    taskStatus = "Doing";
                                    break;
                                case 3:
                                    taskStatus = "Done";
                                    break;
                            }

                            String taskDetails = kanban.printTaskDetails(taskStatus, developerFirstName, developerLastName, i, taskName, taskDescription, taskID, taskDuration);
                            JOptionPane.showMessageDialog(dialog, taskDetails);

                            totalHours += taskDuration;

                            // Add task to TaskManager arrays
                            taskManager.addTask(developerFirstName + " " + developerLastName, taskName, taskID, taskDuration, taskStatus);
                        }

                        JOptionPane.showMessageDialog(dialog, "Total hours: " + totalHours);
                        break;

                    case 2:
                        // Show report options loop
                        int reportChoice;
                        do {
                            reportChoice = Integer.parseInt(JOptionPane.showInputDialog(dialog, "Choose an option:\n1. Show tasks with 'Done' status\n2. Show longest task\n3. Search task by name\n4. Search tasks by developer\n5. Delete a task\n6. Show all tasks report\n7. Exit report"));

                            switch (reportChoice) {
                                case 1:
                                    JOptionPane.showMessageDialog(dialog, taskManager.getTasksWithStatus("Done"));
                                    break;
                                case 2:
                                    JOptionPane.showMessageDialog(dialog, taskManager.getLongestTask());
                                    break;
                                case 3:
                                    String taskName = JOptionPane.showInputDialog(dialog, "Enter Task Name to search:");
                                    JOptionPane.showMessageDialog(dialog, taskManager.searchTaskByName(taskName));
                                    break;
                                case 4:
                                    String developerName = JOptionPane.showInputDialog(dialog, "Enter Developer Name to search:");
                                    JOptionPane.showMessageDialog(dialog, taskManager.searchTasksByDeveloper(developerName));
                                    break;
                                case 5:
                                    String taskToDelete = JOptionPane.showInputDialog(dialog, "Enter Task Name to delete:");
                                    taskManager.deleteTask(taskToDelete);
                                    JOptionPane.showMessageDialog(dialog, "Task deleted.");
                                    break;
                                case 6:
                                    JOptionPane.showMessageDialog(dialog, taskManager.getAllTasksReport());
                                    break;
                                case 7:
                                    JOptionPane.showMessageDialog(dialog, "Exiting Report section.");
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(dialog, "Invalid choice.");
                                    break;
                            }
                        } while (reportChoice != 7);  // Keep showing report options until the user exits

                        break;

                    case 3:
                        JOptionPane.showMessageDialog(dialog, "Exiting the application.");
                        break;

                    default:
                        JOptionPane.showMessageDialog(dialog, "Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 3);  // Continue running until the user chooses to quit

            dialog.dispose();  // Dispose dialog at the end
        }
    }
}
