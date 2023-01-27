import java.util.Scanner;

public class OthelloGameDriver {
	public static void main(String[] args) {
		String[][] board = new String[8][8];
		for (int row = 0; row < 8; row++)
			for (int col = 0; col < 8; col++)
				board[row][col] = ".";
		board[3][3] = "B";
		board[4][4] = "B";
		board[3][4] = "W";
		board[4][3] = "W";
		Scanner kbreader = new Scanner(System.in);
		String[] p1Info = getPlayerNameAndType(1);
		String p1type = p1Info[0];
		String p1name = p1Info[1];
		String[] p2Info = getPlayerNameAndType(2);
		String p2type = p2Info[0];
		String p2name = p2Info[1];
		OthelloGame mygame = new OthelloGame();
		mygame.playGame(p1name, p1type, p2name, p2type, board);
	}

	public static String[] getPlayerNameAndType(int playerNumber) {
		Scanner kbreader = new Scanner(System.in);
		System.out.println("-----PLAYER " + playerNumber + ":-----");
		String type = new String();
		while (true) {
			System.out.println("Are you a human or computer player?");
			System.out.println("Enter 'human' or 'computer'.");
			type = kbreader.nextLine().toLowerCase();
			if (type.contains("human") || "human".contains(type)) {
				type = "human";
				break;
			}
			if (type.contains("computer") || "computer".contains(type)) {
				type = "computer";
				break;
			}
		}
		System.out.println("Please enter your name: ");
		String name = kbreader.nextLine();
		return new String[] { type, name };
	}

}
