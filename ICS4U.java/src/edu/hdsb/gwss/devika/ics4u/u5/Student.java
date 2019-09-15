/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u5;

import java.util.Objects;

/**
 *
 * @author drruh
 */
public class Student {
    
    //Class variables
    public static int nextId = 100000; //student id's start at 100000
    
    //object variables
    private int id;
    private String firstName;
    private String lastName;
    private String dob; //MMDDYY
    
    //constructors
    public Student(String firstName, String lastName, String dob) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        
        this.id = nextId;
        
        nextId += 3;
        
    }
    
    public Student() { //empty constructor
        
        this (null, null, null);
        
    }
    
    public boolean isValid() { //checks if the student is valid (must have a primary and secondary key)
    
        if ( this.firstName == null || this.lastName == null || this.dob == null) {
            
            return false;
            
        }
        
        return true;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        
        //checks primary key
        if (this.id == other.id) { 
            return true;
        }
        
        //checks secondary key
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        return true;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + '}';
    }
    
    
    
    
    
}
