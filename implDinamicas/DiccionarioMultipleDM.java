package implDinamicas;

import especificaciones.ConjuntoTDA;
import especificaciones.DiccionarioMultipleTDA;

public class DiccionarioMultipleDM implements DiccionarioMultipleTDA {

    class NodoClave {
        private int clave;
        private NodoValor primerValor;
        private NodoClave sig;
    }

    class NodoValor{
        private int valor;
        private NodoValor sig;
    }

    private NodoClave origen;

    @Override
    public void inicializarDiccionario() {
        origen = null;
    }

    @Override
    public void agregar(int clave, int valor) {
        NodoClave nuevaClave = new NodoClave();
        NodoValor nuevoValor = new NodoValor();
        // Busco la clave
        NodoClave aux = clave2NodoClave(clave);
        // Si encuentro la clave, busco el valor
        if(aux != null){
            NodoValor viajero = aux.primerValor;
            while(viajero != null && viajero.valor != valor)
                viajero = viajero.sig;
            // Si no encuentro el valor, lo agrego
            if(viajero == null){
                nuevoValor.sig = aux.primerValor;
                nuevoValor.valor = valor;
                aux.primerValor = nuevoValor;
            }
        }
        // Si no encuentro la clave, la agrego junto al valor
        else{
            nuevaClave.sig = origen;
            origen = nuevaClave;
            nuevaClave.clave = clave;
            nuevaClave.primerValor = nuevoValor;
            nuevoValor.valor = valor;
            nuevoValor.sig = null;
        }
    }

    @Override
    public void eliminar(int clave) {
        if(origen != null){
            if(origen.clave == clave)
                origen = origen.sig;
            else{
                NodoClave aux = origen;
                while(aux.sig != null && aux.sig.clave != clave){
                    aux = aux.sig;
                }
                if(aux.sig != null){
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }

    @Override
    public void eliminarValor(int clave, int valor) {
        // Busco la clave
        NodoClave aux = clave2NodoClave(clave);
        // Si encuentro la clave
        if(aux != null){
            NodoValor viajero = aux.primerValor;
            // Pregunto si es el primer valor, si es lo elimino
            if(viajero.valor == valor){
                aux.primerValor = viajero.sig;
                // Si la clave quedo sin valores, la elimino
                if(aux.primerValor == null)
                    eliminar(clave);
            }
            // Si no es el primer valor, recorro la lista de valores
            else{
                while(viajero.sig != null && viajero.sig.valor != valor)
                    viajero = viajero.sig;
                // Si encontre el valor, lo elimino
                if(viajero.sig != null)
                    viajero.sig = viajero.sig.sig;
            }
        }
    }

    @Override
    public ConjuntoTDA recuperar(int clave) {
        ConjuntoTDA valores = new ConjuntoDM();
        valores.inicializarConjunto();
        // Busco la clave
        NodoClave aux = clave2NodoClave(clave);
        // Si la encuentro, recorro lista de valores y los agrego al conjunto
        if(aux != null){
            NodoValor viajero = aux.primerValor;
            while(viajero != null){
                valores.agregar(viajero.valor);
                viajero = viajero.sig;
            }
        }
        return valores;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA claves = new ConjuntoDM();
        claves.inicializarConjunto();
        NodoClave aux = origen;
        while(aux != null){
            claves.agregar(aux.clave);
            aux = aux.sig;
        }
        return claves;
    }

    private NodoClave clave2NodoClave(int clave){
        NodoClave aux = origen;
        while(aux != null && aux.clave != clave){
            aux = aux.sig;
        }
        return aux;
    }

}
