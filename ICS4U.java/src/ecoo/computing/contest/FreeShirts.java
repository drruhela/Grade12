/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoo.computing.contest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author drruh
 */
public class FreeShirts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //OPEN FILE 
        File file = new File("DATA.txt");
        Scanner file1 = new Scanner(file);
        //System.out.println("hello");
        int N;
        int M;
        int D;
        int laundry = 0;
        //int dirtyShirts = 0;
        int initialShirts = 0;
        int lines = 0;

        while (file1.hasNextLine()) {
           // int laundry = 0;
           // for (int k = 0; k < 2; k++) {
                
                String currentLine = file1.nextLine();
                lines ++;
                StringTokenizer st = new StringTokenizer(currentLine, " ");
                //System.out.println(currentLine);
                //System.out.println("hhello");
                if (lines%2 == 0) {
                N = Integer.parseInt(st.nextToken());
                // System.out.println("hello");
                M = Integer.parseInt(st.nextToken());
                D = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(file1.nextLine(), " ");
                lines ++;
                N = initialShirts;
                int j = 0;
                int event = Integer.parseInt(st.nextToken()); 
                }

                for (int i = 1; i <= D; i++) {
                    if (N == 0) {
                        laundry++;
                        N = initialShirts;
                    }

                    if (D == event) {
                    j++;
                    if (j < M) {
                    event = Integer.parseInt(st.nextToken());
                        System.out.println(event);
                        
                    }
                    
                    N++;
                    }
                    N--;
                }
                
                

            
        }
            
       System.out.println(laundry);     
    }
        //System.out.println(laundry);
    //char letter = 'A';
    
       // System.out.println( (int) letter);
}


