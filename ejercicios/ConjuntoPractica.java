package ejercicios;

import especificaciones.ConjuntoTDA;
import implEstaticas.Conjunto;

public class ConjuntoPractica {

    public static ConjuntoTDA interseccionDeConjuntos(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA resultado = new Conjunto();
        resultado.inicializarConjunto();
        ConjuntoTDA copiaA = copiarConjunto(a);
        ConjuntoTDA copiaB = copiarConjunto(b);
        while (!copiaA.conjuntoVacio()) {
            int elemento = copiaA.elegir();
            if (copiaB.pertence(elemento)) {
                resultado.agregar(elemento);
                copiaB.sacar(elemento);
            }
            copiaA.sacar(elemento);
        }
        return resultado;
    }

    public static ConjuntoTDA unionDeConjuntos(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA resultado = new Conjunto();
        resultado.inicializarConjunto();
        ConjuntoTDA copiaA = copiarConjunto(a);
        ConjuntoTDA copiaB = copiarConjunto(b);
        while (!copiaA.conjuntoVacio() || !copiaB.conjuntoVacio()) {
            if (!copiaA.conjuntoVacio()) {
                int elemento = copiaA.elegir();
                resultado.agregar(elemento);
                copiaA.sacar(elemento);
            }
            if (!copiaB.conjuntoVacio()) {
                int elemento = copiaB.elegir();
                resultado.agregar(elemento);
                copiaB.sacar(elemento);
            }
        }
        return resultado;
    }

    public static ConjuntoTDA diferenciaDeConjuntos(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA resultado = new Conjunto();
        resultado.inicializarConjunto();
        ConjuntoTDA copiaA = copiarConjunto(a);
        ConjuntoTDA copiaB = copiarConjunto(b);
        while (!copiaA.conjuntoVacio()) {
            int elemento = copiaA.elegir();
            if (!copiaB.pertence(elemento))
                resultado.agregar(elemento);
            else
                copiaB.sacar(elemento);
            copiaA.sacar(elemento);
        }
        while (!copiaB.conjuntoVacio()) {
            int elemento = copiaB.elegir();
            resultado.agregar(elemento);
            copiaB.sacar(elemento);
        }
        return resultado;
    }

    public static ConjuntoTDA copiarConjunto(ConjuntoTDA original) {
        ConjuntoTDA aux = new Conjunto();
        ConjuntoTDA copia = new Conjunto();
        aux.inicializarConjunto();
        copia.inicializarConjunto();
        while (!original.conjuntoVacio()) {
            int elemento = original.elegir();
            aux.agregar(elemento);
            copia.agregar(elemento);
            original.sacar(elemento);
        }
        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            original.agregar(elemento);
            aux.sacar(elemento);
        }
        return copia;
    }

    public static void imprimirConjunto(ConjuntoTDA c) {
        ConjuntoTDA copia = copiarConjunto(c);
        while (!copia.conjuntoVacio()) {
            int elemento = copia.elegir();
            System.out.println(elemento);
            copia.sacar(elemento);
        }
    }

}
