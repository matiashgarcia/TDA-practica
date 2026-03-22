package especificaciones;

public interface SemaforoTDA {

    void inicializarSemaforo(String color);

    void cambiarARojo();

    void cambiarAVerde();

    void cambiarAAmarilo();

    String colorActual();

}