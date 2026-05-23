package implDinamicas;

import especificaciones.ABBTDA;

public class ABB implements ABBTDA {

    class NodoABB {
        int valor;
        ABBTDA hijoIzq;
        ABBTDA hijoDer;
    }

    private NodoABB raiz;

    @Override
    public void inicializarArbol() { // Complejidad constante
        raiz = null;
    }

    @Override
    public int raiz() { // Complejidad constante
        return raiz.valor;
    }

    @Override
    public void agregarNodo(int valor) { // Complejidad lineal
        // Si el arbol esta vacio, llegue al nodo hoja donde debo agregar el valor
        if (arbolVacio()) {
            raiz = new NodoABB();
            raiz.valor = valor;
            raiz.hijoIzq = new ABB();
            raiz.hijoIzq.inicializarArbol();
            raiz.hijoDer = new ABB();
            raiz.hijoDer.inicializarArbol();
        }
        // Si el arbol no esta vacio
        else {
            // Si el valor que busco es menor al de la raiz, busco por el hijo izquierdo
            if (valor < raiz.valor) {
                raiz.hijoIzq.agregarNodo(valor);
            }
            // Si el valor que busco es mayor al de la raiz, busco por el hijo derecho
            if (valor > raiz.valor) {
                raiz.hijoDer.agregarNodo(valor);
            }
        }
    }

    @Override
    public void eliminarNodo(int valor) { // Complejidad lineal
        // Si el arbol no esta vacio, busco el valor
        if (!arbolVacio()) {
            // Si encontre el valor
            if (raiz.valor == valor) {
                // Si el valor esta en un nodo hoja, lo elimino (arbol vacio)
                if (raiz.hijoIzq.arbolVacio() && raiz.hijoDer.arbolVacio()) {
                    raiz = null;
                }
                // Si tiene hijo izquierdo
                else if (!raiz.hijoIzq.arbolVacio()) {
                    // Busco el mayor de los menores, reemplazo la raiz con el mayor y mando a
                    // eliminar el mayor que quedo suelto
                    int mayor = mayor(this.hijoIzq());
                    raiz.valor = mayor;
                    raiz.hijoIzq.eliminarNodo(mayor);
                }
                // Si solo tiene hijo derecho
                else {
                    // Busco el menor de los mayores, reemplazo la raiz con el menor y mando a
                    // eliminar el menor que quedo suelto
                    int menor = menor(this.hijoDer());
                    raiz.valor = menor;
                    raiz.hijoDer.eliminarNodo(menor);
                }
            }
            // Si el valor que busco es menor al actual, busco en hijo izquierdo
            else if (valor < raiz.valor) {
                raiz.hijoIzq.eliminarNodo(valor);
            }
            // Si el valor que busco es mayor al actual, busco en hijo derecho
            else {
                raiz.hijoDer.eliminarNodo(valor);
            }
        }
    }

    private int menor(ABBTDA abb) { // Complejidad lineal
        // Si llegue al menor, devuelvo el valor
        if (abb.hijoIzq().arbolVacio()) {
            return abb.raiz();
        }
        // Si no llegue al menor, sigo buscando en el hijo izquierdo
        return menor(abb.hijoIzq());
    }

    private int mayor(ABBTDA abb) { // Complejidad lineal
        // Si llegue al mayor, devuelvo el valor
        if (abb.hijoDer().arbolVacio()) {
            return abb.raiz();
        }
        // Si no llegue al mayor, sigo buscando en el hijo derecho
        return mayor(abb.hijoDer());
    }

    @Override
    public ABBTDA hijoIzq() { // Complejidad constante
        return raiz.hijoIzq;
    }

    @Override
    public ABBTDA hijoDer() { // Complejidad constante
        return raiz.hijoDer;
    }

    @Override
    public boolean arbolVacio() { // Complejidad constante
        return raiz == null;
    }

}
