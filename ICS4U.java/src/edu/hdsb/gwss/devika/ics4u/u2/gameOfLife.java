/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u2;

import java.util.Scanner;

/**
 *
 * @author drruh
 */
public class gameOfLife {

    /**
     * @param args the command line arguments
     */
    
    static int ROWS;
    static int COLS;
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        ROWS = Integer.parseInt(input.nextLine());
        
        System.out.print("Enter number of columns: ");
        COLS = Integer.parseInt(input.nextLine());
        
        System.out.print("Number of living cells: ");
        final int beforeLiving = Integer.parseInt(input.nextLine());
        
        int[][] beforeBoard = new int[ROWS][COLS];
        
        int lives = 0;
        while (lives < beforeLiving) {
            
            int row = (int) (Math.random() * ROWS);
            int col = (int) (Math.random() * COLS);
            
            if (beforeBoard[row][col] != 1) {
                beforeBoard[row][col] = 1;
                lives ++;
            }
            
        }
        
        printArray(beforeBoard);
        System.out.println("");
        int[][] board = finalBoard(beforeBoard);
        printArray(board);
        
        menu(board);
        
    }
    
    public static void printArray(int[][] array) {
        
        for (int i = 0; i < ROWS; i++) {
            
            for (int j = 0; j < COLS; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        
        
    }
    
    public static int[][] finalBoard(int[][] previousBoard) {
        
        int[][] afterBoard = previousBoard;
        for (int row = 0; row < ROWS; row++) {
            
            for (int col = 0; col < COLS; col++) {
                int neighbors = 0;
               
                if (row == 0) { //top row cases

                    if (col != 0 && col!= COLS - 1) { //top edge

                        neighbors += previousBoard[row][col+1];
                            
                        neighbors += previousBoard[row][col-1];
                           
                        neighbors += previousBoard[row+1][col];
                            
                        neighbors += previousBoard[row+1][col-1];
                                                        
                        neighbors += previousBoard[row+1][col+1];

                    } else if ( col == 0) { //top left corner
                            
                        neighbors += previousBoard[row][col+1];
                            
                        neighbors += previousBoard[row+1][col];
                            
                        neighbors += previousBoard[row+1][col+1];
                            
                    } else if ( col == COLS-1) { //top right corner
                            
                        neighbors += previousBoard[row][col-1];
                            
                        neighbors += previousBoard[row+1][col];
                            
                        neighbors += previousBoard[row+1][col-1];
                        
                    }

                } else if ( row == ROWS - 1) { //last row cases

                    if (col != 0 && col!= COLS - 1) { //bottom edge
                            
                        neighbors += previousBoard[row][col+1];
                            
                        neighbors += previousBoard[row][col-1];
                            
                        neighbors += previousBoard[row-1][col];
                            
                        neighbors += previousBoard[row-1][col-1];
                            
                        neighbors += previousBoard[row-1][col+1];
                            
                            
                    } else if ( col == 0) { //bottom left corner
                            
                        neighbors += previousBoard[row][col+1];
                            
                        neighbors += previousBoard[row-1][col];
                            
                        neighbors += previousBoard[row-1][col+1];
                            
                    } else if ( col == COLS-1) { //bottom right corner
                            
                         neighbors += previousBoard[row][col-1];
                            
                        neighbors += previousBoard[row-1][col];
                            
                        neighbors += previousBoard[row-1][col-1];

                    }
                        
                } else {
                        
                    if (col == 0) { //left edge 
                            
                        neighbors += previousBoard[row][col+1];
                            
                        neighbors += previousBoard[row-1][col];
                            
                        neighbors += previousBoard[row+1][col];
                            
                        neighbors += previousBoard[row-1][col+1];
                            
                        neighbors += previousBoard[row+1][col+1];
                            
                    } else if (col == COLS - 1) {
                            
                        neighbors += previousBoard[row][col-1];
                            
                        neighbors += previousBoard[row-1][col];
                            
                        neighbors += previousBoard[row+1][col];
                            
                        neighbors += previousBoard[row-1][col-1];
                            
                        neighbors += previousBoard[row+1][col-1];
                            
                    } else {
                            
                        neighbors += previousBoard[row][col+1];
                            
                        neighbors += previousBoard[row][col-1];
                            
                        neighbors += previousBoard[row+1][col];
                            
                        neighbors += previousBoard[row-1][col];
                            
                        neighbors += previousBoard[row+1][col+1];
                            
                        neighbors += previousBoard[row+1][col-1];
                            
                        neighbors += previousBoard[row-1][col+1];
                            
                        neighbors += previousBoard[row-1][col-1];

                    }
                        
                }

                if (neighbors < 2 || neighbors > 3) {
                    
                    if (previousBoard[row][col] == 1) {
                        afterBoard[row][col] = 0;
                    }
                    
                } else if (neighbors == 3) {
                    
                    if (previousBoard[row][col] == 0) {
                        afterBoard[row][col] = 1;
                    }
                }
            }
        }
        
        return afterBoard;
            
    }
    
    public static void menu(int[][] currentBoard) {
        Scanner input = new Scanner (System.in);
        boolean again = true;
        
        while (again) {
            
            System.out.println("Continue? (Y or N) ");
            String answer = input.nextLine();
            
            if (answer.toUpperCase().equals("N")) {
                again = false;
            } else {
                int[][] newBoard = finalBoard(currentBoard);
                printArray(newBoard);
            }
            
        }
        
    }
        
        
    

    
}
