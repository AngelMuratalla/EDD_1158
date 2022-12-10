/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.Pruebas;

import java.util.ArrayList;

/**
 *
 * @author rodol
 */
public class Switch implements Comparable{
    int[] ropa = {1,2,3,4};

    public Switch(){
        
    }
    
    @Override
    public String toString() {
        
        return "HOLA";
    }
    
    
    
    public static void main(String[] args) {
        
        
        Integer a = 2;
        Integer b = 2;
        Switch s1 = new Switch();
        Switch s2 = new Switch();
        Switch[] sts = {s1, s2};
        ArrayList<Integer> college = new ArrayList();

        for (Switch sp : sts) {
            System.out.println(sp);
        }
        
//        int a = 0;
//        int opcion = 2;
//        
//        switch (opcion) {
//            case 1: case 2: case 3:
//                System.out.println("hola");
//                break;
//        }

    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
