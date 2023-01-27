/*
 * Rachel Kahler, period 7 APCSA, 3/19/2018
 * This class creates the location of a human or computer player on the Othello board.
 */
public class Location implements Comparable<Location> {
	private int row;
	private int col;

	public Location(int r, int c) {
		row = r;
		col = c;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int compareTo(Location loc) {
		if (row == loc.getRow() && col == loc.getCol())
			return 1;
		return 0;
	}

}