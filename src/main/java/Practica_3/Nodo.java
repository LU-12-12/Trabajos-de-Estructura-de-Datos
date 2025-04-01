/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica_3;

/**
 * Clase Nodo que representa un elemento de la lista enlazada simple circular.
 * @param <T> Tipo de dato almacenado en el nodo.
 * @author riosr
 */
public class Nodo<T> {
    T dato;
    Nodo<T> siguiente;

    /**
     * Constructor de la clase Nodo.
     *
     * @param dato El dato a almacenar en el nodo.
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
