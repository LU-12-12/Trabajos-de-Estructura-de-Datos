/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica_2;

/**
 * Clase LDA que implementa una lista doblemente enlazada.
 * @param <T> Tipo de dato almacenado en la lista.
 * @author riosr
 */
public class LDE <T> {
    private Nodo<T> inicial;
    private int contador;

    /**
     * Constructor que inicializa una lista vacía.
     */
    public LDE() {
        this.inicial = null;
        this.contador = 0;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return inicial == null;
    }

    /**
     * Retorna el tamaño de la lista.
     *
     * @return Número de elementos en la lista.
     */
    public int size() {
        return contador;
    }

    /**
     * Agrega un elemento al inicio de la lista.
     *
     * @param dato Elemento a agregar.
     */
    public void addFirst(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (isEmpty()) {
            inicial = nuevo;
        } else {
            nuevo.siguiente = inicial;
            inicial.anterior = nuevo;
            inicial = nuevo;
        }
        contador++;
    }

    /**
     * Agrega un elemento al final de la lista.
     *
     * @param dato Elemento a agregar.
     */
    public void addLast(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (isEmpty()) {
            inicial = nuevo;
        } else {
            Nodo<T> actual = inicial;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
        }
        contador++;
    }

    /**
     * Elimina el primer elemento de la lista.
     */
    public void removeFirst() {
        if (!isEmpty()) {
            inicial = inicial.siguiente;
            if (inicial != null) {
                inicial.anterior = null;
            }
            contador--;
        }
    }

    /**
     * Elimina el último elemento de la lista.
     */
    public void removeLast() {
        if (!isEmpty()) {
            if (inicial.siguiente == null) {
                inicial = null;
            } else {
                Nodo<T> actual = inicial;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.anterior.siguiente = null;
            }
            contador--;
        }
    }

    /**
     * Verifica si la lista contiene un elemento específico.
     *
     * @param dato Elemento a buscar.
     * @return true si el elemento está en la lista, false en caso contrario.
     */
    public boolean contains(T dato) {
        Nodo<T> actual = inicial;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    /**
     * Obtiene el elemento en una posición específica.
     *
     * @param index Índice del elemento (basado en 0).
     * @return El elemento en la posición especificada.
     * @throws IndexOutOfBoundsException Si el índice es inválido.
     */
    public T getElement(int index) {
        if (index < 0 || index >= contador) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo<T> actual = inicial;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    /**
     * Elimina todos los elementos de la lista.
     */
    public void clear() {
        inicial = null;
        contador = 0;
    }

    /**
     * Retorna una representación en cadena de la lista.
     *
     * @return Cadena con los elementos de la lista.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo<T> actual = inicial;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) {
                sb.append(", ");
            }
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}
