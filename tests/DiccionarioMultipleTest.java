package tests;

import ejercicios.DiccionarioMultiplePractica;
import especificaciones.DiccionarioMultipleTDA;
import implEstaticas.DiccionarioMultiple;

public class DiccionarioMultipleTest {

    public static void main(String[] args) {
        DiccionarioMultipleTDA d = new DiccionarioMultiple();
        d.inicializarDiccionario();
        d.agregar(2, 5);
        d.agregar(91, 6);
        d.agregar(8, 53);
        DiccionarioMultiplePractica.imprimirDiccionario(d);
    }
}
