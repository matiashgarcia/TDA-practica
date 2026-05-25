package implDinamicas;

import especificaciones.ConjuntoTDA;
import especificaciones.GrafoTDA;

public class GrafoDM implements GrafoTDA {

    class NodoVertice {
        private int valor;
        private NodoVertice sigVertice;
        private NodoArista primerArista;
    }

    class NodoArista {
        private int peso;
        private NodoVertice nodoDestino;
        private NodoArista sigArista;
    }

    private NodoVertice origen;

    @Override
    public void inicializarGrafo() { // Complejidad constante
        origen = null;
    }

    @Override
    public void agregarVertice(int valor) { // Complejidad lineal
        NodoVertice nuevo = vertice2NodoVertice(valor);
        // Si no encuentro el vertice, lo agrego al comienzo
        if (nuevo == null) {
            nuevo = new NodoVertice();
            nuevo.valor = valor;
            nuevo.sigVertice = origen;
            nuevo.primerArista = null;
            origen = nuevo;
        }
    }

    @Override
    public void eliminarVertice(int valor) { // Complejidad lineal
        // Si el grafo no esta vacio
        if (origen != null) {
            NodoVertice aux = origen;
            // Por cada vertice, mando a eliminar la arista que tiene el nodo como destino
            while (aux != null) {
                eliminarAristaEnNodoVertice(aux, valor);
                aux = aux.sigVertice;
            }
            // Luego, si el primer nodo es el que busco, lo elimino
            if (origen.valor == valor) {
                origen = origen.sigVertice; 
            }
            // Si no es el primero, recorro el resto de nodos 
            else {
                aux = origen;
                while (aux.sigVertice != null && aux.sigVertice.valor != valor) {
                    aux = aux.sigVertice;
                }
                // Si encontre el nodo, lo elimino
                if (aux.sigVertice != null) {
                    aux.sigVertice = aux.sigVertice.sigVertice;
                }
            }
        }
    }

    @Override
    public void agregarArista(int o, int d, int peso) { // Complejidad lineal
        NodoVertice nodoOrigen = vertice2NodoVertice(o);
        NodoVertice nodoDestino = vertice2NodoVertice(d);
        // Si ambos nodos existen
        if (nodoOrigen != null && nodoDestino != null) {
            NodoArista aux = nodoOrigen.primerArista;
            // Busco la arista
            while (aux != null && aux.nodoDestino != nodoDestino) {
                aux = aux.sigArista;
            }
            // Si no existe la arista, la agrego
            if (aux == null) {
                NodoArista nueva = new NodoArista();
                nueva.nodoDestino = nodoDestino;
                nueva.sigArista = nodoOrigen.primerArista;
                nodoOrigen.primerArista = nueva;
                nueva.peso = peso;
            }
            // Si existe la arista, actualizo su peso
            else {
                aux.peso = peso;
            }
        }
    }

    @Override
    public void eliminarArista(int o, int d) { // Complejidad lineal
        NodoVertice nodoOrigen = vertice2NodoVertice(o);
        // Si ambos nodos existen, mando a eliminar la arista
        if (nodoOrigen != null) {
            eliminarAristaEnNodoVertice(nodoOrigen, d);
        }
    }

    @Override
    public int pesoArista(int o, int d) { // Complejidad lineal
        NodoVertice nodoOrigen = vertice2NodoVertice(o);
        // Si existe el nodo origen
        if (nodoOrigen != null) {
            NodoArista aux = nodoOrigen.primerArista;
            // Busco la arista
            while (aux != null && aux.nodoDestino.valor != d) {
                aux = aux.sigArista;
            }
            // Si encuentro la arista, devuelvo el peso
            if (aux != null) {
                return aux.peso;
            }
        }
        // Si no existe el nodo o no existe la arista, devuelvo -1
        return -1;
    }

    @Override
    public ConjuntoTDA vertices() { // Complejidad polinomica
        ConjuntoTDA vertices = new ConjuntoDM();
        vertices.inicializarConjunto();
        NodoVertice aux = origen;
        while (aux != null) {
            vertices.agregar(aux.valor);
            aux = aux.sigVertice;
        }
        return vertices;
    }

    @Override
    public boolean existeArista(int o, int d) { // Complejidad lineal
        NodoVertice nodoOrigen = vertice2NodoVertice(o);
        // Si existe el nodo origen
        if (nodoOrigen != null) {
            NodoArista aux = nodoOrigen.primerArista;
            // Busco la arista
            while (aux != null && aux.nodoDestino.valor != d) {
                aux = aux.sigArista;
            }
            // Existe la arista
            if (aux != null) {
                return true;
            }
        }
        // No existe la arista
        return false;
    }

    private NodoVertice vertice2NodoVertice(int valor) { // Complejidad lineal
        NodoVertice aux = origen;
        // Busco el nodo
        while (aux != null && aux.valor != valor) {
            aux = aux.sigVertice;
        }
        // Devuelve el nodo o null segun si haya lo haya encontrado o no
        return aux;
    }

    private void eliminarAristaEnNodoVertice(NodoVertice vertice, int valor) { // Complejidad lineal
        NodoArista aux = vertice.primerArista;
        // Si tiene aristas
        if (aux != null) {
            // Si la primer arista tiene como destino el nodo buscado, lo elimino
            if (aux.nodoDestino.valor == valor) {
                vertice.primerArista = vertice.primerArista.sigArista;
            }
            // Si no, recorro las aristas
            else {
                while (aux.sigArista != null && aux.sigArista.nodoDestino.valor != valor) {
                    aux = aux.sigArista;
                }
                if (aux.sigArista != null) {
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }

}
