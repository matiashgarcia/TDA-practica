package implDinamicas;

import especificaciones.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {

    class Nodo {
        private int elemento;
        private int prioridad;
        private Nodo sig;
    }

    private Nodo origen;

    @Override
    public void inicializarCola() {
        origen = null;
    }

    @Override
    public void acolarPrioridad(int elemento, int prioridad) {
        Nodo nuevo = new Nodo();
        // Si lo tengo que acolar primero o segundo
        if (colaVacia() || prioridad > origen.prioridad) {
            nuevo.sig = origen;
            origen = nuevo;
        } else {
            Nodo aux = origen;
            while (aux.sig != null && prioridad <= aux.sig.prioridad) {
                aux = aux.sig;
            }
            // Si lo tengo que acolar entre dos nodos o ultimo
            nuevo.sig = aux.sig;
            aux.sig = nuevo;
        }
        nuevo.elemento = elemento;
        nuevo.prioridad = prioridad;
    }

    @Override
    public void desacolar() {
        origen = origen.sig;
    }

    @Override
    public int primero() {
        return origen.elemento;
    }

    @Override
    public int prioridad() {
        return origen.prioridad;
    }

    @Override
    public boolean colaVacia() {
        return origen == null;
    }

}
