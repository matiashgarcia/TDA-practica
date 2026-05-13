package tests;

import ejerciciosEstaticos.PilaPractica;
import especificaciones.PilaTDA;
import implEstaticas.Pila;

public class PilaTest {

    public static void main(String[] args) {

        PilaTDA pila = new Pila();
        pila.inicializarPila();
        pila.apilar(8);
        pila.apilar(7);
        pila.apilar(6);
        pila.apilar(4);
        // PilaPractica.imprimirPila(pila);

        PilaTDA pila2 = new Pila();
        pila2.inicializarPila();
        pila2.apilar(3);
        pila2.apilar(12);
        pila2.apilar(5);
        pila2.apilar(64);

        // System.out.println("-------------");
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

        /*
         * PilaPractica.invertirPila(pila);
         * PilaPractica.imprimirPila(pila);
         */

        // System.out.println(PilaPractica.contarElementosPila(pila));
        // System.out.println(PilaPractica.sumarElementosPila(pila));
        // System.out.println(PilaPractica.promedioElementosPila(pila));

        /*
         * PilaTDA pila3 = PilaPractica.obtenerMayoresAlPromedio(pila);
         * PilaPractica.imprimirPila(pila3);
         */

        /*
         * PilaPractica.insertarValorEnPosicion(pila, 18, 2);
         * PilaPractica.imprimirPila(pila);
         */

        // System.out.println(PilaPractica.estaOrdenadaCrecientemente(pila));

        PilaTDA pila4 = PilaPractica.generarPilaIntercalada(pila, pila2);
        PilaPractica.imprimirPila(pila4);
    }
}
