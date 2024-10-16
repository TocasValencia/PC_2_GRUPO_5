public class PilaArreglo {
    private int maxSize;    // tamaño máximo de la pila
    private int[] stackArray;
    private int top;        // tope de la pila

    // Constructor
    public PilaArreglo(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;  // Pila vacía
    }

    // Insertar un elemento en la pila
    public void push(int value) {
        if (isFull()) {
            System.out.println("La pila está llena. No se puede insertar " + value);
            return;
        }
        top++;
        stackArray[top] = value;
    }

    // Eliminar y devolver el elemento superior de la pila
    public int pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía. No se puede eliminar elementos.");
            return -1;  // Valor de error
        }
        int value = stackArray[top];
        top--;
        return value;
    }

    // Ver el elemento superior de la pila sin eliminarlo
    public int peek() {
        if (isEmpty()) {
            System.out.println("La pila está vacía. No hay elementos para ver.");
            return -1;  // Valor de error
        }
        return stackArray[top];
    }

    // Verificar si la pila está vacía
    public boolean isEmpty() {
        return (top == -1);
    }

    // Verificar si la pila está llena
    public boolean isFull() {
        return (top == maxSize - 1);
    }
    
     public int buscar(String valor){
          if(isEmpty()){
          System.out.println("La pila está vacía. No se puede buscar elementos.");
            return -1; // Indicar que no se encontró el valor
          } 
          for (int cont = top; cont >= 0; cont--) { // Comienza desde el tope
            if (stackArray[cont]==valor) {
                // Comparar usando equals
                System.out.println("El valor " + valor + " fue encontrado en la posición " + cont);
                return cont; // Retornar la posición del valor
            } else {            }
        }

        System.out.println("El valor " + valor + " no está en la pila.");
        return -1;  // Indicar que no se encontró el valor
     }

    void push(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}     
