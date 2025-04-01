/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica_4;

/**
 *
 * @author riosr
 */
public class Principal_P4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear la lista doblemente enlazada circular
        LDEC<Integer> lista = new LDEC<>();

        // Agregar elementos al inicio y al final
        lista.addFirst(10); // Lista: [10]
        lista.addLast(20);  // Lista: [10, 20]
        lista.addFirst(5);  // Lista: [5, 10, 20]
        lista.addLast(30);  // Lista: [5, 10, 20, 30]

        // Imprimir la lista
        System.out.println("Lista después de agregar elementos: " + lista);

        // Verificar si la lista contiene ciertos elementos
        System.out.println("¿Contiene 10? " + lista.contains(10)); // true
        System.out.println("¿Contiene 25? " + lista.contains(25)); // false

        // Obtener un elemento en una posición específica
        System.out.println("Elemento en índice 2: " + lista.getElement(2)); // 20

        // Eliminar el primer y último elemento
        lista.removeFirst();  // Lista: [10, 20, 30]
        System.out.println("Lista después de removeFirst: " + lista);
        lista.removeLast();   // Lista: [10, 20]
        System.out.println("Lista después de removeLast: " + lista);

        // Obtener el tamaño de la lista
        System.out.println("Tamaño de la lista: " + lista.size()); // 2

        // Vaciar la lista
        lista.clear();
        System.out.println("Lista después de clear: " + lista); // []

        // Verificar si la lista está vacía
        System.out.println("¿Está la lista vacía? " + lista.isEmpty()); // true
    }
}
