
/* Title: Mileage
 * Authors: Ryan Slater and Ben Molseed
 * Date: 11/17/2017
 */

import java.util.Scanner;

public class Mileage {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int count = 0;
		while (true) {
			count++;
			System.out.print("Enter a reading: ");
			String in = s.nextLine();

			if (in.equals("000000")) {
				break;
			}
			System.out.print("#" + count + " " + in + " ");
			String milesLeft = "";
			boolean order = true;
			int max = 0;
			for (int i = 0; i < in.length(); i++) {
				int c0 = Character.getNumericValue(in.charAt(i));
				if (c0 > max) {
					max = c0;
				}
				if (c0 < max) {
					milesLeft = milesLeft + (max - c0);
					order = false;
				} else {
					milesLeft = milesLeft + "0";
				}
			}

			for (int i = 0; i < milesLeft.length(); i++) {
				if (milesLeft.charAt(i) == '0') {
					milesLeft = milesLeft.substring(i + 1, milesLeft.length());
					i--;
				} else if (milesLeft.charAt(i) != '0') {
					break;
				}
			}

			if (order == true) {
				System.out.println("is already sorted.");
			} else {
				if (milesLeft.equals("1")) {
					System.out.println("requires " + milesLeft + " more mile.");
				} else {
					System.out.println("requires " + milesLeft + " more miles.");
				}
			}

		}
	}
}