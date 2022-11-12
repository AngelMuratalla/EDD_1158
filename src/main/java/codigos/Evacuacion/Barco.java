
package codigos.Evacuacion;

import codigos.ADTS.BoundedPriorityQueue;

public class Barco {
    public static void main(String[] args) {
        BoundedPriorityQueue<String> abordo = new BoundedPriorityQueue(7);
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
        while(!abordo.isEmpty()){
            System.out.printf("%s han evacuado el barco %n", abordo.dequeue());
        }
    }
}
