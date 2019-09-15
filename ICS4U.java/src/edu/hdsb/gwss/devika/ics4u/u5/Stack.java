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
public class Stack implements StackInterface {
    
    //class constants
    public static final int DEFAULT_CAPACITY = 11;
    
    //class variables
    
    //object variables
    private int capacity;
    private int top;
    private String[] stack;
    
    //constructors
    public Stack(int capacity) { //creates a stack object with the given capacity
        
        this.capacity = capacity;
        this.top = -1; //sets the top index to -1 because the stack is empty
        this.stack = new String[this.capacity]; //creates the stack array with size of the given capacity
        
    } 
    
    public Stack() { //makes stack with default capacity
        this (DEFAULT_CAPACITY);
    }
    
    /**
     * @return the peak, or top value of the stack.
     */
    public String peak() {
        
        if (!isEmpty()) { //if stack is not empty, return the top value
            return this.stack[this.top];
        }
        
        return null; //if empty, return null
    }

    /**
     * Removes the top value from the stack.
     * @return the value that got removed
     */
    public String pop() {
        
        if (!isEmpty()) { //if not empty,remove top value
            this.top -= 1; //set the top index to the one below the current top
            return this.stack[top+1]; //return the value that just got popped
        }
        
        return null;
        
    }

    /**
     * Adds a value to the top of the stack.
     */
    public void push( String value ) {
        
        if (!isFull()) { //if the stack has space
            
            if (value != null) { //add the value if it is not null
                this.top += 1; //increase the top index
                this.stack[this.top] = value; //make this the new top value (the peak)
            } else {
                System.out.println("Cannot push null value.");
            }
            
        } else {
            System.out.println("Stack is full. Cannot push anything.");
        }
        
    }

    /**
     * @return The size of the stack.
     */
    public int size() {
        return this.top + 1;
    }

    /**
     * @return The capacity of the stack.
     */
    public int capacity() {
        return this.capacity;
    }

    /**
     * Checks if the stack is empty.
     * @return true or false if empty or not.
     */
    public boolean isEmpty() {
        if ( this.size() == 0 ) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the stack is full.
     * @return true or false if full or not.
     */
    public boolean isFull() {
        
        if (this.size() == this.capacity) {
            return true;
        }
        
        return false;
    
    }

    /**
     * Makes the stack empty.
     */
    public void makeEmpty() {
        
        this.top = -1;
        
    }
    
    /**
     * @return The stack as a string.
     */
    public String toString() {
        
        String s = "";
        
        if ( this.isEmpty() ) { //if empty, don't add anything to s
            
        }
        
        else if ( this.size() == 1) {
            s = this.peak();
        }
        
        else {
            
            for (int i = this.top; i >= 0; i--) { //adds each value to s, starting at the top
                s = s + this.stack[i] + " ";
            }
            
        }
        
        return s;
    }
}
