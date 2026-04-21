package ejercicios;

import especificaciones.ConjuntoTDA;
import especificaciones.DiccionarioMultipleTDA;
import especificaciones.DiccionarioSimpleTDA;
import implEstaticas.DiccionarioMultiple;

public class DiccionarioMultiplePractica {

    public static DiccionarioMultipleTDA pasarDicSimpleADicMult(DiccionarioSimpleTDA dic){
        DiccionarioMultipleTDA dicMultiple = new DiccionarioMultiple();
        dicMultiple.inicializarDiccionario();
        ConjuntoTDA c = dic.claves();
        while(!c.conjuntoVacio()){
            int clave = c.elegir();
            int valor = dic.recuperar(clave);
            dicMultiple.agregar(clave, valor);
            c.sacar(clave);
        }
        return dicMultiple;
    }

    public static void imprimirDiccionario(DiccionarioMultipleTDA d){
        ConjuntoTDA c = d.claves();
        while(!c.conjuntoVacio()){
            int clave = c.elegir();
            ConjuntoTDA v = d.recuperar(clave);
            System.out.print("{" + clave + " : " + "[");
            while(!v.conjuntoVacio()){
                int valor = v.elegir();
                System.out.print(+ valor + ", ");
                v.sacar(valor);
            }
            System.out.println("]}");
            c.sacar(clave);
        }
    }
    
}
