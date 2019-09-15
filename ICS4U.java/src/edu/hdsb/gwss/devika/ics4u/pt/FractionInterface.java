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
public interface FractionInterface {
    
    public int getNumerator();
    
    public int getDenominator();
    
    public double value();
    
    public Fraction times(Fraction f);
    
    public Fraction add(Fraction f);
    
    public Fraction larger(Fraction f);
    
    public void invert() throws Exception;
    
    public boolean equals (Object obj);
    
    public String toString();
    
    public String toString(boolean mixed);
    
    public MixedFraction toMixed() throws Exception;
    
    public ImproperFraction toImproper() throws Exception;
    
}
