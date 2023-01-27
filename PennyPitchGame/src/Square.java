/*
 * Title: Penny Pitch
 * Author: Ryan Slater
 * Date: 10/10/2017
 */

public class Square {

	private int value;
	private boolean penny;
	
	public Square(int v){
		value = v;
	}
	
	public void reset(){
		penny = false;
	}
	
	public int hit(){
		penny = true;
		return value;
	}
	
	public int getValue(){
		if(penny == true) {
			return 0;
		}
		return value;
	}
	
	public String toString(){
		return("Value " + value + "\nPenny " + penny);
	}
	
}