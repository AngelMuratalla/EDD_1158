/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.Laberinto;

import codigos.Pruebas.LectorArchivo;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author rodol
 */
public class Solucion extends JPanel{
    
    Laberinto laberinto;
    ArrayList<ArrayList<String>> archivo = new ArrayList();

    public Solucion(String ruta) {
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

        juego.laberinto.buscarSinDetenerse();
        JOptionPane.showMessageDialog(ventana, "La solucion está en la consola :)");
        System.out.println(juego.laberinto.resultadoFinal());
    }
}
