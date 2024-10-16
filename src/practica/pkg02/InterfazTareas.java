package practica.pkg02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazTareas extends JFrame {
    private MiColaTareas colaTareas;
    private JTextField campoNombre;
    private JList<String> listaTareasUI;
    private DefaultListModel<String> modeloLista;

    public InterfazTareas() {
        colaTareas = new MiColaTareas();  // Implementación de cola con nodos
        modeloLista = new DefaultListModel<>();
        listaTareasUI = new JList<>(modeloLista);

        setTitle("Gestión de Tareas");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Componentes para agregar tareas
        JLabel labelNombre = new JLabel("Tarea:");
        labelNombre.setBounds(10, 10, 80, 25);
        add(labelNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(100, 10, 200, 25);
        add(campoNombre);

        JButton botonAgregar = new JButton("Agregar Tarea");
        botonAgregar.setBounds(320, 10, 150, 25);
        add(botonAgregar);

        // JList para mostrar las tareas
        JScrollPane scrollLista = new JScrollPane(listaTareasUI);
        scrollLista.setBounds(10, 100, 460, 200);
        add(scrollLista);

        // Botón para eliminar una tarea
        JButton botonEliminar = new JButton("Eliminar Tarea");
        botonEliminar.setBounds(10, 320, 150, 25);
        add(botonEliminar);

        // Botón para buscar una tarea
        JButton botonBuscar = new JButton("Buscar Tarea");
        botonBuscar.setBounds(180, 320, 150, 25);
        add(botonBuscar);

        // Acción para agregar tarea
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                if (!nombre.isEmpty()) {
                    colaTareas.agregarTarea(nombre); // Agregar tarea a la cola
                    actualizarListaUI();
                    campoNombre.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa una tarea válida.");
                }
            }
        });

        // Acción para eliminar tarea
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colaTareas.eliminarTarea(); // Elimina la primera tarea en la cola
                actualizarListaUI();
            }
        });

        // Acción para buscar tarea
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                if (colaTareas.buscarTarea(nombre)) {
                    JOptionPane.showMessageDialog(null, "Tarea encontrada: " + nombre);
                } else {
                    JOptionPane.showMessageDialog(null, "Tarea no encontrada.");
                }
            }
        });
    }

    // Método para actualizar la lista mostrada en la interfaz con índices
    private void actualizarListaUI() {
        modeloLista.clear();
        String[] tareas = colaTareas.obtenerTareas();
        for (int i = 0; i < tareas.length; i++) {
            modeloLista.addElement((i + 1) + ". " + tareas[i]);
        }
    }

    public static void main(String[] args) {
        new InterfazTareas().setVisible(true);
    }
}

// Clase Nodo para la estructura de cola
class Nodo {
    String tarea;
    Nodo siguiente;

    public Nodo(String tarea) {
        this.tarea = tarea;
        this.siguiente = null;
    }
}

// Implementación de una Cola utilizando nodos
class MiColaTareas {
    private Nodo inicio;
    private Nodo fin;

    public MiColaTareas() {
        this.inicio = null;
        this.fin = null;
    }

    // Método para agregar tarea al final (orden de llegada)
    public void agregarTarea(String tarea) {
        Nodo nuevoNodo = new Nodo(tarea);
        if (fin == null) {
            inicio = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
    }

    // Método para eliminar la primera tarea (FIFO)
    public void eliminarTarea() {
        if (inicio != null) {
            inicio = inicio.siguiente;
            if (inicio == null) {
                fin = null;
            }
        }
    }

    // Método para buscar una tarea en la cola
    public boolean buscarTarea(String tarea) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.tarea.equals(tarea)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Método para obtener todas las tareas en un array
    public String[] obtenerTareas() {
        int size = contarTareas();
        String[] tareas = new String[size];
        Nodo actual = inicio;
        int index = 0;
        while (actual != null) {
            tareas[index++] = actual.tarea;
            actual = actual.siguiente;
        }
        return tareas;
    }

    // Método auxiliar para contar las tareas
    private int contarTareas() {
        int contador = 0;
        Nodo actual = inicio;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
}
