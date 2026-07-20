package practicaFinal;

import java.util.Random;

import especificaciones.ConjuntoTDA;
import implEstaticas.Conjunto;

public class ConjuntoDupla implements ConjuntoDuplaTDA {

    class NodoDupla {
        private int val1;
        private int val2;
        private NodoDupla sig;
    }

    private NodoDupla origen;

    @Override
    public void inicializarConjunto() { // Complejidad constante
        origen = null;
    }

    @Override
    public boolean conjuntoVacio() { // Complejidad constante
        return origen == null;
    }

    @Override
    public void agregarDupla(int num1, int num2) { // Complejidad lineal
        // Si no existe la dupla, la agrego al comienzo de la lista de duplas
        if (!perteneceProd(num1, num2)) {
            NodoDupla nuevo = new NodoDupla();
            nuevo.sig = origen;
            origen = nuevo;
            nuevo.val1 = num1;
            nuevo.val2 = num2;
        }
    }

    @Override
    public boolean perteneceProd(int num1, int num2) { // Complejidad lineal
        NodoDupla aux = origen;
        // Recorro la lista de duplas viendo si ya existe la dupla actual
        while (aux != null && (aux.val1 * aux.val2) != (num1 * num2)) {
            aux = aux.sig;
        }
        // Si existe retorno true, si no existe, false
        return aux != null;
    }

    @Override
    public void sacar(int num1, int num2) { // Complejidad lineal
        // Si no esta vacia la lista
        if (origen != null) {
            // Si la primer dupla es la que quiero sacar, la saco
            if ((num1 == origen.val1 && num2 == origen.val2) || (num1 == origen.val2 && num2 == origen.val1)) {
                origen = origen.sig;
            }
            // Si no es la primera dupla
            else {
                NodoDupla aux = origen;
                // Busco en el resto de duplas
                while (aux.sig != null && !((num1 == aux.sig.val1 && num2 == aux.sig.val2)
                        || (num1 == aux.sig.val2 && num2 == aux.sig.val1))) {
                    aux = aux.sig;
                }
                // Si la encuentro, la saco
                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }

    @Override
    public int elegirSolo() { // Complejidad constante
        // Devuelvo cualquiera de los dos valores de la primer dupla
        Random random = new Random();
        return random.nextBoolean() ? origen.val1 : origen.val2;
    }

    @Override
    public ConjuntoTDA elegirDuo(int num) { // Complejidad lineal
        ConjuntoTDA duos = new Conjunto();
        duos.inicializarConjunto();
        NodoDupla aux = origen;
        // Recorro la lista de duplas, si hay duo, guardo el duo
        while (aux != null) {
            if (aux.val1 == num)
                duos.agregar(aux.val2);
            if (aux.val2 == num)
                duos.agregar(aux.val1);
            aux = aux.sig;
        }
        return duos;
    }

}
