package test;

import especificaciones.ColaTDA;
import especificaciones.SemaforoTDA;
import implEstaticas.Cola;
import implEstaticas.Semaforo;

public class Test {
    public static void main(String[] args) {
        ColaTDA cola = new Cola();
        cola.inicializarCola();
        cola.acolar(5);
        System.out.println(cola.primero());
        cola.desacolar();
        System.out.println(cola.primero());

    }
}
