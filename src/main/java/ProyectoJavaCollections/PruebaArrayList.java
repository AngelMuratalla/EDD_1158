package ProyectoJavaCollections;

//Importamos la clase ArrayList
import java.util.ArrayList;
/**@autor Luis Angel Garcia Muratalla*/
public class PruebaArrayList {

    public static void main(String[] args) {
        //Instanciar un ArrayList
        ArrayList lista = new ArrayList();
        
        //Algunos métodos importantes
            
            //size() muestra el número de elementos que contiene nuesta lista
            System.out.printf("Mostrando el tamaño de la lista:  %d %n", lista.size());
            
            //add() añade un elemento al final de la lista, podemos añadir datos de tipo primitivos u objetos
            lista.add("cadena");
            lista.add(27);
            lista.add(2.7);
            lista.add(true);
            lista.add(new ArrayList());
            System.out.printf("Mostrando el tamaño de la lista:  %d %n", lista.size());
            
            //get(int indice) regresa el elemento ubicado en el indice indicado
            System.out.printf("Mostrando el elemento en el indice 3: %s %n", lista.get(3));
            
            //set(int indice, Object elemento) cambia el elemento ubicado en el indice indicado
            lista.set(3, false);
            System.out.printf("Mostrando el elemento en el indice 3: %s %n", lista.get(3));
            
            //remove(int indice) elimina el elemento en el indice indicado
            System.out.println("Lista actual: " + lista);
            lista.remove(1);
            System.out.println("Lista después de borrar: " + lista);
    }
}
