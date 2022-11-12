package codigos.ADTS;

import java.util.ArrayList;

/**
 * @author AngelMuratalla
 * @param <T>
 */
public class Queue <T>{

    private final ArrayList<T> college;
    private int size;

    /**
     * Crea una lista vacía para almacenar los datos 
     * de la cola
     */
    public Queue() {
        college = new ArrayList();
    }

    /**
     * Sirve para averiguar si la cola está vacía  
     * @return El resultado de la siguiente comparación size == 0,
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     *  Sirve para averiguar el tamaño de la cola
     * @return Cantidad de elementos encolados.
     */
    public int size(){
        return size;
    }
    
    /**
     *  Añade un elemento al final de la lista
     * @param element - elemento a insertar
     */
    public void enqueue(T element){
        college.add(size++, element);
    }
    
    /**
     * Sirve para sacar el elemento al principio de la cola
     * @return Regresa el elemento al principio de la cola
     */
    public T dequeue(){
        T out = null;
        if (!this.isEmpty()) {
            out = college.remove(0);
            size--;
        }
       return out;
    }

    @Override
    public String toString() {
        String out = "";
        if (!this.isEmpty()) {
          out = college.stream().map(element -> ","+ element).reduce(out, String::concat);
        return "{" + out.substring(1) + "}";  
        }
        return "{" + out+ "}";
    }
    
    public static void main(String[] args) {
        Queue a = new Queue();
        a.enqueue("1");
        a.enqueue("2");
        a.enqueue("3");
        a.enqueue("4");
        a.dequeue();
        System.out.println(a);
    }  
}
