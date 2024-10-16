package practica.pkg02;

public class PilaTareas {
    private Nodo cima;

    public PilaTareas() {
        cima = null;
    }

    public void apilar(Tarea tarea) {
        Nodo nuevoNodo = new Nodo(tarea);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    public void desapilar() {
        if (cima != null) {
            cima = cima.siguiente;
        }
    }

    public void mostrarPila() {
        Nodo temp = cima;
        while (temp != null) {
            System.out.println(temp.tarea.getNombre() + ": " + temp.tarea.getDescripcion());
            temp = temp.siguiente;
        }
    }
}
