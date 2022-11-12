package codigos.ADTS;

import java.util.HashMap;

/**
 * @author AngelMuratalla
 * @param <T>
 */
public class BoundedPriorityQueue <T>{

    private final HashMap<Integer, Queue<T>> collection; 
    private int numElements;
    private int highPriority;
    
    public BoundedPriorityQueue(int levels) {
        collection = new HashMap(levels);
        for (int key = 0; key < levels; key++) {
            collection.put(key, new Queue());
        }
    }
    
    public boolean isEmpty(){
        return numElements == 0;
    }
    
    public int length(){
        return numElements;
    }
    
    public void enqueue(int priority, T element){
        collection.get(priority).enqueue(element);
        numElements++;
    }
    
    public T dequeue(){
        T out = null;
        if (!this.isEmpty()) {
            this.checkPriority();
            out = collection.get(highPriority).dequeue();
            numElements--;
        }
        return out;
    }
    
    private void checkPriority(){
        if (this.collection.get(this.highPriority).isEmpty() && numElements > 0) {
            this.highPriority++;
        }
    }
    
}