public abstract class Character implements CharacterInterface {

	//class constants
	public static final int STEPS = 5;
	public static final int SIZE = 40;
	public static final int RIGHT = 1;
	public static final int LEFT = 2;
	public static final int UP = 3;
	public static final int DOWN = 4;

	//instance variables
	protected String name;
	protected int xLoc;
	protected int yLoc;
	protected int direction;
	protected color fillColor;


	//constructor
	public Character( int xLoc, int yLoc, String name) {

		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.name = name;
		this.direction = 0;

	}

	public void move() { //changes xLoc/yLoc based on direction

		if (this.direction == RIGHT) { //if direction is right, add steps to xLoc
			this.xLoc += STEPS;
		}

		else if (this.direction == LEFT) { //if direction is left, subtract steps from xLoc
			this.xLoc -= STEPS;
		}

		else if (this.direction == UP) { //if direction is up, subtract steps from yLoc
			this.yLoc -= STEPS;
		}

		else if (this.direction == DOWN) { //if direction is down, add steps to yLoc
			this.yLoc += STEPS;
		}

	}

	//getters and setters
	public int getXLoc() {
		return this.xLoc;
	}

	public int getYLoc() {
		return this.yLoc;
	}

	public int getDirection() {
		return this.direction;
	}

	public String getName() {
		return this.name;
	}

	public void setXLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public void setYLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public String toString() { //return info about object as String
		return name + ": (" + xLoc + ", " + yLoc + ")";
	}


}
