/*
 * Title: Triangle
 * Author: Ryan Slater
 * Date: 8/29/2017
 * Purpose: Calculate triangle information given height and width
 */

public class Main {

	public static void main(String[] args) {
		
		Triangle triangle = new Triangle(5, 10);
		System.out.println("Perimeter: " + triangle.getPerimeter());
		System.out.println("Area: " + triangle.getArea());
		System.out.println(triangle.toString());
		
	}

}
