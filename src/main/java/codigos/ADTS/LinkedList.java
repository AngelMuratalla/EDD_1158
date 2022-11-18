package codigos.ADTS;

/**
 *
 * @author AngelMuratalla
 * @param <T>
 */
public class LinkedList<T> {

    Nodo<T> head;
    int tamanio;

    public boolean estaVacia() {
        return this.head == null;
    }

    public int getTamanio() {
        return this.tamanio;
    }

    public void agregarAlFinal(T valor) {
        Nodo nuevo = new Nodo(valor);
        if (this.estaVacia()) {
            this.head = nuevo;
        } else {
            Nodo aux = this.head;
            for (int contador = 1; contador < this.tamanio; contador++) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        this.tamanio++;
    }

    public void agregarAlInicio(T valor) {
        Nodo nuevo = new Nodo(valor);
        if (this.estaVacia()) {
            this.head = nuevo;
        } else {
            nuevo.setSiguiente(this.head);
            this.head = nuevo;
        }
        this.tamanio++;
    }

    public void agregarDespuesDe(T valor, int posicion) {
        if (posicion <= this.tamanio && posicion >= 0) {
            Nodo nuevo = new Nodo(valor);
            Nodo aux = this.head;
            for (int contador = 1; contador <= posicion - 1; contador++) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
        this.tamanio++;
    }

    public void eliminar(int posicion) {
        if (posicion <= tamanio && posicion >= 0) {
            Nodo aux = this.head;
            for (int contador = 1; contador <= posicion - 1; contador++) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
        }
        this.tamanio--;
    }

    public void eliminarPrimero() {
        this.head = this.head.getSiguiente();
        this.tamanio--;
    }

    public void eliminarFinal() {
        if (!this.estaVacia()) {
            Nodo aux = this.head;
            for (int indice = 1; indice < this.tamanio; indice++) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null);
        }
        this.tamanio--;
    }

    public int buscar(T dato) {
        Nodo aux = this.head;
        int posicion = 0;
        if (this.estaVacia()) {
            return -1;
        } else if (this.head.getDato() == dato) {
            return 1;
        } else {
            while (aux != null) {
                if (aux.getDato() == dato) {
                    break;
                } else {
                    aux = aux.getSiguiente();
                    posicion++;
                }
            }
        }
        return posicion;
    }
    
    public T obtener(T dato) {
        Nodo<T> aux = this.head;
        if (this.estaVacia()) {
            return null;
        } 
        while(aux.getDato().equals(dato) && aux.getSiguiente().getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        return aux.getDato();
    }
    
    public static void main(String[] args) {
        
    }

    public void transversal() {
        System.out.println(this.head.printAll());
    }
}
