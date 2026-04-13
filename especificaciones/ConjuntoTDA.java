package especificaciones;

public interface ConjuntoTDA {

    public void inicializarConjunto();

    public void agregar(int x);

    public void sacar(int x);

    public int elegir();

    public boolean pertence(int x);

    public boolean conjuntoVacio();
}
