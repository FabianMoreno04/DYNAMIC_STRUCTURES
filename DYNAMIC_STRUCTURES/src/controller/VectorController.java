package controller;

import java.util.Vector;

import javax.swing.SwingUtilities;

import model.VectorArticuloModel;
import view.VectorView;

public class VectorController {
    private Vector<VectorArticuloModel> carrito = new Vector<>();
    private VectorView view;

    public VectorController(VectorView view) {
        this.view = view;
    }

    public void agregarArticulo(String nombre, double precio) {
        VectorArticuloModel articulo = new VectorArticuloModel(nombre, precio);
        carrito.add(articulo);
        view.actualizarCarrito(carrito);
    }

    public double calcularTotal() {
        double total = 0;
        for (VectorArticuloModel articulo : carrito) {
            total += articulo.getPrecio();
        }
        return total;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VectorView().setVisible(true);
            }
        });
    }
}

