package implEstaticas;

import especificaciones.ConjuntoTDA;
import especificaciones.GrafoTDA;

public class Grafo implements GrafoTDA {

    class Vertice{
        private int valor;
        private Arista[] aristas;
        private int idxAristas;
    }

    class Arista{
        private int peso;
        private Vertice destino;
    }

    private Vertice[] vertices;
    private int idxVertices;

    @Override
    public void inicializarGrafo() {
        vertices = new Vertice[100];
        idxVertices = 0;
    }

    @Override
    public void agregarVertice(int vertice) {
    }

    @Override
    public void eliminarVertice(int vertice) {
    }

    @Override
    public void agregarArista(int origen, int destino, int peso) {
    }

    @Override
    public void eliminarArista(int origen, int destino) {
    }

    @Override
    public int pesoArista(int origen, int destino) {
        throw new UnsupportedOperationException("Unimplemented method 'pesoArista'");
    }

    @Override
    public ConjuntoTDA vertices() {
        throw new UnsupportedOperationException("Unimplemented method 'vertices'");
    }

    @Override
    public boolean existeArista(int origen, int destino) {
        throw new UnsupportedOperationException("Unimplemented method 'existeArista'");
    }

}
