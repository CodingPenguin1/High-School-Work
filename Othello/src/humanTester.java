/* Title: humanTester.java
 * Author: Ryan J Slater
 * Date: Mar 20, 2018
 */

public class humanTester {

	public static void main(String[] args) {
		
		String[][] board = new String[15][15];
		HumanOthelloPlayer o = new HumanOthelloPlayer("bob");
		System.out.println(o.move(15, 15, board, "B").toString());
		
	}

}
