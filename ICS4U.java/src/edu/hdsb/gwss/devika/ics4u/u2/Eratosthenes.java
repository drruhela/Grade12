/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u2;

import java.util.ArrayList;

/**
 *
 * @author drruh
 */
public class Eratosthenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean[] bools = new boolean[1001];
        
        for (int i = 0; i < bools.length; i++) { //makes every element in bools true
            bools[i] = true;
        }
        
        int half = bools.length / 2;
        
        for (int i = 2; i < half; i++) {
            
            for (int j = i + 1; j < bools.length; j++) { //if a number is divisible by any other number in the array, the boolean of that index is set to false
                
                if (j % i == 0) {
                    bools[j] = false;
                }
                    
            }
            
        }
        
        for (int i = 2; i < bools.length; i++) { //prints out prime nums from 2 to 1000
            if (bools[i] == true) {
                System.out.println(i);
           }
        }
        
        
        
        
    }
    
    
    
}
