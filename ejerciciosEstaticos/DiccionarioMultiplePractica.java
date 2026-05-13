package ejerciciosEstaticos;

import especificaciones.ColaTDA;
import especificaciones.ConjuntoTDA;
import especificaciones.DiccionarioMultipleTDA;
import especificaciones.DiccionarioSimpleTDA;
import implEstaticas.Cola;
import implEstaticas.DiccionarioMultiple;

public class DiccionarioMultiplePractica {

    public static DiccionarioMultipleTDA pasarDicSimpleADicMult(DiccionarioSimpleTDA dic) {
        DiccionarioMultipleTDA dicMultiple = new DiccionarioMultiple();
        dicMultiple.inicializarDiccionario();
        ConjuntoTDA c = dic.claves();
        while (!c.conjuntoVacio()) {
            int clave = c.elegir();
            int valor = dic.recuperar(clave);
            dicMultiple.agregar(clave, valor);
            c.sacar(clave);
        }
        return dicMultiple;
    }

    public static void imprimirDiccionario(DiccionarioMultipleTDA d) {
        ConjuntoTDA c = d.claves();
        while (!c.conjuntoVacio()) {
            int clave = c.elegir();
            ConjuntoTDA v = d.recuperar(clave);
            System.out.print("{" + clave + " : " + "[");
            while (!v.conjuntoVacio()) {
                int valor = v.elegir();
                System.out.print(valor + ", ");
                v.sacar(valor);
            }
            System.out.println("]}");
            c.sacar(clave);
        }
    }

    public static void clavesOrdenadas(DiccionarioMultipleTDA d) {
        ColaTDA resultado = new Cola();
        resultado.inicializarCola();
        ConjuntoTDA claves = d.claves();
        while (!claves.conjuntoVacio()) {
            ColaTDA aux = new Cola();
            aux.inicializarCola();
            int min = claves.elegir();
            // encuentro al minimo, queda vacio el conjunto claves
            while (!claves.conjuntoVacio()) {
                int clave = claves.elegir();
                if (clave < min) {
                    min = clave;
                }
                aux.acolar(clave);
                claves.sacar(clave);
                // relleno el conjunto claves menos el minimo
            }
            while (!aux.colaVacia()) {
                if (aux.primero() != min)
                    claves.agregar(aux.primero());
                aux.desacolar();
            }
            claves.sacar(min);
            resultado.acolar(min);
        }
        System.out.println("Claves ordenadas: " + resultado);
    }

}
