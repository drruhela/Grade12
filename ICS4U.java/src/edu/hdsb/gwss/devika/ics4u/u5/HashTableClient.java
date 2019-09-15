/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u5;

/**
 *
 * @author drruh
 */
public class HashTableClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HashTable table = new HashTable(6);
        
        Student a = new Student("a", "a", "010101"); //100000, 5
        Student b = new Student("b", "b", "010201"); //100003, 1
        Student c = new Student("c", "c", "010301"); //100006, 4
        Student d = new Student("d", "d", "010401"); //100009, 0
        Student e = new Student("e", "e", "010501"); //100012, 3
        Student f = new Student("f", "f", "010601"); //100015, 6
        Student g = new Student("g", "g", "010701"); //100018, 2
        Student h = new Student("h", "h", "010801"); //100021, 5

        //Assertions
        
        //Testing Empty Hash table
        System.out.println("Test: Empty Table");
        System.out.println(table.toString());
        assert( table.capacity() == 7);
        assert( table.isEmpty() == true);
        assert( table.size() == 0);
        assert( table.loadFactor() == 0);
        assert( table.contains(a) == false);
        assert( table.containsKey(a.getId()) == false);
        assert( table.get( a.getId()) == null);
        System.out.println("Passed \n");
        
        //Testing Hash values of Students
        assert( table.hash(a.getId()) == 5);
        assert( table.hash(b.getId()) == 1);
        assert( table.hash(c.getId()) == 4);
        assert( table.hash(d.getId()) == 0);
        assert( table.hash(e.getId()) == 3);
        assert( table.hash(f.getId()) == 6);
        assert( table.hash(g.getId()) == 2);
        assert( table.hash(h.getId()) == 5);
        System.out.println("Passed \n");
        
        //Testing with one student in table
        System.out.println("Testing: One Student in Table");
        table.put(a.getId(), a);
        System.out.println(table.toString());
        assert( table.capacity() == 7);
        assert( table.isEmpty() == false);
        assert( table.size() == 1);
        assert( table.loadFactor() == 1.0/7);
        assert( table.contains(a) == true);
        assert( table.containsKey(a.getId()) == true);
        assert( table.get( a.getId()).equals(a));
        System.out.println("Passed \n");
        
        //Testing with multiple students in table (loadfactor < 75%)
        System.out.println("Testing: Multiple Students (Loadfactor < 75%)");
        table.put(a.getId(), a);
        table.put(b.getId(), b);
        table.put(c.getId(), c);
        table.put(d.getId(), d);
        table.put(h.getId(), h); //same hash as a so linear probing will happen
        System.out.println(table.toString());
        assert( table.capacity() == 7);
        assert( table.isEmpty() == false);
        assert( table.size() == 5);
        assert( table.loadFactor() == 5.0/7);
        assert( table.contains(h) == true);
        assert( table.containsKey(h.getId()) == true);
        assert( table.get( h.getId()).equals(h));
        System.out.println("Passed \n");
        
        //Testing with multiple students in table (loadfactor > 75%)
        System.out.println("Testing: Multiple Students (Loadfactor > 75%)");
        table.put(e.getId(), e);
        table.put(f.getId(), f);
        table.put(g.getId(), g);
        System.out.println(table.toString());
        assert( table.capacity() == 29); // 6/7 > .75, so newCapacity = 6 * 4 = 24; nearest prime = 29
        assert( table.isEmpty() == false);
        assert( table.size() == 8);
        assert( table.loadFactor() == 8.0/29);
        assert( table.contains(g) == true);
        assert( table.containsKey(g.getId()) == true);
        assert( table.get( g.getId()).equals(g));
        System.out.println("Passed \n");
        
        //Testing empty again
        System.out.println("Testing: Empty again");
        table.makeEmpty();
        System.out.println(table.toString());
        assert( table.capacity() == 29);
        assert( table.isEmpty() == true);
        assert( table.size() == 0);
        assert( table.loadFactor() == 0);
        assert( table.contains(a) == false);
        assert( table.containsKey(a.getId()) == false);
        assert( table.get( a.getId()) == null);
        System.out.println("Passed \n");
    }
    
}
