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
public class encryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a word or phrase: ");
        String phrase = input.nextLine();
        
        System.out.print("Enter the key: ");
        int key = Integer.parseInt(input.nextLine());
        
        String str = encrypt(phrase, key);
        System.out.println(str);
    }
    
    public static String encrypt(String message, int key) {
        
        String encrypted = "";
        
        //Capital letters: 65 - 90
        //Lowercase letters: 97 - 122
        
        int lowerStart = 97;
        int upperStart = 65;
        
        for (int i = 0; i < message.length(); i++) {
            int val = message.charAt(i);
            char newChar;
            if (val == 90) { //if Z
                newChar = (char) (upperStart + key - 1);
            }
            else if (val == 122) { //if z
                newChar = (char) (lowerStart + key - 1);
            }
            else if(val == 32) { //if space
                newChar = (char) (val);
            }
            else {
                newChar = (char) (val + key);
            }
            encrypted += newChar;
        }
        
        return encrypted;
    }
}
