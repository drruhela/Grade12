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
public class LinkedList implements LinkedListInterface {
    
    /**
     * Adds the String to the front of the linked list.
     *
     * @param str
     */
    
    //instance variables
    private Node head;
    private Node tail;
    
    //no constructor because default constructor will be used
    
    /**
     * Adds the String to the front of the linked list.
     *
     * @param str
     */
    public void addAtFront( String str ) {
        
        if (str != null) { //adds the string if it is not null
            
            String value = str;
            Node newNode = new Node(value); //makes a new node for the value

            if (isEmpty()) { //if empty, this node will be the head AND tail so it will point to null

                newNode.setNext(null); //points to nothing cuz it is the end of the list
                this.tail = newNode;

            } else {
                //add this to front and point to the previous head
                newNode.setNext(this.head);

            }

            this.head = newNode; //this node is the head now
        }
        
    }

    /**
     * Adds the String to the end of the linked list.
     *
     * @param str
     */
    public void addAtEnd( String str ) {
        
        if (str != null) { //if string is not null
            
            String value = str;
            Node newNode = new Node(value);

            if ( this.isEmpty() )  { //if empty, this node will be both the tail AND head

                newNode.setNext(null);
                this.head = newNode;

            } else {
                
                //add this to the end and set the pointer to null cuz it's the end
                newNode.setNext(null);
                this.tail.setNext(newNode); //set the pointer of the previous tail to this
            }

            this.tail = newNode; //set the tail to this
        }
        
    }

    /**
     * Removes the first occurrence of the given string.
     *
     * @param str
     */
    public void remove( String str ) {
        
        if (!this.isEmpty()) { //if not empty
            
            if (this.head.getValue().equals(str)) { //if the value is at the head, remove the head

                this.removeHead();

            }

            else if (this.tail.getValue().equals(str)) { //if the value is at the tail, remove the tail

                this.removeTail();

            }

            else {
                
                //starting at the head, loop through the list until the end is reached or the node has been found
                Node node = this.head;
                while ( node.getNext() != null && !node.getNext().getValue().equals(str)) {
                    
                    node = node.getNext();

                }

                if ( node != this.tail ) { //if the loop ended before getting to the end, the node is found
                    
                    Node toDelete = node.getNext(); //this is the node that needs to be removed
                    node.setNext(node.getNext().getNext()); //set the node before toDelete to toDelete.getNext()

                    toDelete.setNext(null); //set the pointer from toDelete to null so it is not attached to the list anymore
                    
                } else { //if the loop reached the last node (the tail), it is not in the list
                    System.out.println("Node not found.");
                }

            }
        } else {
            System.out.println("Node not found.");
        }
    }

    public String removeHead() {
        
        if (!this.isEmpty()) { //if list is not empty
            
            Node toDelete = this.head;
            
            if ( this.size() != 1) { // if size > 1
                this.head = this.head.getNext(); //set the head to the node after the current head
                toDelete.setNext(null); //set the pointer from the old head to null so it is not attached to the list anymore
                
            } else {
                this.makeEmpty(); //if only one value in list, empty the list
            }
            
            return toDelete.getValue(); //return the value of the string that got removed
        }
        
        return null; //if empty, nothing can be removed so return null
    }

    public String removeTail() {
        
        if ( !this.isEmpty() ) { //if list is not empty
            
            Node toDelete = this.tail;
            
            if (this.size() != 1) { //if the size > 1
                
                //starting at the head, loop until node = the node before the tail
                Node node = this.head;
                while (node.getNext() != this.tail) {

                    node = node.getNext();

                }
                
                node.setNext(null); //set the pointer for the node before the tail to null so the tail is not attached to the list anymore
                this.tail = node; //make the previous node the new tail
                
            } else {
                this.makeEmpty(); //if only one value in list, empty the list
            }
            
            return toDelete.getValue(); //return the value of the string that got removed
        }
        
        return null; //if empty, nothing can be removed so return null
        
    }

    /**
     * Retrieves, but does not remove, the head of this Linked List, or returns
     * null if this Linked List is empty.
     */
    public String head() {
        
        if ( this.isEmpty() ) { //if list is empty, head doesn't exist so it is null
            
            return null;
            
        } else {
            
            return this.head.getValue(); //return the string value of the head node
            
        }
        
        
    }

    /**
     * Retrieves, but does not remove, the tail of this Linked List, or returns
     * null if this Linked List is empty.
     */
    public String tail() {
        
        if ( this.isEmpty() ) { //if list is empty, tail doesn't exist so it is null
            
            return null;
            
        } else {
            
            return this.tail.getValue(); //return the string value of the tail node
            
        }
        
    }

    /**
     * Returns the number of Strings in the Linked List.
     *
     * @return
     */
    public int size() {
        
        if (this.head == null) { //if head is null, the list is empty
            
            return 0;
            
        }
        
        //starting at the head, all the nodes will be counted until you get to the tail
        int counter = 1;
        Node node = this.head;
        while ( node.getNext() != null ) {
            counter++;
            node = node.getNext();
        }
        
        return counter;
    }

    /**
     * Returns the current capacity of the Linked List.
     *
     * @return
     */
    public int capacity() { 
        // there is no max capacity to the list so the max integer value is returned
        return Integer.MAX_VALUE;
        
    }

    /**
     * Tests if this Linked List is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        
        if (this.size() == 0) {
            
            return true;
            
        }
        
        return false;
    }

    /**
     * Tests if the Linked List is full.
     *
     * @return
     */
    public boolean isFull() {
        
        return false;
        
    }

    /**
     * The Linked List will be empty after this call returns.
     */
    public void makeEmpty() {
        
        //if tail and head are null, nothing is linked to them so the list is empty
        this.tail = null;
        this.head = null;
        
    }

    /**
     * Creates a String that lists the nodes of the linked list.
     *
     * Head --> A --> B -- > C --> Tail
     *
     * @return string
     */
    @Override
    public String toString() {
        
        String s = "";
        
        if (this.isEmpty()) { //if empty, the string is null
            s = null;
        }
        
        else if (this.size() == 1) { //if the size is 1, s = head
            
            s = this.head.getValue();
            
        }
        
        else {
            
            //starting at the head, the loop will add all the nodes' values to s except the tail
            Node node = this.head;
            while (node.getNext() != null) {
                
                s = s + node.getValue() + " ";
                node = node.getNext();
            
            }
            
            s = s + this.tail.getValue(); //add the tail value to s
            
        }
        return s;
        
    }
    
}
