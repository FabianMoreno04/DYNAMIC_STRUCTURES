package view;

import javax.swing.*;

import controller.PriorityQueueController;
import model.PriorityQueuePacienteModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PriorityQueueView extends JFrame {
    private JTextArea areaAtencion;
    private JButton agregarButton;
    private PriorityQueueController controller;

    public PriorityQueueView(PriorityQueueController controller) {
        this.controller = controller;
        setTitle("Centro Médico");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        areaAtencion = new JTextArea();
        areaAtencion.setEditable(false);
        panel.add(new JScrollPane(areaAtencion), BorderLayout.CENTER);

        agregarButton = new JButton("Agregar Paciente");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.agregarPaciente();
            }
        });
        panel.add(agregarButton, BorderLayout.SOUTH);

        add(panel);
    }

    public void actualizarLista(List<PriorityQueuePacienteModel> pacientes) {
        areaAtencion.setText("");
        for (PriorityQueuePacienteModel paciente : pacientes) {
            areaAtencion.append("Paciente: " + paciente.getNombre() + " - Gravedad: " + paciente.getGravedad() + "\n");
        }
    }

}

