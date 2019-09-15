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
public class Queue implements QueueInterface {

    //class constants
    public static final int DEFAULT_CAPACITY = 11;

    //instance variables
    private String[] queue;
    private int head;
    private int tail;

    //constructors
    public Queue(int capacity) {
        
        this.queue = new String[capacity]; //sets size of queue array to the capacity
        //sets head and tail indexes to -1 because the queue has nothing in it so it has no head or tail
        this.head = -1;
        this.tail = -1;
        
    }

    public Queue() { //makes queue with default capacity

        this(DEFAULT_CAPACITY);

    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty.
     *
     * @return the head of this queue.
     */
    public String head() {
        
        //if queue is not empty, return the value at the head index
        if (!this.isEmpty()) {
            return this.queue[this.head];
        }
        return null;
    }

    /**
     * Retrieves, but does not remove, the tail of this queue, or returns null
     * if this queue is empty.
     *
     * @return the tail of this queue.
     */
    public String tail() {
        
        //if queue is not empty, return the value at the tail index
        if (!this.isEmpty()) {
            return this.queue[this.tail];
        }

        return null;
    }

    /**
     * Inserts the String into this queue, if space is available.
     *
     * @param value
     */
    public void enqueue(String value) {

        if (isFull()) {
            System.out.println("Queue is full.");
        } else {
            
            if (this.size() == 0) { //is size = 0, set head index to 0, so queue[0] is the tail AND head
                this.head = 0;
            }
            
            this.tail = (this.tail + 1) % this.capacity(); //add one to tail and % capacity so index is not out of bounds
            this.queue[this.tail] = value; //set the tail of the queue to the value
            
        }
    }

    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of this queue.
     */
    public String dequeue() {
        
        int head = this.head;
        
        if (this.isEmpty()) {
            return null;
        }
        
        else if (this.size() == 1) { //if the queue has only one value, just empty the queue
            
            this.makeEmpty();
            return this.queue[head];
        
        } 
        
        //set head to head + 1 (and wrap it around if it is at the last index of the queue)
        this.head = (this.head + 1) % this.capacity();
        return this.queue[head]; //return the value that got dequeued

    }

    /**
     * @return the number of Strings in the Queue.
     *
     */
    public int size() {

        if (this.head == -1) { //head and tail are only -1 when queue is empty
            return 0;
        } 
        
        else if (this.head == this.tail) { //when head and tail are same, there is only one value in queue
            return 1;
        } 
        
        else if (this.tail > this.head) { //if tail > head, get the difference between head and tail inclusive
            return this.tail - this.head + 1;
        }
        
        //otherwise, get the difference between the head and the end of the array and add it to the tail
        return this.capacity() - this.head + this.tail + 1;

    }

    /**
     * Returns the current capacity of the Queue.
     *
     * @return
     */
    public int capacity() {

        return this.queue.length;

    }

    /**
     * Tests if this Queue is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }

        return false;
    }

    /**
     * Tests if the Queue is full.
     *
     * @return
     */
    public boolean isFull() {

        if (size() == this.capacity()) {
            return true;
        }

        return false;
    }

    /**
     * The Queue will be empty after this call returns.
     */
    public void makeEmpty() {
        this.head = -1;
        this.tail = -1;
        
    }

    /**
     * Returns the queue as a string (from head to tail).
     */
    public String toString() {

        String s = "";
        
        if (this.isEmpty()) {
            
        }
        
        else if (this.head < this.tail) {
            
            for (int i = this.head; i <= this.tail; i++) {
                s += this.queue[i] + " ";
            }
            
        }
        
        else if (this.head > this.tail) {
            
            for (int i = this.head; i < this.capacity(); i++) {
                s += this.queue[i] + " ";
            }
            
            for (int i = 0; i <= this.tail; i++) {
                s += this.queue[i] + " ";
            }
            
        }
        
        else {
            
            s = this.head();
            
        }
        
        return s;
    }

}
