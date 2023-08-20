package model;

import java.util.Date;

public class Task {
    private String description;
    private Date dueDate;
    private String assignedTo;

    public Task(String description, Date dueDate, String assignedTo) {
        this.description = description;
        this.dueDate = dueDate;
        this.assignedTo = assignedTo;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    @Override
    public String toString() {
        return "Description: " + description + " | Due Date: " + dueDate + " | Assigned To: " + assignedTo;
    }
}

