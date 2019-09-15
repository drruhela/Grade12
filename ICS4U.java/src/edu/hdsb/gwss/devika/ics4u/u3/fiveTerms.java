/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u3;

import java.text.NumberFormat;



/**
 *
 * @author drruh
 */
public class fiveTerms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.print("Sequence 1: ");
        for (int i = 1; i <= 5; i++) {
            if (i == 1) {
                System.out.print(seq1(i));
            } else {
                System.out.print(", " + seq1(i));
            }
        }
        
        System.out.println("");
        
        System.out.print("Sequence 2: ");
        for (int i = 1; i <= 5; i++) {
            NumberFormat decimal = NumberFormat.getNumberInstance(); 
            decimal.setMinimumFractionDigits( 2 );
            decimal.setMaximumFractionDigits( 2 );
            String term = decimal.format( seq2(i) );

            if (i == 1) {
                System.out.print(term);
            } else {
                System.out.print(", " + term);
            }
        }
    }
    
    public static int seq1 (int n) {
        //t1 = 1; t2 = 3; tn = t(n-1) + t(n+2), n > 2
        
        if ( n==1 ) return 1;
        if ( n==2 ) return 3;
        
        return seq1(n-1) + seq1(n-2);
        
    }
    
    public static double seq2 (int n) {
        //t1 = 2; tn = sqrt(3t(n-1) + 4), n>1
        
        if (n == 1) return 2.00;
        
        return ( Math.sqrt( (3 * seq2(n-1)) + 4 ) );
        
    }
    
}
