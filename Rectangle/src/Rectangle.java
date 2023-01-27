/*
 * Title: Rectangle
 * Author: Ryan Slater
 * Date: 8/29/2017
 * Purpose: Calculate rectangle information given length and width
 */

public class Rectangle {
	
	public int length;
	public int width;
	
	public Rectangle(){
		length = 0;
		width = 0;
	}
	
	public Rectangle(int l, int w){
		length = l;
		width = w;
	}
	
	public void setLength(int l){
		length = l;
	}
	
	public void setWidth(int w){
		width = w;
	}
	
	public int getLength(){
		return length;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getArea(){
		return(length*width);
	}
	
	public int getPerimeter(){
		return(2*(length+width));
	}
	
}