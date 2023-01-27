/*
 * Title: Calculator
 * Author: Ryan Slater
 * Date:9/1/2017
 * Purpose: Mr. Schultz's summative lab assignment to make a calculator
 */
public class Calculator {
	
	private String lastFunction;
	
	public int add(int z1, int z2){
		lastFunction = z1 + " + " + z2;
		return(z1+z2);
	}
	
	public double add(double d1, double d2){
		lastFunction = d1 + " + " + d2;
		return(d1+d2);
	}
	
	public int subtract(int z1, int z2){
		lastFunction = z1 + " - " + z2;
		return(z1-z2);
	}
	
	public double subtract(double d1, double d2){
		lastFunction = d1 + " - " + d2;
		return(d1-d2);
	}
	
	public int multiply(int z1, int z2){
		lastFunction = z1 + " * " + z2;
		return(z1*z2);
	}
	
	public double multiply(double d1, double d2){
		lastFunction = d1 + " * " + d2;
		return(d1*d2);
	}
	
	public double multiply(int z1, double d2){
		lastFunction = z1 + " * " + d2;
		return(z1*d2);
	}
	
	public double divide(int z1, int z2){
		lastFunction = z1 + " / " + z2;
		return(z1/z2);
	}
	
	public double divide(double d1, double d2){
		lastFunction = d1 + " / " + d2;
		return(d1/d2);
	}
	
	public double divide(double d1, int z1){
		lastFunction = d1 + " / " + z1;
		return(d1/z1);
	}
	
	public double power(int z1, int z2){
		lastFunction = z1 + " ^ " + z2;
		int x = 1;
		for(int i = 0; i<z2; i++){
			x*=z1;
		}
		return x;
	}
	
	public double power(double d1, int z2){
		lastFunction = d1 + " ^ " + z2;
		double x = 1;
		for(int i = 0; i<z2; i++){
			x*=d1;
		}
		return x;
	}
	
	public int squareRoot(int z1){
		lastFunction = "sqrt(" + z1 + ")";
		int x = 0;
		for(int i=2; i<(z1/2); i++){
			if ((i*i)==z1){
				x = i;
				break;
			}
		}
		return x;
	}
	
	public double factorial(int z1){
		lastFunction = "fact(" + z1 + ")";
		double x = 1;
		for(int i = 0; i<z1; i++){
			x*=(z1-i);
		}
		return x;
	}
	
	public String lastFunction(){
		return "Last function: " + lastFunction;
	}
	
	public String toString(){
		return "Last function: " + lastFunction;
	}
	
}
