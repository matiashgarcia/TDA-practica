package implDinamicas;

import especificaciones.ConjuntoTDA;

public class ConjuntoDM implements ConjuntoTDA{

    class Nodo{
        private int valor;
        private Nodo sig;
    }

    private Nodo origen;

    @Override
    public void inicializarConjunto() {
        origen = null;
    }

    @Override
    public void agregar(int x) {
        Nodo aux = origen;
        while(aux != null && aux.valor != x)
            aux = aux.sig;
        if(aux == null){
            Nodo nuevo = new Nodo();
            nuevo.valor = x;
            nuevo.sig = origen;
            origen = nuevo;
        }
    }          

    @Override
    public void sacar(int x) {
        if(origen != null)
            if(origen.valor == x)
                origen = origen.sig;
            Nodo aux = origen;
            while(aux.sig != null && aux.sig.valor != x){
                aux = aux.sig;
            }
            if(aux.sig != null)
                aux.sig = aux.sig.sig;            
    }

    @Override
    public int elegir() {
        return origen.valor;

    }

    @Override
    public boolean pertence(int x) {
        Nodo aux = origen;
        while(aux != null && aux.valor != x)
            aux = aux.sig;
        return aux != null;
    }

    @Override
    public boolean conjuntoVacio() {
        return origen == null;
    }

}
