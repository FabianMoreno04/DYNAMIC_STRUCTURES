package controller;

import javax.swing.*;

import model.PriorityQueuePacienteModel;
import view.PriorityQueueView;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class PriorityQueueController {
    private PriorityQueue<PriorityQueuePacienteModel> colaTurnos = new PriorityQueue<>();
    private PriorityQueueView view;

    public void setView(PriorityQueueView view) {
        this.view = view;
        actualizarVista();
    }

    public void agregarPaciente() {
        String nombre = JOptionPane.showInputDialog(view, "Ingrese el nombre del paciente:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            String gravedadStr = JOptionPane.showInputDialog(view, "Ingrese la gravedad del paciente (entero):");
            try {
                int gravedad = Integer.parseInt(gravedadStr);
                PriorityQueuePacienteModel paciente = new PriorityQueuePacienteModel(nombre, gravedad);
                colaTurnos.add(paciente);
                actualizarVista();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view, "Ingrese un número válido para la gravedad.");
            }
        }
    }

    private void actualizarVista() {
        List<PriorityQueuePacienteModel> pacientes = new ArrayList<>();
        PriorityQueue<PriorityQueuePacienteModel> colaTurnosCopia = new PriorityQueue<>(colaTurnos);
        while (!colaTurnosCopia.isEmpty()) {
            PriorityQueuePacienteModel paciente = colaTurnosCopia.poll();
            pacientes.add(new PriorityQueuePacienteModel(paciente.getNombre(), paciente.getGravedad()));
        }
        view.actualizarLista(pacientes);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PriorityQueueController controller = new PriorityQueueController();
                PriorityQueueView view = new PriorityQueueView(controller);
                controller.setView(view);
                view.setVisible(true);
            }
        });
    }
}

