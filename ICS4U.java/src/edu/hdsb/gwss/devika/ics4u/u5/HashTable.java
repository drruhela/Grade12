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
public class HashTable implements HashTableInterface {

    /**
     * @return Returns the number of keys in this hash table.
     */
    //class constants
    public static final int DEFUALT_CAPACITY = 50;

    //object variables
    private Student[] table;
    private int capacity;

    //constructors
    public HashTable(int capacity) {
        
        if ( !this.isPrime(capacity)) { //if the capacity is not a prime number, get the next prime number
            capacity = this.getNextPrime(capacity);
        }
        
        this.capacity = capacity;
        this.table = new Student[this.capacity]; //make an empty hash table with the given capacity
    }

    public HashTable() {

        this(DEFUALT_CAPACITY); //calls previous constructor to make HashTable with default capacity (50)
    }

    /**
     * @return If the number is prime or not.
     */
    private boolean isPrime(int number) {

        if (number <= 3) { //if less than 3, the number is prime
            return true;
        }
        
        else if (number % 2 == 0 || number % 3 == 0) { //if number is divisible by 2 or 3, it's not prime
            return false;
        }
        
        //6k+-1 primality test algorithm from wikipedia
        int i = 5;
        while ( (i * i) <= number) {
            
            if ( number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
            
            i += 6;
            
        }
        
        return true;
        
    }
    
    /**
     * @return The next prime number.
     */

    private int getNextPrime(int number) {

        if (number % 2 == 0) { //if number is even, make it odd before looking for the next prime
            number += 1;
        }
        
        while ( !this.isPrime(number)) { //check every other number to see if its prime
            number += 2;
        }
        
        return number;
        
    }
    
    /**
     * @return The size of the hash table.
     */
    public int size() {
        
        int size = 0;
        //loops through the array and adds one to size if the there is something at that index
        for (int index = 0; index < this.table.length; index++) {
            
            if ( this.table[index] != null ) {
                size += 1;
            }
        }
        
        return size;
        
    }

    /**
     * @return The load factor of the hash table.
     */
    public double loadFactor() {
        
        //returns how much of the table is full
        return this.size() / (this.capacity * 1.0);
        
    }

    /**
     * Clears this hash table so that it contains no keys.
     */
    public void makeEmpty() {
        
        //loops through the array and makes every item in the table null if it isn't already
        for (int index = 0; index < this.table.length; index++) {
            
            if (this.table[index] != null) {
                this.table[index] = null;
            }
            
        }
        
    }

    /**
     * Tests if this hash table maps no keys to values.
     */
    public boolean isEmpty() {
        
        //if array size is 0, it is empty
        if (this.size() == 0) {
            return true;
        }
        
        return false;
    }

    /**
     * Increases the capacity of and internally reorganizes this hash table, in
     * order to accommodate and access its entries more efficiently.
     */
    public void rehash() {
        
        int newCapacity = this.size() * 4; //this will make the load factor 25%
        
        if ( !this.isPrime(newCapacity) ) {  //make sure the capacity is a prime number
            newCapacity = this.getNextPrime(newCapacity);
        }
        
        Student[] tempTable = this.table; //make a temporary table equal to the old table to transfer values from
        
        this.capacity = newCapacity;
        this.table = new Student[this.capacity]; //make a new empty table with the new capacity
        
        //find new hash values for each non-null value in the old array and put them in the new array
        for (int index = 0; index < tempTable.length; index++) {
            
            if (tempTable[index] != null) {
                
                Student student = tempTable[index];
                int key = student.getId();
                this.put(key, student);
                
            }
            
        }
        
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * @param key
     * @return
     */
    public Student get(int key) {
        
        int initialIndex = this.hash(key);
        
        //starting at the hash value, the loop looks for the key until an empty space is found (meaning the key is not in table)
        int index = initialIndex;
        while (this.table[index] != null && this.table[index].getId() != key) {
            index += 1;
        }
        
        return this.table[index];
        
    }

    /**
     * Maps the specified key to the specified value in this hash table. Neither
     * the key nor the value can be null.
     *
     * @param key
     * @param value
     */
    public void put(int key, Student value) {

        if (value.isValid() && !this.contains(value)) {
            
            double lf = this.loadFactor(); //gets the loadfactor before putting value in

            int collisions = 0;
            int index = this.hash(key); //gets the hash value of the key
            
            if (this.table[index] == null) { //if table[hash] is empty, but the student there
                this.table[index] = value;
            } else { //look for the next empty spot following the hash index

                //linear probing - loop until an empty index is found to put the value in
                while ( this.table[index%this.capacity] != null) {
                    
                    index += 1;
                    index = index % this.capacity; //puts the index back to the beginning of the array when it gets to the end
                    collisions += 1;
                    
                }
                
                this.table[index] = value; //put the value at the found index
            }
            
            System.out.println("Load Factor: " + lf + " " + "Collisions: " + collisions); //print loadfactor (before addition) and number of collisions
            
            if (this.loadFactor() >= .75) { //if array is >=75% full, rehash the table 
                this.rehash();
            }
            
        } else { //if the student is already in the array or doesn't have valid credentials
            
            System.out.println("No duplicate students allowed.");
            
        }
        
    }

    /**
     * Tests if a SECONDARY KEY of the value maps into the specified value in
     * this hash table. This operation is more expensive than the containsKey
     * method. SECONDARY KEY: First Name, Last Name, DOB
     *
     * @param value
     * @return if the student is in the table.
     */
    public boolean contains(Student value) {
        
        for (int index = 0; index < this.table.length; index++) {
            
            if ( this.table[index] != null) { //if table[index] is not null, check if it is equal to value
                
                Student student = this.table[index];
                if (student.equals(value)) { //if student is in array, return true
                    return true;
                }
                
            }
            
        }
        
        return false;
        
    }

    /**
     * Tests if the specified object is a key in this hash table.
     *
     * @param key
     * @return if the key is in the table or not.
     */
    public boolean containsKey(int key) {
        
        if (this.get(key) == null) { //if the key isn't in the array, return false
            return false;
        }
        
        return true;
        
    }

    /**
     *
     * @param key
     * @return
     */
    public int hash(int key) {
        
        return key % capacity;
        
    }
    
    /**
     * @return the capacity of the table.
     */
    public int capacity() {
        return this.capacity;
    }
    
    /**
     * @return the hash table as an string
     */
    public String toString() {
        
        String s = "";
        
        //loops through the table and adds the string value to s
        for (int index = 0; index < this.table.length; index++) {
            
            if (this.table[index] != null) {
                
                s = s + this.table[index].getId() + " ";
            
            } else {
                
                s = s + this.table[index] + " ";
            
            }
            
        }
        
        return s;
        
    }
}
