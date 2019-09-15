/**
 * Queue Interface.
 *
 * @author Wm.Muir
 * @version 2018-19.S2
 */
package edu.hdsb.gwss.devika.ics4u.u5;

public interface QueueInterface {
    
    /**
     * Retrieves, but does not remove, the head of this queue, or returns null 
     * if this queue is empty.
     * 
     * @return the head of this queue.
     */
    public String head();
    
    /**
     * Retrieves, but does not remove, the tail of this queue, or returns null 
     * if this queue is empty.
     * 
     * @return the head of this queue.
     */
    public String tail();
       
    /**
     * Inserts the String into this queue, if space is available.
     * @param value 
     */
    public void enqueue( String value );

    /**
     * Retrieves and removes the head of this queue.
     * @return the head of this queue.
     */
    public String dequeue();

    /**
     * Returns the number of Strings in the Queue.
     *
     * @return
     */
    public int size();

    /**
     * Returns the current capacity of the Queue.
     *
     * @return
     */
    public int capacity();

    /**
     * Tests if this Queue is empty.
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * Tests if the Queue is full.
     *
     * @return
     */
    public boolean isFull();

    /**
     * The Queue will be empty after this call returns.
     */
    public void makeEmpty();

}
