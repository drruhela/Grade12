/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u1;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author 1ruheladev
 */
public class palindrome2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a sentence (no punctuation): ");
        String phrase = input.nextLine();
        
        String[] exclude = {",", ".", "!", "'"};
        
        for (int i = 0; i < exclude.length; i++) {
            phrase = phrase.replace(exclude[i], "");
        }
        
        StringTokenizer st = new StringTokenizer( phrase);
        
        String[] words = new String[st.countTokens()];
        
        int index = 0;
        while (st.hasMoreTokens()) {
            words[index] = st.nextToken();
            index += 1;
        }
        
        int count = numOfPals(words);
        
        if (count == 1) {
            System.out.println("There is " + count + " palindrome.");
        } else {
            System.out.println("There are " + count + " palindromes.");
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
    
    public static int numOfPals(String[] words) {
        int amount = 0;
        
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            
            String word = words[wordIndex];
            
            if (word.length() >= 2) {
                
                if (isPal(word)) {
                    System.out.println(word + " is a palindrome.");
                    amount += 1;
                }  
            }         
        }
        return amount;
    }
    
}
