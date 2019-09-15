public class MsPacman extends Pacman implements PacmanInterface {

	//constructors
	public MsPacman(int xLoc, int yLoc, String name) {

		super (xLoc, yLoc, name); //calls constructor from Pacman class
		this.fillColor = color(255, 51, 153); //pink
	}

	public MsPacman(int xLoc, int yLoc) {
		this (xLoc, yLoc, "Ms Pacman");
	}

	public MsPacman() {

		this ((int) (Math.random() * (width - SIZE/2.0) + SIZE/2.0 ), (int) (Math.random() * (height - SIZE/2.0) + SIZE/2.0), "Ms Pacman");		
		
	}

}