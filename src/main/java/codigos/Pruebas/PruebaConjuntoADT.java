
package codigos.Pruebas;

import codigos.ADTS.SetADT;

public class PruebaConjuntoADT {
    public static void main(String[] args) {
        SetADT p = new SetADT();
        SetADT m = new SetADT();
        
        System.out.println(p.getLongitud());
        p.agregarElemento("1");
        p.agregarElemento("2");
        p.agregarElemento("3");
        p.agregarElemento("4");
        p.agregarElemento("5");
        p.agregarElemento("6");
        p.agregarElemento("19");
        m.agregarElemento("1");
        m.agregarElemento("34");
        m.agregarElemento("79");
        System.out.println(p);
        System.out.println(m);
        System.out.println(p.esIgual(m));
        System.out.println(p.contiene(m));
        System.out.println(p.union(m));
        System.out.println(p.interseccion(m));
        System.out.println(m.diferencia(p));
        
    }
}
