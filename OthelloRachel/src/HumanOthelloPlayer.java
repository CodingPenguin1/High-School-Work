
/*
 * Rachel Kahler, period 7 APCSA, 3/19/2018
 * Goal: Create a class that extends OthelloPlayer and overrides the move method.
 * The move() method is supposed to prompt a user to specify a row and column and then
 * return that location within a Location object.
 */
import java.util.Scanner;

public class HumanOthelloPlayer extends OthelloPlayer {
	public HumanOthelloPlayer(String name) {
		super(name);
	}

	@Override
	public Location move() {
		Scanner kbreader = new Scanner(System.in);
		System.out.println("Please enter a row:");
		int row = kbreader.nextInt();
		System.out.println("Please enter a column:");
		int col = kbreader.nextInt();
		return new Location(col, row);
	}

}
