/* Title: Console Board Display
 * Author: Ryan J Slater
 * Date: 3/12/2018
 */

public class ConsoleBoardDisplay implements BoardDisplay {

	static String[][] board;

	public ConsoleBoardDisplay(String[][] boardParam) {
		board = boardParam;
	}

	private static void printHorizontalLine(int rows) {
		for (int i = 0; i < rows + 2; i++)
			System.out.print(" ");
		for (int i = 0; i < board[0].length; i++)
			System.out.print("+---");
		System.out.println("+");
	}

	private static void printLetters(int rows) {
		String letters = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ ");
		for (int i = 0; i < rows + 4; i++)
			System.out.print(" ");
		for (int i = 0; i < board[0].length; i++)
			System.out.print(letters.substring(i, i + 1) + "   ");
		System.out.println("   ");
	}

	public void display() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        int horizLineSpaces = 0;
        if (board.length > 9)
            horizLineSpaces = 1;
        printLetters(horizLineSpaces);
        for (int row = 0; row < board.length; row++) {
            printHorizontalLine(horizLineSpaces);
            int spaces = 1;
            if (row < 10 && board.length > 9)
                spaces = 2;
            System.out.print(row);
            for (int i = 0; i < spaces; i++)
            	System.out.print(" ");
            for(int col = 0; col < board[0].length; col++) {
            	if (board[row][col].equals(" "))
            		System.out.print("|   ");
            	else if (board[row][col].equals("B"))
            		System.out.print("| " + board[row][col] + " ");
            	else
            		System.out.print("| " + board[row][col] + " ");
            }
            System.out.println("| " + row);
        }
        printHorizontalLine(horizLineSpaces);
        printLetters(horizLineSpaces);

	}

}