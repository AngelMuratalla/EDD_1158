package codigos.JuegoVida;

/**
 * @author AngelMuratalla
 */
public class Reglas {

    /**
     * Aplica las reglas sobre la celula en base a los vecinos vivos y los moridos 
     * @param celula
     * @param vecinosVivos
     * @param vecinosMuertos
     * @return
     */
    public static boolean aplicarReglas(Celula celula, int vecinosVivos, int vecinosMuertos) {

        if (celula.isEstado()) {
            if (vecinosVivos == 2 || vecinosVivos == 3) {   //Regla 1
                return true;
            } else if (vecinosVivos < 2) { //Regla 2
                return false;
            } else if (vecinosVivos >= 4) { //Regla 3
                return false;
            }
        } else if (vecinosVivos == 3) { //Regla 4
            return true;
        } 
        return false;
    }
}
