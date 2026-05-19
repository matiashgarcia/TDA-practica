package implDinamicas;

import especificaciones.ConjuntoTDA;
import especificaciones.DiccionarioSimpleTDA;

public class DiccionarioSimpleDM implements DiccionarioSimpleTDA {

    class Nodo {
        private int clave;
        private int valor;
        private Nodo sig;
    }

    private Nodo origen;

    @Override
    public void inicializarDiccionario() {
        origen = null;
    }

    @Override
    public void agregar(int clave, int valor) {
        Nodo aux = origen;
        while (aux != null && aux.clave != clave) {
            aux = aux.sig;
        }
        if (aux != null)
            aux.valor = valor;
        else {
            Nodo nuevo = new Nodo();
            nuevo.clave = clave;
            nuevo.valor = valor;
            nuevo.sig = origen;
            origen = nuevo;
        }
    }

    @Override
    public void eliminar(int clave) {
        // Si no esta vacio el diccionario, empiezo
        if (origen != null) {
            // Si la clave esta en el origen, la elimino
            if (origen.clave == clave)
                origen = origen.sig;
            // Si no esta en el origen, recorro la lista
            else {
                Nodo aux = origen;
                while (aux.sig != null && aux.sig.clave != clave) {
                    aux = aux.sig;
                }
                // Si encuentro la clave, la elimino
                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA claves = new ConjuntoDM();
        claves.inicializarConjunto();
        Nodo aux = origen;
        while (aux != null) {
            claves.agregar(aux.clave);
            aux = aux.sig;
        }
        return claves;
    }

    @Override
    public int recuperar(int clave) {
        Nodo aux = origen;
        while (aux != null && aux.clave != clave)
            aux = aux.sig;
        if (aux != null)
            return aux.valor;
        return -1;

    }

}
