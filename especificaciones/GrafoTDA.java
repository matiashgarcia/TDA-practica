package especificaciones;

public interface GrafoTDA {

    void inicializarGrafo();

    void agregarVertice(int valor);

    void eliminarVertice(int valor);

    void agregarArista(int origen, int destino, int peso);

    void eliminarArista(int origen, int destino);

    int pesoArista(int origen, int destino);

    ConjuntoTDA vertices();

    boolean existeArista(int origen, int destino);

}
