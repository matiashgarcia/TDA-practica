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
            inOrder(abb.hijoIzq());
            System.out.println(abb.raiz());
            inOrder(abb.hijoDer());
        }
    }
    // Imprime de abajo hacia arriba
    public void postOrder(ABBTDA abb){
        if(!abb.arbolVacio()){
            postOrder(abb.hijoIzq());
            postOrder(abb.hijoDer());
            System.out.println(abb.raiz());
        }
    }

    // Calcula altura de un arbol desde la raiz a la hoja mas profunda
    public int altura(ABBTDA abb){
        if(abb.arbolVacio()){
            return 0;
        }
        return 1 + Math.max(altura(abb.hijoIzq()), altura(abb.hijoDer()));
    }

    // Calcula la suma de todos los elemtnos del arbol
    public int sumaArbol(ABBTDA abb){
        if(abb.arbolVacio())
            return 0;
        return abb.raiz() + (sumaArbol(abb.hijoIzq()) + sumaArbol(abb.hijoDer()));
    }
}
