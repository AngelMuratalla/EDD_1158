package HashTable;

/**
 * NodoHash es una clase encargada de almacenar llave y valor sigue los mismos
 * principios del Nodo para una LinkedList
 *
 * @author AngelMuratalla
 * @param <K>
 * @param <V>
 */
public class NodoHash<K, V> {

    private K key;
    private V value;
    private NodoHash<K, V> next;

    /**
     * Crea un nodo que almacena la llave y valor indicada pero la referencia
     * para el nodo siguiente es null
     *
     * @param key
     * @param value
     */
    public NodoHash(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Crea un nodo que almacena la llave, valor y referencia a siguiente indicada
     *
     * @param key
     * @param value
     * @param next
     */
    public NodoHash(K key, V value, NodoHash<K, V> next) {
        this(key, value);
        this.next = next;
    }

    /**
     *
     * @return El nodo al que la referencia de siguiente
     * está apuntando.
     */
    public NodoHash<K, V> getNext() {
        return next;
    }

    /**
     *  Cambia la referencia de siguiente por el nodo indicado
     * @param next
     */
    public void setNext(NodoHash<K, V> next) {
        this.next = next;
    }

    /**
     *
     * @return El dato almacenado en la casilla llave de este nodo
     */
    public K getKey() {
        return key;
    }

    /**
     * Cambia el dato de llave de este nodo
     * @param key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     *
     * @return El valor almacenado en este nodo.
     */
    public V getValue() {
        return value;
    }

    /**
     * Cambia el valor que almacena el nodo
     * @param value
     */
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "|" + this.value + "| --> ";
    }

    /**
     *
     * @return Una cadena con todos los nodos a los que esta
     * ligado este.
     */
    public String printAll() {
        if (this.next == null) {
            return this.toString() + null;
        }
        return this.toString() + this.getNext().printAll();
    }
}
