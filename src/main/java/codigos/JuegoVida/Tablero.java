
package codigos.JuegoVida;

import codigos.ADTS.Array2DADT;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Clase principal que lleva el control de la posición y estado de celulas
 * @author AngelMuratalla
 */
public final class Tablero {
    //Una matriz que contiene celulas
    private final Array2DADT<Celula> tablero;

    /**
     * Crea un tablero con dimensiones iniciales de 10 x 10,
     * con valores iniciales de las celulas = muerta
     */
    public Tablero() {
        this.tablero = new Array2DADT(10, 10);
        limpiarTablero();
    }
    
        public void paint(Graphics grafico) {
        int anchoBloque = 40;
        int altoBloque = 40;
        for (int filas = 0; filas < 10; filas++) {
            for (int columnas = 0; columnas < 10; columnas++) {
                switch (tablero.getElemento(filas, columnas).toString()) {
                    case "M":
                        grafico.setColor(Color.RED);
                        grafico.fillRect(columnas * anchoBloque, filas * altoBloque, anchoBloque, altoBloque);
                        grafico.setColor(Color.black);
                        grafico.drawRect(columnas * anchoBloque, filas * altoBloque, anchoBloque, altoBloque);
                        break;
                    case "V":
                        grafico.setColor(Color.GREEN);
                        grafico.fillRect(columnas * anchoBloque, filas * altoBloque, anchoBloque, altoBloque);
                        break;
                }
            }
        }
    }

    /**
     *
     * @param fila
     * @param columna
     * @return Un arreglo que contine el numero de vecinos vivos 
     * y muertos
     */
    public int[] buscarVecinos(int fila, int columna) {
        int[] vivos_muertos = {0, 0};
        int numVecinos = 0;
        if (comprobarRango(fila - 1, columna - 1)) { //1
            vivos_muertos[0] += comprobarEstado(fila - 1, columna - 1);
            numVecinos++;
        }
        if (comprobarRango(fila - 1, columna)) { //2
            vivos_muertos[0] += comprobarEstado(fila - 1, columna);
            numVecinos++;
        }
        if (comprobarRango(fila - 1, columna + 1)) { //3
            vivos_muertos[0] += comprobarEstado(fila - 1, columna + 1);
            numVecinos++;
        }
        if (comprobarRango(fila, columna + 1)) { //4
            vivos_muertos[0] += comprobarEstado(fila, columna + 1);
            numVecinos++;
        }
        if (comprobarRango(fila + 1, columna + 1)) { //5
            vivos_muertos[0] += comprobarEstado(fila + 1, columna + 1);
            numVecinos++;
        }
        if (comprobarRango(fila + 1, columna)) { //6
            vivos_muertos[0] += comprobarEstado(fila + 1, columna);
            numVecinos++;
        }
        if (comprobarRango(fila + 1, columna - 1)) { //7
            vivos_muertos[0] += comprobarEstado(fila + 1, columna - 1);
            numVecinos++;
        }
        if (comprobarRango(fila, columna - 1)) { //8
            vivos_muertos[0] += comprobarEstado(fila, columna - 1);
            numVecinos++;
        }
        vivos_muertos[1] = numVecinos - vivos_muertos[0];
        return vivos_muertos;
    }

    /**
     *  
     * @param fila
     * @param columna
     * @return regresa true si la fila y la columna esta dentro del rango del
     * tablero, false si es lo contrario.
     */
    private boolean comprobarRango(int fila, int columna) {
        return (fila >= 0 && fila < 10 && columna >= 0 && columna < 10);
    }

    /**
     * 
     * @param fila
     * @param columna
     * @return 1 si la celula contenida en el tablero esta viva, 0 si 
     * esta morida.
     */
    private int comprobarEstado(int fila, int columna) {
        if (tablero.getElemento(fila, columna).isEstado()) {
            return 1;
        }
        return 0;
    }
    
    /**
     *
     * @param fila
     * @param columna
     * @return la celula contenida en esa casilla
     */
    public Celula getCelula(int fila, int columna){
        return tablero.getElemento(fila, columna);
    }

    /**
     *  Cambia el estado de la celula en la casilla indicada por el
     * nuevo valor indicado
     * @param fila
     * @param columna
     * @param vivo
     */
    public void cambiarEstado(int fila, int columna, boolean vivo) {
        tablero.getElemento(fila, columna).setEstado(vivo);
    }
    
    /**
     * Limpia el tablero haciendo que todas las celulas tengan el valor
     * inicial.
     */
    public void limpiarTablero(){
        for (int filas = 0; filas < 10; filas++) {
            for (int columnas = 0; columnas < 10; columnas++) {
                tablero.setElemento(filas, columnas, new Celula(false));
            }
        }
    }

    @Override
    public String toString() {
        return tablero.toString();
    }
    
}
