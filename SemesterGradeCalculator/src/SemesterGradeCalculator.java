/* Title: Semester Grade Calculator from Quarter Grades
 * Author: Ryan Slater
 * Date: 12/13/2017
 */

import java.util.*;

public class SemesterGradeCalculator {

	public static void main(String[] args) {
		
		Scanner k = new Scanner(System.in);
		double q1, q2;
		System.out.println("Enter Quarter 1 Grade:");
		q1 = k.nextDouble();
		System.out.println("Enter Quarter 2 Grade:");
		q2 = k.nextDouble();
		double aplus, a, aminus, bplus, b, bminus;
		aplus = (975 - 4*q1 - 4*q2)/2;
		a = (925 - 4*q1 - 4*q2)/2;
		aminus = (895 - 4*q1 - 4*q2)/2;
		bplus = (875 - 4*q1 - 4*q2)/2;
		b = (825 - 4*q1 - 4*q2)/2;
		bminus = (795 - 4*q1 - 4*q2)/2;
		System.out.println("A+: " + aplus);
		System.out.println("A : " + a);
		System.out.println("A-: " + aminus);
		System.out.println("B+: " + bplus);
		System.out.println("B: " + b);
		System.out.println("B-: " + bminus);
		
	}
}