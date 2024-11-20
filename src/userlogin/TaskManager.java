/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userlogin;

/**
 *
 * @author RC_Student_lab
 */
public class TaskManager {
    private String[] developers = new String[100];
    private String[] taskNames = new String[100];
    private String[] taskIDs = new String[100];
    private int[] taskDurations = new int[100];
    private String[] taskStatuses = new String[100];
    private int taskCount = 0;

    // Add a task to arrays
    public void addTask(String developer, String taskName, String taskID, int taskDuration, String taskStatus) {
        developers[taskCount] = developer;
        taskNames[taskCount] = taskName;
        taskIDs[taskCount] = taskID;
        taskDurations[taskCount] = taskDuration;
        taskStatuses[taskCount] = taskStatus;
        taskCount++;
    }

    // Get all tasks with 'Done' status
    public String getTasksWithStatus(String status) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            if (taskStatuses[i].equalsIgnoreCase(status)) {
                result.append("Developer: ").append(developers[i]).append(", Task Name: ").append(taskNames[i]).append(", Duration: ").append(taskDurations[i]).append(" hours\n");
            }
        }
        return result.length() > 0 ? result.toString() : "No tasks found with the status '" + status + "'";
    }

    // Get the longest task
    public String getLongestTask() {
        int longestIndex = 0;
        for (int i = 1; i < taskCount; i++) {
            if (taskDurations[i] > taskDurations[longestIndex]) {
                longestIndex = i;
            }
        }
        return "Task with longest duration: " + taskNames[longestIndex] + ", Developer: " + developers[longestIndex] + ", Duration: " + taskDurations[longestIndex] + " hours";
    }

    // Search for a task by name
    public String searchTaskByName(String taskName) {
        for (int i = 0; i < taskCount; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                return "Task: " + taskNames[i] + ", Developer: " + developers[i] + ", Status: " + taskStatuses[i];
            }
        }
        return "Task not found.";
    }

    // Search for all tasks by developer name
    public String searchTasksByDeveloper(String developerName) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            if (developers[i].equalsIgnoreCase(developerName)) {
                result.append("Task Name: ").append(taskNames[i]).append(", Status: ").append(taskStatuses[i]).append("\n");
            }
        }
        return result.length() > 0 ? result.toString() : "No tasks found for developer: " + developerName;
    }

    // Delete a task by task name
    public void deleteTask(String taskName) {
        for (int i = 0; i < taskCount; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                for (int j = i; j < taskCount - 1; j++) {
                    developers[j] = developers[j + 1];
                    taskNames[j] = taskNames[j + 1];
                    taskIDs[j] = taskIDs[j + 1];
                    taskDurations[j] = taskDurations[j + 1];
                    taskStatuses[j] = taskStatuses[j + 1];
                }
                taskCount--;
                return;
            }
        }
    }

    // Get a report of all tasks
    public String getAllTasksReport() {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            report.append("Developer: ").append(developers[i])
                    .append(", Task Name: ").append(taskNames[i])
                    .append(", Task ID: ").append(taskIDs[i])
                    .append(", Duration: ").append(taskDurations[i])
                    .append(" hours, Status: ").append(taskStatuses[i]).append("\n");
        }
        return report.length() > 0 ? report.toString() : "No tasks available.";
    }
}
