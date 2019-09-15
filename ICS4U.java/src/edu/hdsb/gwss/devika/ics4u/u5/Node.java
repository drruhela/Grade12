/**
 * Node.
 *
 * @author Wm.Muir
 * @version 2018-19.S2
 */
package edu.hdsb.gwss.devika.ics4u.u5;

/**
 * TODO
 */
public class Node implements NodeInterface{
    
    //instance variables
    private Node nextNode;
    private String value;
    
    //constructors
    public Node( String value ) { //creates a node object with a string value and a pointer to the next node
        
        this.value = value;
        this.nextNode = null;
        
    }
    
    public Node() { //uses the previous constructor to make a node object with an empty string value
        
        this ("");
        
    }
    
    
    /**
     * The node pointed to by 'next' is returned
     */
    public Node getNext() {
        
        return this.nextNode;
        
    }

    /**
     * The node pointed to by 'next' is changed to newNode
     */
    public void setNext( Node newNode ) {
        
        this.nextNode = newNode;
        
    }

    /**
     * The value (data) of the node.
     */
    public String getValue() {
        
        return this.value;
        
    }
    
}
