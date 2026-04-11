package ejercicios;

import especificaciones.ColaPrioridadTDA;
import especificaciones.ColaTDA;

public class ColaPrioridadPractica {

    public static void pasarColaPrioridadAColas(ColaPrioridadTDA origen, ColaTDA valores, ColaTDA prioridades) {
        while (!origen.colaVacia()) {
            valores.acolar(origen.primero());
            prioridades.acolar(origen.prioridad());
            origen.desacolar();
        }
    }

}
