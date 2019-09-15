void setup() {
  
  size(800, 800);
  background(255);
  
  fractal(width/2, height/2, 50); //center
  fractal(0, height/2, 400); //left
  fractal(width, height/2, 400); //right
  fractal(width/2, 0, 400); //up
  fractal(width/2, height, 400); //down

}

void circle(float x, float y, float radius) { //makes circles inside circle (similar to a bullseye)
  
  float red = (float) Math.random() * 255;
  float green = (float) Math.random() * 255;
  float blue = (float) Math.random() * 255;
  
  fill(red, green, blue); //each circle is a different color so the overall result has multiple colors
  ellipse(x, y, radius, radius); //makes circle with the center at (0,0)
  
  if (radius >= 10) { //until the radius of the last circle is 10, circles will keep on getting drawn inside the previous one
    
    circle(x, y, radius-10); //the recursive call
    
  }
  
}

void fractal(float x, float y, float radius) { //uses the first method to make multiple circle thingies
  
  circle(x, y, radius); // calls the circle method
  
  if (radius >= 30) { //makes the circle thingy above, below, left, and right of the previous circle
  
    radius = radius / 2;
    
    fractal(x, y - radius, radius);  //top
    fractal(x, y + radius, radius); //bottom
    fractal(x - radius, y, radius); //left
    fractal( x + radius, y, radius); //right
    
  }
  
}
