
/* Title: OthelloGame.java
 * Author: Ryan J Slater
 * Date: Mar 12, 2018
 */

import java.util.*;

public class OthelloGame {

	private String[][] board;
	private BoardDisplay bdDisplay = new ConsoleBoardDisplay(board);
	private OthelloPlayer player1;
	private OthelloPlayer player2;

	public void playGame(String player1Name, String player1Type, String player2Name, String player2Type, String[][] Board) {
		if (player1Type.equals("h"))
			player1 = new HumanOthelloPlayer(player1Name);
		else if (player1Type.equals("s"))
			player1 = new StupidComputerPlayer(player1Name);
		else if (player1Type.equals("m"))
			player1 = new MediocreComputerPlayer(player1Name);
		if (player2Type.equals("h"))
			player2 = new HumanOthelloPlayer(player2Name);
		else if (player2Type.equals("s"))
			player2 = new StupidComputerPlayer(player2Name);
		else if (player2Type.equals("m"))
			player2 = new MediocreComputerPlayer(player2Name);
		board = Board;
		bdDisplay = new ConsoleBoardDisplay(board);
		String p1Color = "B";
		String p2Color = "W";
		Location p1move = new Location(0, 0);
		Location p2move = new Location(0, 0);
		int p1Count = getPlayerCount("B");
		int p2Count = getPlayerCount("W");
		int turnCount = 0;
		while (true) {
			// ========== Player 1 ==============================
			ArrayList<Location> p1a = availableMoves(p1Color);
			bdDisplay = new ConsoleBoardDisplay(board);
			bdDisplay.display();
			p1Count = getPlayerCount("B");
			p2Count = getPlayerCount("W");
			displayProgressBar(p1Count, p2Count);
			if (p1a.size() > 0) {
				if (turnCount > 0)
					System.out.println(player2Name + " went at " + p2move.print());
				System.out.println(player1Name + "'s turn");
				while (true) {
					p1move = player1.move(board.length, board[0].length, board, "B");
					boolean validMove = false;
					for (Location i : p1a) {
						if (i.compareTo(p1move) == 1) {
							validMove = true;
							break;
						}
					}
					if (validMove) {
						updateBoard(p1Color, p1move);
						break;
					}
				}
			}
			if ((player2Type.equals("m") || player2Type.equals("s")) && (player1Type.equals("m") || player1Type.equals("s")))
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			p1a = availableMoves(p1Color);
			ArrayList<Location> p2a = availableMoves(p2Color);
			boolean boardFull = true;
			for (int row = 0; row < board.length; row++)
				for (int col = 0; col < board[0].length; col++)
					if (board[row][col].equals(" ")) {
						boardFull = false;
						break;
					}
			if ((p1a.size() == 0 && p2a.size() == 0) || boardFull)
				break;

			// ========== Player 2 ==============================
			p2a = availableMoves(p2Color);
			bdDisplay = new ConsoleBoardDisplay(board);
			bdDisplay.display();
			p1Count = getPlayerCount("B");
			p2Count = getPlayerCount("W");
			displayProgressBar(p1Count, p2Count);
			if (p2a.size() > 0) {
				System.out.println(player1Name + " went at " + p1move.print());
				System.out.println(player2Name + "'s turn");
				int count = 0;
				while (true) {
					p2move = player2.move(board.length, board[0].length, board, "W");
					boolean validMove = false;
					for (Location i : p2a) {
						if (i.compareTo(p2move) == 1) {
							validMove = true;
							break;
						}
					}
					if (validMove) {
						updateBoard(p2Color, p2move);
						break;
					}
				}
			}
			p1a = availableMoves(p1Color);
			p2a = availableMoves(p2Color);
			if (!player2Type.equals("h") && player1Type.equals("h"))
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			else if ((player2Type.equals("m") || player2Type.equals("s")) && (player1Type.equals("m") || player1Type.equals("s")))
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			boardFull = true;
			for (int row = 0; row < board.length; row++)
				for (int col = 0; col < board[0].length; col++)
					if (board[row][col].equals(" ")) {
						boardFull = false;
						break;
					}
			if ((p1a.size() == 0 && p2a.size() == 0) || boardFull)
				break;

			turnCount++;
		}

		p1Count = getPlayerCount("B");
		p2Count = getPlayerCount("W");
		bdDisplay = new ConsoleBoardDisplay(board);
		bdDisplay.display();
		p1Count = getPlayerCount("B");
		p2Count = getPlayerCount("W");
		displayProgressBar(p1Count, p2Count);
		if (p1Count > p2Count)
			System.out.println("\n" + player1.getName() + " wins!");
		else if (p2Count > p1Count)
			System.out.println("\n" + player2.getName() + " wins!");
		else
			System.out.println("\nIt's a tie!");

	}

	public void displayProgressBar(int p1, int p2) {
		double prop1 = ((double) p1) / (p1 + p2);
		int numbar = (int) (25 * prop1);
		System.out.print("\n" + p1 + " (" + (int) (100 * prop1) + "%) B |");
		for (int i = 0; i < numbar; i++)
			System.out.print("-");
		System.out.print("|");
		for (int i = numbar; i < 25; i++)
			System.out.print("-");
		System.out.println("| W " + p2 + " (" + (int) (100 - ((int) (100 * prop1))) + "%)\n");
	}

	public int getPlayerCount(String pcolor) {
		int count = 0;
		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board[0].length; col++)
				if (board[row][col].equals(pcolor))
					count++;
		return count;
	}

	public boolean checkValid(int row, int col, int dir, String color) {
		if (!board[row][col].equals(" "))
			return false;
		int oppCount = 0;
		int lookr = row;
		int lookc = col;
		if (dir >= 1 && dir <= 3)
			lookc++;
		if (dir >= 5)
			lookc--;
		if (dir <= 1 || dir == 7)
			lookr--;
		if (dir >= 3 && dir <= 5)
			lookr++;
		while (lookr >= 0 && lookr < board.length && lookc >= 0 && lookc < board[0].length) {
			if (board[lookr][lookc].equals(" ")) {
				return false;
				// If opponent color
			} else if (!board[lookr][lookc].equals(" ") && !board[lookr][lookc].equals(color)) {
				oppCount++;
				// If self color
			} else {
				if (oppCount > 0) {
					return true;
				}
				return false;
			}
			if (dir >= 1 && dir <= 3)
				lookc++;
			if (dir >= 5)
				lookc--;
			if (dir <= 1 || dir == 7)
				lookr--;
			if (dir >= 3 && dir <= 5)
				lookr++;
		}
		return false;
	}

	public ArrayList<Location> availableMoves(String pcolor) {
		ArrayList<Location> available = new ArrayList<Location>();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				int[] directions;
				if (row == 0)
					if (col == 0)
						directions = new int[] { 2, 3, 4 };
					else if (col == board[0].length - 1)
						directions = new int[] { 4, 5, 6 };
					else
						directions = new int[] { 2, 3, 4, 5, 6 };
				else if (row == board.length - 1)
					if (col == 0)
						directions = new int[] { 0, 1, 2 };
					else if (col == board[0].length - 1)
						directions = new int[] { 0, 6, 7 };
					else
						directions = new int[] { 0, 1, 2, 6, 7 };
				else {
					if (col == 0)
						directions = new int[] { 0, 1, 2, 3, 4 };
					else if (col == board[0].length - 1)
						directions = new int[] { 0, 4, 5, 6, 7 };
					else
						directions = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
				}

				boolean valid = false;
				for (int dir : directions) {
					valid = checkValid(row, col, dir, pcolor);
					if (valid) {
						available.add(new Location(row, col));
						break;
					}
				}

			}
		}
		return available;
	}

	public boolean isLegal(ArrayList<Location> available, Location move) {
		for (Location i : available)
			if (move.compareTo(i) == 1)
				return true;
		return false;
	}

	public void updateBoard(String pcolor, Location move) {
		board[move.getRow()][move.getCol()] = pcolor;
		for (int dir = 0; dir < 8; dir++) {
			boolean valid = false;
			int oppCount = 0;
			int lookr = move.getRow();
			int lookc = move.getCol();
			int stopr = move.getRow();
			int stopc = move.getCol();
			if (dir >= 1 && dir <= 3)
				lookc++;
			if (dir >= 5)
				lookc--;
			if (dir <= 1 || dir == 7)
				lookr--;
			if (dir >= 3 && dir <= 5)
				lookr++;
			while (lookr >= 0 && lookr < board.length && lookc >= 0 && lookc < board[0].length) {
				if (board[lookr][lookc].equals(" ")) {
					break;
					// If opponent color
				} else if (!board[lookr][lookc].equals(" ") && !board[lookr][lookc].equals(pcolor)) {
					oppCount++;
					// If self color
				} else {
					if (oppCount > 0) {
						valid = true;
						stopr = lookr;
						stopc = lookc;
						break;
					}
					break;
				}
				if (dir >= 1 && dir <= 3)
					lookc++;
				if (dir >= 5)
					lookc--;
				if (dir <= 1 || dir == 7)
					lookr--;
				if (dir >= 3 && dir <= 5)
					lookr++;
			}

			if (valid) {
				lookr = move.getRow();
				lookc = move.getCol();
				int rdir = 0;
				int cdir = 0;
				if (lookr > stopr)
					rdir = -1;
				else if (lookr < stopr)
					rdir = 1;
				if (lookc > stopc)
					cdir = -1;
				if (lookc < stopc)
					cdir = 1;
				for (int i = 0; i < 100; i++) {
					if (Math.hypot(lookr - stopr, lookc - stopc) > 0) {
						board[lookr][lookc] = pcolor;
						lookr += rdir;
						lookc += cdir;
					} else
						break;
				}
				board[lookr][lookc] = pcolor;
			}
		}
	}

}