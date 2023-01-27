/* Title: Player.java
 * Author: Ryan J. Slater, Austin Anderson, Harold Flower
 * Date: Sep 4, 2018
 */

public abstract class Player {

	String name;
	char symbol;
	int wins;
	int ties;
	int losses;

	public Player(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
		wins = 0;
		ties = 0;
		losses = 0;
	}

	public abstract void takeTurn(Board board);

	public void displayStats() {
		System.out.println("Stats for " + name + " (" + symbol + ")");
		for (int i = 0; i < 14 + name.length(); i++)
			System.out.print("-");
		System.out.println("\nWins:   " + wins);
		System.out.println("Ties:   " + ties);
		System.out.println("Losses: " + losses + "\n");
	}
	
}
