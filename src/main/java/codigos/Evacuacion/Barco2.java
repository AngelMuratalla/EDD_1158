package codigos.Evacuacion;

import codigos.ADTS.BoundedPriorityQueue2;

public class Barco2 {
    public static void main(String[] args) {
        BoundedPriorityQueue2<String> abordo = new BoundedPriorityQueue2(7);
        //Grupo de personas que están abordo
        abordo.enqueue(4, "Maestre");
        abordo.enqueue(2, "Niños");
        abordo.enqueue(4, "Mecanico");
        abordo.enqueue(3, "Mujeres");
        abordo.enqueue(2, "Personas de tercera edad");
        abordo.enqueue(1, "Niñas");
        abordo.enqueue(3, "Hombres");
        abordo.enqueue(4, "Vigia");
        abordo.enqueue(5, "Capitan");
        abordo.enqueue(4, "Timonel");
        //Vamos a evacuarlos hasta que la cola este vacía
        while(!abordo.isEmpty()){
            System.out.printf("%s han evacuado el barco %n", abordo.dequeue());
        }
    }
}
