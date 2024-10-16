package practica.pkg02;

public class Tarea {
    private String nombre;
    private String descripcion;
    private int prioridad;

    public Tarea(String nombre, String descripcion, int prioridad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getPrioridad() { return prioridad; }
}

