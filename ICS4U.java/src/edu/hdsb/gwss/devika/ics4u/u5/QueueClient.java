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
public class QueueClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Queue q = new Queue(8);
        
        //Empty queue
        System.out.println("Test: Empty");
        System.out.println(q.toString());
        assert( q.capacity() == 8);
        assert( q.size() == 0);
        assert( q.isEmpty() == true);
        assert( q.isFull() == false);
        assert( q.head() == null);
        assert( q.tail() == null);
        assert( q.dequeue() == null);
        System.out.println("Passed \n");
        
        //One item in queue
        System.out.println("Test: One Item");
        q.enqueue("a");
        System.out.println(q.toString());
        assert( q.capacity() == 8);
        assert( q.size() == 1);
        assert( q.isEmpty() == false);
        assert( q.isFull() == false);
        assert( q.head().equals("a"));
        assert( q.tail().equals("a"));
        assert( q.dequeue().equals("a"));
        System.out.println(q.toString());
        System.out.println("Passed \n");
        
        //a few items in queue
        for( int i = 0; i < 5; i++ ) {
            q.enqueue( "" + (char)( 'a' + i) );
        }
        System.out.println("Test: A few items in queue");
        System.out.println(q.toString());
        assert( q.capacity() == 8);
        assert( q.size() == 5);
        assert( q.isEmpty() == false);
        assert( q.isFull() == false);
        assert( q.head().equals("a"));
        assert( q.tail().equals("e"));
        assert( q.dequeue().equals("a"));
        System.out.println(q.toString());
        System.out.println("Passed \n");
        
        q.makeEmpty();
        
        //full list
        for( int i = 0; i < q.capacity(); i++ ) {
            q.enqueue( "" + (char)( 'a' + i) );
        }
        System.out.println("Test: Full queue");
        System.out.println(q.toString());
        assert( q.capacity() == 8);
        assert( q.size() == 8);
        assert( q.isEmpty() == false);
        assert( q.isFull() == true);
        assert( q.head().equals("a"));
        assert( q.tail().equals("h"));
        assert( q.dequeue().equals("a"));
        System.out.println(q.toString());
        System.out.println("Passed \n");
        
        q.enqueue("i");
        
        //overfill
        System.out.println("Test: Overfill");
        System.out.println(q.toString());
        String before = q.toString();
        q.enqueue("j");
        String after = q.toString();
        assert( before.equals(after) );
        System.out.println(q.toString());
        System.out.println("Passed \n");
        
        
        //empty again
        System.out.println("Test: Empty again");
        q.makeEmpty();
        System.out.println(q.toString());
        assert( q.capacity() == 8);
        assert( q.size() == 0);
        assert( q.isEmpty() == true);
        assert( q.isFull() == false);
        assert( q.head() == null);
        assert( q.tail() == null);
        assert( q.dequeue() == null);
        System.out.println("Passed \n");
        
    }
    
}
