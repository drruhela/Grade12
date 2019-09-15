/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drruh
 */
public class StateDB {

    //class variables
    private static RandomAccessFile raf;

    public StateDB() {
        open();
    }

    public static void open() {

        try {

            raf = new RandomAccessFile("data/states.dat", "rw"); //creates (or finds) and opens states.dat
            raf.seek(0);

        } catch (FileNotFoundException ex) {

            System.out.println("File not found."); //if file does not exist

        } catch (IOException ex) {

            System.out.println("Cannot open file."); //if there is an error when navigating to start of file
        }

    }

    public static void close() {

        try {
            raf.close(); //closes the file so it updates
        } catch (IOException ex) {
            System.out.println("Cannot close file.");
        }
    }

    public static State save(State s) {

        if (s != null && s.isValid()) { //if the state object is valid (has all necessary attributes), save/update it in file

            try {
                
                open();
                long recNum = raf.length() / (long) State.REC_LENGTH;

                if (s.getId() <= 0) { // if id=-1, it hasn't been saved. So, add it to the file

                    raf.seek(raf.length()); //go to end of file
                    s.setId(recNum + 1); //set the id to 1 + number of objects in file

                } 
                
                else if (s.getId() > recNum) { // if id is bigger than the number of objects in the file, return null
                    return null;
                }
                
                else { //if object is somewhere in the file, navigate to the beginning of it (to overwrite it)
                    raf.seek((s.getId() - 1) * State.REC_LENGTH);
                }

                //save/update the object
                raf.writeChars(s.getName());
                raf.writeChars(s.getCountry());
                raf.writeInt(s.getCities());
                raf.writeInt(s.getLakes());
                raf.writeDouble(s.getPopulation());
                raf.writeBoolean(s.isCoastal());
                raf.writeChar(s.getCode());
                
                return s;

            } catch (IOException ex) {
                return null;
            }

        }

        return null;
    }

    public static State get(long dbID) {

        try {
            open();
            
            long recNum = raf.length() / (long) State.REC_LENGTH; //number of objects in
            
            if (dbID <= recNum && dbID != -1) { //if the id is less than num of objects (meaning if the object has been saved)
                
                raf.seek((dbID - 1) * State.REC_LENGTH); //go to the start of that object
                State s = new State( dbID );
                
                //reading from file
                char[] data = new char[State.NAME_LENGTH];
                for (int i = 0; i < data.length; i++) { //read the name string
                    data[i] = raf.readChar();
                }
                s.setName(new String (data) ); //set name to the data just read
                
                data = new char[State.COUNTRY_LENGTH]; //reset data to new array with size of country string
                for (int i = 0; i < data.length; i++) { //read the country string
                    data[i] = raf.readChar();
                }
                s.setCountry(new String (data) ); //set the country to the data just read
                
                //read from the file and set the object's attributes
                s.setCities(raf.readInt());
                s.setLakes(raf.readInt());
                s.setPopulation(raf.readDouble());
                s.setCoastal(raf.readBoolean());
                s.setCode(raf.readChar());
                
                return s; //return the new object
                
            }
            
            return null; //if object has not been saved or does not exist, return null

        } catch (IOException ex) {
            return null;
        }

    }
}
