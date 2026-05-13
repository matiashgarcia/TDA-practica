package ejerciciosEstaticos;

import especificaciones.ConjuntoTDA;
import especificaciones.DiccionarioSimpleTDA;
import especificaciones.PilaTDA;
import implEstaticas.Pila;

public class DiccionarioSimplePractica {

    public static PilaTDA pasarValoresDiccionarioAPila(DiccionarioSimpleTDA dic) {
        PilaTDA pilaValores = new Pila();
        pilaValores.inicializarPila();
        ConjuntoTDA claves = dic.claves(); // P
        while (!claves.conjuntoVacio()) { // L
            int clave = claves.elegir(); // C
            int valor = dic.recuperar(clave); // L
            pilaValores.apilar(valor); // C
            claves.sacar(clave); // L
        }
        return pilaValores;
    }

    public static void imprimirDiccionario(DiccionarioSimpleTDA dic) {
        ConjuntoTDA claves = dic.claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            int valor = dic.recuperar(clave);
            System.out.println("{" + clave + " : " + valor + "}");
            claves.sacar(clave);
        }
    }

    public static boolean sonDiccionariosIguales(DiccionarioSimpleTDA a, DiccionarioSimpleTDA b) {
        ConjuntoTDA clavesA = a.claves();
        ConjuntoTDA clavesB = b.claves();
        while (!clavesA.conjuntoVacio() && !clavesB.conjuntoVacio()) {
            int claveA = clavesA.elegir();
            int valorA = a.recuperar(claveA);
            int valorB = b.recuperar(claveA);
            if (!clavesB.pertence(claveA) || valorA != valorB)
                return false;
            clavesA.sacar(claveA);
            clavesB.sacar(claveA);
        }
        return clavesA.conjuntoVacio() && clavesB.conjuntoVacio();
    }

}
