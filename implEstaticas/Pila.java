package implEstaticas;

import especificaciones.PilaTDA;

public class Pila implements PilaTDA {

    private int[] arr;
    private int indice;

    @Override
    public void inicializarPila() {
        arr = new int[100];
        indice = 0;
    }

    @Override
    public void apilar(int x) {
        arr[indice] = x;
        indice++;
    }

    @Override
    public void desapilar() {
        if (!pilaVacia())
            indice--;
    }

    @Override
    public int tope() {
        if (!pilaVacia())
            return arr[indice - 1];
        return -1;
    }

    @Override
    public boolean pilaVacia() {
        return indice == 0;
    }
}
