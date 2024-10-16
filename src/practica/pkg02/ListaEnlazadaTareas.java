package practica.pkg02;

public class ListaEnlazadaTareas {

    private Nodo inicio;

    public ListaEnlazadaTareas() {
        inicio = null;
    }

    public void agregarTarea(Tarea tarea) {
        Nodo nuevoNodo = new Nodo(tarea);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo temp = inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
    }

    public void eliminarTarea(String nombre) {
        if (inicio == null) {
            return;
        }
        if (inicio.tarea.getNombre().equals(nombre)) {
            inicio = inicio.siguiente;
            return;
        }

        Nodo temp = inicio;
        while (temp.siguiente != null && !temp.siguiente.tarea.getNombre().equals(nombre)) {
            temp = temp.siguiente;
        }
        if (temp.siguiente != null) {
            temp.siguiente = temp.siguiente.siguiente;
        }
    }

    public void mostrarTareas() {
        Nodo temp = inicio;
        while (temp != null) {
            System.out.println(temp.tarea.getNombre() + ": " + temp.tarea.getDescripcion());
            temp = temp.siguiente;
        }
    }

    public boolean buscarTarea(String nombre) {
        Nodo temp = inicio;
        while (temp != null) {
            if (temp.tarea.getNombre().equals(nombre)) {
                return true;
            }
            temp = temp.siguiente;
        }
        return false;
    }
}
