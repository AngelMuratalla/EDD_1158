
package codigos.Pruebas;

import codigos.ADTS.ArrayADT;
import java.util.ArrayList;

/**
 *
 * @author AngelMuratalla
 */
public class NominaADT {

    public static void main(String[] args) {
        /*Guardamos los datos del archivo en una matriz (lista de listas) y generamos el ArrayADT que contendra a los
        empleados.*/
        ArrayList<ArrayList<String>> matriz = new ArrayList();
        LectorArchivo.leerArchivo("C:\\Users\\rodol\\Downloads\\junio.dat", matriz);
        ArrayADT<Empleado> nomina = new ArrayADT(matriz.size() - 1);
        
        /*Almacenamos cada empleado en el ArrayADT nomina con los datos del archivo que vienen contenidos 
        en matriz.*/
        for (int indice = 0; indice < nomina.getLenght(); indice++) {
            nomina.setElemento( indice,
                    (new Empleado(
                            Integer.parseInt(matriz.get(indice + 1).get(0)), //Número de trabajador
                            matriz.get(indice + 1).get(1),                           //Nombre(s)
                            matriz.get(indice + 1).get(2),                           //Apellido Paterno
                            matriz.get(indice + 1).get(3),                           //Apellido Materno
                            Integer.parseInt(matriz.get(indice + 1).get(4)), //Horas Extra
                            Double.parseDouble(matriz.get(indice + 1).get(5)), //Sueldo Base
                            Integer.parseInt(matriz.get(indice + 1).get(6)))) //Anio Ingreso
                            
                           /*indice*/ );                                                          //Posición            
        }
        /*Mostramos el numero de trabajador y el sueldo de cada empleado tomando en cuenta la antiguedad,
        horas extra y sueldo base.*/
        System.out.printf("%30s %n", "Sueldos");
        for (int indice = 0; indice < nomina.getLenght(); indice++) {
            System.out.printf("ID: %d  Sueldo: %,.2f  Nombre: %s %n", 
                    (nomina.getElemento(indice)).getNumTrabajador(), //Obtenemos el ID o numero de trabajador
                    (nomina.getElemento(indice)).calcularSueldo(),        //Obtenemos su sueldo total  
                    (nomina.getElemento(indice)).getNombreCompleto());    //Mostamos su nombre        
        }
        /*Obtener mayor y menor antiguedad*/
        int menorAntiguedad = 2022, mayorAntiguedad = 0, antiguedad;
        for (int indice = 0; indice < nomina.getLenght(); indice++) {
            antiguedad = nomina.getElemento(indice).getAntiguedad();
            if (antiguedad > mayorAntiguedad) {
                mayorAntiguedad = antiguedad;
                        
            }
            if (antiguedad < menorAntiguedad) {
                menorAntiguedad = antiguedad;
            }
        }
        /*Obtenemos los empleados cuya antiguedad coincida con la mayor o con la menor*/
        String salida1 = "", salida2 = "";
        for (int indice = 0; indice < nomina.getLenght(); indice++) {
            if (nomina.getElemento(indice).getAntiguedad() == mayorAntiguedad) {
                salida1 += 
                        "Empleado con Mayor Antiguedad - Antiguedad: " + nomina.getElemento(indice).getAntiguedad() + 
                        " Nombre: " + nomina.getElemento(indice).getNombreCompleto() + "\n";
            }
            if (nomina.getElemento(indice).getAntiguedad() == menorAntiguedad) {
                salida2 +=
                    "Empleado con Menor Antiguedad - Antiguedad: " + nomina.getElemento(indice).getAntiguedad() + 
                    " Nombre: " + nomina.getElemento(indice).getNombreCompleto() + "\n";
            }
        }
        System.out.println("");
        System.out.println(salida1);
        System.out.println(salida2);
    }
}