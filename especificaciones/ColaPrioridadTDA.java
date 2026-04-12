package especificaciones;

public interface ColaPrioridadTDA {

    public void inicializarCola();
    public void acolarPrioridad(int elemento, int prioridad);
    public void desacolar();
    public int primero();
    public int prioridad();
    public boolean colaVacia();

}
