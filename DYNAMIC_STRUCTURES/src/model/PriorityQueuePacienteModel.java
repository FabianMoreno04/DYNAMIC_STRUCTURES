package model;

public class PriorityQueuePacienteModel implements Comparable<PriorityQueuePacienteModel> {
    private String nombre;
    private int gravedad;

    public PriorityQueuePacienteModel(String nombre, int gravedad) {
        this.nombre = nombre;
        this.gravedad = gravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getGravedad() {
        return gravedad;
    }

    @Override
    public int compareTo(PriorityQueuePacienteModel otro) {
        return Integer.compare(otro.gravedad, this.gravedad);
    }
}

