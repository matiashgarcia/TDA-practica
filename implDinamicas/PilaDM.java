package implDinamicas;

import especificaciones.PilaTDA;

public class PilaDM implements PilaTDA{

    class Nodo{
        private int valor;
        private Nodo sig;
    }

    private Nodo origen;

    @Override
    public void inicializarPila() {
        origen = null;
    }

    @Override
    public void apilar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.valor = x;
        nuevo.sig = origen;
        origen = nuevo;
    }

    @Override
    public void desapilar() {
        origen = origen.sig;
    }

    @Override
    public int tope() {
        return origen.valor;
    }

    @Override
    public boolean pilaVacia() {
        return origen == null;
    }

}
