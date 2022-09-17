package codigos.Pruebas;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RedesSociales {

    public static void main(String[] args) {
        RedesSociales archivo = new RedesSociales("C:\\Users\\rodol\\Downloads\\presenciaredes\\presenciaredes.CSV"); 
        archivo.leerArchivo();
       
        String[] encabezado = new String[15];
        for (int j = 0; j < 15; j++) {
            encabezado[j] = archivo.getLista().get(0).get(j);
        }

        Object[][] tabla = new Object[18][15];
        for (int i = 1; i < 19; i++) {
            for (int j = 0; j < 15; j++) {
                tabla[i - 1][j] = archivo.getLista().get(i).get(j);
            }
        }
        int resultado, opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1. Mostrar archivoCSV\n"
                    + "2. Mostrar diferencia de followers en Twiter (enero y junio)\n"
                    + "3. Calcular la diferencia de visualizaciones de YouTube\n"
                    + "4. Calcular el promedio de crecimiento de Twitter y Facebook (enero a junio)\n"
                    + "5. Salir"));

            switch (opcion) {
                case 1:
                    JFrame t1 = new CrearTabla(tabla, encabezado);
                    t1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    t1.setVisible(true);
                    break;
                case 2:

                    resultado
                            = Integer.parseInt(archivo.getLista().get(8).get(3)) - Integer.parseInt(archivo.getLista().get(8).get(8));
                    resultado = Math.abs(resultado);
                    JOptionPane.showMessageDialog(null, "resultado: " + resultado);
                    break;
                case 3:
                    int mes1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero del primer mes a comparar. "));
                    int mes2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero del segundo mes a comparar. "));
                    resultado
                            = Integer.parseInt(archivo.getLista().get(16).get(mes1 + 2)) - Integer.parseInt(archivo.getLista().get(16).get(mes2 + 2));
                    resultado = Math.abs(resultado);
                    JOptionPane.showMessageDialog(null, "resultado: " + resultado);

                    break;
                case 4:
                    double promedioF = 0,
                     promedioT = 0;

                    for (int mes = 3; mes < 9; mes++) {
                        promedioF += Double.parseDouble(archivo.getLista().get(3).get(mes)
                                .substring(0, archivo.getLista().get(3).get(mes).length() - 1));
                        promedioT += Double.parseDouble(archivo.getLista().get(10).get(mes)
                                .substring(0, archivo.getLista().get(10).get(mes).length() - 1));
                        promedioF = promedioF / 6;
                        promedioT = promedioT / 6;
                    }

                    JOptionPane.showMessageDialog(null, "Promedio de Facebook: " + String.format("%.2f", promedioF) + "%"
                            + "\nPromedio de Twitter: " + String.format("%.2f", promedioT) + "%");

                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Esa opcion no es valida.");
                    break;
            }
        } while (opcion != 5);

    }

    private String ruta;
    private String linea;
    public ArrayList<ArrayList<String>> lista = new ArrayList();

    public RedesSociales(String ruta) {
        this.ruta = ruta;
    }

    public void leerArchivo() {
        try {

            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            while ((linea = lector.readLine()) != null) {
                lista.add(verificarLinea(linea.split(",")));
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ArrayList<String> verificarLinea(String[] arreglo) {
        ArrayList<String> salida = new ArrayList();
        int indiceSalida = 0;
        for (int indiceArreglo = 0; indiceArreglo < arreglo.length; indiceArreglo++) {
            if (arreglo[indiceArreglo].startsWith("\"")) {
                salida.add(indiceSalida, arreglo[indiceArreglo].replace("\"", "") + arreglo[indiceArreglo + 1].replace("\"", ""));
                indiceArreglo++;
                indiceSalida++;
            } else {
                salida.add(indiceSalida, arreglo[indiceArreglo]);
                indiceSalida++;
            }
        }
        return salida;
    }

    public void imprimirArchivo() {
        for (int fila = 0; fila < 19; fila++) {
            for (int columna = 0; columna < 15; columna++) {
                System.out.print(lista.get(fila).get(columna) + " | ");
            }
            System.out.println();
        }
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public ArrayList<ArrayList<String>> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ArrayList<String>> lista) {
        this.lista = lista;
    }
}

class CrearTabla extends JFrame {

    public CrearTabla(Object[][] tabla, String[] encabezado) {
        setTitle("Datos");
        setBounds(300, 300, 600, 300);
        JTable marco = new JTable(tabla, encabezado);
        add(new JScrollPane(marco), BorderLayout.CENTER);
    }
}

