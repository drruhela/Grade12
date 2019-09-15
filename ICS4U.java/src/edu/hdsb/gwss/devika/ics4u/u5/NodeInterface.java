/**
 * Node Interface.
 *
 * @author Wm.Muir
 * @version 2018-19.S2
 */
package edu.hdsb.gwss.devika.ics4u.u5;

public interface NodeInterface {

    /**
     * The node pointed to by 'next' is returned
     */
    public Node getNext();

    /**
     * The node pointed to by 'next' is changed to newNode
     */
    public void setNext( Node newNode );

    /**
     * The value (data) of the node.
     */
    public String getValue();

}
