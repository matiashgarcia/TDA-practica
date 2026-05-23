package especificaciones;

public interface ABBTDA {

    void inicializarArbol();

    int raiz();

    void agregarNodo(int valor);

    void eliminarNodo(int valor);

    ABBTDA hijoIzq();

    ABBTDA hijoDer();

    boolean arbolVacio();
}
