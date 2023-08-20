package view;

import javax.swing.*;

import model.HashSetModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class HashSetView extends JFrame {
    private JTextArea outputTextArea;
    private JTextField inputField;
    private JButton generateButton;

    public HashSetView() {
        setTitle("Conjunto de Potencia Generator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }
    
   
    
    private void initComponents() {
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        inputField = new JTextField();
        generateButton = new JButton("Generar Conjunto de Potencia");

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 generatePowerSet();
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Ingrese elementos separados por comas:"), BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(generateButton, BorderLayout.SOUTH);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
    
    private void generatePowerSet() {
        String input = getInput();
        String[] elements = input.split(",");
        Set<Set<String>> powerSet = null;
		try {
			powerSet = HashSetModel.generatePowerSet(elements);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        displayPowerSet(powerSet);
    }

    public String getInput() {
        return inputField.getText();
    }

    public void displayPowerSet(Set<Set<String>> powerSet) {
        outputTextArea.setText("");
        for (Set<String> subset : powerSet) {
            outputTextArea.append(subset.toString() + "\n");
        }
    }

    public void addGenerateButtonListener(ActionListener listener) {
        generateButton.addActionListener(listener);
    }
}
