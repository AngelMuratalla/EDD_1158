package codigos.ADTS;

import java.util.ArrayList;

/**
 *
 * @author AngelMuratalla
 * @param <T>
 */
public class SetADT<T> {

    private final ArrayList<T> conjunto = new ArrayList();

    public int getLongitud() {
        return conjunto.size();
    }

    public void agregarElemento(T elemento) {
        if (!conjunto.contains(elemento)) {
            conjunto.add(elemento);
        }
    }

    public void eliminarElemento(T elemento) {
        if (conjunto.contains(elemento)) {
            conjunto.remove(elemento);
        }
    }

    public SetADT<T> union(SetADT<T> conjunto) {
        SetADT<T> nuevo = new SetADT();
        nuevo.conjunto.addAll(this.conjunto);
        for (int indice = 0; indice < conjunto.getLongitud(); indice++) {
            nuevo.agregarElemento(conjunto.conjunto.get(indice));
        }
        return nuevo;
    }

    public SetADT<T> interseccion(SetADT<T> conjunto) {
        SetADT<T> nuevo = new SetADT();
        SetADT<T> aux = this.union(conjunto);
        T elementoAux;
        for (int indice = 0; indice < aux.getLongitud(); indice++) {
            elementoAux = (T) aux.conjunto.get(indice);
            if (this.contiene(elementoAux) && conjunto.contiene(elementoAux)) {
                nuevo.agregarElemento(elementoAux);
            }
        }
        return nuevo;
    }

    public SetADT<T> diferencia(SetADT<T> conjunto) {
        SetADT<T> nuevo = new SetADT();
        T elementoAux;
        for (int indice = 0; indice < this.getLongitud(); indice++) {
            elementoAux = this.conjunto.get(indice);
            if (!conjunto.contiene(elementoAux)) {
                nuevo.agregarElemento(elementoAux);
            }
        }
        return nuevo;
    }

    public boolean esIgual(SetADT<T> conjunto) {
        if (this.getLongitud() != conjunto.getLongitud()) {
            return false;
        } else {
            return this.contiene(conjunto);
        }
    }

    public boolean contiene(SetADT<T> conjunto) {
        return this.conjunto.containsAll(conjunto.conjunto);
    }

    public boolean contiene(T elemento) {
        return this.conjunto.contains(elemento);
    }

    @Override
    public String toString() {
        return conjunto.toString();
    }
}
