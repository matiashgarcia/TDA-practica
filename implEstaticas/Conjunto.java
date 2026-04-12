package implEstaticas;

import especificaciones.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {

    private int[] arr;
    private int indice;

    @Override
    public void inicializarConjunto() {
        arr = new int[100];
        indice = 0;
    }

    @Override
    public void agregar(int x) {
        // Si no existe, lo agregamos
        if (!pertence(x)) {
            arr[indice] = x;
            indice++;
        }
    }

    @Override
    public void sacar(int x) {
        int i = 0;
        while (i < indice && arr[i] != x) {
            i++;
        }
        if (i < indice) {
            arr[i] = arr[indice - 1];
            indice--;
        }
    }

    @Override
    public int elegir() {
        if (!conjuntoVacio()) {
            int min = 0;
            int max = indice - 1;
            int pos = (int) (Math.random() * (max - min + 1) + min);
            return arr[pos];
        }
        return -1;
    }

    @Override
    public boolean pertence(int x) {
        int i = 0;
        while (i < indice && arr[i] != x) {
            i++;
        }
        return i < indice;
    }

    @Override
    public boolean conjuntoVacio() {
        return indice == 0;
    }
}
