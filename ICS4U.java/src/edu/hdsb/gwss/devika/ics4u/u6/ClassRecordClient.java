/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u6;

import java.io.*;

/**
 *
 * @author drruh
 */
public class ClassRecordClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        RandomAccessFile raf;
        raf = new RandomAccessFile("class.dat", "rw");
        
        ClassRecord c1 = new ClassRecord("Mr. Sanderson", "Chemistry", 31);
        
        raf.seek( raf.length() );
        raf.writeInt( c1.getId() );
        raf.writeChars( c1.getTeacher() );
        raf.writeChars( c1.getSubject() );
        raf.writeInt( c1.getSize() );
        
        raf.close();
    }
    
}
