package implEstaticas;

import especificaciones.ConjuntoTDA;
import especificaciones.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {

    private class Elemento {
        private int clave;
        private int[] valores;
        private int cant;
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
        if (i != -1) {
            Elemento e = elementos[i];
            int j = valor2Indice(e, valor);
            if (j == -1) {
                e.valores[e.cant] = valor;
                e.cant++;
            }
        } else {
            elementos[cant] = new Elemento();
            elementos[cant].clave = clave;
            elementos[cant].valores = new int[100];
            elementos[cant].valores[0] = valor;
            elementos[cant].cant = 1;
            cant++;
        }
    }

    @Override
    public void eliminar(int clave) {
        int i = clave2Indice(clave);
        if (i != -1) {
            elementos[i] = elementos[cant - 1];
            cant--;
        }

    }

    @Override
    public void eliminarValor(int clave, int valor) {
        int i = clave2Indice(clave);
        if (i != -1) {
            Elemento e = elementos[i];
            int j = valor2Indice(e, valor);
            if (j != -1) {
                e.valores[j] = e.valores[e.cant - 1];
                e.cant--;
                if (e.cant == 0) {
                    elementos[i] = elementos[cant - 1];
                    cant--;
                }
            }
        }

    }

    @Override
    public ConjuntoTDA recuperar(int clave) {
        ConjuntoTDA c = new Conjunto();
        c.inicializarConjunto();
        int i = clave2Indice(clave);
        if (i != -1) {
            Elemento e = elementos[i];
            for (int j = 0; j < e.cant; j++) {
                c.agregar(e.valores[j]);
            }
        }
        return c;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA c = new Conjunto();
        c.inicializarConjunto();
        for (int i = 0; i < cant; i++) {
            c.agregar(elementos[i].clave);
        }
        return c;
    }

    private int clave2Indice(int clave) {
        int i = 0;
        while (i < cant && elementos[i].clave != clave) {
            i++;
        }
        if (i < cant)
            return i;
        return -1;
    }

    private int valor2Indice(Elemento e, int valor) {
        int i = 0;
        while (i < e.cant && e.valores[i] != valor) {
            i++;
        }
        if (i < e.cant)
            return i;
        return -1;
    }

}
