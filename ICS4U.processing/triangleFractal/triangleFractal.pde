void setup() {
 
  size(600, 600);
  background (255);
  
  tri(width/2, 0, 600);
  
}


void tri( float x, float y, float l) {
  
  float h = (float) Math.sin(radians(60)) * l;
  
  triangle(
    x, y, //top
    x - l/2.0,  y + h, //bottom left
    x + l/2.0, y + h //bottom right
    );
  
  if (l > 4) {
    
    h = (float) Math.sin(radians(60)) * (l/2.0);
    tri (x, y, l/2.0);
    tri (x - l/4.0,  y + h, l/2.0);
    tri (x + l/4.0,  y + h, l/2.0);
  }
}
