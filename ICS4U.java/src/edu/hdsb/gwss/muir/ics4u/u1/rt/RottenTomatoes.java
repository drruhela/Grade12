/*
 * ICS4U.2019.S2
 */
package edu.hdsb.gwss.muir.ics4u.u1.rt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Movie Review Assignment
 *
 * @author Devika Ruhela
 * @version 1.4
 */
public class RottenTomatoes {
    
    static Scanner kbInput = new Scanner(System.in);
    static Scanner reviewsInput;
    static Scanner wordListInput;
    static File reviews = new File( ".\\data\\movie.review\\MovieReviews.txt" );
    static File posFile = new File( ".\\data\\movie.review\\positive.txt" );
    static File negFile = new File( ".\\data\\movie.review\\negative.txt" );

    public static void main( String[] args ) throws Exception {
        
        menu();
        
    }
    
    //This method will return the number of appearances of a word and the score of the word in an array.
    public static int[] appearancesAndScore(String word) throws FileNotFoundException{
        
        reviewsInput = new Scanner(reviews);
        
        if (word == "") {
            System.out.print("Enter a word: ");
            word = kbInput.nextLine();
        }
        
        int[] countAndScore = new int[2];
        
        //This loop counts appearances of a word (only once per line maximum)
        //Also gets the total score (adds up the score of each line where the word is present)
        int counter = 0;
        int totalScore = 0;
        
        while (reviewsInput.hasNextLine()) {
            String review = reviewsInput.nextLine();
            
            if (review.toLowerCase().contains(word.toLowerCase())) {
                
                StringTokenizer st = new StringTokenizer(review);
                
                while (st.hasMoreTokens()) { //This loop checks if every word in the current line, or review, is equal to the word being searched for.
                    String checkWord = st.nextToken();
                    
                    if (checkWord.toLowerCase().equalsIgnoreCase(word)) {
                        counter++;
                        totalScore += Integer.parseInt(review.charAt(0) + "");
                    }
                }
                
            }
        }
        
        //The first term of the array is the # of appearances
        //Second term is the score of the word        
        countAndScore[0] = counter;
        countAndScore[1] = totalScore;
        
        return countAndScore;
    }
    
    public static double sentenceReview() throws FileNotFoundException {
        
        System.out.print("Enter the name of the the file that you want to find the average score for: ");
        String fileName = kbInput.nextLine();
        
        File review = new File( ".\\data\\movie.review\\" + fileName);
        wordListInput = new Scanner(review);
        
        double numerator = 0; //total of all word scores (not averaged)
        double denominator = 0; //total appearances of all words
        
        while(wordListInput.hasNextLine()) {
            
            String word = wordListInput.nextLine();
            int[] wordData = appearancesAndScore(word);
                        
            numerator += wordData[1]; //adding the scores of all the words from original file
            denominator += wordData[0]; //adding # of appearances of all the words in the original file
            
        }
        
        if (denominator == 0.0) {
            System.out.println("This review cannot be scored.");
            return 0.0;
        }
        
        double reviewScore = (double) numerator / denominator;
        return reviewScore;
        
    }
    
    public static void multipleWordScores() throws FileNotFoundException {
        
        System.out.print("Enter the name of the the file with words you want to score: ");
        String fileName = kbInput.nextLine();
        
        File review = new File( ".\\data\\movie.review\\" + fileName);
        wordListInput = new Scanner(review);
        
        //initializing variables to find min and max
        double min = 4;
        double max = 0;
        String minWord = "";
        String maxWord = "";
        
        while (wordListInput.hasNextLine()) { //while there are more words in file
            
            String word = wordListInput.nextLine(); //get word
            int[] wordData = appearancesAndScore(word); //get # of appearances and score
            
            int appearances = wordData[0];
            int score = wordData[1];
            
            double avgScore = (double) score / appearances;
            
            if (avgScore < min) { //if score is lower than current min, make this word and score the minimum
                min = avgScore;
                minWord = word;
            }
            
            if (avgScore > max) { //if score is higher than current max, make this word and score the maximum
                max = avgScore;
                maxWord = word;
            }
            
        }
        
        System.out.println("The most negative word in the file, with a score of " + min + ", is " + minWord + ".");
        System.out.println("The most positive word in the file, with a score of " + max + ", is " + maxWord + ".");
        
    }

    //This method sorts words from a given file into positive and negative files
    public static void multipleWordSort() throws IOException {
        
        //These will add words to the positive and negative files
        BufferedWriter posWriter = new BufferedWriter(new FileWriter(posFile));
        BufferedWriter negWriter = new BufferedWriter(new FileWriter(negFile));
        
        //getting filename and creating scanner
        System.out.print("Enter the name of the the file with words you want to sort: ");
        String fileName = kbInput.nextLine();
        
        File review = new File( ".\\data\\movie.review\\" + fileName);
        wordListInput = new Scanner(review);
        
        while (wordListInput.hasNextLine()) { //This loop gets the score of each word and checks if the word should be considered negative or positive
            
            String word = wordListInput.nextLine();
            int[] wordData = appearancesAndScore(word);
            
            int appearances = wordData[0];
            int score = wordData[1];
            
            double avgScore = (double) score / appearances;
            
            if (avgScore > 2.1) {
                posWriter.write(word + "\n");
            }
            
            else if (avgScore < 1.9) {
                negWriter.write(word + "\n");
            }
        }
        
        posWriter.close();
        negWriter.close();
        
    }
    
    //Main Menu
    public static void menu() throws FileNotFoundException, IOException {
        
        //print menu
        System.out.println("What would you like to do?");
        System.out.println("1: Get the score of a word");
        System.out.println("2: Get the average score of words in a file (one word per line)");
        System.out.println("3: Find the highest/lowest scoring words in a file");
        System.out.println("4: Sort words from a file into positive.txt and negative.txt");
        System.out.println("5: Exit this program");
        System.out.print("Enter a number 1-5: ");
        
        
        //get answer
        String answer = kbInput.nextLine();
        System.out.println(""); //skips a line before printing answer-specific stuff
        
        boolean runAgain = true;
        
        
        
        if (answer.equals("1")) { //get word score
            
            int[] wordAppearancesAndScore = appearancesAndScore(""); //array[0] = # of appearances, array[1] = Total score of the word
        
            if (wordAppearancesAndScore[0] == 0){
                
                System.out.println("Word not found.");
                
            } else {

                double averageScore = (double) wordAppearancesAndScore[1] / wordAppearancesAndScore[0]; //total score / appearances

                System.out.println("Appearances: " + wordAppearancesAndScore[0]);
                System.out.println("Average Score: " + averageScore);
            }
            
        }
        
        else if (answer.equals("2")) { //get avg score of file
            
            double reviewScore = sentenceReview(); //gets the avg score of the file
            String overall = "neutral"; //overall tone of the file based on the score

            if (reviewScore < 1.99) {
                overall = "negative";
            } 
            else if (reviewScore > 2.01) {
                overall = "positive";
            }

            System.out.println("The average score of the words in this file is " + reviewScore +  ".");
            System.out.println("The overall sentiment is " + overall + ".");
            
        }
        
        else if (answer.equals("3")) { //get highest/lowest scoring words from file
            
            multipleWordScores();
        }
        
        else if (answer.equals("4")) { //sort words from file into positive and negative
            
            multipleWordSort();
        }
        
        else if (answer.equals("5")) { //quit program
            runAgain = false;
        }
        
        else {
            System.out.println(answer);
            System.out.println("Invalid Input.");
        }
        
        if (runAgain) { //if user does not quit program, show menu again
            System.out.println("");
            menu();
        }
        
    }

}
