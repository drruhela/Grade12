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
public class pascalTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //System.out.println(term(0,0));
        int lastRow = 4;
        for (int i = 0; i <= lastRow; i++) {
            row (i, 0);
            System.out.println("");
            
        }
        
        
    }
    
    
    public static int term(int row, int col) {
        
        if (row == 0) return 1;
        if (col == 0 || col == row) return 1;
        
        return term(row-1,col-1) + term(row-1, col);
    }
    
    public static int row (int row, int col) {
        
        
        if (row == 0) {
            System.out.println(term(0,0));
            col = row;
        }
        
        System.out.print(term(row, col) + " ");
        
        if (col != row) {
            
            col++;
        }
        
        //System.out.println(term( row, col));
        
        if (col == row) {
            System.out.print(term (row, col) + " ");
            return 0;
        }
        return row (row, col);
        
        
        
    }
}