package view;

import javax.swing.*;

import controller.StackController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StackView extends JFrame {
    private JTextField inputField;
    private JTextArea resultArea;
    private JButton evalButton;
    private JLabel avisoLabel;
    private JLabel resultadoLabel;
    private StackController controller;

    public StackView(StackController controller) {
        this.controller = controller;
        setTitle("Evaluator de Expresiones Matemáticas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    public void setController(StackController controller) {
        this.controller = controller;
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new BorderLayout());
        JPanel resultPanel = new JPanel(new BorderLayout());

        avisoLabel = new JLabel("Ingrese expresión:");
        avisoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER); // Centra el texto en el campo
        inputField.setPreferredSize(new Dimension(300, 30)); // Ajusta el tamaño del campo

        inputPanel.add(avisoLabel, BorderLayout.WEST);
        inputPanel.add(inputField, BorderLayout.CENTER);

        evalButton = new JButton("Evaluar");
        evalButton.setPreferredSize(new Dimension(100, 30)); // Ajusta el tamaño del botón
        evalButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el botón horizontalmente

        resultadoLabel = new JLabel("Resultado:");
        resultadoLabel.setPreferredSize(new Dimension(100, 30)); 
        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el área de texto horizontalmente

        evalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expression = inputField.getText();
                try {
                    double result = controller.evaluarExpresion(expression);
                    resultArea.setText(String.valueOf(result));
                } catch (Exception ex) {
                    resultArea.setText("Error en la expresión");
                }
            }
        });

        resultPanel.add(resultadoLabel, BorderLayout.WEST);
        resultPanel.add(resultArea, BorderLayout.CENTER);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(evalButton, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public void mostrar() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }
}

