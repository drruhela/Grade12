/**
 * (Closed) hash table Interface
 *
 * @author Wm.Muir
 * @version 2018-19.S2
 */
package edu.hdsb.gwss.devika.ics4u.u5;

public interface HashTableInterface {

    /**
     * @return Returns the number of keys in this hash table.
     */
    public int size();

    /**
     * @return The load factor of the hash table.
     */
    public double loadFactor();

    /**
     * Clears this hash table so that it contains no keys.
     */
    public void makeEmpty();

    /**
     * Tests if this hash table maps no keys to values.
     */
    public boolean isEmpty();

    /**
     * Increases the capacity of and internally reorganizes this hash table, in
     * order to accommodate and access its entries more efficiently.
     */
    public void rehash();

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * @param key
     * @return
     */
    public Student get( int key );

    /**
     * Maps the specified key to the specified value in this hash table. Neither
     * the key nor the value can be null.
     *
     * @param key
     * @param value
     */
    public void put( int key, Student value );

    /**
     * Tests if a SECONDARY KEY of the value maps into the specified value in this hash table. 
     * This operation is more expensive than the containsKey method.
     * SECONDARY KEY:  First Name, Last Name, DOB
     * 
     * @param value
     * @return
     */
    public boolean contains( Student value );

    /**
     * Tests if the specified object is a key in this hash table.
     *
     * @param key
     * @return
     */
    public boolean containsKey( int key );

    /**
     *
     * @param key
     * @return
     */
    public int hash( int key );

}
