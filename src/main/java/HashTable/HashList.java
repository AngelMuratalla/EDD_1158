package HashTable;

/**
 * HashList tiene como función servir como una LinkedList para cada slot de un
 * HashTable, almacenando en cada espacio la llave con su respectivo valor.
 * Aclaración: está lista es un prototipo hay muchas cosas que mejorar.
 * @author AngelMuratalla
 * @param <K>
 * @param <V>
 */
public class HashList<K, V> {

    private NodoHash<K, V> head;
    private NodoHash<K, V> tail;
    private int size;

    /**
     *
     * @return Verdadero o falso dependiendo sí la lista está vacía o no.
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     *
     * @return El tamaño de la HashList
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Añade un nuevo elemento con su respectiva llave y valor al final de la
     * lista.
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        NodoHash<K, V> toAdd = new NodoHash(key, value);
        if (this.isEmpty()) {
            this.head = toAdd;
            this.tail = toAdd;
        } else {
            this.tail.setNext(toAdd);
            this.tail = this.tail.getNext();
        }
        this.size++;
    }

    /**
     * Busca el nodo con la llave indicada
     *
     * @param key
     * @return El valor de la llave que se indico. Sin embargo, si la lista está
     * vacía regresará null y de igual modo sí la llave no se encuentra en la
     * lista.
     */
    public V get(K key) {
        NodoHash<K, V> aux = this.getNodo(key);
        return aux != null ? aux.getValue() : null;
    }

    //Busca el nodo con la llave que indiquemos
    private NodoHash<K, V> getNodo(K key) {
        NodoHash<K, V> aux = this.head;
        while(aux.getNext() != null && aux.getKey() != key){ //Mientras siga siendo cierto
            aux = aux.getNext();
        }
        return this.isEmpty()  || aux.getKey() != key ? null : aux;
    }

    /**
     * Cambia el valor de la llave indicada
     *
     * @param key
     * @param value
     */
    public void setValue(K key, V value) {
        NodoHash<K, V> aux = this.getNodo(key);
        if (aux != null) {
            aux.setValue(value);
        }
    }

    public V remove(K key) {
        NodoHash<K, V> aux = this.head;
        V out = null;
        if (!this.isEmpty()) {
            while (aux.getNext() != null && !(aux.getNext().getKey().equals(key))) {
                aux = aux.getNext();
            }
            
            
            out = aux.getNext() != null ? aux.getNext().getValue() : null;
            if (aux.getNext() != null) {
                aux.setNext(aux.getNext().getNext());
                this.size--;
            }
        }
        
        return this.isEmpty() || aux.getNext() == null ? null : out;
    }

    @Override
    public String toString() {
        return this.head.printAll();
    }
    
    
    

    public static void main(String[] args) {
        HashList<Integer, String> a = new HashList();
        a.add(1, "uno");
        a.add(2, "dos");
        a.add(3, "tres");
        a.add(4, "cuatro");
        System.out.println(a);
        System.out.println(a.get(5));
        a.setValue(2, "3");
        System.out.println(a.size);
        a.remove(4);
        System.out.println(a.size);
        System.out.println(a.get(2));
        System.out.println(a);

    }

}
