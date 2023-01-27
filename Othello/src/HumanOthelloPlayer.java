
/* Title: Human Othello Player
 * Author: Ryan J Slater
 * Date: 3/12/2018
 */

import java.util.*;

public class HumanOthelloPlayer extends OthelloPlayer {

	public HumanOthelloPlayer(String Name) {
		super(Name);
	}

	public Location move(int width, int height, String[][] board, String color) {
		String[] letters = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		int[] letterToInt = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 };
		Scanner in = new Scanner(System.in);
		int row = 0;
		int col = 0;
		while (true) {
			boolean rowFound = false;
			boolean colFound = false;
			System.out.println("Enter space (letter/number) ex. A5");
			String coords = in.nextLine();
			if (coords.length() >= 2) {
				// Finding col
				for (int i = 0; i < letters.length; i++) {
					if (letters[i].toLowerCase().equals(coords.toLowerCase().substring(0, 1))) {
						col = letterToInt[i];
						colFound = true;
					}
				}
				
				// Finding row
				row = getInt(coords);
				if (row != -1)
					rowFound = true;
			}
			if (rowFound && colFound)
				break;
		}
		return new Location(row, col);
	}

	public int getInt(String input) {
		String in = input + " ";
		int output = -1;
		String[] ints = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		for (int i = 0; i < in.length(); i++) {
			for (int j = 0; j < ints.length; j++) {
				if (in.substring(i, i + 1).equals(ints[j])) {
					if (in.substring(i + 1, i + 2).equals(ints[j])) {
						output = Integer.parseInt(in.substring(i, i + 2));
						i = in.length();
						break;
					} else {
						output = Integer.parseInt(in.substring(i, i + 1));
						i = in.length();
						break;
					}
				}
			}
		}
		return output;
	}

}
