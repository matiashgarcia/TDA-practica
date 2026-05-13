package ejerciciosEstaticos;

import especificaciones.ColaPrioridadTDA;
import especificaciones.ColaTDA;
import implEstaticas.ColaPrioridad;

public class ColaPrioridadPractica {

    public static void pasarColaPrioridadAColas(ColaPrioridadTDA origen, ColaTDA valores, ColaTDA prioridades) {
        while (!origen.colaVacia()) {
            valores.acolar(origen.primero());
            prioridades.acolar(origen.prioridad());
            origen.desacolar();
        }
    }

    public static ColaPrioridadTDA combinarColasPrioridad(ColaPrioridadTDA primera, ColaPrioridadTDA segunda) {
        while (!segunda.colaVacia()) {
            primera.acolarPrioridad(segunda.primero(), segunda.prioridad());
            segunda.desacolar();
        }
        return primera;
        /*
         * ColaPrioridad resultado = new ColaPrioridad();
         * resultado.inicializarCola();
         * while(!primera.colaVacia()){
         * resultado.acolarPrioridad(primera.primero(), primera.prioridad());
         * primera.desacolar();
         * }
         * while(!segunda.colaVacia()){
         * resultado.acolarPrioridad(segunda.primero(), segunda.prioridad());
         * segunda.desacolar();
         * }
         * return resultado;
         */
    }

    public static boolean sonColasPrioridadIdenticas(ColaPrioridadTDA a, ColaPrioridadTDA b) {
        ColaPrioridadTDA aux1 = copiarColaPrioridad(a);
        ColaPrioridadTDA aux2 = copiarColaPrioridad(b);
        while (!aux1.colaVacia() && !aux2.colaVacia() && aux1.primero() == aux2.primero()
                && aux1.prioridad() == aux2.prioridad()) {
            aux1.desacolar();
            aux2.desacolar();
        }
        return aux1.colaVacia() && aux2.colaVacia();
    }

    private static ColaPrioridadTDA copiarColaPrioridad(ColaPrioridadTDA cola) {
        ColaPrioridad aux = new ColaPrioridad();
        aux.inicializarCola();
        ColaPrioridad copia = new ColaPrioridad();
        copia.inicializarCola();
        while (!cola.colaVacia()) {
            aux.acolarPrioridad(cola.primero(), cola.prioridad());
            cola.desacolar();
        }
        while (!aux.colaVacia()) {
            cola.acolarPrioridad(aux.primero(), aux.prioridad());
            copia.acolarPrioridad(aux.primero(), aux.prioridad());
            aux.desacolar();
        }
        return copia;
    }
}
