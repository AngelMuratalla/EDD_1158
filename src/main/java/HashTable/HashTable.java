/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

import java.util.ArrayList;

/**
 *
 * @author rodol
 * @param <K>
 * @param <V>
 */
public class HashTable<K, V> {

    private final ArrayList<HashList<K, V>> collection;
    private int size;
    
    public HashTable(int size) {
        this.size = size;
        collection = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            collection.add(new HashList());
        }
    }
    
    private int hash(K key){
        return (int)key % size;
    }
    
    public void add(K key, V value){
        int index = this.hash(key);
        collection.get(index).add(key, value);
    }
    
     public V valueOf(K key){
         return collection.get(this.hash(key)).get(key);
     }
     
     public V remove(K key){
         return collection.get(this.hash(key)).remove(key);
     }
     
     
     public static void main(String[] args) {
        HashTable<Integer, String> a = new HashTable(7);
        a.add(14, "uno");
        a.add(34, "tres");
        a.add(27, "dos");
         System.out.println(a.valueOf(34));
         System.out.println(a.valueOf(14));
         System.out.println(a.valueOf(27));
         a.remove(14);
         System.out.println(a.valueOf(14));
    }
}
