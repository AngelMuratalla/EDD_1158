package ProyectoJavaCollections;

//Importamos la clase ArrayList
import java.util.LinkedList;
/**@autor Luis Angel Garcia Muratalla*/
public class PruebaLinkedList {

    public static void main(String[] args) {
        //Instanciar un ArrayList
        LinkedList lista = new LinkedList();

        //Algunos métodos importantes
            
            //size() muestra el número de elementos que contiene nuesta lista
            System.out.printf("Mostrando el tamaño de la lista:  %d %n", lista.size());
            
            //add() añade un elemento al final de la lista regresando true si se insertó
            //addFirst() añade un elemento al inicio de la lista
            //addLast() añade un elemento al final de la lista
            System.out.println(lista.add("Manzana"));
            lista.addFirst("Mango");
            lista.addLast("Sandia");
            lista.addLast("Papaya");
            lista.addLast("Árbol de Yogurt");
           
            System.out.printf("Mostrando el tamaño de la lista:  %d %n", lista.size());
            
            //get(int indice) regresa el elemento ubicado en el indice indicado
            //getFirst() regresa el elemento ubicado en el indice indicado
            //getLast() regresa el elemento ubicado en el indice indicado
            System.out.printf("Mostrando el elemento en el indice 3: %s %n", lista.get(3));
            System.out.printf("Mostrando el elemento al final de la lista: %s %n", lista.getLast());
            System.out.printf("Mostrando el elemento al inicio de la lista: %s %n", lista.getFirst());
            
            //set(int indice, Object elemento) cambia el elemento ubicado en el indice indicado
            System.out.printf("Mostrando el elemento en el indice 3: %s %n", lista.get(3));
            lista.set(3, "Hola soy el nuevo");
            System.out.printf("Mostrando el elemento en el indice 3: %s %n", lista.get(3));
            
            //remove(int indice) elimina el elemento en el indice indicado
           // lista.removeFirst() elimina el primer elemento
           // lista.removeLast() elimina el último elemento elemento
           //lista.removeFirstOccurrence(Object elemento) elimina la primera aparición del elemento 
           //lista.removeLastOccurrence(Object elemento) elimina la última aparición del elemento
            lista.addFirst("Uva");
            lista.addLast("Uva");
            System.out.println("Lista actual: " + lista);
           lista.removeLastOccurrence("Uva");
           lista.removeFirstOccurrence("Uva");
            System.out.println("Lista después de borrar: " + lista);
            
    }
}