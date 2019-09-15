/**
 * Linked List Interface
 *
 * @author Wm.Muir
 * @version 2018-19.S2
 */
package edu.hdsb.gwss.devika.ics4u.u5;

public interface LinkedListInterface {

    /**
     * Adds the String to the front of the linked list.
     *
     * @param str
     */
    public void addAtFront( String str );

    /**
     * Adds the String to the end of the linked list.
     *
     * @param str
     */
    public void addAtEnd( String str );

    /**
     * Removes the first occurrence of the given string.
     *
     * @param str
     */
    public void remove( String str );

    public String removeHead();

    public String removeTail();

    /**
     * Retrieves, but does not remove, the head of this Linked List, or returns
     * null if this Linked List is empty.
     */
    public String head();

    /**
     * Retrieves, but does not remove, the tail of this Linked List, or returns
     * null if this Linked List is empty.
     */
    public String tail();

    /**
     * Returns the number of Strings in the Linked List.
     *
     * @return
     */
    public int size();

    /**
     * Returns the current capacity of the Linked List.
     *
     * @return
     */
    public int capacity();

    /**
     * Tests if this Linked List is empty.
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * Tests if the Linked List is full.
     *
     * @return
     */
    public boolean isFull();

    /**
     * The Linked List will be empty after this call returns.
     */
    public void makeEmpty();

    /**
     * Creates a String that lists the nodes of the linked list.
     *
     * Head --> A --> B -- > C --> Tail
     *
     * @return string
     */
    @Override
    public String toString();

}
