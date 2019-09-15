/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u1;

import java.util.Scanner;

/**
 *
 * @author 1ruheladev
 */
public class palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a word: ");
        String word = input.nextLine();
        
        
        if (isPal(word)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
        
        
    }
    
    public static boolean isPal(String str) {
        String reverse = "";
        
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        System.out.println("Backwords: " + reverse);
        
        
        if (str.toLowerCase().equals(reverse.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }
    
}
