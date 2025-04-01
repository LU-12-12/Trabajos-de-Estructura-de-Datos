/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica_3;

/**
 * Clase LESC que implementa una lista enlazada simple circular.
 * @param <T> Tipo de dato almacenado en la lista.
 * @author riosr
 */
public class LESC<T> {
    private Nodo<T> ultimo;
    private int contador;

    /**
     * Constructor que inicializa una lista vacía.
     */
    public LESC() {
        this.ultimo = null;
        this.contador = 0;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return ultimo == null;
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
            ultimo = nuevo;
            ultimo.siguiente = ultimo;
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
        }
        contador++;
    }

    /**
     * Agrega un elemento al final de la lista.
     *
     * @param dato Elemento a agregar.
     */
    public void addLast(T dato) {
        addFirst(dato);
        ultimo = ultimo.siguiente;
    }

    /**
     * Elimina el primer elemento de la lista.
     */
    public void removeFirst() {
        if (!isEmpty()) {
            if (ultimo.siguiente == ultimo) {
                ultimo = null;
            } else {
                ultimo.siguiente = ultimo.siguiente.siguiente;
            }
            contador--;
        }
    }

    /**
     * Elimina el último elemento de la lista.
     */
    public void removeLast() {
        if (!isEmpty()) {
            if (ultimo.siguiente == ultimo) {
                ultimo = null;
            } else {
                Nodo<T> actual = ultimo;
                while (actual.siguiente != ultimo) {
                    actual = actual.siguiente;
                }
                actual.siguiente = ultimo.siguiente;
                ultimo = actual;
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
        if (isEmpty()) {
            return false;
        }
        Nodo<T> actual = ultimo.siguiente;
        do {
            if (actual.dato.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);
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
        Nodo<T> actual = ultimo.siguiente;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    /**
     * Elimina todos los elementos de la lista.
     */
    public void clear() {
        ultimo = null;
        contador = 0;
    }

    /**
     * Retorna una representación en cadena de la lista.
     *
     * @return Cadena con los elementos de la lista.
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Nodo<T> actual = ultimo.siguiente;
        do {
            sb.append(actual.dato);
            if (actual.siguiente != ultimo.siguiente) {
                sb.append(", ");
            }
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);
        sb.append("]");
        return sb.toString();
    }
}
