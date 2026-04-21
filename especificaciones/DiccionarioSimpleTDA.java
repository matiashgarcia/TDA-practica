package especificaciones;

public interface DiccionarioSimpleTDA {

    void inicializarDiccionario();

    void agregar(int clave, int valor);

    void eliminar(int clave);

    ConjuntoTDA claves();

    int recuperar(int clave);

}
