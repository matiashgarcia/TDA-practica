package implEstaticas;

import especificaciones.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {

    private class Elemento {
        private int valor;
        private int prioridad;
    }

    private Elemento[] elementos;
    private int indice;

    @Override
    public void inicializarCola() {
        elementos = new Elemento[100];
        indice = 0;
    }

    @Override
    public void acolarPrioridad(int valor, int prioridad) {
        int i = indice - 1;
        while (i >= 0 && prioridad <= elementos[i].prioridad) {
            elementos[i + 1] = elementos[i];
            i--;
        }
        elementos[i + 1] = new Elemento();
        elementos[i + 1].prioridad = prioridad;
        elementos[i + 1].valor = valor;
        indice++;
    }

    @Override
    public void desacolar() {
        indice--;
    }

    @Override
    public int primero() {
        return elementos[indice - 1].valor;
    }

    @Override
    public int prioridad() {
        return elementos[indice - 1].prioridad;
    }

    @Override
    public boolean colaVacia() {
        return indice == 0;
    }

}
