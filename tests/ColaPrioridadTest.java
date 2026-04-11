package tests;

import ejercicios.ColaPrioridadPractica;
import especificaciones.ColaPrioridadTDA;
import especificaciones.ColaTDA;
import implEstaticas.Cola;
import implEstaticas.ColaPrioridad;

public class ColaPrioridadTest {

    public static void main(String[] args) {

        ColaPrioridadTDA cola = new ColaPrioridad();
        cola.inicializarCola();
        cola.acolarPrioridad(5, 7);
        cola.acolarPrioridad(2, 5);
        cola.acolarPrioridad(2, 1);
        cola.acolarPrioridad(2, 4);
        cola.acolarPrioridad(2, 8);
        ColaTDA valores = new Cola();
        valores.inicializarCola();
        ColaTDA prioridades = new Cola();
        prioridades.inicializarCola();
        System.out.println(cola.primero());
        System.out.println(cola.prioridad());
        ColaPrioridadPractica.pasarColaPrioridadAColas(cola, valores, prioridades);
        System.out.println(cola.colaVacia());
        System.out.println(valores.primero());
        System.out.println(prioridades.primero());
    }

}
