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
public class L {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here

        //OPEN FILE 
        File file = new File("DATA21.txt");
        Scanner input = new Scanner(file);

        String currentLine = input.nextLine();
        StringTokenizer st = new StringTokenizer(currentLine, " ");

        int A = 0, B = 2, C = 4, D = 6, E = 8, F = 10, G = 12, H = 14, I = 16, J = 18;
        int K = 20;
        int L = 22;
        int M = 24;
        int N = 26;
        int O = 28;
        int P = 30;
        int Q = 32;
        int R = 34;
        int S = 36;
        int T = 38;
        int U = 40;
        int V = 42;
        int W = 44, X = 46, Y = 48, Z = 50;

        int rules, runs;
        String ax;
for(int p =0; p < 10; p++){
        rules = Integer.parseInt(st.nextToken());
        System.out.println(rules);

        String[] ruleArray = new String[rules * 2];

        runs = Integer.parseInt(st.nextToken());

        ax = st.nextToken();

        int index = 0;

        for (int i = 0; i < (rules); i++) {
            currentLine = input.nextLine();
            st = new StringTokenizer(currentLine, " ");
            ruleArray[index] = st.nextToken();
            ruleArray[index + 1] = st.nextToken();
            // System.out.println(ruleArray[index]);
            //ystem.out.println(ruleArray[index + 1]);
            //System.out.println(ruleArray[i+1]);
            index = index + 2;
        }
        for (int i = 0; i < ruleArray.length; i++) {
            System.out.println(ruleArray[i]);
        }

        String output = "";
 String current = ax;
        System.out.println(" 1 " + output);
        String variable = "";
        
        for (int k = 0; k < runs; k++){
        for (int f = 0; f < current.length(); f++) {
            variable = current.substring(f, f + 1);
            //System.out.println("var" + variable);
            for (int i = 0; i < rules * 2; i = i + 2) {
                if (variable.equals(ruleArray[i])) {
                    int indexNew = i + 1;
                    variable = variable.replaceAll(variable, ruleArray[indexNew]);
                }
            //    output = output + variable;
            }
            output= output + variable;
            
        }
        current = output;
        }
       // System.out.println(currentString);
//        for (int i = 0; i < rules * 2; i = i + 2) {
//            if (variable.equals(ruleArray[i])) {
//                int indexNew = i + 1;
//                variable = variable.replaceAll(variable, ruleArray[indexNew]);
//            }
//        }

      //  output = output + variable;
        //System.out.println(output);
        int leg = output.length();
        System.out.println(output.substring(0,1) + output.substring(leg - 1) + " " + leg);
}
    }

}
