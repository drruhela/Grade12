/*
 * Mountain Paths - Greedy Algorithm
 * Devika Ruhela
 * 2018.03.26 - v1.0
 */
package edu.hdsb.gwss.devika.ics4u.u3;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MountainPaths {

    static final String FS = File.separator;

    /**
     * Mount Paths
     */
    public static void main( String[] args ) throws Exception {

        // ***********************************
        // TASK 1:  read data into a 2D Array
        // 
        System.out.println( "TASK 1: READ DATA" );
        int[][] data = read( "." + FS + "data" + FS + "mountain.paths" + FS + "Colorado.844x480.dat" );
        
        

        // ***********************************
        // Construct DrawingPanel, and get its Graphics context
        //
        
        DrawingPanel panel = new DrawingPanel( data[0].length, data.length );
        Graphics g = panel.getGraphics();

        // ***********************************
        // TASK 2:  find HIGHEST & LOWEST elevation; for GRAY SCALE
        //
        System.out.println( "TASK 2: HIGHEST / LOWEST ELEVATION" );
        int min = findMinValue( data );
        System.out.println( "\tMin: " + min );

        int max = findMaxValue( data );
        System.out.println( "\tMax: " + max );

        // ***********************************
        // TASK 3:  Draw The Map
        //
        System.out.println( "TASK 3: DRAW MAP" );
        drawMap( g, data );

        // ***********************************
        // TASK 4A:  implement indexOfMinInCol
        //
        System.out.println( "TASK 4A: INDEX OF MIN IN COL 0" );
        int minRow = indexOfMinInCol( data, 0 );
        System.out.println( "\tRow with lowest Col 0 Value: " + minRow );

        // ***********************************
        // TASK 4B:  use minRow as starting point to draw path
        //
        System.out.println( "TASK 4B: PATH from LOWEST STARTING ELEVATION" );
        g.setColor( Color.RED );
        int totalChange = drawLowestElevPath( g, data, minRow, 0 ); //
        System.out.println( "\tLowest-Elevation-Change Path starting at row " + minRow + " gives total change of: " + totalChange );

        // ***********************************
        // TASK 5:  determine the BEST path
        //
        g.setColor( Color.RED );
        int bestRow = indexOfLowestElevPath( g, data );
        
        // ***********************************
        // TASK 6:  draw the best path
        //
        System.out.println( "TASK 6: DRAW BEST PATH" );
        //drawMap.drawMap(g); //use this to get rid of all red lines
        g.setColor( Color.GREEN ); //set brush to green for drawing best path
        totalChange = drawLowestElevPath( g, data, bestRow, 0 );
        System.out.println( "\tThe Lowest-Elevation-Change Path starts at row: " + bestRow + " and gives a total change of: " + totalChange );
        
    }

    /**
     * This method reads a 2D data set from the specified file. The Graphics
     * industry standard is width by height (width x height), while programmers
     * use rows x cols / (height x width).
     *
     * @param fileName the name of the file
     * @return a 2D array (rows x cols) of the data from the file read
     */
    public static int[][] read( String fileName ) throws FileNotFoundException {
        
        int[][] data = null; //initializing array. Size will be set later.
        
        //creating scanner to read from text file with elevation data
        Scanner dataReader = new Scanner(new File( fileName ) );
        
        //finding num of columns in each row
        StringTokenizer st = new StringTokenizer(dataReader.nextLine());
        int cols = st.countTokens();
        
        //getting number of rows
        int rows = 1; //starts at 1 because dataReader.nextLine() has already been called once
        while (dataReader.hasNextLine()) { //counting number of rows in file
            rows++;
            dataReader.nextLine();
        }
        
        //setting size of the data array
        data = new int[rows][cols];
        
        //starting the dataReader scanner from the beginning again to fill data[][]
        dataReader = new Scanner( new File (fileName) );
        
        for (int row = 0; row < data.length; row++) { //filling in data[][] with elevations from the file
            
            String line = dataReader.nextLine();
            st = new StringTokenizer(line); //dividing the line at every space, separating all of the numbers
            
            for (int col = 0; col < data[row].length; col++) {
                
                data[row][col] = Integer.parseInt(st.nextToken()); //putting the elevation numbers into the array
            }
        }
        
        return data; //returns updated array filled with elevation data from the file
    }

    /**
     * @param grid a 2D array from which you want to find the smallest value
     * @return the smallest value in the given 2D array
     */
    public static int findMinValue( int[][] grid ) {
        
        int min = grid[0][0]; //setting min initially to the first number in the first row
        
        for (int row = 0; row < grid.length ; row++) {
            
            for (int col = 0; col < grid[row].length ; col++) {
                
                min = Math.min(min, grid[row][col]); //sets min to the lower of the two values
                
            }
            
        }
        
        return min;

    }

    /**
     * @param grid a 2D array from which you want to find the largest value
     * @return the largest value in the given 2D array
     */
    public static int findMaxValue( int[][] grid ) {
        
        int max = grid[0][0]; //setting max initially to the first number in the first row
        
        for (int row = 0; row < grid.length ; row++) {
            
            for (int col = 0; col < grid[row].length ; col++) {
                
                max = Math.max(max, grid[row][col]); //sets max to greater of the two values
            }
        }
        
        return max;

    }

    /**
     * Given a 2D array of elevation data create a image of size rows x cols,
     * drawing a 1x1 rectangle for each value in the array whose color is set to
     * a a scaled gray value (0-255). Note: to scale the values in the array to
     * 0-255 you must find the min and max values in the original data first.
     *
     * @param g a Graphics context to use
     * @param grid a 2D array of the data
     */
    public static void drawMap( Graphics g, int[][] data ) {
        
        float min = findMinValue(data);
        float max = findMaxValue(data);
        
        for (int row = 0; row < data.length; row++) {
            
            for (int col = 0; col < data[row].length; col++) {
                
                float elevation = data[row][col];
                float slope = (255 / (max - min)) ;
                
                /*
                -the elevations can be scaled to between 0 and 255 using a linear formula: y=mx+b
                -y is the new scaled value (the color)
                -m is the slope that has already been found using (y2-y1)/(x2-x1) using the min and max elevations as the two points: (min, 0) (black) and (max, 255) (white)
                -the b is found by plugging in one of the points (min or max) into the y=mx+b: 0=(slope * min) + b; b = -(slope*min)
                -the equation is y=(slope * elevation) - (slope*min)
                */
                int color = (int) (slope * (elevation - min));
                
                g.setColor( new Color( color, color, color) ); //setting the color
                g.fillRect(col, row, 1, 1); //filling the pixel with the color
                
            }
            
        }
        
    }

    /**
     * Scan a single column of a 2D array and return the index of the row that
     * contains the smallest value
     *
     * @param grid a 2D array
     * @col the column in the 2D array to process
     * @return the index of smallest value from grid at the given col
     */
    public static int indexOfMinInCol( int[][] grid, int col ) {
        // TODO
        
        int min = grid[0][col]; //mininum elevation is initially set to first row and at given column
        int lowestElevRow = 0; //row index is set to 0 cuz this starts at first row
        
        for (int row = 0; row < grid.length; row++) {
            
            int elevation = grid[row][col];
            
            if (elevation < min) {
                min = elevation; //if elevation < min, change the min to current elevation
                lowestElevRow = row; //set row index to current row
            }
            
        }
        return lowestElevRow; //returns index of row with lowest value in entire column
    }

    /**
     * Find the minimum elevation-change route from West-to-East in the given
     * grid, from the given starting row, and draw it using the given graphics
     * context
     *
     * @param g - the graphics context to use
     * @param grid - the 2D array of elevation values
     * @param row - the starting row for traversing to find the min path
     * @return total elevation of the route
     */
    public static int drawLowestElevPath( Graphics g, int[][] data, int row, int col ) {

        if (col == data[0].length-1) { //base case
            return 0; //when last col is reached, set elevation change to 0 so it keeps adding onto this
        }
        
        g.fillRect(col, row, 1, 1); //fill the pixel at (col, row) with width and height of 1
        
        int elevationChangeForward = Math.abs( data[row][col+1] - data[row][col] ); //set elevationChangeForward to the elevation in data[row][col+1} - data[row][col]
        //for now, set both of these elevation changes to elevationChangeForward
        int elevationChangeDown = elevationChangeForward;
        int elevationChangeUp = elevationChangeForward;
        
        //if at top row, set elevationChangeUp to max integer value so the method will not choose go up
        if (row == 0) {
            elevationChangeUp = Integer.MAX_VALUE;
        } else { //otherwise, set it to the elevation diagonally up - current elevation
            elevationChangeUp = Math.abs (data[row-1][col+1] - data[row][col] );
        }
        
        //if at last row, set elevationChangeDown to max integer value so the method will not choose go down
        if (row == data.length - 1) {
            elevationChangeDown = Integer.MAX_VALUE;
        } else { //otherwise, set it to the elevation diagonally down - current elevation
            elevationChangeDown = Math.abs (data[row+1][col+1] - data[row][col] );
        }
        
        int elevationChange = elevationChangeForward;//if none of the following cases are true, then the program will choose to go forward
        
        if( elevationChangeForward <= elevationChangeDown && elevationChangeForward <= elevationChangeUp ) {
            //if elevationChangeForward is same or lower than the diagonal elevationChanges, the row does not change
        }
        else if ( (elevationChangeDown < elevationChangeUp ) ) { //if elevationChangeDown is lowest elevation change, row++ so it moves down one row
            row++;
            elevationChange = elevationChangeDown;
        }
        
        else if ( (elevationChangeUp < elevationChangeDown ) ) {//if elevationChangeUp is lowest elevation change, row-- so it moves up one row
            row--;
            elevationChange = elevationChangeUp;
        }
        
        else { //if elevationChangeUp == elevationChangeDown, pick a random side to go to (up or down)
            
            double rand = Math.random() * 2; //get randoom double between 0 and 2, inclusive
            
            //if rand > 1, go down
            if (rand > 1) {
                row++;
                elevationChange = elevationChangeDown;
            }
            else { //if rand <= 1, go up
                row--;
                elevationChange = elevationChangeUp;
            }
            
        }
        
        //row has already been changed based on elevationChange. Call function again after col+1 and add to current 
        return (elevationChange) + drawLowestElevPath(g, data, row, ++col); 
        
    }

    /**
     * Generate all west-to-east paths, find the one with the lowest total
     * elevation change, and return the index of the row that path starts on.
     *
     * @param g - the graphics context to use
     * @param grid - the 2D array of elevation values
     * @return the index of the row where the lowest elevation-change path
     * starts.
     */
    public static int indexOfLowestElevPath( Graphics g, int[][] data ) {

        // TODO
        int lowestElevation = drawLowestElevPath(g, data, 0, 0); //call drawLowestElevPath with row 0 and col 0 as the starting point
        int index = 0;
        
        for (int row = 1; row < data.length; row++) { //starts at row=1 because the initial lowestElevaton and index is already for row 0
            int elevation = drawLowestElevPath(g, data, row, 0); // call drawLowestElevPath for every row in the array
            
            if (elevation < lowestElevation) { 
                index = row; //set index to the row with lower elevation change
                lowestElevation = elevation; //set lowestElevation to elevation if the elevation change for the current row is less than the already set lowestElevation
            }
        }
        
        return index; //return index of row with lowest elevation change
    }

}
