/*
 * Title: Calculator
 * Author: Ryan Slater
 * Date:9/1/2017
 * Purpose: Mr. Schultz's summative lab assignment to make a calculator
 */
public class Main {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		System.out.println(calc.add(1, 1) + " add int should be 2");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.add(2.5, 1.5) + " add double should be 4.0");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.subtract(3, 1) + " subtract int should be 2");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.subtract(2.5, 1.5) + " subtract double should be 1.0");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.multiply(5, 3) + " multiply int should be 15");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.multiply(3.5, 5.5) + " multiply double should be 19.25");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.multiply(5, 2.0) + " multiply int and double should be 10.0");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.divide(6, 2) + " divide int should be 3.0");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.divide(4.5, 3) + " divide double should be 1.5");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.divide(4.5, 2) + " divide double by int should be 2.25");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.power(2, 3) + " power int should be 8.0");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.power(2.5, 3) + " power double, int should be 15.625");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.squareRoot(5) + " sqrt(5) should return nothing");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.squareRoot(9) + " sqrt(9) should return 3");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
		System.out.println(calc.factorial(4) + " factorial should return 24.0");
		System.out.println(calc.lastFunction());
		System.out.println(calc.toString());
	}
}