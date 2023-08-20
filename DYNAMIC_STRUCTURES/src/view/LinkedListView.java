package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LinkedListView extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField descriptionField;
    private JTextField dueDateField;
    private JTextField assignedToField;
    private JButton addButton;

    public LinkedListView() {
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        descriptionField = new JTextField(20);
        dueDateField = new JTextField(10);
        assignedToField = new JTextField(10);
        addButton = new JButton("Añadir Tarea");

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Descripcion:"));
        inputPanel.add(descriptionField);
        inputPanel.add(new JLabel("Due Date (yyyy-MM-dd):"));
        inputPanel.add(dueDateField);
        inputPanel.add(new JLabel("Asignar a:"));
        inputPanel.add(assignedToField);
        inputPanel.add(addButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        setTitle("Task Manager");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void clearInputFields() {
        descriptionField.setText("");
        dueDateField.setText("");
        assignedToField.setText("");
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public String getDescription() {
        return descriptionField.getText();
    }

    public String getDueDate() {
        return dueDateField.getText();
    }

    public String getAssignedTo() {
        return assignedToField.getText();
    }

    public void updateTaskList(String task) {
        taskListModel.addElement(task);
    }
}

