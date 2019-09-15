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
public class LinkedListClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList list = new LinkedList();
        
        //Empty
        System.out.println("Test: Empty");
        System.out.println(list.toString());
        assert(list.capacity() == Integer.MAX_VALUE);
        assert(list.size() == 0);
        assert(list.head() == null);
        assert(list.tail() == null);
        assert(list.isEmpty() == true);
        assert(list.isFull() == false);
        assert(list.removeHead() == null);
        assert(list.removeTail() == null);
        list.remove("a");
        System.out.println("Passed \n");
        
        //one node
        list.addAtFront("a");
        System.out.println("Test: One node");
        System.out.println(list.toString());
        assert(list.capacity() == Integer.MAX_VALUE);
        assert(list.size() == 1);
        assert(list.head().equals("a"));
        assert(list.tail().equals("a"));
        assert(list.isEmpty() == false);
        assert(list.isFull() == false);
        assert(list.removeHead().equals("a"));
        assert(list.removeTail() == null);
        System.out.println("Passed \n");
        
        //bunch of nodes
        for (int i = 0; i < 26; i++) {
            list.addAtEnd( "" + (char) ('a' + i) );
        }
        
        System.out.println("Test: Multiple Nodes");
        System.out.println(list.toString());
        assert(list.capacity() == Integer.MAX_VALUE);
        assert(list.size() == 26);
        assert(list.head().equals("a"));
        assert(list.tail().equals("z"));
        assert(list.isEmpty() == false);
        assert(list.isFull() == false);
        assert(list.removeHead().equals("a"));
        assert(list.removeTail().equals("z"));
        System.out.println("Passed \n");
        
        list.addAtFront("a");
        list.addAtEnd("z");
        
        //removing a node from the middle (c)
        System.out.println("Test: Removing a node from the middle.");
        list.remove("c");
        System.out.println(list.toString());
        System.out.println("Passed \n");
        
        //trying to remove a node that isn't in list
        System.out.println("Test: Removing nonexistent node");
        list.remove("-");
        System.out.println(list.toString());
        System.out.println("Passed \n");
        
        //empty again
        list.makeEmpty();
        System.out.println("Test: Empty again");
        System.out.println(list.toString());
        assert(list.capacity() == Integer.MAX_VALUE);
        assert(list.size() == 0);
        assert(list.head() == null);
        assert(list.tail() == null);
        assert(list.isEmpty() == true);
        assert(list.isFull() == false);
        assert(list.removeHead() == null);
        assert(list.removeTail() == null);
        System.out.println("Passed \n");
        
    }
    
    
    
}
