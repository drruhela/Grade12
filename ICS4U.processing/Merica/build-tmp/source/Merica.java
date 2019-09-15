import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.Scanner; 
import java.util.StringTokenizer; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Merica extends PApplet {

/*
 * Merica
 * Author: Devika Ruhela
 * 2018-19.S2
 */



final static String[] FILE_NAMES_ELECTIONS = {
  "USA1960.txt", "USA1964.txt", "USA1968.txt", "USA1972.txt", "USA1976.txt", 
  "USA1980.txt", "USA1984.txt", "USA1988.txt", "USA1992.txt", "USA1996.txt", 
  "USA2000.txt", "USA2004.txt", "USA2008.txt", "USA2012.txt", "USA2016.txt"
};

String fileName;
String[][] electionResults;
PFont font;
int republicanVotes;
int democraticVotes;
int otherVotes;

/*
 * SETUP; CALLED ONCE @ STARTUP
 */
public void setup() {
  
  
  
  //Setting up the text font
  //int textSize = 35;
  //font = createFont("verdana", textSize, true);
  
  
  // DEFAULT MAP
  fileName = FILE_NAMES_ELECTIONS[0];

  // ELECTION RESULTS
  electionResult();
  background( 40, 100, 255); //ocean color
  drawMap(); //draws map of 1960 (default)
  
  showText(); //shows votes for all parties and sets window title to "America" + year + "election results"
  
}

/*
 * DRAW; CALLED @ FRAME RATE
 */

public void draw() {
  
}

/*
 * ELECTION RESULTS
 * - parse election file INTO electionResults[][] 2D-Array, or data structure of your choice.
 */
public void electionResult( ) {
  try {

    // ELECTION RESULT DATA
    Scanner data = new Scanner( new File( dataPath("") + "\\" + fileName ) );

    //rows=num of states; each row has 4 columns (state name and votes for each candidate)
    
    //getting number of states/rows
    int counter = -1;
    while (data.hasNextLine()) {
      counter += 1;
      data.nextLine();
    }

    //to get to top of the results data file again
    data = new Scanner (new File (dataPath("") + "\\" + fileName)); 

    electionResults = new String[counter][4]; //don't hardcode it

    data.nextLine();

    //going through the results and putting them into the array electionResults
    for (int row = 0; row < electionResults.length; row++) {

      String line = data.nextLine();
      StringTokenizer st = new StringTokenizer(line, ",");

      for (int col = 0; col < electionResults[row].length; col++) {

        electionResults[row][col] = st.nextToken();
        
      }
    }

    data.close();
  }
  catch (Exception e ) {
    e.printStackTrace();
  }
}

//getting total votes of all parties

public void getPartyVotes() {
  
  //getting total votes for all parties
  republicanVotes = 0;
  democraticVotes = 0;
  otherVotes = 0;
  
  for (int row = 0; row < electionResults.length; row++) {
    
    republicanVotes += Integer.parseInt(electionResults[row][1]);
    democraticVotes += Integer.parseInt(electionResults[row][2]);
    otherVotes += Integer.parseInt(electionResults[row][3]);
    
  }
  
}


/*
 * DRAW MAP OFF USA w/ Election Results
 */
public void drawMap() {
  // MAP
  try {

    // USA MAP DATA
    Scanner data = new Scanner( new File( dataPath("") + "\\USA.txt" ) );

    StringTokenizer st = new StringTokenizer(data.nextLine());

    //transformation
    
    //getting min and max latitude and longitude of USA map from the data file; will be used to determine how to transform and scale the states when drawing them
    float minLat = Float.parseFloat(st.nextToken());
    float minLon = Float.parseFloat(st.nextToken());

    st = new StringTokenizer(data.nextLine());
    float maxLat = Float.parseFloat(st.nextToken());
    float maxLon = Float.parseFloat(st.nextToken());
    
    //getting scale to make the map bigger; the smaller scale will be used
    float xScale = (width)/(maxLat-minLat);
    float yScale = (height)/(maxLon-minLon);
    
    float scale = xScale;
    if(yScale < scale) {
      scale = yScale;
    }

    data.nextLine();
    data.nextLine();
    
    //making the background (aka the ocean) blue
    background( 40, 100, 255);
    
    //drawing each state until there are no more states (or lines) in the data
    while (data.hasNextLine()) {
     
      String state = data.nextLine(); //state name will be used when calling the setColour() method
      data.nextLine();
      int numOfCoords = Integer.parseInt(data.nextLine()); //this line gives the number of lat and lon coords; this will be # of vertices
     
      setColour( state );
      
      //starting drawing the state
      beginShape();
      for (int i= 0; i < numOfCoords; i++) {
     
        String coords = data.nextLine();
        st = new StringTokenizer(coords);
       
        float lat = Float.parseFloat(st.nextToken());
        float lon = Float.parseFloat(st.nextToken());
       
        vertex( (lat + Math.abs(minLat)) * scale, (-lon + Math.abs(maxLon)) * scale); //scaled vertex
     
      }
      
      endShape();
      data.nextLine();
    }
    
    //get total votes
    getPartyVotes();
     
    data.close();
  }
  catch (Exception e ) {
    e.printStackTrace();
  }
}

/*
 * Draw State
 */
public void setColour(String state ) {
  
  //getting color of state
  for (int row = 0; row < electionResults.length; row++) {
    
    if (state.equals(electionResults[row][0])) { //when the state is found in the electionResults array, get the votes for it
      
      //votes for each party
      int rep = Integer.parseInt(electionResults[row][1]);
      int demo = Integer.parseInt(electionResults[row][2]);
      int other = Integer.parseInt(electionResults[row][3]);
      
      //getting percentage of each party's votes and getting color value based on that
      float red = ( (float) rep / (rep + demo + other)) * 255;
      float green = ( (float) other / (rep + demo + other)) * 255;
      float blue = ( (float) demo / (rep + demo + other)) * 255;
      
      fill(red, green, blue);
    
    }
  
  }
  
}

public void showText() {
  
  //setting window title
  String year = fileName.substring(3, fileName.length()-4);
  surface.setTitle("America " + year + " Election Results");
    
    
  int textHeight = 35;
  font = createFont("verdana", textHeight, true);
  textFont(font);
      
  //republican
  String displayRep = "Republican: " + republicanVotes;
  fill(188,47,47);
  text(displayRep, textHeight, height-(textHeight*4));
    
  //democratic
  String displayDemo = "Democratic: " + democraticVotes;
  fill(39,12, 212);
  text(displayDemo, textHeight, height-(textHeight*2.5f));
  
  //other party
  String displayOther = "Other: " + otherVotes;
  fill(24, 168, 19);
  text(displayOther, textHeight, height-textHeight);
  
}
/*
 */
public void keyPressed() {
  if ( key >= 'a' && key <= ( 'a' + FILE_NAMES_ELECTIONS.length - 1 )  ) {
    fileName = FILE_NAMES_ELECTIONS[key-'a'];
    print( fileName );
    electionResult();
    drawMap();

    //displaying votes and text
    showText();
    
  }
}
  public void settings() {  size(1200, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Merica" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
