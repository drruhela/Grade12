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
public class StackClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Stack stack = new Stack(10);
        
        //empty
        System.out.println("Test: Empty");
        System.out.println(stack.toString());
        assert( stack.capacity() == 10);
        assert( stack.size() == 0);
        assert( stack.isEmpty() == true);
        assert( stack.isFull() == false);
        assert( stack.peak() == null);
        assert( stack.pop() == null);
        System.out.println("Passed \n");
        
        //one item
        stack.push("a");
        System.out.println("Test: One Item");
        System.out.println(stack.toString());
        assert( stack.capacity() == 10);
        assert( stack.size() == 1);
        assert( stack.isEmpty() == false);
        assert( stack.isFull() == false);
        assert( stack.peak().equals("a"));
        assert( stack.pop().equals("a"));
        System.out.println(stack.toString());
        System.out.println("Passed \n");
        
        //multiple items
        for( int i = 0; i < 5; i++ ) {
            stack.push( "" + (char)( 'a' + i) );
        }
        System.out.println("Test: Multiple Items");
        System.out.println(stack.toString());
        assert( stack.capacity() == 10);
        assert( stack.size() == 5);
        assert( stack.isEmpty() == false);
        assert( stack.isFull() == false);
        assert( stack.peak().equals("e"));
        assert( stack.pop().equals("e"));
        System.out.println(stack.toString());
        System.out.println("Passed \n");
        
        //full stack
        for (int i = 4; i < stack.capacity(); i++) {
            stack.push( "" + (char)( 'a' + i) );
        }
        System.out.println("Test: Full Stack");
        System.out.println(stack.toString());
        assert( stack.capacity() == 10);
        assert( stack.size() == 10);
        assert( stack.isEmpty() == false);
        assert( stack.isFull() == true);
        assert( stack.peak().equals("j"));
        System.out.println("Passed \n");
        
        //overfill
        System.out.println("Test: Overfill");
        stack.push("k");
        System.out.println(stack.toString());
        assert( stack.capacity() == 10);
        assert( stack.size() == 10);
        assert( stack.isEmpty() == false);
        assert( stack.isFull() == true);
        assert( stack.peak().equals("j"));
        System.out.println("Passed \n");
        
        //empty again
        stack.makeEmpty();
        System.out.println("Test: Empty again");
        System.out.println(stack.toString());
        assert( stack.capacity() == 10);
        assert( stack.size() == 0);
        assert( stack.isEmpty() == true);
        assert( stack.isFull() == false);
        assert( stack.peak() == null);
        assert( stack.pop() == null);
        System.out.println("Passed \n");
        
    }
    
}
