/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u6;

import java.util.Objects;
import java.io.*;

/**
 *
 * @author drruh
 */
public class State implements Serializable {
    
    //Class constants
    public static int NAME_LENGTH = 15;
    public static int COUNTRY_LENGTH = 12;
    public static int REC_LENGTH = (NAME_LENGTH * 2) + (COUNTRY_LENGTH * 2) + 4 + 4 + 8 + 1 + 2;
    
    //Class variables
    private static long nextNumber = 1;
    
    //Object Variables:
    private long id; //primary key
    
    //Secondary key stuff
    private String name; //name of state/province
    private String country;
    private int cities; //number of cities
    private int lakes;
    private double population; //(in millions)
    private boolean coastal; //if it's by the ocean
    private char code;
    
    //constructors
    public State() { //empty constructor
        this.id = -1;
    }

    public State(long id) { //primary key constructor
        this.id = id;
    }

    public State(String name, String country, int cities, int lakes, double population, boolean coastal) { //secondary key constructor
        
        this.setName(name);
        this.setCountry(country);
        this.setCities(cities);
        this.setLakes(lakes);
        this.setPopulation(population);
        this.setCoastal(coastal);
        this.setCode(name.charAt(0));
        this.id = -1;
        
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        
        return name;
        
    }

    public void setName(String name) {
        
        StringBuilder temp = new StringBuilder();

        if ( name != null ) {
            temp.append( name.trim() );
        } else {
            temp.append( "TBD" );
        }

        // trucates or pads the string
        temp.setLength( this.NAME_LENGTH );
        this.name = temp.toString();
        
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        
        StringBuilder temp = new StringBuilder();

        if ( country != null ) {
            temp.append( country.trim() );
        } else {
            temp.append( "TBD" );
        }

        // trucates or pads the string
        temp.setLength( this.COUNTRY_LENGTH );
        this.country = temp.toString();
        
    }

    public boolean isValid() {
        
        if (this.name == null || this.country == null || this.cities <= 0 || this.lakes < 0 || this.population < 0) {
            return false;
        }
        
        return true;
        
    }
    
    //getters and setters
    public int getCities() {
        return cities;
    }

    public void setCities(int cities) {
        
        this.cities = cities;
    }

    public int getLakes() {
        return lakes;
    }

    public void setLakes(int lakes) {
        this.lakes = lakes;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public boolean isCoastal() {
        return coastal;
    }

    public void setCoastal(boolean coastal) {
        this.coastal = coastal;
    }

    public char getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }
    
    @Override
    public String toString() {
        return "State{" + "id=" + id + ", name=" + name + ", country=" + country + ", cities=" + cities + ", lakes=" + lakes + ", population=" + population + ", coastal=" + coastal + ", code=" + code + '}';
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
        final State other = (State) obj;
        if (this.id != other.id) {
            System.out.println("Diff ids");
            return false;
        }
        if (this.cities != other.cities) {
            return false;
        }
        if (this.lakes != other.lakes) {
            return false;
        }
        if (Double.doubleToLongBits(this.population) != Double.doubleToLongBits(other.population)) {
            return false;
        }
        if (this.coastal != other.coastal) {
            return false;
        }
        if (this.code != other.code) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        return true;
    }
    
}
