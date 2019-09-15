Pacman pacman;
MsPacman paccy;
Ghost blinky;
Ghost pinky;
Ghost inky;
Ghost clyde;

final int DIR_RIGHT = 1;
final int DIR_LEFT = 2;
final int DIR_UP = 3;
final int DIR_DOWN = 4;

PFont font;

void setup() {

	size(500, 500);
	frameRate(20);
  	
  	//creating pacman and ghost objects
	pacman = new Pacman(width/2, height/2);
	println(pacman.toString()); 

	blinky = new Ghost("Blinky");
	println(blinky.toString());

	pinky = new Ghost ("Pinky");
	println(pinky.toString());

	inky = new Ghost ("Inky");
	println(inky.toString());

	clyde = new Ghost("Clyde");
	println(clyde.toString());

	//Setting initial directions of the ghosts:

	//blinky (horizontal movements only)
	double initialDirection = Math.random() * 2;

	if (initialDirection < 1) {
		blinky.setDirection(DIR_RIGHT);
	} else {
		blinky.setDirection(DIR_LEFT);
	}
	
	//pinky (vertical movemennts only)
	initialDirection = Math.random() * 2;

	if (initialDirection < 1) {
		pinky.setDirection(DIR_DOWN);
	} else {
		pinky.setDirection(DIR_UP);
	}
	
	//inky (random movements)
	inky.setDirection(newDirection());

	//clyde's initial direction is just 0 because it will follow pacman
}

void draw() {
	
	background(0);

	pacman.drawPacman(); //draws pacman
	checkDeath(); //checks if pacman runs into any ghosts

	//ghost movements
	moveHorizontal(blinky);
	moveVertical(pinky);
	moveRandom(inky);
	followPacman(clyde);

	//drawing the ghosts
	blinky.drawGhost();
	pinky.drawGhost();
	inky.drawGhost();
	clyde.drawGhost();

	showLives(); //displays pacman's remaining lives in the window

	if (!pacman.isAlive()) { //if pacman loses all 3 lives, the game ends
		gameOverScreen();
		noLoop();
	} 
}

void moveHorizontal (Ghost ghost) { //moves ghost right and left

	if (ghost.getDirection() == DIR_RIGHT) { //if ghost is currently moving right

		if (ghost.getXLoc() + Ghost.SIZE/2.0 >= width) { //if ghost reaches the right edge of window, go left
			ghost.setDirection(DIR_LEFT);
		}
	}

	else if (ghost.getDirection() == DIR_LEFT) { //if ghost is currently moving left

		if (ghost.getXLoc() - Ghost.SIZE/2.0 <= 0) { //if ghost reaches left edge, go right
			ghost.setDirection(DIR_RIGHT);
		}

	}

	ghost.move(); //move ghost

}

void moveVertical (Ghost ghost) { //moves ghost up and down

	if (ghost.getDirection() == DIR_DOWN) { //if ghost is currently moving down
		if (ghost.getYLoc() + Ghost.SIZE * 1.25 >= height) { //if ghost reaches bottom edge, go up
			ghost.setDirection(DIR_UP);
		}
	}

	else if (ghost.getDirection() == DIR_UP) { //if ghost is currently moving up

		if (ghost.getYLoc() - Ghost.SIZE/2.0 <= 0) { //if ghost reaches top edge, go down
			ghost.setDirection(DIR_DOWN);
		}

	}

	ghost.move(); //move ghost

}

int stepsTaken = 0;
void moveRandom( Ghost ghost) { //ghost changes direction every 30 steps

	if (ghost.getDirection() == DIR_RIGHT || ghost.getDirection() == DIR_LEFT) {
		moveHorizontal(ghost);
	} else {
		moveVertical(ghost);
	}

	stepsTaken += 1; //each time the ghost moves (everytime draw() is called), add 1 to stepsTaken

	if (stepsTaken >= 30) { //for every 30 stepsTaken, set a new direction
		ghost.setDirection(newDirection());
		stepsTaken = 0; //reset stepsTaken
	}

}

void followPacman(Ghost ghost) { //ghost follows pacman

	//find shortest distance
	int xDistance = ghost.getXLoc() - pacman.getXLoc();
	int yDistance = ghost.getYLoc() - pacman.getYLoc();

	if (Math.abs( xDistance) < Math.abs(yDistance)) { //if ghost if closer to pacman horizontally than vertically, then move horizontally

		if (Math.abs(xDistance) < Ghost.SIZE) { //if horizontal distance is close enough for them to touch, move towards pacman vertically

			if (yDistance > 0) { // if ghost is below pacman, move up

				ghost.setDirection(DIR_UP);

			} else { //if ghost is above pacman, move down

				ghost.setDirection(DIR_DOWN);

			}

			moveVertical(ghost);

		} else if (xDistance > 0) { //if ghost is right of pacman, move left

			ghost.setDirection(DIR_LEFT);
			moveHorizontal(ghost);

		}

		else { //if ghost is left of pacman, move right

			ghost.setDirection(DIR_RIGHT);
			moveHorizontal(ghost);

		}

	} else { //if ghost if closer to pacman vertically than horizontally, then move vertically

		if (Math.abs(yDistance) < 50) { //if vertical distance is close enough for them to touch, move towards pacman horizontally

			if (xDistance > 0) { // if ghost is right of pacman, move left

				ghost.setDirection(DIR_LEFT);

			} else { //if ghost is left of pacman, move right

				ghost.setDirection(DIR_RIGHT);

			}

			moveHorizontal(ghost);

		} 

		else if (yDistance > 0) { //if ghost is below pacman, move up

			ghost.setDirection(DIR_UP);
			moveVertical(ghost);

		}

		else { //if ghost is above pacman, move down

			ghost.setDirection(DIR_DOWN);
			moveVertical(ghost);

		}

	}
	
}

int newDirection() { //get a random direction

	double direction = Math.random() * 4;

	if (direction < 1) {
		return DIR_RIGHT;
	}

	else if (direction < 2) {
		return DIR_LEFT;
	}

	else if (direction < 3) {
		return DIR_UP;
	} 

	else {
		return DIR_DOWN;
	}

}

void checkDeath() {

	//get horizontal distances between pacman and the ghosts
	int blinkyDistX = Math.abs(pacman.getXLoc() - blinky.getXLoc());
	int pinkyDistX = Math.abs(pacman.getXLoc() - pinky.getXLoc());
	int inkyDistX = Math.abs(pacman.getXLoc() - inky.getXLoc());
	int clydeDistX = Math.abs(pacman.getXLoc() - clyde.getXLoc());

	//get vertical distances between pacman and the ghosts
	int blinkyDistY = Math.abs(pacman.getYLoc() - blinky.getYLoc());
	int pinkyDistY = Math.abs(pacman.getYLoc() - pinky.getYLoc());
	int inkyDistY = Math.abs(pacman.getYLoc() - inky.getYLoc());
	int clydeDistY = Math.abs(pacman.getYLoc() - clyde.getYLoc());

	int size = Pacman.SIZE;

	//if pacman is touching any of the ghosts, pacman dies (loses a life)
	if ( (blinkyDistX < size && blinkyDistY < size) || (pinkyDistX < size && pinkyDistY < size)
		|| (inkyDistX < size && inkyDistY < size) || (clydeDistX < size && clydeDistY < size) ) {

		pacman.die();

	}

}

void showLives() { //displays lives in window

	String lives = "Lives: " + pacman.getLives();

	int textHeight = 20;
	font = createFont("consolas", textHeight, true);
	textFont(font);

	fill(255,255,255);
	text(lives, textHeight, textHeight);
}

void gameOverScreen() { //displays "Game Over" in window
	String text = "Game Over!";

	int textHeight = 50;
	font = createFont("consolas", textHeight, true);
	textFont(font);

	fill(255,0,0);
	text(text, width/4, height/2);
}

void keyPressed() {

	if (key == CODED) {

		if (keyCode == RIGHT && pacman.getXLoc() + (Pacman.SIZE/2.0) < width) { //move right
			pacman.setDirection(DIR_RIGHT);
			pacman.move();
		}

		else if (keyCode == LEFT && pacman.getXLoc() - (Pacman.SIZE/2.0) > 0) {//move left
			pacman.setDirection(DIR_LEFT);
			pacman.move();
		}

		else if (keyCode == UP && pacman.getYLoc() - (Pacman.SIZE/2.0) > 0) { //move up
			pacman.setDirection(DIR_UP);
			pacman.move();
		}

		else if (keyCode == DOWN && pacman.getYLoc() + (Pacman.SIZE/2.0) < height) { //move down
			pacman.setDirection(DIR_DOWN);
			pacman.move();
		}

	}

}