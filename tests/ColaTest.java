package tests;

import ejercicios.ColaPractica;
import especificaciones.ColaTDA;
import implEstaticas.Cola;

public class ColaTest {
    public static void main(String[] args) {
        ColaTDA cola = new Cola();
        cola.inicializarCola();
        cola.acolar(5);
        cola.acolar(3);
        cola.acolar(10);
        ColaTDA cola2 = ColaPractica.copiarCola(cola);
        ColaPractica.imprimirCola(cola);
        ColaPractica.imprimirCola(cola2);

        System.out.println("----------------");

        ColaTDA cola3 = new Cola();
        cola3.inicializarCola();
        ColaPractica.pasarCola(cola, cola3);
        ColaPractica.imprimirCola(cola3);

        System.out.println("----------------");

        System.out.println(ColaPractica.calcularSuma(cola3));
    }
}
