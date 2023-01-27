
/* Title: OthelloDriver.java
 * Author: Ryan J Slater
 * Date: Mar 19, 2018
 */

import java.util.Scanner;

public class OthelloDriver {

	public static void main(String[] args) {
		boolean playAgain = true;
		while (playAgain) {
			OthelloGame o = new OthelloGame();
			OthelloPlayer player1;
			OthelloPlayer player2;
			Scanner input = new Scanner(System.in);
			int w = 8;
			int h = 8;
			String ints = new String("0123456789");
			while (true) {
				System.out.println("Enter board size \"WidthxHeight\" or \"random\" for a random size. Size between 3-26 inclusive.");
				String size = input.nextLine();
				if (size.toLowerCase().contains("random") || "random".contains(size.toLowerCase())) {
					w = 3 + (int) (Math.random() * ((26 - 3) + 1));
					h = 3 + (int) (Math.random() * ((26 - 3) + 1));
					System.out.println("Board size of " + w + "x" + h + " randomly selected\n");
					break;
				} else if (size.length() >= 3) {
					size = size.toLowerCase();
					int xLoc = size.indexOf("x");
					boolean validEntry = true;
					if (xLoc != -1 && xLoc + 1 < size.length()) {
						String tmpsize = size + " ";
						for (int i = 1; i < xLoc; i++) {
							if (!ints.contains(tmpsize.substring(i - 1, i)))
								validEntry = false;
						}
						if (validEntry)
							for (int i = xLoc + 2; i < tmpsize.length(); i++) {
								if (!ints.contains(tmpsize.substring(i - 1, i)))
									validEntry = false;
							}
					}
					if (validEntry) {
						w = Integer.parseInt(size.substring(0, xLoc));
						h = Integer.parseInt(size.substring(xLoc + 1));
						if (w > 2 && w < 27 && h > 2 && h < 27)
							break;
					}

				}
			}
			String[][] board = new String[h][w];
			for (int row = 0; row < board.length; row++)
				for (int col = 0; col < board[0].length; col++)
					board[row][col] = " ";
			int row = (int) (board.length / 2);
			int col = (int) (board[0].length / 2);
			board[row - 1][col - 1] = "B";
			board[row][col] = "B";
			board[row - 1][col] = "W";
			board[row][col - 1] = "W";
			int players;
			while (true) {
				System.out.print("How many human players (0, 1, or 2): ");
				String pnum = input.nextLine();
				if (pnum.length() == 1)
					if (ints.contains(pnum))
						if (Integer.parseInt(pnum) <= 2) {
							players = Integer.parseInt(pnum);
							break;
						}
			}
			if (players == 0) {
				String p1Type = "";
				String p2Type = "";
				while (true) {
					System.out.println("What type of AI for Player 1? (Stupid, Mediocre)");
					String in = input.nextLine().toLowerCase();
					if (in.contains("stupid") || "stupid".contains(in)) {
						player1 = new StupidComputerPlayer("Stupid 1");
						p1Type = "s";
						break;
					} else if (in.contains("mediocre") || "mediocre".contains(in)) {
						player1 = new MediocreComputerPlayer("Mediocre 1");
						p1Type = "m";
						break;
					}
				}
				while (true) {
					System.out.println("What type of AI for Player 2? (Stupid, Mediocre)");
					String in = input.nextLine().toLowerCase();
					if (in.contains("stupid") || "stupid".contains(in)) {
						player2 = new StupidComputerPlayer("Stupid 2");
						p2Type = "s";
						break;
					} else if (in.contains("mediocre") || "mediocre".contains(in)) {
						player2 = new MediocreComputerPlayer("Mediocre 2");
						p2Type = "m";
						break;
					}
				}
				o.playGame(player1.getName(), p1Type, player2.getName(), p2Type, board);

			} else if (players == 1) {
				String p1name;
				String p2Type = "";
				while (true) {
					System.out.print("Player 1, enter your name: ");
					p1name = input.nextLine();
					if (p1name.length() <= 40)
						break;
					else
						System.out.println("Max name length is 40 characters");
				}
				player1 = new HumanOthelloPlayer(p1name);
				while (true) {
					System.out.println("What type of AI for Player 2? (Stupid, Mediocre)");
					String in = input.nextLine().toLowerCase();
					if (in.contains("stupid") || "stupid".contains(in)) {
						player2 = new StupidComputerPlayer("Stupid 2");
						p2Type = "s";
						break;
					} else if (in.contains("mediocre") || "mediocre".contains(in)) {
						player2 = new MediocreComputerPlayer("Mediocre 2");
						p2Type = "m";
						break;
					}
				}
				o.playGame(player1.getName(), "h", player2.getName(), p2Type, board);

			} else if (players == 2) {
				String p1name;
				while (true) {
					System.out.print("Player 1, enter your name: ");
					p1name = input.nextLine();
					if (p1name.length() <= 40)
						break;
					else
						System.out.println("Max name length is 40 characters");
				}
				player1 = new HumanOthelloPlayer(p1name);
				String p2name;
				while (true) {
					System.out.print("Player 2, enter your name: ");
					p2name = input.nextLine();
					if (p2name.length() <= 40)
						break;
					else
						System.out.println("Max name length is 40 characters");
				}
				player2 = new HumanOthelloPlayer(p2name);
				o.playGame(player1.getName(), "h", player2.getName(), "h", board);
			}

			playAgain = true;
			System.out.println("Would you like to play again? [Y/n]");
			String again = input.nextLine().toLowerCase();
			if (again.length() != 0)
				if (again.contains("n") || "n".contains(again))
					playAgain = false;

		}
	}

}
