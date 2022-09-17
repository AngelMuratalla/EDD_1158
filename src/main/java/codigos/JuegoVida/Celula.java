package codigos.JuegoVida;

/**
 * Clase modelo de una celula
 * @author AngelMuratalla
 */
public class Celula {
    //El estado indica si esta viva o muerta
    private boolean estado;

    /**
     * Intanciar una celula requiere indicar si esta viva o no
     * @param vivo
     */
    public Celula(boolean vivo) {
                this.estado = vivo;
    }

    /**
     * @return sí la celula esta viva o muerta 
     * (true = viva, false = muerta)
     */
    public boolean isEstado() {
        return estado;
    }
    
    /**
     * Modifica el estado de la celula
     * @param estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**      
     * @return 0 = viva, . = muerta 
     */
    @Override
    public String toString() {
         if (estado) {
            return "0";
        }else{
            return ".";
        }
    }
}
