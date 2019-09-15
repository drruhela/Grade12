public class Pacman extends Character implements PacmanInterface {

	//instance variables
	protected int lives;
	protected boolean mouthOpen;

	//constructors
	public Pacman(int xLoc, int yLoc, String name) {

		super (xLoc, yLoc, name); //calls constructor from Character class
		this.lives = 3;
		this.mouthOpen = false;
		this.fillColor = color(253,238,34);
	}

	public Pacman(int xLoc, int yLoc) {
		this (xLoc, yLoc, "Pacman");
	}

	public Pacman() {

		this ((int) (Math.random() * (width - SIZE) + SIZE/2.0 ), (int) (Math.random() * (height - SIZE) + SIZE/2.0), "Pacman");		
		
	}

	//instance methods

	public void move() { //calls the move method from Character class, but changes mouthOpen so it opens and closes
		this.mouthOpen = !this.mouthOpen;
		super.move();
	}

	public void drawPacman() { //draws pacman 

		fill(this.fillColor); //set color to yellow

		if (this.mouthOpen) { //if mouth is open, draw arc instead of ellipse

			if (this.direction == RIGHT) { //if going right, put arc opening on right side
				arc( this.xLoc, this.yLoc, SIZE, SIZE, radians(45), radians(315)); //right
			}

			else if (this.direction == LEFT) { //if going left, put arc opening on left side
				arc( this.xLoc, this.yLoc, SIZE, SIZE, radians(225), (3*PI) - radians(45)); //left
			}

			else if (this.direction == UP) { //if going up, put arc opening on top
				arc( this.xLoc, this.yLoc, SIZE, SIZE, -radians(45), radians(225)); //Up
			}

			else if (this.direction == DOWN) { //if going down, put arc opening on bottom
				arc( this.xLoc, this.yLoc, SIZE, SIZE, radians(135), (2*PI) + radians(45)); //down
			}

		} else { //if mouth closed, draw full circle
			ellipse(this.xLoc, this.yLoc, SIZE, SIZE);
		}

	}

	public void die() { //if pacman dies, subtract 1 from lives
		lives -= 1;
		this.xLoc = (int) (Math.random() * (width - SIZE/2.0) + SIZE/2.0 );
		this.yLoc = (int) (Math.random() * (height - SIZE/2.0) + SIZE/2.0);

	}

	public boolean isAlive() { //if pacman runs out of lives, return false cuz it is dead
		if (this.lives == 0) {
			return false;
		}
		return true;
	}

	//getters
	public int getLives() { //return number of lives left
		return this.lives;
	}

	public String toString() { //return info about object as string

		String info = super.toString();
		return info + " Lives: " + lives;

	}

}