/*
 * Game Of Life
 * ICS4U.S2.2019
 */

// CONSTANTS
static final int OFFSET = 5; 
static final int DIMENSIONS = 40;
static final int CELL_DEAD = 0;
static final int CELL_ALIVE = 1;

// GLOBAL VARIABLES
int cellWidth;
int[][] data;

/* SETUP */
void setup() {

  // WINDOWS SIZE
  size( 610, 610 );

  // GAME OF LIFE GRID SIZE
  println( "Grid Size: " + DIMENSIONS + "x" + DIMENSIONS );

  // BACKGROUND
  background( #B2CBFF );

  // FRAME RATE
  frameRate( 2 );

  // RECT MODE; Top Left Corner
  rectMode(CORNER);

  // STROKE COLOR
  stroke( 255 );

  // CELL DIMENSIONS
  cellWidth = (int) ( (width-2*OFFSET) / 40 );
  println( "Grid Size: " + DIMENSIONS + "x" + DIMENSIONS );

  // CELL DATA
  data = new int[DIMENSIONS][DIMENSIONS];

  // PLACE RANDOM CELLS
  placeRandomCells( 800 );

  // DRAW CELLS
  drawCells();
}


/* SETUP */
void draw() {

  // NEXT GENERATION
  nextGeneration();

  // DRAW CELLS
  drawCells();
}

/*
 * TODO:  GAME OF LIFE LOGIC; Next Generation
 */
void nextGeneration() {

  // TODO: GAME OF LIFE

  for ( int row = 0; row < 40; row++ ) {
    for ( int col = 0; col < 40; col++ ) {

      // GAME LOGIC GOES HERE
      int neighbors = 0;
               
                if (row == 0) { //top row cases

                    if (col != 0 && col!= data[row].length - 1) { //top edge

                        neighbors += data[row][col+1];
                            
                        neighbors += data[row][col-1];
                           
                        neighbors += data[row+1][col];
                            
                        neighbors += data[row+1][col-1];
                                                        
                        neighbors += data[row+1][col+1];

                    } else if ( col == 0) { //top left corner
                            
                        neighbors += data[row][col+1];
                            
                        neighbors += data[row+1][col];
                            
                        neighbors += data[row+1][col+1];
                            
                    } else if ( col == data[row].length - 1) { //top right corner
                            
                        neighbors += data[row][col-1];
                            
                        neighbors += data[row+1][col];
                            
                        neighbors += data[row+1][col-1];
                        
                    }

                } else if ( row == data.length - 1) { //last row cases

                    if (col != 0 && col!= data[row].length - 1) { //bottom edge
                            
                        neighbors += data[row][col+1];
                            
                        neighbors += data[row][col-1];
                            
                        neighbors += data[row-1][col];
                            
                        neighbors += data[row-1][col-1];
                            
                        neighbors += data[row-1][col+1];
                            
                            
                    } else if ( col == 0) { //bottom left corner
                            
                        neighbors += data[row][col+1];
                            
                        neighbors += data[row-1][col];
                            
                        neighbors += data[row-1][col+1];
                            
                    } else if ( col == data[row].length - 1) { //bottom right corner
                            
                         neighbors += data[row][col-1];
                            
                        neighbors += data[row-1][col];
                            
                        neighbors += data[row-1][col-1];

                    }
                        
                } else {
                        
                    if (col == 0) { //left edge 
                            
                        neighbors += data[row][col+1];
                            
                        neighbors += data[row-1][col];
                            
                        neighbors += data[row+1][col];
                            
                        neighbors += data[row-1][col+1];
                            
                        neighbors += data[row+1][col+1];
                            
                    } else if (col == data[row].length - 1) {
                            
                        neighbors += data[row][col-1];
                            
                        neighbors += data[row-1][col];
                            
                        neighbors += data[row+1][col];
                            
                        neighbors += data[row-1][col-1];
                            
                        neighbors += data[row+1][col-1];
                            
                    } else {
                            
                        neighbors += data[row][col+1];
                            
                        neighbors += data[row][col-1];
                            
                        neighbors += data[row+1][col];
                            
                        neighbors += data[row-1][col];
                            
                        neighbors += data[row+1][col+1];
                            
                        neighbors += data[row+1][col-1];
                            
                        neighbors += data[row-1][col+1];
                            
                        neighbors += data[row-1][col-1];

                    }
                        
                }

                if (neighbors < 2 || neighbors > 3) {
                    
                    if (data[row][col] == 1) {
                        data[row][col] = 0;
                    }
                    
                } else if (neighbors == 3) {
                    
                    if (data[row][col] == 0) {
                        data[row][col] = 1;
                    }
                }
            }
        }
      
      
    

} // END nextGeneration()


/*
 * TODO:  PLACE RANDOM CELLS @ START OF GAME
 */
void placeRandomCells( int num ) {

  int lives = 0;
  while (lives < num) {
            
    int row = (int) (Math.random() * DIMENSIONS);
    int col = (int) (Math.random() * DIMENSIONS);
            
    if (data[row][col] != 1) {
      data[row][col] = 1;
      lives ++;
      }
    }
  
} 


/* 
 * DRAW CELLS based on their state; ALIVE - Green, DEAD/EMPTY - White
 */
void drawCells( ) {

  for ( int row = 0; row < 40; row++ ) {
    for ( int col = 0; col < 40; col++ ) {

      if ( data[row][col] == CELL_ALIVE ) {
        fill( #37FC1F );
      } else {
        fill( 255 );
      }
      rect( OFFSET + row*cellWidth, OFFSET + col*cellWidth, cellWidth, cellWidth );
    }
  }
} // END drawCells()
