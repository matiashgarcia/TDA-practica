package implDinamicas;

import especificaciones.ConjuntoTDA;

public class ConjuntoDM implements ConjuntoTDA {

    class Nodo {
        private int valor;
        private Nodo sig;
    }

    private Nodo origen;

    @Override
    public void inicializarConjunto() {
        origen = null;
    }

    @Override
    public void agregar(int x) {
        if (!pertence(x)) {
            Nodo nuevo = new Nodo();
            nuevo.valor = x;
            nuevo.sig = origen;
            origen = nuevo;
        }
    }

    @Override
    public void sacar(int x) {
        // Si el conjunto no esta vacio
        if (!conjuntoVacio()) {
            // Si es el primer elemento, lo saco
            if (origen.valor == x)
                origen = origen.sig;
            else {
                Nodo aux = origen;
                // Si no es el primer elemento, lo busco
                while (aux.sig != null && aux.sig.valor != x) {
                    aux = aux.sig;
                }
                // Si lo encuentro, lo saco
                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }

    @Override
    public int elegir() {
        return origen.valor;

    }

    @Override
    public boolean pertence(int x) {
        Nodo aux = origen;
        while (aux != null && aux.valor != x)
            aux = aux.sig;
        return aux != null;
    }

    @Override
    public boolean conjuntoVacio() {
        return origen == null;
    }

}
