/*
 * Title: NGon
 * Author: Ryan Slater
 * Date: 8/30/2017
 * Purpose: Create an n-gon class that will represent any regular n-gon.
 * Properties must contain side length and the number of sides.
 */
public class Main {

	public static void main(String[] args) {
		
		Polygon poly = new Polygon(5, 10);
		System.out.println("Perimeter: " + poly.getPerimeter());
		System.out.println("Area: " + poly.getArea());
		System.out.println(poly.toString());
		
	}
}