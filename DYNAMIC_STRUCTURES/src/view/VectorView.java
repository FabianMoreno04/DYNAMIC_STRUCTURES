package view;

import javax.swing.*;

import controller.VectorController;
import model.VectorArticuloModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class VectorView extends JFrame {
    private VectorController controller;
    private JTextArea carritoTextArea;
    private JLabel totalLabel;

    public VectorView() {
        setTitle("Carrito de Compras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        controller = new VectorController(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        carritoTextArea = new JTextArea();
        carritoTextArea.setEditable(false);
        panel.add(new JScrollPane(carritoTextArea), BorderLayout.CENTER);

        totalLabel = new JLabel("Total: $0.00");
        panel.add(totalLabel, BorderLayout.SOUTH);

        JButton agregarButton = new JButton("Agregar Artículo");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoAgregar();
            }
        });
        panel.add(agregarButton, BorderLayout.NORTH);

        add(panel);
    }

    private void mostrarDialogoAgregar() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del artículo:");
        if (nombre != null && !nombre.isEmpty()) {
            String precioStr = JOptionPane.showInputDialog(this, "Ingrese el precio del artículo:");
            if (precioStr != null && !precioStr.isEmpty()) {
                try {
                    double precio = Double.parseDouble(precioStr);
                    controller.agregarArticulo(nombre, precio);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Precio inválido. Ingrese un número válido.");
                }
            }
        }
    }

    public void actualizarCarrito(Vector<VectorArticuloModel> carrito) {
        carritoTextArea.setText("");
        for (VectorArticuloModel articulo : carrito) {
            carritoTextArea.append(articulo.getNombre() + " - $" + articulo.getPrecio() + "\n");
        }
        double total = controller.calcularTotal();
        totalLabel.setText("Total: $" + total);
    }
}

