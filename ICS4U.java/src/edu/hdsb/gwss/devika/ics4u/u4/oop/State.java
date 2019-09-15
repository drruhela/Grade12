/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u4.oop;

import java.util.Objects;

/**
 *
 * @author drruh
 */
public class State {
    
    //Class variables
    static int nextNumber = 1;
    
    //Object Variables:
    int number; //primary key
    
    //Secondary key stuff
    String name; //name of state/province
    int cities; //number of cities
    double population; //(in millions)
    boolean coastal; //if it's by the ocean
    Country country;
    
    public State() { //empty constructor
        number = -1;
    }

    public State(int number) { //primary key constructor
        this.number = number;
    }

    public State(String name, int cities, double population, boolean coastal, Country country) { //secondary key constructor
        this.name = name;
        this.cities = cities;
        this.population = population;
        this.coastal = coastal;
        this.country = country;
        number = nextNumber++;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        
        if (number <= 0) {
            System.out.println("Invalid State Number");
        } else {
            this.number = number;
        }
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        
        if (name.length() <= 1) {
            System.out.println("Invalid Name");
        }
        else {
            this.name = name;
        }
        
    }

    public int getCities() {
        return cities;
    }

    public void setCities(int cities) {
        
        if (cities <= 0) {
            System.out.println("Invalid Number of Cities");
        } else {
            this.cities = cities;
        }
        
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        
        if (population < 0) {
            System.out.println("Invalid Population");
        } else {
            this.population = population;
        }
    }

    public boolean isCoastal() {
        return coastal;
    }

    public void setCoastal(boolean coastal) {
        this.coastal = coastal;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "State{" + "number=" + number + ", name=" + name + ", cities=" + cities + ", population=" + population + ", coastal=" + coastal + ", country=" + country + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { //if memory location is same
            return true;
        }
        if (obj == null) { //if the object being compared to does not exist
            return false;
        }
        if (getClass() != obj.getClass()) { //if the objects aren't of the same class. ex. comparing State object to String Object
            return false;
        }
        final State other = (State) obj;
        if (this.number != other.number) { //if the primary keys of the objects aren't the same, they are not same object
            return false;
        }
        if (this.number == -1 || other.number == -1) { //if the object(s) has not been given a primay key, they are not equal
            return false;
        }
        
        //looking at secondary key info
        if (this.cities != other.cities) { //if the number of cities of both states is not the same, they are not equal
            return false;
        }
        if (Double.doubleToLongBits(this.population) != Double.doubleToLongBits(other.population)) { //if the populations of the states are not equal
            return false;
        }
        if (this.coastal != other.coastal) { //if one state is coastal and the other isn't
            return false;
        }
        if (!Objects.equals(this.name, other.name)) { //if the names of the states are not the same
            return false;
        }
        if (!Objects.equals(this.country, other.country)) { //if the states are not part of the same country
            return false;
        }
        return true; //if everything is the same, then the two objects being compared are the same state
    }
    
    public static void main(String[] args) {
        
        //String name, int cities, double population, boolean coastal, Country country
        Country canada = new Country("Canada", 13);
        State ontario = new State("Ontario", 52, 14.45, false, canada);
        State quebec = new State("Quebec", 227, 8.43, true, canada);
        /*
        State britishColumbia = new State(canada);
        State alberta = new State(false, canada);
        State manitoba = new State(canada);
        State saskatchewan = new State(false, canada);
        State novaScotia = new State(canada);
        State newBrunswick = new State(canada);
        State newfoundlandAndLabrador = new State(canada);
        State princeEdwardIsland = new State(canada);
        State northwestTerritories = new State(true, canada);
        State nunavut = new State(true, canada);
        State yukon = new State(true, canada);
        */
        
    }
    
}
