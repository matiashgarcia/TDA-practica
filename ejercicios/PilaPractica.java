package ejercicios;

import especificaciones.PilaTDA;
import implEstaticas.Pila;

public class PilaPractica {

    // Precondicion: origen y destino inicializadas
    public static void pasarPilaInvertida(PilaTDA origen, PilaTDA destino) {
        while (!origen.pilaVacia()) {
            destino.apilar(origen.tope());
            origen.desapilar();
        }
    }
    // Postcondicion: origen queda vacia

    // Precondicion: original esta inicializada
    public static PilaTDA copiarPila(PilaTDA original) {
        PilaTDA aux = new Pila();
        PilaTDA copia = new Pila();
        aux.inicializarPila();
        copia.inicializarPila();
        while (!original.pilaVacia()) {
            aux.apilar(original.tope());
            original.desapilar();
        }
        while (!aux.pilaVacia()) {
            original.apilar(aux.tope());
            copia.apilar(aux.tope());
            aux.desapilar();
        }
        return copia;
    }
    // Postcondicion: original queda como ingreso

    // Precondicion: pila esta inicializada
    public static void invertirPila(PilaTDA pila) {
        PilaTDA aux = new Pila();
        aux.inicializarPila();
        pasarPilaInvertida(pila, aux);
        pasarPilaInvertida(aux, pila);
    }

    // Precondicion: pila esta inicializada
    public static int contarElementosPila(PilaTDA pila) {
        PilaTDA aux = copiarPila(pila);
        int contador = 0;
        while (!aux.pilaVacia()) {
            contador++;
            aux.desapilar();
        }
        return contador;
    }

    // Precondicion: pila esta inicializada
    public static int sumarElementosPila(PilaTDA pila) {
        PilaTDA aux = copiarPila(pila);
        int suma = 0;
        while (!aux.pilaVacia()) {
            suma += aux.tope();
            aux.desapilar();
        }
        return suma;
    }

    // Precondicion: pila esta inicializada
    public static int promedioElementosPila(PilaTDA pila) {
        return sumarElementosPila(pila) / contarElementosPila(pila);
    }

    public static void imprimirPila(PilaTDA pila) {
        PilaTDA aux = copiarPila(pila);
        while (!aux.pilaVacia()) {
            System.out.println(aux.tope());
            aux.desapilar();
        }
    }

}
