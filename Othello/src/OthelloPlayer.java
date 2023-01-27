/* Title: Othello Player
 * Author: Ryan J Slater
 * Date: 3/12/2018
 */

public abstract class OthelloPlayer {
	
	String name;
	
	public OthelloPlayer(String Name) {
		name = Name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract Location move(int width, int height, String[][] board, String color);
	
}