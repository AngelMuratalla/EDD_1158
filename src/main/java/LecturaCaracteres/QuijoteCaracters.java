
package LecturaCaracteres;

/**
 *
 * @author AngelMuratalla
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;

/**
 * Está clase tiene por objetivo identificar cuantas veces se repite un caracter en el libro
 * del Quijote, excepto la "ñ" esa no la lee el Buffer :c
 * @author AngelMuratalla
 */
public class QuijoteCaracters {
    public static void main(String[] args) {
        //Almacenamiento
        String words = "a-b-c-d-e-f-g-h-i-j-k-l-m-n-ñ-o-p-q-r-s-t-u-v-w-x-y-z-,-.-:-;";
        String[][] table = new String[31][2];
        String[] aux = words.split("-");
        for (int i = 0; i < aux.length; i++) {
            table[i][0] = aux[i];
            table[i][1] = "0";
        }
        //Lectura del archivo
        String ruta = "C:\\Users\\rodol\\Downloads\\el_quijote.txt";
        String line;
         try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            while ((line = lector.readLine()) != null) {    
                //Escaneo de lineas
                line =  line.toLowerCase();
                line = stripAccents(line);
                check(line, table, words);
            }
            for (String[] table1 : table) {
                System.out.println(table1[0] + " se ha encontrado " + table1[1] + " veces");
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    public static void check(String s, String[][] t, String w){
        for (int i = 0; i < s.length(); i++) {
            CharSequence cs = s.substring(i, i+1);
            if (w.contains(cs)) {
                plus(s.substring(i, i+1), t);
            }
        }
    }
    
    public static void plus(String c, String[][] t){
        int aux;
        for (String[] t1 : t) {
            if (t1[0].equalsIgnoreCase(c)) {
                aux = Integer.parseInt(t1[1]) + 1;
                t1[1] = aux + "";
            }
        }
    }
    
    public static String stripAccents(String s){
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
    }
}
