package codigos.Laberinto;

import codigos.Pruebas.LectorArchivo;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SolucionPorPasos extends JPanel {

    Laberinto laberinto;
    ArrayList<ArrayList<String>> archivo = new ArrayList();

    public SolucionPorPasos(String ruta) {
        LectorArchivo.leerArchivo(ruta, archivo);
        laberinto = new Laberinto(archivo);
    }

    @Override
    public void paint(Graphics grafico) {
        laberinto.paint(grafico);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Laberinto");
        SolucionPorPasos juego = new SolucionPorPasos("C:\\Users\\rodol\\Downloads\\laberinto2.csv");
        ventana.add(juego);
        ventana.setSize(950, 600);
        ventana.setLocation(300, 100);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(juego.laberinto.isSolucion()){
            retardo();
            juego.laberinto.siguientePaso();
            juego.repaint();
        }
        JOptionPane.showMessageDialog(ventana, "La solucion está en la consola :)");
        System.out.println( juego.laberinto.resultadoFinal());
    }

    public static void retardo() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}
