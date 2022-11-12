package codigos.ADTS;

import java.util.ArrayList;

/**
 * @author AngelMuratalla
 * @param <T>
 */
public class Queue <T>{

    private final ArrayList<T> college;
    private int size;

    public Queue() {
        college = new ArrayList();
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size(){
        return size;
    }
    
    public void enqueue(T element){
        college.add(size++, element);
    }
    
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
        a.enqueue(null);
        a.enqueue("2");
        a.enqueue("3");
        a.enqueue("4");
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        System.out.println(a);
    }  
}
