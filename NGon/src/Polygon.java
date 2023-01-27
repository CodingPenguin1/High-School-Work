/*
 * Title: NGon
 * Author: Ryan Slater
 * Date: 8/30/2017
 * Purpose: Create an n-gon class that will represent any regular n-gon.
 * Properties must contain side length and the number of sides.
 */
public class Polygon {
	
	private int numSides;
	private int length;
	
	public Polygon(int s, int l){
		numSides = s;
		length = l;
	}
	
	public void setNumberSides(int s){
		numSides = s;
	}
	
	public void setLength(int l){
		length = l;
	}
	
	public int getNumberSides(){
		return numSides;
	}
	
	public int getLength(){
		return length;
	}
	
	public int getPerimeter(){
		return(numSides*length);
	}
	
	public double getArea(){
		double theta = (180/numSides) * (Math.PI/180);
		double height = (0.5*length)/Math.tan(theta);
		double area = numSides*0.5*length*height;
		return area;
	}
	
	public String toString(){
		return(numSides + " " + length + " long sides\n");
	}
	
}