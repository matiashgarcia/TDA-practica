package practicaFinal;

import especificaciones.PilaTDA;
import implEstaticas.Pila;

public class PilaParImpar implements PilaParImparTDA {

    class NodoPila {
        private int valor;
        private NodoPila sig;
    }

    private NodoPila topePar;
    private NodoPila topeImpar;

    @Override
    public void apilarPar(int x) {
        if ((x % 2) == 0) {
            NodoPila nuevo = new NodoPila();
            nuevo.valor = x;
            nuevo.sig = topePar;
            topePar = nuevo;
        }
    }

    @Override
    public void apilarImpar(int x) {
        if ((x % 2) != 0) {
            NodoPila nuevo = new NodoPila();
            nuevo.valor = x;
            nuevo.sig = topeImpar;
            topeImpar = nuevo;
        }
    }

    @Override
    public PilaTDA unirPilas() {
        PilaTDA pilaUnida = new Pila();
        pilaUnida.inicializarPila();
        NodoPila auxPar = topePar;
        NodoPila auxImpar = topeImpar;
        // Lleno la pila unida primero con los pares
        while (auxPar != null) {
            pilaUnida.apilar(auxPar.valor);
            auxPar = auxPar.sig;
        }
        // Luego la termino de llenar con los impares
        while (auxImpar != null) {
            pilaUnida.apilar(auxImpar.valor);
            auxImpar = auxImpar.sig;
        }
        return pilaUnida;
    }

}
