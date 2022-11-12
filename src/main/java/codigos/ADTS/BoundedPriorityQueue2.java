package codigos.ADTS;

import java.util.HashMap;

/**
 * @author AngelMuratalla
 * @param <T>
 */
public class BoundedPriorityQueue2 <T>{

    private final HashMap<Integer, Queue2<T>> collection; 
    private int numElements;
    private int highPriority;
    
    /**
     *  Crea una cola de prioridad acotada donde se almacenan los 
     * datos en un HashMap
     * @param levels - cantidad de niveles de prioridad
     */
    public BoundedPriorityQueue2(int levels) {
        collection = new HashMap(levels);
        for (int key = 0; key < levels; key++) {
            collection.put(key, new Queue2());
        }
    }
    
    /**
     * Sirve para averiguar si la cola está vacía
     * @return El resultado de la comparación numero de elementos == 0
     */
    public boolean isEmpty(){
        return numElements == 0;
    }
    
    /**
     * @return numero de elementos de la cola acotada
     */
    public int length(){
        return numElements;
    }
    
    /**
     * Sirve para añadir un elemento a la cola acotada
     * @param priority - nivel de prioridad
     * @param element - elemento a encolar
     */
    public void enqueue(int priority, T element){
        collection.get(priority).enqueue(element);
        numElements++;
    }
    
    /**
     * Sirve para sacar el elemento con mayor prioridad
     * @return Elemento desencolado
     */
    public T dequeue(){
        T out = null;
        if (!this.isEmpty()) {
            this.checkPriority();
            out = collection.get(highPriority).dequeue();
            numElements--;
        }
        return out;
    }
    //Sirve para revisar cual de todos los niveles que tiene elementos tiene mayor prioridad
    private void checkPriority(){
        if (this.collection.get(this.highPriority).isEmpty() && numElements > 0) {
            this.highPriority++;
        }
    }
}
