/*
 * Rachel Kahler, period 7 APCSA, 3/13/2018
 * Goal: create the first part of an othello game that displays the board and locations
 * at the top.
 */
public class ConsoleBoardDisplay implements BoardDisplay {
	String[][] boardy = new String[0][0];

	public ConsoleBoardDisplay(String[][] board) {
		boardy = board;
	}

	public void display() {
		System.out.print("  ");
		for (int lcv = 0; lcv < boardy.length; lcv++)
			System.out.print(lcv + " ");
		System.out.println();
		for (int lcv = 0; lcv < boardy[boardy.length - 1].length; lcv++) {
			System.out.print(lcv + " ");
			for (int Lcv = 0; Lcv < boardy[lcv].length; Lcv++)
				System.out.print(boardy[Lcv][lcv] + " ");
			System.out.println();
		}

	}
}
