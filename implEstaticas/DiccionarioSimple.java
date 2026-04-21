package implEstaticas;

import especificaciones.ConjuntoTDA;
import especificaciones.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

    private class Elemento {
        private int clave;
        private int valor;
    }

    private Elemento[] elementos;
    private int cant;

    @Override
    public void inicializarDiccionario() {
        elementos = new Elemento[100];
        cant = 0;
    }

    @Override
    public void agregar(int clave, int valor) {
        int i = clave2Indice(clave);
        if (i < cant)
            elementos[i].valor = valor;
        else {
            elementos[cant] = new Elemento();
            elementos[cant].clave = clave;
            elementos[cant].valor = valor;
            cant++;
        }
    }

    @Override
    public void eliminar(int clave) {
        int i = clave2Indice(clave);
        if (i < cant) {
            elementos[i].clave = elementos[cant - 1].clave;
            elementos[i].valor = elementos[cant - 1].valor;
            cant--;
        }

    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA claves = new Conjunto();
        claves.inicializarConjunto();
        for (int i = 0; i < cant; i++) {
            claves.agregar(elementos[i].clave);
        }
        return claves;
    }

    @Override
    public int recuperar(int clave) {
        int i = clave2Indice(clave);
        if (i < cant)
            return elementos[i].valor;
        return -1;
    }

    private int clave2Indice(int clave) {
        int i = 0;
        while (i < cant && elementos[i].clave != clave) {
            i++;
        }
        return i;
    }

}
