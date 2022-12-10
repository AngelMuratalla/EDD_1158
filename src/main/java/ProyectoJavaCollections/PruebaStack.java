package ProyectoJavaCollections;

//Importamos la clase Stack
import java.util.Stack;
/**@autor Luis Angel Garcia Muratalla*/
public class PruebaStack {
    
    public static void main(String[] args) {
    //Intanciar un objeto de tipo pila
    Stack pila = new Stack();
    
    //Métodos más importantes
        
        //size()
        System.out.printf("Mostramos el tañamano de la pila %d %n", pila.size());
        
        //push(Object elemento) añade hasta arriba o al inicio de la pila
        pila.push("1, -2");
        pila.push("3, 0");
        pila.push("10, 3");
        pila.push("12, 5");
        
        //peek() regresa el último elemento agregado sin sacarlo
        System.out.printf("Mostrando el último elemento agregado: %s %n", pila.peek());
        
        //push() saca el último elemento agregado
        System.out.printf("Sacando un elemento de la pila: %s %n", pila.pop());
        System.out.printf("Sacando un elemento de la pila: %s %n", pila.pop());
    }   
}
