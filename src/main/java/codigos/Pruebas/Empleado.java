
package codigos.Pruebas;

/**
 * La clase Empleado tiene por objetivo simular a un empleado almacenando sus datos
 * @author AngelMuratalla
 */
public class Empleado {
    
    
    private int numTrabajador, horasExtra, anioIngreso;
    private String nombres, apellidoPaterno, apellidoMaterno;
    private double sueldoBase;

    /**
     *
     * @param numeroTrabajador
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param horasExtra
     * @param sueldoBase
     * @param anioIngreso
     */
    public Empleado(int numeroTrabajador, String nombre, String apellidoPaterno, String apellidoMaterno,
            int horasExtra, double sueldoBase, int anioIngreso) {
        this.numTrabajador = numeroTrabajador;
        this.nombres = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoPaterno;
        this.horasExtra = horasExtra;
        this.sueldoBase = sueldoBase;
        this.anioIngreso = anioIngreso;
    }

    /**
     * @return Regresa el ID o Número de trabajador
     */
    public int getNumTrabajador() {
        return this.numTrabajador;
    }

    /**
     * Permite cambiar el ID del trabajador
     * @param numeroTrabajador
     */
    public void setNumTrabajador(int numeroTrabajador) {
        this.numTrabajador = numeroTrabajador;
    }

    /**
     * @return Regresa solo los o el nombre del empleado
     */
    public String getNombres() {
        return this.nombres;
    }
    
    /**
     * @return Regresa el nombre completo del trabajador
     */
    public String getNombreCompleto() {
        return getNombres() + " " + getApellidoPaterno() + " " + getApellidoMaterno();
    }

    /**
     * Permite cambiar el nombre del empleado
     * @param nombre
     */
    public void setNombres(String nombre) {
        this.nombres = nombre;
    }

    /**
     * @return Regresa el apellido paterno del empleado
     */
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    
    /**
     * Permite cambiar el apellido paterno del empleado
     * @param apellidoPaterno
     */
    public void setApellidoP(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

     /**
     * @return Regresa el apellido materno del empleado
     */
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

    /**
     * Permite cambiar el apellido paterno del empleado
     * @param apellidoMaterno
     */
    public void setApellidoM(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return Regresa las horas extra del empleado
     */
    public int getHorasExtra() {
        return this.horasExtra;
    }

    /**
     * Permite cambiar las horas extra del empleado
     * @param horasExtra
     */
    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    /**
     * @return Regresa el sueldo base del empleado
     */
    public double getSueldoBase() {
        return this.sueldoBase;
    }

    /**
     * Permite cambiar el sueldo base del empleado
     * @param sueldoBase
     */
    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    /**
     *
     * @return Regresa el año en el que ingreso el empleado
     */
    public int getAnioIngreso() {
        return this.anioIngreso;
    }

    /**
     * Permite cambiar el año de ingreso del empleado
     * @param anioIngreso
     */
    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }
    
    /**
     *
     * @return Regresa la antiguedad del empleado tomando en cuenta la diferencia del año de ingreso con 2022
     */
    public int getAntiguedad() {
        return 2022 - this.anioIngreso;
    }

    @Override
    public String toString() { 
        return String.format("%s %s, %s, %s, %s, %s, %s",
                numTrabajador, nombres, apellidoPaterno, apellidoMaterno, horasExtra, sueldoBase, anioIngreso);
    }

    /**
     * @return Calcula el sueldo tomando en cuenta horas extra y años de antiguedad
     */
    public double calcularSueldo() {
        return this.sueldoBase + (this.sueldoBase * (getAntiguedad() * 0.03)) + (this.horasExtra * 276.5);
    } 
}