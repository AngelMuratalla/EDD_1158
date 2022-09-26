package codigos.ADTS;

public class DoubleNodo<T> {
    
    private T dato; //Dato que contendra el nodo
    private DoubleNodo<T> siguiente; //Referencia al siguiente
    private DoubleNodo<T> anterior; //Referencia al anterior
    
    /**
     *  Construye un nodo que almacena un valor
     * @param dato
     */
    public DoubleNodo(T dato) {
        this.siguiente = null;
        this.anterior = null;
        this.dato = dato;
    }

    /**
     * Cronstruye un nuevo nodo con una referencia para el nodo siguiente indicado
     * @param dato
     * @param siguiente
     */
    public DoubleNodo(T dato, DoubleNodo<T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = null;
    }
    
    /**
     * Construye un nodo con las referencias de siguiente y anterior apuntando a los 
     * nodos indicados
     * @param dato
     * @param siguiente
     * @param anterior
     */
    public DoubleNodo(T dato, DoubleNodo<T> siguiente, DoubleNodo<T> anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    /**
     *
     * @return El nodo al que apunta la referencia siguiente
     */
    public DoubleNodo<T> getSiguiente() {
        return this.siguiente;
    }

    /**
     * Cambia la referencia del nodo siguiente
     * @param siguiente
     */
    public void setSiguiente(DoubleNodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Cambia la referencia del nodo siguiente, además de ligar automaticamente
     * (Este nodo apunta al nodo siguiente y el  nodo siguiente apunta a este)
     * @param siguiente
     * @param autoligar
     */
    public void setSiguiente(DoubleNodo<T> siguiente, boolean autoligar) {
        this.siguiente = siguiente;
        siguiente.setAnterior(this);
    }
    
    /**
     *
     * @return El nodo al que apunte la referencia anterior
     */
    public DoubleNodo<T> getAnterior() {
        return this.anterior;
    }

    /**
     * Cambia la referencia anterior por el nuevo nodo indicado
     * @param anterior
     */
    public void setAnterior(DoubleNodo<T> anterior) {
        this.anterior = anterior;
    }

    /**
     * Cambia la rerencia del anteriror, además de autoligar
     * (Este nodo apunta al anterior y el anterior a este)
     * @param anterior
     * @param autoligar
     */
    public void setAnterior(DoubleNodo<T> anterior, boolean autoligar) {
        this.anterior = anterior;
        anterior.setSiguiente(this);
    }

    /**
     *
     * @return Dato almacenado en nodo
     */
    public T getDato() {
        return dato;
    }

    /**
     * Cambia el dato que almacena este nodo
     * @param dato
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "|" + dato + "| <--> ";
    }

    /**
     *
     * @return Regresa un String con todos los nodos siguientes
     */
    public String printAll() {
        if (this.siguiente == null) {
            return this.toString() + null;
        }
        return this.toString() + this.getSiguiente().printAll();
    }
    
    public String printAllReverse(){
        if (this.anterior == null) {
            return this.toString() + null;
        }
        return this.toString() + this.getAnterior().printAllReverse();
    }
    
    
    public static void main(String[] args) {
        DoubleNodo head = new DoubleNodo(5);
        DoubleNodo cola;
        DoubleNodo dn1 = new DoubleNodo(4);
        dn1.setAnterior(head, true);
        dn1.setSiguiente(new DoubleNodo(3), true);
        // |5|<->|4|<->|3|<->null
        System.out.println(head.printAll());
        // |4|<->
        System.out.println(head.getSiguiente());
        //|5|<->
        System.out.println(head.getSiguiente().getAnterior());
        cola = head.getSiguiente().getSiguiente();
        System.out.println("Final: " +cola);
        System.out.println("Anterior a final: "+cola.getAnterior());
        System.out.println(cola.printAllReverse());
        
        
    }
}
