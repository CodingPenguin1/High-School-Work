/*
 * Rachel Kahler, period 7, APCSA, 3/19/2018
 * Goal:Create a class that extends Othello Player and overrides the move() method.
 * The row and column of the location should be randomly generated and be returned in a
 * location object.
 */
public class StupidComputerPlayer extends OthelloPlayer {

	public StupidComputerPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Location move() {
		Location newloc = new Location((int)(Math.random()*8),(int)(Math.random()*8));
		return newloc;
	}

}
