/* Title: StupidComputerPlayer.java
 * Author: Ryan J Slater
 * Date: Mar 12, 2018
 */

public class StupidComputerPlayer extends OthelloPlayer {

	public StupidComputerPlayer(String Name) {
		super(Name);
	}
	
	public Location move(int width, int height, String[][] board, String color) {
		return (new Location((int)(height*Math.random()), (int)(width*Math.random())));
	}
	
}