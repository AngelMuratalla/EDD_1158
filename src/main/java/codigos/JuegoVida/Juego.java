package codigos.JuegoVida;

public class Juego {

    public static void main(String[] args) {
        Tablero generacionActual = new Tablero();
        //Valores iniciales
        generacionActual.cambiarEstado(4, 4, true);
        generacionActual.cambiarEstado(5, 4, true);
        generacionActual.cambiarEstado(5, 3, true);
        generacionActual.cambiarEstado(5, 5, true);
        //Generación de origen
        System.out.println("Generacion 1");
        System.out.println(generacionActual);

        int vec[];
        Celula cel1;
        int generaciones = 15;
        //For que lleva el control de las generaciones
        for (int c = 2; c <= generaciones; c++) {
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
            System.out.println("Generacion " + c);
            generacionActual = generacionSiguiente;
            System.out.println(generacionActual);
        }
    }
}
