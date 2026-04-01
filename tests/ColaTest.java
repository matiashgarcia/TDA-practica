package test;

import ejercicios.practicaCola;
import especificaciones.ColaTDA;
import implEstaticas.Cola;

public class Test {
    public static void main(String[] args) {
        ColaTDA cola = new Cola();
        cola.inicializarCola();
        cola.acolar(5);
        cola.acolar(3);
        cola.acolar(10);
        ColaTDA cola2 = practicaCola.copiarCola(cola);
        practicaCola.imprimirCola(cola);
        practicaCola.imprimirCola(cola2);

        System.out.println("----------------");

        ColaTDA cola3 = new Cola();
        cola3.inicializarCola();
        practicaCola.pasarCola(cola, cola3);
        practicaCola.imprimirCola(cola3);

        System.out.println("----------------");

        System.out.println(practicaCola.calcularSuma(cola3));
    }
}
