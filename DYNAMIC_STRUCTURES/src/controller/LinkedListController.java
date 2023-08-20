package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.LinkedListModel;
import view.LinkedListView;

public class LinkedListController {
    private LinkedListModel model;
    private LinkedListView view;

    public LinkedListController(LinkedListModel model, LinkedListView view) {
        this.model = model;
        this.view = view;

        this.view.addAddButtonListener(new AddButtonListener());
    }

    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String description = view.getDescription();
            String dueDateString = view.getDueDate();
            String assignedTo = view.getAssignedTo();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dueDate = new Date(); // Default due date
            try {
                dueDate = dateFormat.parse(dueDateString);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            model.addTask(description, dueDate, assignedTo);
            view.updateTaskList(description + "  |  Due Date: " + dueDateString + "  |  Assigned To: " + assignedTo);

            // Clear input fields
            view.clearInputFields();
        }
    }
    public static void main(String[] args) {
        LinkedListModel model = new LinkedListModel();
        LinkedListView view = new LinkedListView();
        LinkedListController controller = new LinkedListController(model, view);
    }
}

