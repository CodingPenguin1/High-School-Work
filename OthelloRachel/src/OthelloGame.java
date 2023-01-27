
/*
 * Rachel Kahler, period 7 , APCSA, 3/27/2018
 * Goal: create a program that lets two people play the othello game by
 * implementing a playGame(), availibleMoves(), isLegal() and updateBoard() method.
 * This will check  the legality of a player's move and declare if they have won or not.
 */
import java.util.ArrayList;

public class OthelloGame {
	private String[][] bo;
	private BoardDisplay bdDisplay;
	private OthelloPlayer player1;
	private OthelloPlayer player2;

	public void playGame(String name1, String type1, String name2, String type2, String[][] boardy) {
		bo = boardy;
		if (type1.equalsIgnoreCase("computer"))
			player1 = new StupidComputerPlayer(name1);
		else
			player1 = new HumanOthelloPlayer(name1);
		if (type2.equalsIgnoreCase("human"))
			player2 = new HumanOthelloPlayer(name2);
		else
			player2 = new StupidComputerPlayer(name2);

		// should have players alternate moves until game is over
		int pturn = 1;
		while (true) {
			ArrayList<Location> p1Moves = availibleMoves("B");
			ArrayList<Location> p2Moves = availibleMoves("W");
			Location move = new Location(0, 0);

			for (int i = 0; i < 50; i++)
				System.out.println();
			bdDisplay = new ConsoleBoardDisplay(bo);
			bdDisplay.display();

			boolean valid = false;
			if (pturn > 0 && p1Moves.size() > 0) {
				System.out.println(name1 + "'s turn (B)");
				while (!valid) {
					move = player1.move();
					for (Location i : p1Moves)
						if (i.compareTo(move) == 1) {
							updateBoard("B", move);
							valid = true;
						}
				}
			} else if (p2Moves.size() > 0) {
				System.out.println(name2 + "'s turn (W)");
				while (!valid) {
					move = player2.move();
					for (Location i : p2Moves)
						if (i.compareTo(move) == 1) {
							updateBoard("W", move);
							valid = true;
						}
				}
			}
			pturn *= -1;
			if (availibleMoves("B").size() == 0 && availibleMoves("W").size() == 0)
				break;

		}

		// count the number of black and white pieces for each person
		int bcount = 0;
		int wcount = 0;
		for (int lcv = 0; lcv < bo.length; lcv++)
			for (int lcv2 = 0; lcv2 < bo[0].length; lcv2++)
				if (bo[lcv][lcv2].equalsIgnoreCase("B"))
					bcount++;
				else if (bo[lcv][lcv2].equalsIgnoreCase("W"))
					wcount++;

		if (bcount > wcount) {
			System.out.println("Game over.The winner is black with " + bcount + " number of squares occupied.");
			System.out.println("White occupied " + wcount + " spaces.");
		} else if (wcount > bcount) {
			System.out.println("Game over.The winner is white with " + wcount + " number of squares occupied.");
			System.out.println("Black occupied " + bcount + " spaces. ");
		} else {
			System.out.println("Game over. There is a tie!!");
			System.out.println("Black occupied " + bcount + " spaces.");
			System.out.println("White occupied " + wcount + " spaces.");
		}

	}

	public ArrayList<Location> availibleMoves(String color) {
		// returns arrayList containing all locations that would be considered legal
		ArrayList<Location> locations = new ArrayList<Location>();
		int drow = 0;
		int dcol = 0;
		for (int row = 0; row < bo.length; row++)
			for (int col = 0; col < bo[row].length; col++)
				if (bo[row][col] == ".")
					for (int dir = 0; dir < 8; dir++) {
						boolean legal = false;
						int targcol = col;
						int targrow = row;
						if (dir == 0) {
							drow = 0;
							dcol = 1;
						}
						if (dir == 1) {
							drow = -1;
							dcol = 1;
						}
						if (dir == 2) {
							drow = -1;
							dcol = 0;
						}
						if (dir == 3) {
							drow = -1;
							dcol = -1;
						}
						if (dir == 4) {
							drow = 0;
							dcol = -1;
						}
						if (dir == 5) {
							drow = 1;
							dcol = -1;
						}
						if (dir == 6) {
							drow = 1;
							dcol = 0;
						}
						if (dir == 7) {
							drow = 1;
							dcol = 1;
						}
						int oppCount = 0;
						while (!legal) {
							targrow += drow;
							targcol += dcol;

							// If out of bounds
							if (targrow > bo.length - 1 || targrow < 0 || targcol > bo[row].length - 1 || targcol < 0)
								break;
							// If empty
							else if (bo[targrow][targcol].equals("."))
								break;
							// If not empty and not my color
							else if (!bo[targrow][targcol].equals(".") && !bo[targrow][targcol].equals(color))
								oppCount++;
							// If my color
							else if (oppCount > 0)
								legal = true;
						}
						if (legal) {
							locations.add(new Location(row, col));
							break;
						}
					}

		return locations;

	}

	public boolean isLegal(ArrayList<Location> avail, Location move) {
		// if location is in list then true if no then false
		if (avail.contains(move))
			return true;
		System.out.println("Your move is not legal. Please enter another location.");
		return false;
	}

	public void updateBoard(String color, Location site) {
		// reconfigures board according to rule
		int drow = 0;
		int dcol = 0;
		int row = site.getRow();
		int col = site.getCol();
		for (int dir = 0; dir < 8; dir++) {
			boolean legal = false;
			int targcol = col;
			int targrow = row;
			if (dir == 0) {
				drow = 0;
				dcol = 1;
			}
			if (dir == 1) {
				drow = -1;
				dcol = 1;
			}
			if (dir == 2) {
				drow = -1;
				dcol = 0;
			}
			if (dir == 3) {
				drow = -1;
				dcol = -1;
			}
			if (dir == 4) {
				drow = 0;
				dcol = -1;
			}
			if (dir == 5) {
				drow = 1;
				dcol = -1;
			}
			if (dir == 6) {
				drow = 1;
				dcol = 0;
			}
			if (dir == 7) {
				drow = 1;
				dcol = 1;
			}
			int oppCount = 0;
			while (!legal) {
				targrow += drow;
				targcol += dcol;

				// If out of bounds
				if (targrow > bo.length - 1 || targrow < 0 || targcol > bo[row].length - 1 || targcol < 0)
					break;
				// If empty
				else if (bo[targrow][targcol].equals("."))
					break;
				// If not empty and not my color
				else if (!bo[targrow][targcol].equals(".") && !bo[targrow][targcol].equals(color))
					oppCount++;
				// If my color
				else if (oppCount > 0)
					legal = true;
			}
			if (legal) {
				int r = row;
				int c = col;
				while (true) {
					if (bo[r][c].equals(color))
						break;
					bo[r][c] = color;
					r += drow;
					c += dcol;
				}
			}
		}

	}
}
