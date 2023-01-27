
/* Title: Math Program
 * Author: Ryan J Slater
 * Date: 2/9/2018
 */

import java.util.*;

public class MathProgram {

	public static void main(String[] args) {
		MathStuff m = new MathStuff();
		Scanner input = new Scanner(System.in);
		int x = 0;
		int y = 0;

		while (true) {

			try {
				System.out.println("Enter your first integer between -100 and 100: ");
				x = input.nextInt();
				if (x > 100 || x < -100) {
					throw new IntegerOutOfBoundsException("Integers must be between -100 and 100 inclusive");
				}
				System.out.println("Enter your second integer between -100 and 100: ");
				y = input.nextInt();
				if (y > 100 || y < -100) {
					throw new IntegerOutOfBoundsException("Integers must be between -100 and 100 inclusive");
				}
				System.out.println(x + " x " + y + " = " + m.multiply(x, y));
				System.out.println(x + " / " + y + " = " + m.divide(x, y));
			} catch (InputMismatchException e) {
				System.out.println(e + " - Input must be an integer");
			} catch (ArithmeticException e) {
				System.out.println(e + " - Second integer must not be 0; cannot divide by 0");
			} catch (IntegerOutOfBoundsException e) {
				System.out.println(e);
			} finally {
				System.out.println();
				input.nextLine();
			}
		}

	}

}