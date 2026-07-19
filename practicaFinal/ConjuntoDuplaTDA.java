package practicaFinal;

import especificaciones.ConjuntoTDA;

public interface ConjuntoDuplaTDA {
    void inicializarConjunto(); // inicializa el TDA.

    boolean conjuntoVacio(); // indica si el TDA está vacío o no.

    void agregarDupla(int num1, int num2); // agrega la dupla de num1 y
    // num2, siempre que en el TDA no exista una dupla cuyo producto
    // de elementos sea igual al resultado de multiplicar num1 por
    // num2.

    boolean perteneceProd(int num1, int num2); // indica si existe alguna
    // dupla en el TDA cuyo producto de elementos sea igual a la
    // multiplicación entre num1 y num2.

    void sacar(int num1, int num2); // elimina del TDA la dupla formada
    // por num1 y num2. La dupla eliminada puede tener cualquier
    // orden (num1, num2) o (num2, num1). De no existir, no hace
    // nada.

    int elegirSolo(); // devuelve un valor cualquiera de una dupla
    // cualquiera del TDA.

    ConjuntoTDA elegirDuo(int num); // devuelve un ConjuntoTDA con
    // todos los elementos que comparten alguna dupla con num, en
    // cualquier orden.
}