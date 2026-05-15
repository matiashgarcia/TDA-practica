package implDinamicas;

import especificaciones.ColaTDA;

public class ColaDM implements ColaTDA {

    class Nodo{
        private int valor;
        private Nodo sig;
    }

    private Nodo origen;

    @Override
    public void inicializarCola() {
        origen = null;
    }

    @Override
    public void acolar(int x) {
        Nodo nuevo = new Nodo();
        if(colaVacia())
            origen = nuevo;
        else{
            Nodo aux = origen;
            while(aux.sig != null){
                aux = aux.sig;
            }
            aux.sig = nuevo;
        }
        nuevo.valor = x;
        nuevo.sig = null;
    }

    @Override
    public void desacolar() {
        origen = origen.sig;
    }

    @Override
    public int primero() {
        return origen.valor;
    }

    @Override
    public boolean colaVacia() {
        return origen == null;
    }

}
