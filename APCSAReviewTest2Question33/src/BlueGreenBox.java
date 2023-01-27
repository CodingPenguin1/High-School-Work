/* Title: BlueGreenBox.java
 * Author: Ryan J. Slater
 * Date: Apr 12, 2018
 */

public class BlueGreenBox extends ColorBox{

	public BlueGreenBox() {
		System.out.print("blue ");
	}
	
	public void showColor() {
		System.out.print("green ");
		super.showColor();
	}
	
}