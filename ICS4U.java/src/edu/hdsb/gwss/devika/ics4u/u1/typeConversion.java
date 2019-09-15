/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u1;

/**
 *
 * @author drruh
 */
public class typeConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        boolean bool = true;
        String boolString = Boolean.toString(bool);
        
        char c = 'A';
        int cInt = (int) c;
        double cDouble = (double) c;
        long cLong = (long) c;
        String cString = Character.toString(c);
        
        int i = 5;
        double iDouble = i;
        long iLong = i;
        char iChar = (char) i;
        String iString = Integer.toString(i);
        
        long j = 310449335;
        double jDouble = j;
        int jInt = (int) j;
        char jChar = (char) j;
        String jString = Long.toString(j);
        
        double k = 35.3;
        long kLong = (long) k;
        int kInt = (int) k;
        char kChar = (char) k;
        String kString = Double.toString(k);
        
        String str = "hello";
        int strInt = Integer.parseInt(str);
        double strDouble = Double.parseDouble(str);
        long strLong = Long.parseLong(str);
        
    }
    
}
