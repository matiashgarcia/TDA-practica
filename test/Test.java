package test;

import ejercicios.PasarColaACola;
import especificaciones.ColaTDA;
import especificaciones.SemaforoTDA;
import implEstaticas.Cola;
import implEstaticas.Semaforo;

public class Test {
    public static void main(String[] args) {
        ColaTDA cola = new Cola();
        ColaTDA cola2 = new Cola();
        cola.inicializarCola();
        cola2.inicializarCola();
        cola.acolar(5);
        cola.acolar(3);
        PasarColaACola.PasarColaACola(cola, cola2);
        System.out.println(cola.primero());
        cola.desacolar();
        System.out.println(cola.primero());
        System.out.println(cola2.primero());
        cola2.desacolar();
        System.out.println(cola2.primero());
    }
}
