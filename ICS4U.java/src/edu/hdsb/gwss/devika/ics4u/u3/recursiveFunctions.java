/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u3;

/**
 *
 * @author drruh
 */
public class recursiveFunctions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        System.out.println(function1( 5, 3));
        System.out.println(function1( 2, 2));
        System.out.println(function1( 1, 4));
        System.out.println(function1( -5, -2));
        
        System.out.println("");
        System.out.println(function2 ( 1, 1));
        System.out.println(function2 ( 2, 1));
        //System.out.println(function2 ( 5, 5));
        */        

        System.out.println( gcd(5, 10));
        
    }
    
    public static int function1 (int x, int y) { //gives the absolute value of difference of x and y
        
        if (x < y) return function1(-x, -y);
        if (x == y) return 0;
        
        return ( 1 + function1(x-1, y) );
        
    }
    
    public static int function2 ( int m, int n) {
        
        if ( m == 0) return n + 1;
        if (m > 0 && n == 0) return function2( m - 1, 1 );
        
        return ( function2( m - 1, function2( m, n - 1) ));
        
    }
    
    public static int gcd(int m, int n) {
        
        if (m == n) return m;
        
        if (m > n) return gcd(n, m-n);
        
        return gcd(n, m);
        
    }
    
}
