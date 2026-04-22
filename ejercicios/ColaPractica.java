package ejercicios;

import especificaciones.ColaTDA;
import especificaciones.PilaTDA;
import implEstaticas.Cola;
import implEstaticas.Pila;

public class ColaPractica {

    // Pasar los elementos de una cola a la otra, manteniendo el orden original
    // Precondicion: ambas colas inicializadas
    public static void pasarCola(ColaTDA origen, ColaTDA destino) {
        while (!origen.colaVacia()) {
            int primero = origen.primero();
            destino.acolar(primero);
            origen.desacolar();
        }
    }

    // Copio los elementos de una cola a una nueva cola, manteniendo la original
    // intacta
    public static ColaTDA copiarCola(ColaTDA origen) {
        ColaTDA aux = new Cola();
        ColaTDA destino = new Cola();
        aux.inicializarCola();
        destino.inicializarCola();
        while (!origen.colaVacia()) {
            int primero = origen.primero();
            aux.acolar(primero);
            origen.desacolar();
        }
        while (!aux.colaVacia()) {
            int primero = aux.primero();
            origen.acolar(primero);
            destino.acolar(primero);
            aux.desacolar();
        }
        return destino;
    }

    // precondicion: cola inicializada
    public static void invertirColaConPilas(ColaTDA cola) {
        PilaTDA aux = new Pila();
        aux.inicializarPila();
        while (!cola.colaVacia()) {
            aux.apilar(cola.primero());
            cola.desacolar();
        }
        while (!aux.pilaVacia()) {
            cola.acolar(aux.tope());
            aux.desapilar();
        }
    }

    // precondicion: cola inicializada
    public static void invertirColaSinPilas(ColaTDA cola) {
        if (cola.colaVacia()) {
            return;
        }
        int primero = cola.primero();
        cola.desacolar();
        invertirColaSinPilas(cola);
        cola.acolar(primero);
    }

    public static boolean coincideFinal(ColaTDA a, ColaTDA b) {
        invertirColaConPilas(a);
        invertirColaConPilas(b);
        return a.primero() == b.primero();
    }

    public static boolean esCapicua(ColaTDA cola) {
        ColaTDA copia1 = copiarCola(cola);
        ColaTDA copia2 = copiarCola(cola);
        invertirColaConPilas(copia2);
        while (!copia1.colaVacia()) {
            if (copia1.primero() != copia2.primero())
                return false;
            copia1.desacolar();
            copia2.desacolar();
        }
        return true;
    }

    // Precondicion: ambas colas inicializadas
    public static boolean sonInversas(ColaTDA cola1, ColaTDA cola2) {
        ColaTDA copia1 = copiarCola(cola1);
        ColaTDA copia2 = copiarCola(cola2);
        invertirColaConPilas(copia2);
        while (!copia1.colaVacia()) {
            if (copia1.primero() != copia2.primero())
                return false;
            copia1.desacolar();
            copia2.desacolar();
        }
        return true;
    }

    public static int contarElementos(ColaTDA cola) {
        ColaTDA aux = copiarCola(cola);
        int contador = 0;
        while (!aux.colaVacia()) {
            contador++;
            aux.desacolar();
        }
        return contador;
    }

    public static int calcularSuma(ColaTDA cola) {
        ColaTDA copia = copiarCola(cola);
        int suma = 0;
        while (!copia.colaVacia()) {
            suma += copia.primero();
            copia.desacolar();
        }
        return suma;
    }

    public static void imprimirCola(ColaTDA cola) {
        ColaTDA aux = copiarCola(cola);
        while (!aux.colaVacia()) {
            System.out.println(aux.primero());
            aux.desacolar();
        }
    }

    public static moverKelementosAlFinal(int k, ColaTDA c){

    }
}
