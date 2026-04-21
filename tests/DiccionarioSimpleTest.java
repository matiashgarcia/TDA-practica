package tests;

import ejercicios.DiccionarioSimplePractica;
import ejercicios.PilaPractica;
import especificaciones.DiccionarioSimpleTDA;
import especificaciones.PilaTDA;
import implEstaticas.DiccionarioSimple;
import implEstaticas.Pila;

public class DiccionarioSimpleTest {

    public static void main(String[] args) {

        DiccionarioSimpleTDA d1 = new DiccionarioSimple();
        d1.inicializarDiccionario();
        d1.agregar(4, 2);
        d1.agregar(56, 12);
        d1.agregar(68, 3);
        DiccionarioSimplePractica.imprimirDiccionario(d1);

        d1.eliminar(4);
        DiccionarioSimplePractica.imprimirDiccionario(d1);

        PilaTDA pila = DiccionarioSimplePractica.pasarValoresDiccionarioAPila(d1);
        PilaPractica.imprimirPila(pila);
    }

}
