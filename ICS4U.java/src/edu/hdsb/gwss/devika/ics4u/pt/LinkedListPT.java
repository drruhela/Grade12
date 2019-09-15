/**
 * Linked List of Students
 *
 * @version v2019.S2
 */
package edu.hdsb.gwss.devika.ics4u.pt;

public class LinkedListPT {

    private NodePT head;
    private NodePT tail;

    /**
     * Constructor: Empty Linked List
     */
    public LinkedListPT() {
        this.head = null;
        this.tail = null;
    }

    /**
     * @return returns the size (# of students) in the linked list.
     */
    public int size() {

        if (this.head == null) { //if head is null, the list is empty

            return 0;

        }

        //starting at the head, all the nodes will be counted until you get to the tail
        int counter = 1;
        NodePT node = this.head;
        while (node.getNext() != null) {
            counter++;
            node = node.getNext();
        }

        return counter;

    }

    /**
     * This method makes the linked list empty.
     */
    public void makeEmpty() {

        //if tail and head are null, nothing is linked to them so the list is empty
        this.tail = null;
        this.head = null;

    }

    /**
     * This method returns true if the linked list is empty
     *
     * @return returns true if there are no student objects in the linked list
     */
    public boolean isEmpty() {

        if (this.size() == 0) {

            return true;

        }

        return false;

    }

    /**
     * This method adds a student object to the end of the linked list.
     *
     * @param student
     */
    public void addAtEnd(CSStudent student) {

        if (student != null) { //if string is not null

            CSStudent value = student;
            NodePT newNode = new NodePT(value);

            if (this.isEmpty()) { //if empty, this node will be both the tail AND head

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
     * This method will get a student object from the linked list, given the
     * student number
     *
     * @param key student number (key)
     * @return returns the student object for the given key, or null if it
     * doesn't exist.
     */
    public CSStudent get(int key) {

        if (!this.isEmpty()) {

            if (this.head.getData().getKey() == key) {
                return this.head.getData();
            } 
            
            else if (this.tail.getData().getKey() == key) {
                return this.tail.getData();
            }

            NodePT node = this.head;
            while (node.getNext() != null && node.getNext().getData().getKey() != key) {

                node = node.getNext();

            }

            if (node != this.tail) { //if the loop ended before getting to the end, the node is found

                return node.getNext().getData();

            }

            return null;

        }

        return null;
    }

    /**
     * This method will remove a student object from the linked list, given the
     * student number.
     *
     * @param key student number (key)
     * @return returns the removed student object, or null if the key is not
     * found
     */
    public CSStudent remove(int key) {

        if (!this.isEmpty()) { //if not empty

            NodePT toDelete = null;

            if (this.size() == 1) {

                if (this.head.getData().getKey() == key) {
                    
                    toDelete = this.head;
                    this.makeEmpty();
                    return toDelete.getData();
                    
                }

                return null;

            } 
            
            else if (this.head.getData().getKey() == key) {

                toDelete = this.head;

                this.head = this.head.getNext(); //set the head to the node after the current head
                toDelete.setNext(null); //set the pointer from the old head to null so it is not attached to the list anymore

                return toDelete.getData(); //return the CSStudent that got removed

            } 
            
            else if (this.tail.getData().getKey() == key) {

                toDelete = this.tail;

                //starting at the head, loop until node = the node before the tail
                NodePT node = this.head;
                while (node.getNext() != this.tail) {

                    node = node.getNext();

                }

                node.setNext(null); //set the pointer for the node before the tail to null so the tail is not attached to the list anymore
                this.tail = node; //make the previous node the new tail

                return toDelete.getData();

            }
            
            //starting at the head, loop through the list until the end is reached or the node has been found
            NodePT node = this.head;
            while (node.getNext() != null && node.getNext().getData().getKey() != key) {
                node = node.getNext();
            }

            if (node != this.tail) { //if the loop ended before getting to the end, the node is found

                toDelete = node.getNext(); //this is the node that needs to be removed
                node.setNext(node.getNext().getNext()); //set the node before toDelete to toDelete.getNext()

                toDelete.setNext(null); //set the pointer from toDelete to null so it is not attached to the list anymore
                
                return toDelete.getData();
            }
            
            return null;

        }
        
        return null;

    }

    /**
     * DONE FOR YOU
     */
    @Override
    public String toString() {
        return "HEAD: " + toString(this.head);
    }

    /**
     * DONE FOR YOU
     */
    private String toString(NodePT n) {
        String s = "";
        if (n != null) {
            s = n.getData() + " --> " + this.toString(n.getNext());
        }
        return s;
    }

}
