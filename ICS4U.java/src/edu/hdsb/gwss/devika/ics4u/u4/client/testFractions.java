/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u4.client;

import edu.hdsb.gwss.devika.ics4u.u4.oop.Fraction;

/**
 *
 * @author drruh
 */
public class testFractions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        System.out.println("Test: 0 in denominator and numerator");
        try {
            
            Fraction denZero = new Fraction(1, 0);
            assert(false);
            
            Fraction numZero = new Fraction (0, 4);
            numZero.invert();
            assert (false);
            
        } catch (Exception e) {
            assert (true);
            System.out.println("Passed \n");
        }
        
        Fraction a = new Fraction (3,4);
        Fraction b = new Fraction (1, -2);
        Fraction c = new Fraction (6, 4);
        Fraction d = new Fraction (-4, 2);
        Fraction e = new Fraction (-5, -4);
        Fraction f = new Fraction (0, 3);
        
        
        //tests obj.getNumerator()
        System.out.println("Test: obj.getNumerator()");
        assert(a.getNumerator() == 3);
        assert(b.getNumerator() == -1);
        assert(c.getNumerator() == 3);
        assert(d.getNumerator() == -2);
        assert(e.getNumerator() == 5);
        assert(f.getNumerator() == 0);
        System.out.println("Passed \n");
        
        //tests obj.getDenominator()
        System.out.println("Test: obj.getDenominator()");
        assert(a.getDenominator() == 4);
        assert(b.getDenominator() == 2);
        assert(c.getDenominator() == 2);
        assert(d.getDenominator() == 1);
        assert(e.getDenominator() == 4);
        assert(f.getDenominator() == 1);
        System.out.println("Passed \n");
        
        //tests toString()
        System.out.println("Test: obj.toString()");
        assert(a.toString().equals("3/4"));
        assert(b.toString().equals("-1/2"));
        assert(c.toString().equals("3/2"));
        assert(d.toString().equals("-2"));
        assert(e.toString().equals("5/4"));
        assert(f.toString().equals("0"));
        System.out.println("Passed \n");
        
        //tests toString(false) (should be the same as above)
        System.out.println("Test: obj.toString(false)");
        assert(a.toString(false).equals("3/4"));
        assert(b.toString(false).equals("-1/2"));
        assert(c.toString(false).equals("3/2"));
        assert(d.toString(false).equals("-2"));
        assert(e.toString(false).equals("5/4"));
        assert(f.toString(false).equals("0"));
        System.out.println("Passed \n");
        
        //tests toString(true)
        System.out.println("Test: obj.toString(true)");
        assert(a.toString(true).equals("3/4"));
        assert(b.toString(true).equals("-1/2"));
        assert(c.toString(true).equals("1 1/2"));
        assert(d.toString(true).equals("-2"));
        assert(e.toString(true).equals("1 1/4"));
        assert(f.toString(true).equals("0"));
        System.out.println("Passed \n");
        
        //tests obj.larger()
        System.out.println("Test: obj.larger()");
        assert(a.larger(b).equals(a));
        assert(b.larger(a).equals(a));
        assert(a.larger(a).equals(a));
        assert(a.larger(null).equals(a));
        System.out.println("Passed \n");
        
        //tests Fraction.larger(Fraction a, Fraction b)
        System.out.println("Test: Fraction.larger()");
        assert( Fraction.larger(a, b).equals(a));
        assert( Fraction.larger(b, a).equals(a));
        assert( Fraction.larger(a, a).equals(a));
        assert( Fraction.larger(null, a).equals(a));
        assert( Fraction.larger(a, null).equals(a));
        assert( Fraction.larger(null, null) == null);
        System.out.println("Passed \n");
        
        //tests obj.times()
        System.out.println("Test: obj.times()");
        assert( a.times(b).equals( new Fraction( -3, 8)) );
        assert( a.times(c).equals( new Fraction (18, 16) ));
        assert( a.times(d).equals( new Fraction (-12, 8) ));
        assert( e.times(e).equals(new Fraction (25, 16)));
        assert( a.times(null) == null);
        System.out.println("Passed \n");
        
        //tests Fraction.times(a, b)
        System.out.println("Test: Fraction.times()");
        assert( Fraction.times(a, b).equals( new Fraction( -3, 8)) );
        assert( Fraction.times(a, c).equals( new Fraction (18, 16) ));
        assert( Fraction.times(a, d).equals( new Fraction (-12, 8) ));
        assert( Fraction.times(e, e).equals(new Fraction (25, 16)));
        assert( Fraction.times(a, null) == null);
        assert( Fraction.times(null, a) == null);
        assert( Fraction.times(null, null) == null);
        System.out.println("Passed \n");
        
        //tests obj.add()
        System.out.println("Test: obj.add()");
        assert(a.add(b).equals(new Fraction(1, 4)));
        assert(a.add(c).equals(new Fraction (9, 4)));
        assert(b.add(d).equals(new Fraction (-5, 2)));
        assert(a.add(null).equals(a));
        System.out.println("Passed \n");
        
        //tests Fraction.add()
        System.out.println("Test: Fraction.add()");
        assert(Fraction.add(a, b).equals(new Fraction(1, 4)));
        assert(Fraction.add(a, c).equals(new Fraction (9, 4)));
        assert(Fraction.add(b, d).equals(new Fraction (-5, 2)));
        assert(Fraction.add(a, null).equals(a));
        assert(Fraction.add(null, a).equals(a));
        assert(Fraction.add(null, null) == null);
        System.out.println("Passed \n");
        
        //tests obj.value()
        System.out.println("Test: obj.value()");
        assert(a.value() == .75);
        assert(b.value() == -.5);
        assert(a.add(b).value() == .25);
        System.out.println("Passed \n");
        
        //tests obj.invert()
        a.invert();
        b.invert();
        d.invert();
        assert( a.equals( new Fraction (4, 3)));
        assert( b.equals( new Fraction (-2, 1)));
        assert(d.equals( new Fraction (-1, 2)));
        
    }

}
