package ejerciciosEstaticos;

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
        PilaTDA aux2 = new Pila();
        aux2.inicializarPila();
        pasarPilaInvertida(pila, aux);
        pasarPilaInvertida(aux, aux2);
        pasarPilaInvertida(aux2, pila);
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

    // Precondicion: pila esta inicializada y no debe estar vacia
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

    public static PilaTDA obtenerMayoresAlPromedio(PilaTDA original) {
        PilaTDA copia = copiarPila(original);
        PilaTDA resultado = new Pila();
        resultado.inicializarPila();
        int promedio = promedioElementosPila(copia);
        while (!copia.pilaVacia()) {
            if (copia.tope() > promedio)
                resultado.apilar(copia.tope());
            copia.desapilar();
        }
        return resultado;
    }

    public static void insertarValorEnPosicion(PilaTDA pila, int x, int k) {
        PilaTDA aux = new Pila();
        aux.inicializarPila();
        int contador = 0;
        while (!pila.pilaVacia() && contador != k) {
            aux.apilar(pila.tope());
            pila.desapilar();
            contador++;
        }
        if (contador == k) {
            pila.apilar(x);
            while (!aux.pilaVacia()) {
                pila.apilar(aux.tope());
                aux.desapilar();
            }
        }
    }

    public static boolean estaOrdenadaCrecientemente(PilaTDA pila) {
        PilaTDA copia = copiarPila(pila);
        int anterior = copia.tope();
        copia.desapilar();
        while (!copia.pilaVacia() && anterior < copia.tope()) {
            anterior = copia.tope();
            copia.desapilar();
        }
        return copia.pilaVacia();
    }

    public static PilaTDA generarPilaIntercalada(PilaTDA a, PilaTDA b) {
        PilaTDA resultado = new Pila();
        resultado.inicializarPila();
        while (!a.pilaVacia() && !b.pilaVacia()) {
            resultado.apilar(a.tope());
            resultado.apilar(b.tope());
            a.desapilar();
            b.desapilar();
        }
        return resultado;
        /*
         * while(!a.pilaVacia() || !b.pilaVacia()){
         * if(!a.pilaVacia())
         * resultado.apilar(a.tope());
         * a.desapilar();
         * if(!b.pilaVacia())
         * resultado.apilar(b.tope());
         * b.desapilar();
         * }
         */
    }

}
