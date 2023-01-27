
/*
 * Title: Penny Pitch
 * Author: Ryan Slater
 * Date: 10/10/2017
 */

import java.util.*;

public class PennyPitch {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		
		while (true) {
			
			int sizeX = 5;
			int sizeY = 5;
			
			System.out.print("How many rows do you want? ");
			//Get number of rows
			while (true) {
				try {
					sizeY = s.nextInt();

					if (sizeY > 0) {
						break;
					} else {
						System.out.println("Please enter a postive integer");
						s.nextLine();
					}
				} catch (InputMismatchException exception) {
					System.out.println("Please enter a postive integer");
					s.nextLine();
				}
			}
			
			System.out.print("How many columns do you want? ");
			//Get number of cols
					while (true) {
						try {
							sizeX = s.nextInt();

							if (sizeX > 0) {
								break;
							} else {
								System.out.println("Please enter a postive integer");
								s.nextLine();
							}
						} catch (InputMismatchException exception) {
							System.out.println("Please enter a postive integer");
							s.nextLine();
						}
					}
			
			// Create Board
			Square[][] board = new Square[sizeY][sizeX];
			for (int row = 0; row < sizeY; row++) {
				for (int col = 0; col < sizeX; col++) {

					int val = col + 1;
					if (row < col) {
						val = row + 1;
					}
					int val2 = sizeY - row;
					if (sizeY - row > sizeX - col) {
						val2 = sizeX - col;
					}
					if (val2 > val) {
						board[row][col] = new Square(val);
					} else {
						board[row][col] = new Square(val2);
					}

				}
			}

			// Print Initial Board
			for (int row = 0; row < sizeY; row++) {
				for (int col = 0; col < sizeX; col++) {
					if (board[row][col].getValue() != 0) {
						System.out.print(board[row][col].getValue() + " ");
					} else {
						System.out.print("P ");
					}
				}
				System.out.print("\n");
			}

			// Ask how many coins to throw
			int coins = 0;
			int i = 0;
			int maxCoins = sizeX * sizeY;
			System.out.print("How many pennies would you like to throw? ");
			while (true) {
				try {
					coins = s.nextInt();

					if (coins > 0 && coins <= maxCoins) {
						break;
					} else {
						System.out.println("Please enter an integer between 1 and " + maxCoins);
						s.nextLine();
					}
				} catch (InputMismatchException exception) {
					System.out.println("Please enter an integer between 1 and " + maxCoins);
					s.nextLine();
				}
			}

			// Run Simulation
			int score = 0;
			while (i < coins) {
				while (true) {
					int row = (int) (Math.random() * sizeY);
					int col = (int) (Math.random() * sizeX);
					if (board[row][col].getValue() != 0) {
						score += board[row][col].hit();
						break;
					}
				}
				i++;
			}

			// Print Final Board
			for (int row = 0; row < sizeY; row++) {
				for (int col = 0; col < sizeX; col++) {
					if (board[row][col].getValue() != 0) {
						System.out.print(board[row][col].getValue() + " ");
					} else {
						System.out.print("P ");
					}
				}
				System.out.print("\n");
			}
			System.out.println("Score: " + score + "\n");

			// Ask to play again
			boolean gameOver = false;
			while (true) {
				System.out.print("Would you like to play again? (Yes/No) ");
				s.nextLine();
				String input = s.nextLine();
				if (input.toLowerCase().contains("yes") || "yes".contains(input.toLowerCase())) {
					break;
				} else if (input.toLowerCase().contains("no") || "no".contains(input.toLowerCase())) {
					gameOver = true;
					break;
				} else {
					System.out.println("Please enter \"yes\" or \"no\"!");
				}
			}
			if (gameOver == true) {
				System.out.println("\nThanks for playing!!!");
				break;
			}

		}

	}
}