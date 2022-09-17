package codigos.Pruebas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *Esta clase esta hecha para leer archivos separados por coma
 * @author AngelMuratalla
 * @param <T>
 */
public class LectorArchivo<T> {

    private static String linea;

    /**
     * Utiliza la ruta indicada para buscar el archivo y la lista de listas para almacenar los datos contenidos dentro
     * @param lista
     * @param ruta
     */
    public static  void leerArchivo(String ruta, ArrayList<ArrayList<String>> lista) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            while ((linea = lector.readLine()) != null) {                
               lista.add(auxiliar(linea.split(",")));
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private static <T> ArrayList<T> auxiliar(T[] arreglo){
        ArrayList<T> listaSalida = new ArrayList<>();
        listaSalida.addAll(Arrays.asList(arreglo));
        return listaSalida;
        }   
   }