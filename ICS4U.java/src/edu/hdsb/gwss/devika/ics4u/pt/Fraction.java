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
public class Fraction implements FractionInterface {

    //Instance variables
    
    protected int numerator;
    protected int denominator;

    public Fraction(int numerator, int denominator) throws Exception { //constructor

        //sets the object's num and den to the parameters
        this.setDenominator(denominator);
        this.numerator = numerator;
        
        reduce(); //reduce fraction, no negative denominator
        
    }
    
    public Fraction() { //empty constructor
        //numerator is set to default: 0
        this.denominator = 1; //set to 1 cuz a denominator can't be 0
    }

    public int getNumerator() { //returns numerator
        return this.numerator;
    }

    public int getDenominator() {//returns denominator
        return this.denominator;
    }
    
    protected void setDenominator(int den) throws Exception {
        
        if (den != 0) {
            this.denominator = den;
        } else {
            throw new Exception("Denominator cannot be 0.");
        }
    }
    /*
    protected void setNumerator(int num) {
        
        if (num < 0) {
            this.numerator = num;
        } else {
             this.numerator = num % this.denominator;
        }
        
    }*/

    public double value() { //returns the value of the fraction as a double

        //numerator / denominator
        return ((double) this.numerator) / this.denominator;
    }

    protected void reduce() { //reduces the fraction
        
        if (this.numerator == 0) {
            this.denominator = 1;
        }
        
        positiveDenominator(); //make denominator positive if it is not already
        
        int factor = gcd (Math.abs(this.numerator), Math.abs(this.denominator)); //find the gcf of the num and den
        
        //divide the num and den by the gcf to reduce and simplify
        this.numerator /= factor;
        this.denominator /= factor;
        
    }
    
    private void positiveDenominator() {
        
        if (this.denominator < 0) { //if the denominator is negative, make it positive and switch sign of numerator
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }
    
    public static Fraction times(Fraction f, Fraction g) { //class method to multiply two fractions
        
        Fraction newFraction = new Fraction(); //instantiate class to make new fraction with num=0 den=1
        
        if (f != null && g != null) { //if f and g exist
            
            newFraction.denominator = f.denominator * g.denominator; //multiply the denominators
            newFraction.numerator = f.numerator * g.numerator; //multiply the numerators

            newFraction.reduce(); //reduce the newFraction
            return newFraction; //return the product of the two fractions
            
        } 
        
        return null; //if one or both fraction(s) is/are null, product is also null
    }
    
    public Fraction times(Fraction f) {
        
        return times(this, f); //object multiplies itself by Fraction f by calling the Class method for times
        
    }
    
    public static Fraction larger( Fraction f, Fraction g) { //compares two fractions and returns the larger of the two
        
        if (f != null && g != null) { //if both f and g exist
            
            double val1 = f.value();
            double val2 = g.value();

            if (val2 > val1) { //if value of Fraction g is greater than f, return g
                return g;
            }
            
            return f; //otherwise, return f
            
        } else if (f == null) { //if f does not exist, return g
            return g;
        } 
        return f; //if g does not exist, return f
    }
    
    public Fraction larger(Fraction f) { //object method to compare another fraction
        
        //uses the static larger method to compare itself (as one parameter) with another fraction to find the larger one
        return larger (this, f);
    }
    
    public static Fraction add( Fraction f, Fraction g) { //class method to add two fractions
        
        Fraction newFraction = new Fraction(); //creates new Fraction object num=0 den=1
        
        if (f != null && g != null) { //if both fractions exist, add them
            
            //to add, get common denominator
            //numerator = (f.num*g.den) + (g.num*f.den)
            newFraction.numerator = (f.numerator * g.denominator) + (g.numerator * f.denominator);
            //denominator = f.den * g.den
            newFraction.denominator = f.denominator * g.denominator;

            newFraction.reduce(); //reduce the sum of the fractions
            
        } else if (f == null) { //if f does not exist, return g
            
            newFraction = g;
            
        } else if (g == null) { //if g does not exist, return f
            
            newFraction = f;
        
        }
        
        return newFraction; //return the sum of f and g
    }
    
    public Fraction add( Fraction f) {
        
        //uses the class method add with the object itself as one parameter to add it to another fraction
        return add( this, f );
        
    }
    
    public void invert() throws Exception { //flips the fraction
        
        if (this.numerator != 0) { //if num is not 0, flip/invert the fraction
            
            int newNumerator = this.denominator; //placeholder
            this.denominator = this.numerator; //den=num
            this.numerator = newNumerator; //num=den
            
            reduce(); //reduce to get positive denominator in case it is not already
            
        } else { //if the numerator was 0, the fraction cannot be flipped cuz the den can never be 0
            throw new Exception("Denominator cannot be 0.");
        }
    }

    public MixedFraction toMixed() throws Exception {
        
        MixedFraction f = new MixedFraction(this.numerator, this.denominator);
        
        return f;
        
    }
    
    public ImproperFraction toImproper() throws Exception{
        ImproperFraction f = new ImproperFraction(this.numerator, this.denominator);
        
        return f;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) { //checks if two objects are equal
        
        if (this == obj) { //if this and obj are the same object, true
            return true;
        }
        if (obj == null) { //if obj does not exist, false
            return false;
        }
        if (getClass() != obj.getClass()) { //if obj is not a Fraction object ,false
            return false;
        }
        
        final Fraction f = (Fraction) obj;
        
        double val1 = value(); //value of this fraction object
        double val2 = f.value(); //value of the other fraction object
        
        if (val1 != val2) { //if the values for the two fraction objects are not equal, the fractions are not equal
            return false;
        }
        return true; //if values are equal, the fractions are equal
    }
    
    public String toString() { //returns string of fraction as a proper/improper fraction
        
        //calls the toString(boolean mixed) with false parameter to get string as not a mixed number
        return toString(false);
    }
    
    public String toString (boolean mixed) {
        
        if (mixed) {
            
            int coeff = this.numerator / this.denominator; //coeff = integer division of num / den
            int newNumerator = this.numerator % this.denominator; //the numerator to be returned will be current num % den
            
            if (Math.abs(newNumerator) > 0) { //if numerator is 0, only return the coefficient with no fraction
                if (coeff != 0) {
                    return coeff + " " + Math.abs(newNumerator) + "/" + this.denominator; //return mixed number as coeff num/den
                }
                return newNumerator + "/" + this.denominator;
            }
            return coeff + ""; //if newNumerator == 0
            
        } //if num < den or the client wants improper fraction
        if (this.denominator == 1) { //if den = den, same as not haveing a denominator; return only numerator
            return this.numerator + "";
        }
        return this.numerator + "/" + this.denominator; //return fraction string as numerator/denominator
        
    }
    
    private static int gcd(int p, int q) { //finds the gcd/gcf of two numbers
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }
}
