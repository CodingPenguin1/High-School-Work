/*
 * Rachel Kahler, period 7 APCSA, 3/19/2018
 * Goal: This abstract class contains instance variables to store a players name, as 
 * well as an abstract move method that returns a location.
 */
public abstract class OthelloPlayer {
	private String n = null;
	public OthelloPlayer(String name){
		n = name;
	}
	public String getName(String n){
		return n;
	}
	abstract Location move();
}


