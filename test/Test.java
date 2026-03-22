package test;

import especificaciones.SemaforoTDA;
import implEstaticas.Semaforo;

public class Test {
    public static void main(String[] args) {

        SemaforoTDA semaforo = new Semaforo();
        semaforo.inicializarSemaforo("Amarillo");
        System.out.println(semaforo.colorActual());
        semaforo.cambiarARojo();
        System.out.println(semaforo.colorActual());
        semaforo.cambiarAVerde();
        System.out.println(semaforo.colorActual());

    }
}
