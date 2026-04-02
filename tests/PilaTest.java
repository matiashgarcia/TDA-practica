package tests;

import ejercicios.PilaPractica;
import especificaciones.PilaTDA;
import implEstaticas.Pila;

public class PilaTest {

    public static void main(String[] args) {

        PilaTDA pila = new Pila();
        pila.inicializarPila();
        pila.apilar(6);
        pila.apilar(4);
        pila.apilar(8);
        PilaPractica.imprimirPila(pila);

        PilaTDA pila2 = new Pila();
        pila2.inicializarPila();

        System.out.println("-------------");
        /*
         * PilaPractica.pasarPilaInvertida(pila, pila2);
         * PilaPractica.imprimirPila(pila);
         * PilaPractica.imprimirPila(pila2);
         */

        /*
         * pila2 = PilaPractica.copiarPila(pila);
         * PilaPractica.imprimirPila(pila2);
         * PilaPractica.imprimirPila(pila);
         */

        PilaPractica.invertirPila(pila);
        PilaPractica.imprimirPila(pila);

        // System.out.println(PilaPractica.contarElementosPila(pila));
        // System.out.println(PilaPractica.sumarElementosPila(pila));
        // System.out.println(PilaPractica.promedioElementosPila(pila));
    }
}
