package tests;

import ejercicios.ConjuntoPractica;
import especificaciones.ConjuntoTDA;
import implEstaticas.Conjunto;

public class ConjuntoTest {

    public static void main(String[] args) {

        ConjuntoTDA c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(5);
        c1.agregar(2);
        c1.agregar(6);

        ConjuntoTDA c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(6);
        c2.agregar(1);
        c2.agregar(7);
        c2.agregar(2);

        /*
         * ConjuntoTDA c3 = ConjuntoPractica.interseccionDeConjuntos(c1, c2);
         * ConjuntoPractica.imprimirConjunto(c3);
         */

        /*
         * ConjuntoTDA c4 = ConjuntoPractica.unionDeConjuntos(c1, c2);
         * ConjuntoPractica.imprimirConjunto(c4);
         */

        ConjuntoTDA c5 = ConjuntoPractica.diferenciaDeConjuntos(c1, c2);
        ConjuntoPractica.imprimirConjunto(c5);
    }

}
