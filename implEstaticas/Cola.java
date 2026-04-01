package implEstaticas;

import especificaciones.ColaTDA;

public class Cola implements ColaTDA {

    private int arr[];
    private int index;

    @Override
    public void inicializarCola() {
        arr = new int[100];
        index = 0;
    }

    @Override
    public void acolar(int x) {
        arr[index] = x;
        index++;
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            // Desplazamiento a la izquierda - Sobreescribo primero de la cola
            for (int i = 0; i < index - 1; i++) {
                arr[i] = arr[i + 1];
            }
            index--;
        }
    }

    @Override
    public int primero() {
        if (!colaVacia())
            return arr[0];
        return -1;
    }

    @Override
    public boolean colaVacia() {
        return index == 0;
    }

}