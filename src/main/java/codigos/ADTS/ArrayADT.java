/**
 * Este programa fue creado para hacer una lista ADT que se capaz de almacenar cualquier tipo de dato
 * Fecha de creación: 25/'08/2022
 */
package codigos.ADTS;

import codigos.Pruebas.Empleado;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Muratalla
 * @param <T>
 *
 */
public class ArrayADT<T> {

    public static void main(String[] args) {
        ArrayADT lista = new ArrayADT(12); //Constructor
        lista.setElemento(0, "ARIGATO");
        System.out.println(lista);
        
        System.out.println("Dato inicial: " + lista.getElemento(5)); //getElemento
        lista.setElemento(5, "Soy un dato..."); //setElemento
        lista.setElemento(1, new Empleado(19, "Carlos Yael", "Tenorio", "Castilla", 35, 35000, 2002));
        System.out.println("Dato modificado: " + lista.getElemento(5));
        System.out.println("Tamaño de la lista: " + lista.getLenght()); //getLenght
        Iterator a = lista.getIterator();
        System.out.println("Impresión utilizando el iterador");
        while (a.hasNext()) {
            System.out.println("-" + a.next());
        }
        System.out.println("-------------------------------");
        lista.clear(5); //clear
        System.out.println("Impresión utilizando toString");
        System.out.println(lista.toString()); //toString
    }

     final ArrayList<T> datos;

    /**
     * Constructor: crea un ArrayList con el tamaño especificado y almacena null
     * como valor de inicio en cada espacio
     *
     * @param tamanio
     */
    public ArrayADT(int tamanio) {
        this.datos = new ArrayList(tamanio);
        for (int indice = 0; indice < tamanio; indice++) {
            datos.add(null);
        }
    }

    /**
     *
     * @param indice
     * @return Regresa el valor almacenado en el indice indicado, si el indice
     * indicado esta fuera del rango del arreglo regresa null
     */
    public T getElemento(int indice) {
        if (indice >= 0 && indice < datos.size()) {
            return (datos.get(indice));
        }
        return null;
    }

    /**
     * Remplaza el dato almacenado en el indice indicado por el nuevo tipo de
     * dato que se indique
     * @param elemento
     * @param indice
     */
    public void setElemento(int indice, T elemento) { //Setter
        if (indice >= 0 && indice < datos.size()) {
            datos.set(indice, elemento);
        } 
    }

    /**
     *
     * @return Regresa el tamaño de la lista
     */
    public int getLenght() {
        return datos.size();
    }

    /**
     * Remplaza todos los datos almacenados en la lista por un dato indicado
     * @param elemento
     */
    public void clear(T elemento) {
        for (int indice = 0; indice < datos.size(); indice++) {
            datos.set(indice, elemento);
        }
    }

    public Iterator getIterator() {
        return datos.listIterator();
    }

    public Iterator getIterator(int indice) {
        return datos.listIterator(indice);
    }

    /**
     * Imprime todo los datos almacenados en la lista
     */
    @Override
    public String toString() {
        return datos.toString();
    }
}
