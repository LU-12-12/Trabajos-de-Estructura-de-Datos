/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica_4;

/**
 * Clase ListaDoblementeEnlazadaCircular que implementa una lista doblemente
 * enlazada circular.
 * @param <T> Tipo de dato almacenado en la lista.
 * @author riosr
 */
public class LDEC<T> {
    private Nodo<T> inicial;
    private int contador;

    /**
     * Constructor que inicializa una lista vacía.
     */
    public LDEC() {
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
            Nodo<T> ultimo = inicial.anterior;
            nuevo.siguiente = inicial;
            nuevo.anterior = ultimo;
            inicial.anterior = nuevo;
            ultimo.siguiente = nuevo;
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
        if (isEmpty()) {
            addFirst(dato);
        } else {
            Nodo<T> nuevo = new Nodo<>(dato);
            Nodo<T> ultimo = inicial.anterior;
            nuevo.siguiente = inicial;
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            inicial.anterior = nuevo;
            contador++;
        }
    }

    /**
     * Elimina el primer elemento de la lista.
     */
    public void removeFirst() {
        if (!isEmpty()) {
            if (contador == 1) {
                inicial = null;
            } else {
                Nodo<T> ultimo = inicial.anterior;
                inicial = inicial.siguiente;
                inicial.anterior = ultimo;
                ultimo.siguiente = inicial;
            }
            contador--;
        }
    }

    /**
     * Elimina el último elemento de la lista.
     */
    public void removeLast() {
        if (!isEmpty()) {
            if (contador == 1) {
                inicial = null;
            } else {
                Nodo<T> ultimo = inicial.anterior;
                Nodo<T> nuevoUltimo = ultimo.anterior;
                nuevoUltimo.siguiente = inicial;
                inicial.anterior = nuevoUltimo;
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
        Nodo<T> actual = inicial;
        do {
            if (actual.dato.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != inicial);
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
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Nodo<T> actual = inicial;
        do {
            sb.append(actual.dato);
            actual = actual.siguiente;
            if (actual != inicial) {
                sb.append(", ");
            }
        } while (actual != inicial);
        sb.append("]");
        return sb.toString();
    }
}
