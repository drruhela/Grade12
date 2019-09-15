public class Ghost extends Character implements GhostInterface {

	//constructors
	public Ghost(int xLoc, int yLoc, String name) {

		super (xLoc, yLoc, name); //calls constructor from Character class

		this.fillColor = color ( (float) Math.random() * 255, (float) Math.random() * 255, (float) Math.random() * 255 ); //get random color
	}

	public Ghost(int xLoc, int yLoc) {

		this (xLoc, yLoc, "Ghost");

	}

	public Ghost(String name) {

		this ( (int) (Math.random() * (width - SIZE) + SIZE/2.0 ), (int) (Math.random() * (height - SIZE*1.25) + SIZE/2.0), name);
	
	}

	public void drawGhost() { //draws ghost

		fill(this.fillColor);

		//making the ghost shape
		//half circle (top)
		noStroke();
		arc(this.xLoc, this.yLoc, SIZE, SIZE, -PI, 0);

		//square (middle)
		rect(this.xLoc - (SIZE*.5) , this.yLoc, SIZE, SIZE);

		//triangles (bottom/legs)
		float length = SIZE / 4;
		float x = this.xLoc - (SIZE*.5);
		float y = this.yLoc + SIZE;
		float height = (float) ( (length * .5) * Math.sin( radians(60)) );

		for (int legs = 0; legs < 4; ++legs) { //makes 4 legs at the bottom of the ghost
			triangle( x, y, x+length, y, x + (.5 * length), y + height);
			x += length;
		}

		//making the eyes
		fill(0);
		if (this.direction == RIGHT) { //make eye at the right side of ghost
			
			ellipse(this.xLoc + length, this.yLoc, .2 * SIZE, .2 * SIZE);

		}

		else if (this.direction == LEFT) { //make eye at left side of ghost
			
			ellipse(this.xLoc - length, this.yLoc, .2 * SIZE, .2 * SIZE);

		}

		else { //makes two eyes if not moving or going up or down
			ellipse(this.xLoc + length, this.yLoc, .2 * SIZE, .2 * SIZE);
			ellipse(this.xLoc - length, this.yLoc, .2 * SIZE, .2 * SIZE);
		}
	}

}
