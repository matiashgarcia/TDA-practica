package ejerciciosEstaticos;

import java.util.ArrayList;
import java.util.List;

import especificaciones.ColaTDA;
import especificaciones.ConjuntoTDA;
import especificaciones.DiccionarioMultipleTDA;
import especificaciones.DiccionarioSimpleTDA;
import especificaciones.PilaTDA;
import implEstaticas.Cola;
import implEstaticas.Conjunto;
import implEstaticas.DiccionarioSimple;
import implEstaticas.Pila;

public class ColaPractica {

    // Pasar los elementos de una cola a la otra, manteniendo el orden original
    // Precondicion: ambas colas inicializadas
    public static void pasarCola(ColaTDA origen, ColaTDA destino) {
        while (!origen.colaVacia()) {
            int primero = origen.primero();
            destino.acolar(primero);
            origen.desacolar();
        }
    }

    // Copio los elementos de una cola a una nueva cola, manteniendo la original
    // intacta
    public static ColaTDA copiarCola(ColaTDA origen) {
        ColaTDA aux = new Cola();
        ColaTDA destino = new Cola();
        aux.inicializarCola();
        destino.inicializarCola();
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
        return destino;
    }

    // precondicion: cola inicializada
    public static void invertirColaConPilas(ColaTDA cola) {
        PilaTDA aux = new Pila();
        aux.inicializarPila();
        while (!cola.colaVacia()) {
            aux.apilar(cola.primero());
            cola.desacolar();
        }
        while (!aux.pilaVacia()) {
            cola.acolar(aux.tope());
            aux.desapilar();
        }
    }

    // precondicion: cola inicializada
    public static void invertirColaSinPilas(ColaTDA cola) {
        if (cola.colaVacia()) {
            return;
        }
        int primero = cola.primero();
        cola.desacolar();
        invertirColaSinPilas(cola);
        cola.acolar(primero);
    }

    public static boolean coincideFinal(ColaTDA a, ColaTDA b) {
        invertirColaConPilas(a);
        invertirColaConPilas(b);
        return a.primero() == b.primero();
    }

    public static boolean esCapicua(ColaTDA cola) {
        ColaTDA copia1 = copiarCola(cola);
        ColaTDA copia2 = copiarCola(cola);
        invertirColaConPilas(copia2);
        while (!copia1.colaVacia()) {
            if (copia1.primero() != copia2.primero())
                return false;
            copia1.desacolar();
            copia2.desacolar();
        }
        return true;
    }

    // Precondicion: ambas colas inicializadas
    public static boolean sonInversas(ColaTDA cola1, ColaTDA cola2) {
        ColaTDA copia1 = copiarCola(cola1);
        ColaTDA copia2 = copiarCola(cola2);
        invertirColaConPilas(copia2);
        while (!copia1.colaVacia()) {
            if (copia1.primero() != copia2.primero())
                return false;
            copia1.desacolar();
            copia2.desacolar();
        }
        return true;
    }

    public static int contarElementos(ColaTDA cola) {
        ColaTDA aux = copiarCola(cola);
        int contador = 0;
        while (!aux.colaVacia()) {
            contador++;
            aux.desacolar();
        }
        return contador;
    }

    public static int calcularSuma(ColaTDA cola) {
        ColaTDA copia = copiarCola(cola);
        int suma = 0;
        while (!copia.colaVacia()) {
            suma += copia.primero();
            copia.desacolar();
        }
        return suma;
    }

    public static void imprimirCola(ColaTDA cola) {
        ColaTDA aux = copiarCola(cola);
        while (!aux.colaVacia()) {
            System.out.println(aux.primero());
            aux.desacolar();
        }
    }

    public static void moverKelementosAlFinal(int k, ColaTDA c) {
        for (int i = 0; i < k; i++) {
            int elemento = c.primero();
            c.acolar(elemento);
            c.desacolar();
        }
    }

    // Chequear este metodo
    public static void ordenarConColasAux(ColaTDA c) {
        ColaTDA resultado = new Cola();
        resultado.inicializarCola();

        while (!c.colaVacia()) {
            // cycle through c to find minimum, saving all elements in aux
            ColaTDA aux = new Cola();
            aux.inicializarCola();
            int min = c.primero();
            while (!c.colaVacia()) {
                if (c.primero() < min)
                    min = c.primero();
                aux.acolar(c.primero());
                c.desacolar();
            }
            // restore c from aux, skipping the first occurrence of min
            boolean removed = false;
            while (!aux.colaVacia()) {
                if (aux.primero() == min && !removed) {
                    removed = true;
                } else {
                    c.acolar(aux.primero());
                }
                aux.desacolar();
            }
            resultado.acolar(min);
        }
        pasarCola(resultado, c);
    }

    public static int valorMasRepetido(ColaTDA c) {
        ColaTDA aux = copiarCola(c);
        DiccionarioSimpleTDA d = new DiccionarioSimple();
        d.inicializarDiccionario();
        while (!aux.colaVacia()) {
            int clave = aux.primero();
            int valor = d.recuperar(clave);
            if (valor == -1)
                d.agregar(clave, 1);
            else
                d.agregar(clave, valor + 1);
            aux.desacolar();
        }
        ConjuntoTDA claves = d.claves();
        int claveMayor = claves.elegir();
        int valorMayor = d.recuperar(claveMayor);
        claves.sacar(claveMayor);
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            int valor = d.recuperar(clave);
            if (valor > valorMayor) {
                valorMayor = valor;
                claveMayor = clave;
            }
            claves.sacar(clave);
        }
        return claveMayor;
    }

    public static void separarParesEImpares(ColaTDA c, ColaTDA pares, ColaTDA impares) {
        ColaTDA aux = copiarCola(c);
        while (!aux.colaVacia()) {
            int primero = aux.primero();
            if (primero % 2 == 0)
                pares.acolar(primero);
            else
                impares.acolar(primero);
            aux.desacolar();
        }
    }

    public static ColaTDA valoresDictMultipleCuyaClaveCoincideCola(DiccionarioMultipleTDA d, ColaTDA c) {
        ColaTDA aux = new Cola();
        aux.inicializarCola();
        ConjuntoTDA claves = d.claves();
        ColaTDA resultado = new Cola();
        resultado.inicializarCola();
        while (!c.colaVacia()) {
            int clave = c.primero();
            if (claves.pertence(clave)) {
                ConjuntoTDA valores = d.recuperar(clave);
                while (!valores.conjuntoVacio()) {
                    int valor = valores.elegir();
                    resultado.acolar(valor);
                    valores.sacar(valor);
                }
                claves.sacar(clave);
            }
            c.desacolar();
            aux.acolar(clave);
        }
        while (!aux.colaVacia()) {
            int elemento = aux.primero();
            c.acolar(elemento);
            aux.desacolar();
        }
        return resultado;
    }
}
