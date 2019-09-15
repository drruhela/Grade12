/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.pt;

/**
 *
 * @author drruh
 */
public class ProperFraction extends Fraction {
    
    public ProperFraction() {
        super();
    }
    
    public ProperFraction(int numerator, int denominator) throws Exception {
    
        super(numerator, denominator);
        if ( this.numerator > this.denominator) {
            throw new Exception ("Numerator must be less than denominator.");
        }
        
    }
    
}
