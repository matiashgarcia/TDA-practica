package practicaFinal;

import especificaciones.PilaTDA;

public interface PilaParImparTDA {

    void apilarPar(int x); // Apila un número en la pila de pares(se supone que sólo recibe pares)

    void apilarImpar(int x); // Apila un número en la pila de impares (se supone que sólo recibe impares)

    PilaTDA unirPilas(); // Devuelve una nueva pila combinando las pilas par e impar
}
/*
 * Otros métodos
 * void inicializarPila();
 * void desapilarPar(); // Desapila un número de la pila de pares
 * void desapilarImpar(); // Desapila un número de la pila de impares
 * int topePar(); // Devuelve el tope de la pila de pares
 * int topeImpar(); // Devuelve el tope de la pila de impares
 * boolean pilaVacia(); // Verifica si ambas pilas (par e impar) están vacías
 * boolean pilaParVacia(); // Verifica si la pila de elementos pares está vacía
 * boolean pilaImparVacia(); // Verifica si la pila de elementos impares está
 * vacía
 */
