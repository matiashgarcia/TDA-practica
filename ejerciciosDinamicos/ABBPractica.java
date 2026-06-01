package ejerciciosDinamicos;

import especificaciones.ABBTDA;

public class ABBPractica {
    // Imprime de arriba hacia abajo
    public void preOrder(ABBTDA abb){
        if(!abb.arbolVacio()){
            System.out.println(abb.raiz());
            preOrder(abb.hijoIzq());
            preOrder(abb.hijoDer());
        }
    }
    // Imprime de menor a mayor
    public void inOrder(ABBTDA abb){
        if(!abb.arbolVacio()){
            preOrder(abb.hijoIzq());
            System.out.println(abb.raiz());
            preOrder(abb.hijoDer());
        }
    }
    // Imprime de abajo hacia arriba
    public void postOrder(ABBTDA abb){
        if(!abb.arbolVacio()){
            preOrder(abb.hijoIzq());
            preOrder(abb.hijoDer());
            System.out.println(abb.raiz());
        }
    }
}
