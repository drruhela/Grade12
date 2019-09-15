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
public class MixedFraction extends Fraction {
    
    private int coeff;
    
    public MixedFraction() {
        super();
    }
    
    public MixedFraction( int numerator, int denominator ) throws Exception {
        
        this (0, numerator, denominator);
    }
    
    public MixedFraction (int coeff, int numerator, int denominator) throws Exception {
        
        this.coeff = coeff;
        this.setNumerator(numerator);
        this.setDenominator(denominator);
        
        this.reduce();
        
    }
    
    public double value() {
        
        return super.value() + this.coeff;
        
    }
    
    public int getCoeff() {
        return this.coeff;
    }
    
    public void setNumerator(int num) {
        
        this.numerator = num % this.denominator;
        
        if (Math.abs(num) > Math.abs(this.denominator) ) {
            this.coeff = this.numerator / this.denominator;
        
        }
   
    }
    
    public ImproperFraction toImproper() throws Exception{
        int num = coeff * this.denominator + this.numerator;
        
        ImproperFraction f = new ImproperFraction(num, this.denominator);
        
        return f;
    }
    
    public static MixedFraction larger(MixedFraction f, MixedFraction g) throws Exception {
        int fNum = f.coeff * f.denominator + f.numerator;
        int gNum = g.coeff * g.denominator + g.numerator;
        
        Fraction a = new Fraction( fNum, f.denominator);
        Fraction b = new Fraction( gNum, g.denominator);
        
        Fraction largest = a.larger(b);
        
        return largest.toMixed();
        
    }
    
    public MixedFraction larger(MixedFraction f) throws Exception {
        
        return larger( this, f);     
    }
    
    public static MixedFraction add(MixedFraction f, MixedFraction g) throws Exception {
        int fNum = f.coeff * f.denominator + f.numerator;
        int gNum = g.coeff * g.denominator + g.numerator;
        
        Fraction a = new Fraction( fNum, f.denominator);
        Fraction b = new Fraction( gNum, g.denominator);
        
        Fraction sum = a.add(b);
        
        return sum.toMixed();
        
    }
    
    public MixedFraction add(MixedFraction f) throws Exception {
        
        return add( this, f);     
    }
    
     public static MixedFraction times(MixedFraction f, MixedFraction g) throws Exception {
        int fNum = f.coeff * f.denominator + f.numerator;
        int gNum = g.coeff * g.denominator + g.numerator;
        
        Fraction a = new Fraction( fNum, f.denominator);
        Fraction b = new Fraction( gNum, g.denominator);
        
        Fraction product = a.times(b);
        
        return product.toMixed();
        
    }
    
    public MixedFraction times(MixedFraction f) throws Exception {
        
        return times( this, f);     
    }
    
    public void invert() throws Exception {
        this.numerator = this.coeff * this.denominator + this.numerator;
        
        super.invert();
        this.coeff = 0;
    }
    public String toString() {
        
        String s = "";
        
        if ( this.coeff != 0 ) {
            s += this.coeff + " ";
        }
        
        s += this.numerator + "/" + this.denominator;
        
        return s;
    }
    
    
}
