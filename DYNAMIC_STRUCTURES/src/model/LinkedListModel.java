package model;

import java.util.Date;
import java.util.LinkedList;

public class LinkedListModel {
    private LinkedList<Task> tasks;

    public LinkedListModel() {
        tasks = new LinkedList<>();
    }

    public void addTask(String description, Date dueDate, String assignedTo) {
        Task task = new Task(description, dueDate, assignedTo);
        tasks.add(task);
    }

    public LinkedList<Task> getTasks() {
        return tasks;
    }
}

