package ejercicios;

import especificaciones.ColaTDA;
import implEstaticas.Cola;

public class PasarColaACola {

    public static void PasarColaACola(ColaTDA origen, ColaTDA destino) {
        ColaTDA aux = new Cola();
        aux.inicializarCola();
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
    }
}
