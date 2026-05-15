package implDinamicas;

import especificaciones.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {

    class Nodo{
        private int valor;
        private int prioridad;
        private Nodo sig;
    }

    private Nodo origen;

    @Override
    public void inicializarCola() {
        origen = null;
    }

    @Override
    public void acolarPrioridad(int elemento, int prioridad) {
          Nodo nuevo = new Nodo();
          
    }

    @Override
    public void desacolar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desacolar'");
    }

    @Override
    public int primero() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'primero'");
    }

    @Override
    public int prioridad() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'prioridad'");
    }

    @Override
    public boolean colaVacia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colaVacia'");
    }

}
