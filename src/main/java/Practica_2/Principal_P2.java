/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica_2;

/**
 *
 * @author riosr
 */
public class Principal_P2 {

    /**
     *
     * Clase principal para probar la lista doblemente enlazada.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LDE<Integer> lista = new LDE<>();

        lista.addFirst(10);
        lista.addLast(20);
        lista.addFirst(5);
        lista.addLast(30);

        System.out.println("Lista: " + lista);
        System.out.println("Tamaño: " + lista.size());
        System.out.println("Contiene 20: " + lista.contains(20));
        System.out.println("Elemento en índice 2: " + lista.getElement(2));

        lista.removeFirst();
        System.out.println("Después de removeFirst: " + lista);

        lista.removeLast();
        System.out.println("Después de removeLast: " + lista);

        lista.clear();
        System.out.println("Después de clear: " + lista);
    }
}
