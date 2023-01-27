/*
 * Title: Triangle
 * Author: Ryan Slater
 * Date: 8/29/2017
 * Purpose: Calculate triangle information given height and width
 */

public class Triangle {
	
	private int width;
	private int height;
	
	public Triangle(int w, int h){
		width = w;
		height = h;
	}
	
	public void setWidth(int w){
		width = w;
	}
	
	public void setHeight(int h){
		height = h;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public double getPerimeter(){
		double w = 0.5 * width;
		double hyp = Math.sqrt(Math.pow(height, 2) + Math.pow(w, 2));
		return(width + 2*hyp);
	}
	
	public double getArea(){
		return(0.5*height*width);
	}
	
	public String toString(){
		return("Width: " + width + "\nHeight: " + height);
	}
	
}