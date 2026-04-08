import especificaciones.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {

    private class Elemento{
        private int valor;
        private int prioridad;
    }

    private Elemento[] elementos;
    private int indice;

    @Override
    public void inicializarCola() {
        elementos = new Elemento[100];
        indice = 0;
    }

    @Override
    public void acolarPrioridad(Elemento elemento) {
    }

    @Override
    public void desacolar() {}

    @Override
    public int primero() { return 0; }

    @Override
    public int prioridad() { return 0; }

    @Override
    public boolean colaVacia() { return false; }




}
