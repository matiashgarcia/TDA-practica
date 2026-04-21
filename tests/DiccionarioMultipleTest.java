package tests;

import ejercicios.DiccionarioMultiplePractica;
import especificaciones.DiccionarioMultipleTDA;
import especificaciones.DiccionarioSimpleTDA;
import implEstaticas.DiccionarioMultiple;
import implEstaticas.DiccionarioSimple;

public class DiccionarioMultipleTest {

    public static void main(String[] args) {
/*         DiccionarioMultipleTDA d = new DiccionarioMultiple();
        d.inicializarDiccionario();
        d.agregar(2, 5);
        d.agregar(91, 6);
        d.agregar(91, 12);
        d.agregar(91, 82);
        d.agregar(8, 53);
        d.agregar(8, 20);
        DiccionarioMultiplePractica.imprimirDiccionario(d); */

        DiccionarioSimpleTDA dicSimple = new DiccionarioSimple();
        dicSimple.inicializarDiccionario();
        dicSimple.agregar(2, 5);
        dicSimple.agregar(94, 41);
        dicSimple.agregar(62, 4);
        dicSimple.agregar(1, 5);
        DiccionarioMultipleTDA d2 = DiccionarioMultiplePractica.pasarDicSimpleADicMult(dicSimple);
        DiccionarioMultiplePractica.imprimirDiccionario(d2);
    }
}
