/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author drruh
 */
public class StateClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        RandomAccessFile raf = new RandomAccessFile("data/states.dat", "rw");
        
        State s1 = new State( "Ontario", "Canada", 52, 250000, 14.45, true);
        State s2 = new State ("Quebec", "Canada", 227, 561, 8.43, true);
        
        System.out.println(State.REC_LENGTH);
        raf.seek(0);
        //raf.seek( raf.length() ); //moves the pointer to the end of the file
        System.out.println(raf.length());
        raf.writeChars( s1.getName());
        System.out.println(raf.length());
        raf.writeChars( s1.getCountry());
        System.out.println(raf.length());
        raf.writeInt( s1.getCities());
        System.out.println(raf.length());
        raf.writeInt( s1.getLakes());
        System.out.println(raf.length());
        raf.writeDouble(s1.getPopulation());
        System.out.println(raf.length());
        raf.writeBoolean(s1.isCoastal() );
        System.out.println("REC#1" + raf.length());
        
        raf.writeChars( s2.getName());
        raf.writeChars( s2.getCountry());
        raf.writeInt( s2.getCities());
        raf.writeInt( s2.getLakes());
        raf.writeDouble(s2.getPopulation());
        raf.writeBoolean(s2.isCoastal() );
        System.out.println("REC#2" + raf.length());
       
        
        
        //reading objects from file
        
        long recNum = raf.length() / (long) State.REC_LENGTH;
        System.out.println(recNum);
        
        int recId = 2; //look for second object
        
        if (recId < 1 || recId > recNum) {
            System.out.println("RecId " + recId + " does not exist.");
            recId = (int) Math.ceil(recNum);
        }
        State s3 = new State(recId);
        
        raf.seek( (recId - 1) * State.REC_LENGTH); //move pointer to the beginning of the object
        
        raf.readInt();
        
        char[] data  = new char[State.NAME_LENGTH];
        for (int i = 0; i < data.length; i++) {
            data[i] = raf.readChar();
        }
        
        
        s3.setName( new String( data ));
        
        data  = new char[State.COUNTRY_LENGTH];
        for (int i = 0; i < data.length; i++) {
            data[i] = raf.readChar();
        }
        s3.setCountry( new String( data ));
        
        s3.setCities( raf.readInt() );
        s3.setLakes( raf.readInt() );
        s3.setPopulation( raf.readDouble() );
        s3.setCoastal( raf.readBoolean() );
        
        System.out.println(s3.toString());
        
        /*
        raf.writeInt( s3.getId() );
        raf.writeChars( s3.getName());
        raf.writeChars( s3.getCountry());
        raf.writeInt( s3.getCities());
        raf.writeInt(s3.getLakes());
        raf.writeDouble(s3.getPopulation());
        raf.writeBoolean(s3.isCoastal() );*/
        
        
        
        raf.close();
    }
    
}
