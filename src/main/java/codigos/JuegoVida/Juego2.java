package codigos.JuegoVida;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Juego2 extends JPanel {

    Tablero generacionActual = new Tablero();
    Tablero genSig = new Tablero();

    public Juego2() {
        //Valores iniciales
        generacionActual.cambiarEstado(4, 4, true);
        generacionActual.cambiarEstado(5, 4, true);
        generacionActual.cambiarEstado(5, 3, true);
        generacionActual.cambiarEstado(5, 5, true);
    }

    @Override
    public void paint(Graphics g) {
        generacionActual.paint(g);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("GOla");
        Juego2 game = new Juego2();
        ventana.setSize(950, 600);
        ventana.setLocation(300, 100);
        ventana.setVisible(true);
        ventana.add(game);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        int iteraciones = 15;
        for (int contador = 2; contador <= iteraciones; contador++) {
            retardo();
            game.siguienteGen();
        }
    }

    public void siguienteGen() {
        int vec[];
        Celula cel1;
        //Necesitamos desvincular el tablero siguiente del mismo tablero que el actual
        Tablero generacionSiguiente = new Tablero();
        for (int i = 0; i < 10; i++) { // i = filas
            for (int j = 0; j < 10; j++) { // j = columnas
                cel1 = generacionActual.getCelula(i, j);
                vec = generacionActual.buscarVecinos(i, j);
                generacionSiguiente.getCelula(i, j).setEstado(
                        Reglas.aplicarReglas(cel1, vec[0], vec[1])
                );
            }
        }
        //Imprime la generación actual
        generacionActual = generacionSiguiente;
        this.repaint();
    }

    public static void retardo() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}
