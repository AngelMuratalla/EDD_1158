package codigos.ADTS;

/**
 *
 * @author AngelMuratalla
 */
public class DoubleLinkedList<T> {

    private DoubleNodo<T> head; //Inicio de la lista
    private DoubleNodo<T> cola; //Final de la lista
    private int tamanio; //Tamaño de lista

    /**
     * Comenzamos con una lista vacia
     */
    public DoubleLinkedList() {
        this.tamanio = 0;
    }

    /**
     * @return Regresa un booleano indicando si la lista esta vacia o no
     */
    public boolean estaVacia() {
        return this.head == null;
    }

    /**
     * @return Regresa el tamaño de la lista
     */
    public int getTamanio() {
        return this.tamanio;
    }

    /**
     * Agrega un nuevo nodo con que almacena el dato indicado
     *
     * @param dato
     */
    public void agregarAlFinal(T dato) {
        DoubleNodo<T> nuevo = new DoubleNodo(dato);
        DoubleNodo<T> aux;
        if (this.estaVacia()) {
            this.head = nuevo;
            this.cola = nuevo;
        } else {
            aux = this.cola;
            this.cola = nuevo;
            aux.setSiguiente(this.cola, true);
        }
        this.tamanio++;
    }

    /**
     * Agrega un valor al inicio de la lista
     *
     * @param dato
     */
    public void agregarAlInicio(T dato) {
        DoubleNodo<T> nuevo = new DoubleNodo(dato);
        if (this.estaVacia()) {
            this.head = nuevo;
            this.cola = nuevo;
        } else {
            nuevo.setSiguiente(this.head, true);
            this.head = nuevo;
        }
        tamanio++;
    }

    /**
     * Agrega un nodo con el dato indicado despues de la posicion indicada
     * (Posiciones negativas recorren de final a inicio)
     *
     * @param posicion
     * @param dato
     */
    public void agregarDespuesDe(int posicion, T dato) {
        DoubleNodo<T> nuevo = new DoubleNodo(dato);
        DoubleNodo<T> aux = this.getPosicion(posicion);
        if (aux.equals(this.cola)) {
            this.agregarAlFinal(dato);
        } else {
            nuevo.setSiguiente(aux.getSiguiente(), true);
            nuevo.setAnterior(aux, true);
            this.tamanio++;
        }
    }

    /**
     * Elimina el nodo de la posicion indicada
     *
     * @param posicion
     */
    public void eliminar(int posicion) {
        DoubleNodo<T> aux = this.getPosicion(posicion);
        if (aux.equals(this.head)) {
            this.eliminarInicio();
        } else if (aux.equals(this.cola)) {
            this.eliminarFinal();
        } else {
            aux.getAnterior().setSiguiente(aux.getSiguiente(), true);
            aux.setAnterior(null);
            aux.setSiguiente(null);
            this.tamanio--;
        }
    }

    /**
     * Elimina el inicio de la lista
     */
    public void eliminarInicio() {
        this.head = this.head.getSiguiente();
        this.head.setAnterior(null);
        this.tamanio--;
    }

    /**
     * Elimina el final de la lista
     */
    public void eliminarFinal() {
        this.cola = this.cola.getAnterior();
        this.cola.setSiguiente(null);
        this.tamanio--;
    }

    /**
     * Busca un elemente de inicio a fin
     *
     * @param dato
     * @return Posicion del dato en caso de ser encontrado, si no lo encuentra
     * regresa -1.
     */
    public int buscar(T dato) {
        DoubleNodo<T> aux = this.head;
        for (int posicion = 0; posicion < this.tamanio; posicion++) {
            if (aux.getDato().equals(dato)) {
                return posicion;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return -1;
    }

    /**
     * Actualiza el dato indicado por el nuevo dato
     *
     * @param datoABuscar
     * @param nuevoDato
     */
    public void actualizar(T datoABuscar, T nuevoDato) {
        int posicion = this.buscar(datoABuscar);
        if (posicion != -1) {
            this.getPosicion(posicion).setDato(nuevoDato);
        } else {
            System.out.println("Dato no encontrado");
        }
    }

    /**
     * (Posiciones negativas recorren de inicio a fin)
     *
     * @param posicion
     * @return Nodo en posicion indicada
     */
    public DoubleNodo<T> getPosicion(int posicion) {
        DoubleNodo<T> aux = null;
        if (posicion >= 0 && posicion < this.tamanio) { //Posicion positiva
            aux = this.head;
            for (int indice = 0; indice < posicion; indice++) {
                aux = aux.getSiguiente();
            }
        } else if (posicion < 0 && Math.abs(posicion) <= this.tamanio) { //Posicion negativa
            aux = this.cola;
            for (int indice = -1; indice > posicion; indice--) {
                aux = aux.getAnterior();
            }
        } else if (Math.abs(posicion) > this.tamanio) {
            System.out.println("Fuera de rango");
        }
        return aux;
    }

    /**
     * @return Final de la lista
     */
    public DoubleNodo<T> getFinal() {
        return this.cola;
    }

    /**
     * Recorrido por la lista 1 = inicio a fin, 2 = fin a inicio
     * @param direccion
     */
    public void transversal(int direccion) {
        switch (direccion) {
            case 1:
                System.out.println(this.head.printAll());
                break;
            case 2:
                System.out.println(this.cola.printAllReverse());
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }
    public static void main(String[] args) {
        DoubleLinkedList a = new DoubleLinkedList();
        a.agregarAlFinal(1);
        a.agregarAlFinal(2);
        a.agregarAlFinal(3);
        a.agregarAlFinal(4);
        a.agregarAlFinal(5);
        a.agregarAlFinal(6);
        a.transversal(1);
        a.transversal(2);
        a.agregarAlInicio("Inicio");
        a.agregarDespuesDe(4, "Hola");
        a.transversal(1);
        a.actualizar("Hola", "HOLAAAAA");
        System.out.println(a.buscar("HOLAAAAA"));
        a.eliminarInicio();
        a.eliminarFinal();
        a.transversal(1);
    }
}
