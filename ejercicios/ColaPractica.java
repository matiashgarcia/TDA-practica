package ejercicios;

import especificaciones.ColaTDA;
import implEstaticas.Cola;

public class practicaCola {

    // Pasar los elementos de una cola a la otra, manteniendo el orden original
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
}
