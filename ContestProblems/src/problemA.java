
/* Title: Problem A
 * Author: Ryan J Slater
 * Date: 3/28/2018
 */

import java.util.*;

public class problemA {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print("Enter a phone number: ");
			String num = input.nextLine();
			if (num.equals("000-0000"))
				break;
			int score = unique(num) + delta(num) + suffix(num);
			System.out.println(num + " has complexity of " + score + ".");
		}
		input.close();
	}

	public static int unique(String number) {
		String num = number + " ";
		int x = 0;
		String[] ints = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
		int[] counts = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < ints.length; i++) {
			for (int j = 0; j < num.length() - 1; j++) {
				if (ints[i].equals(num.substring(j, j + 1))) {
					counts[i]++;
				}
			}
		}
		for (int c : counts) {
			if (c > 0)
				x++;
		}
		return x;
	}

	public static int delta(String number) {
		String tmp = number + " ";
		String num = "";
		String ints = "1234567890";
		for (int i = 0; i < tmp.length() - 1; i++) {
			if (ints.contains(tmp.substring(i, i + 1)))
				num += tmp.substring(i, i + 1);
		}
		int x = 0;
		for (int i = 0; i < num.length() - 1; i++)
			if (!num.substring(i, i + 1).equals(num.substring(i + 1, i + 2)))
				x++;
		return x;
	}

	public static int suffix(String num) {
		int x = 0;
		int[] ints = new int[] { 0, 0, 0, 0 };
		ints[0] = Integer.parseInt(num.substring(4, 5));
		ints[1] = Integer.parseInt(num.substring(5, 6));
		ints[2] = Integer.parseInt(num.substring(6, 7));
		ints[3] = Integer.parseInt(num.substring(7));
		boolean val = true;
		for (int i = 0; i < ints.length - 1; i++) {
			if (Math.abs(ints[i] - ints[i + 1]) != 1) {
				val = false;
				break;
			}
		}
		if (val) {
			x = -7;
		}
		return x;
	}
}
