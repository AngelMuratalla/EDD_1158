package codigos.ADTS;

/**
 *Lista simplemente ligada unidireccional
 * @author rodol
 * @param <T>
 */
public class Prueba<T> {

    Nodo<T> head;
    Nodo<T> aux;
    T elementAux;
    int size;

    /**
     * @return  
     */
    public int getSize() {
        return this.size;
    }
    
    public boolean isEmpty() {
        return head == null;
    }

    public void add(T element) {
        if (this.isEmpty()) {
            head = new Nodo(element);
        } else {
            aux = head;
            for (int index = 1; index < size; index++) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(new Nodo(element));
        }
        size++;
    }
    
    public void addBeginning(T element){
        
    }

    @Override
    public String toString() {
        return head.printAll();
    }
}
