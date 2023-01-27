import java.util.Scanner;

public class ConsoleBoardTester {
	public static void main(String[] args) {
		Scanner kbreader = new Scanner(System.in);
		System.out.println("Please enter the size of your array- has to be greater than or equal to 8!");
		int size = kbreader.nextInt();
		String[][] board = new String[size][size];
		ConsoleBoardDisplay mycd = new ConsoleBoardDisplay(board);
		for (int lcv = 0; lcv < board.length; lcv++) {
			for (int Lcv = 0; Lcv < board[lcv].length; Lcv++) {
				board[Lcv][lcv] = ".";

			}

		}

		mycd.display();
	}
}
