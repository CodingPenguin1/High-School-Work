
/* Title: HumanPlayer.java
 * Author: Ryan J. Slater, Austin Anderson, Harold Flower
 * Date: Sep 4, 2018
 */

import java.util.Scanner;

public class HumanPlayer extends Player {

	Scanner input = new Scanner(System.in);

	public HumanPlayer(String name, char symbol) {
		super(name, symbol);
	}

	public void takeTurn(Board board) {
		System.out.println("\n" + this.name + "'s turn (" + this.symbol + ")");
		board.display();
		char[] numbers = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		while (true) {
			String in = input.nextLine();
			if (in.length() == 0)
				in = " ";
			char locationChar = in.charAt(0);

			boolean legitChar = false;
			for (int i = 0; i < numbers.length; i++)
				if (numbers[i] == locationChar)
					legitChar = true;

			if (legitChar)
				if (!board.placeSymbol(this.symbol, Character.getNumericValue(locationChar)))
					System.out.println("Please enter a valid location");
				else
					break;
			else
				System.out.println("Please enter a valid location");

		}
	}

}
