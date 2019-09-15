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
public class ImproperFraction extends Fraction{
    
    
    public ImproperFraction() {
        super();
        
    }
    
    public ImproperFraction( int numerator, int denominator) throws Exception {
        
        super();
        if (Math.abs(this.numerator) < Math.abs(this.denominator)) {
            throw new Exception( "Numerator must be greater than denominator. ");
        }
        
    }
    
    public static ImproperFraction larger(ImproperFraction f, ImproperFraction g) throws Exception {
        
        Fraction a = new Fraction( f.numerator, f.denominator);
        Fraction b = new Fraction( g.numerator, g.denominator);
        
        Fraction largest = a.larger(b);
        
        return largest.toImproper();
        
    }
    
    public ImproperFraction larger(ImproperFraction f) throws Exception {
        
        return larger( this, f);     
    }
    
    public static ImproperFraction add(ImproperFraction f, ImproperFraction g) throws Exception {
        
        Fraction a = new Fraction( f.numerator, f.denominator);
        Fraction b = new Fraction( g.numerator, g.denominator);
        
        Fraction sum = a.add(b);
        
        return sum.toImproper();
        
    }
    
    public ImproperFraction add(ImproperFraction f) throws Exception {
        
        return add( this, f);     
    }
    
     public static ImproperFraction times(ImproperFraction f, ImproperFraction g) throws Exception {
        
        Fraction a = new Fraction( f.numerator, f.denominator);
        Fraction b = new Fraction( g.numerator, g.denominator);
        
        Fraction sum = a.add(b);
        
        return sum.toImproper();
        
    }
    
    public ImproperFraction times(ImproperFraction f) throws Exception {
        
        return times( this, f);     
    }
    
    public String toString() {
        
        return this.numerator + "/" + this.denominator;
        
    }
    
}
