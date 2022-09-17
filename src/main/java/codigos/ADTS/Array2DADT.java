
package codigos.ADTS;


/**
 * Esta clase tiene como proposito crear matrices que sean capaz de almacenar
 * cualquier cosa
 *
 * @author AngelMuratalla
 * @param <T>
 */
public class Array2DADT<T> {

    int filas, columnas;
    ArrayADT<ArrayADT> matriz;

    public Array2DADT(int filas, int columnas) {
        this.matriz = new ArrayADT(filas);
        for (int fila = 0; fila < matriz.getLenght(); fila++) {
            matriz.setElemento(fila, new ArrayADT(columnas));
        }
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public T getElemento(int fila, int columna) {
        if (fila >= 0 && fila < this.filas) {
            return (T) (matriz.getElemento(fila).getElemento(columna));
        }
        return null;
    }

    public void setElemento(int fila, int columna, T elemento) {
        if (fila >= 0 && fila < this.filas) {
            matriz.getElemento(fila).setElemento(columna, elemento);
        }
    }

    public void limpiar(T elemento) {
        for (int fila = 0; fila < this.filas; fila++) {
            matriz.getElemento(fila).clear(elemento);
        }
    }

    @Override
    public String toString() {
        String salida = "";
        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                salida += String.format("%-5s ", matriz.getElemento(fila).getElemento(columna));
            }
            salida += "\n";
        }
        return salida;
    }
}
