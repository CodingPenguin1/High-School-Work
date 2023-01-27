
/* Title: MediocreComputerPlayer.java
 * Author: Ryan J Slater
 * Date: Mar 19, 2018
 */

import java.util.ArrayList;

public class MediocreComputerPlayer extends OthelloPlayer {

	String[][] board;

	public MediocreComputerPlayer(String name) {
		super(name);
	}

	public Location move(int width, int height, String[][] Board, String color) {
		board = Board;
		String oppColor = "";
		ArrayList<Location> available = availableMoves(board, color);

		for (Location i : available) {
			if ((i.getRow() == 0 || i.getRow() == board.length - 1) && (i.getCol() == 0 || i.getCol() == board[0].length - 1))
				return i;
		}

		if (color.equals("B"))
			oppColor = "W";
		else
			oppColor = "B";

		int[] deltas = new int[available.size()];
		for (int i = 0; i < available.size(); i++) {
			String[][] tmpboard = new String[board.length][board[0].length];
			for (int row = 0; row < board.length; row++)
				for (int col = 0; col < board[0].length; col++)
					tmpboard[row][col] = board[row][col];
			updateBoard(tmpboard, color, available.get(i));
			deltas[i] = availableMoves(tmpboard, color).size() - availableMoves(tmpboard, oppColor).size();

		}

		insertionSort(deltas, available);
		int bestMove = deltas.length - 1;
		while (true) {
			String[][] tmpboard = new String[board.length][board[0].length];
			for (int row = 0; row < board.length; row++)
				for (int col = 0; col < board[0].length; col++)
					tmpboard[row][col] = board[row][col];
			updateBoard(tmpboard, color, available.get(bestMove));
			ArrayList<Location> oppmoves = availableMoves(tmpboard, oppColor);
			boolean corner = false;
			for (Location i : oppmoves) {
				if ((i.getRow() == 0 || i.getRow() == board.length - 1) && (i.getCol() == 0 || i.getCol() == board[0].length - 1)) {
					bestMove--;
					corner = true;
				}
			}
			if (bestMove < 0) {
				bestMove = deltas.length-1;
				break;
			}
			if (!corner)
				break;
		}

		return available.get(bestMove);
	}

	public void insertionSort(int[] array, ArrayList<Location> moves) {
		for (int i = 1; i < array.length; i++) {
			int tmp = array[i];
			Location ltmp = moves.get(i);
			int j = i;
			while (j > 0 && array[j - 1] > tmp) {
				array[j] = array[j - 1];
				moves.set(j, moves.get(j - 1));
				j--;
			}
			array[j] = tmp;
			moves.set(j, ltmp);
		}
	}

	public boolean checkValid(int row, int col, int dir, String color, String[][] Board) {
		if (!Board[row][col].equals(" "))
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
		while (lookr >= 0 && lookr < Board.length && lookc >= 0 && lookc < Board[0].length) {
			if (Board[lookr][lookc].equals(" ")) {
				return false;
				// If opponent color
			} else if (!Board[lookr][lookc].equals(" ") && !Board[lookr][lookc].equals(color)) {
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

	public ArrayList<Location> availableMoves(String[][] Board, String pcolor) {
		ArrayList<Location> available = new ArrayList<Location>();
		for (int row = 0; row < Board.length; row++) {
			for (int col = 0; col < Board[0].length; col++) {
				int[] directions;
				if (row == 0)
					if (col == 0)
						directions = new int[] { 2, 3, 4 };
					else if (col == Board[0].length - 1)
						directions = new int[] { 4, 5, 6 };
					else
						directions = new int[] { 2, 3, 4, 5, 6 };
				else if (row == Board.length - 1)
					if (col == 0)
						directions = new int[] { 0, 1, 2 };
					else if (col == Board[0].length - 1)
						directions = new int[] { 0, 6, 7 };
					else
						directions = new int[] { 0, 1, 2, 6, 7 };
				else {
					if (col == 0)
						directions = new int[] { 0, 1, 2, 3, 4 };
					else if (col == Board[0].length - 1)
						directions = new int[] { 0, 4, 5, 6, 7 };
					else
						directions = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
				}

				boolean valid = false;
				for (int dir : directions) {
					valid = checkValid(row, col, dir, pcolor, Board);
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

	public void updateBoard(String[][] Board, String pcolor, Location move) {
		Board[move.getRow()][move.getCol()] = pcolor;
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
			while (lookr >= 0 && lookr < Board.length && lookc >= 0 && lookc < Board[0].length) {
				if (Board[lookr][lookc].equals(" ")) {
					break;
					// If opponent color
				} else if (!Board[lookr][lookc].equals(" ") && !Board[lookr][lookc].equals(pcolor)) {
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
						Board[lookr][lookc] = pcolor;
						lookr += rdir;
						lookc += cdir;
					} else
						break;
				}
				Board[lookr][lookc] = pcolor;
			}
		}
	}

}
