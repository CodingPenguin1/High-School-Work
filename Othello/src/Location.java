/* Title: Location
 * Author: Ryan J Slater
 * Date: 3/12/2018
 */

public class Location implements Comparable {

	int row;
	int col;

	public Location(int Row, int Col) {
		row = Row;
		col = Col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int compareTo(Object loc) {
		Location newLoc = (Location) loc;
		if (newLoc.getRow() == row && newLoc.getCol() == col)
			return 1;
		return 0;
	}

	public String toString() {
		return ("Row: " + row + ", Col: " + col);
	}

	public String print() {
		String[] letters = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		return (letters[col] + row);
	}

}