/* Title: Numbers to Words
 * Author: Ryan Slater, Ben Molseed
 * Date: 11/16/2017
 */

import java.util.Scanner;

public class NumberToWords {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		char[] ints = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'm', 't', 'h' };
		String[] words = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Zero", "Million",
				"Thousand", "Hundred" };
		String[] words2 = { "One", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] words3 = { "Ten", "Eleven", "Twelve", "Thirteen", "Forteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen" };

		while (true) {
			String opt = "";
			String ipt = s.nextLine();

			for (int i = ipt.length() - 1; i >= 0; i--) {
				if (i == 2 && ipt.charAt(ipt.length() - i - 1) != '0') {
					ipt = ipt.substring(0, ipt.length() - 2) + 'h' + ipt.substring(ipt.length() - 2, ipt.length());
				}
				if (i == 3 && ipt.charAt(ipt.length() - i - 1) != '0') {
					ipt = ipt.substring(0, ipt.length() - 3) + 't' + ipt.substring(ipt.length() - 3, ipt.length());
				}
				if (i == 5 && ipt.charAt(ipt.length() - i - 1) != '0') {
					ipt = ipt.substring(0, ipt.length() - 5) + 'h' + ipt.substring(ipt.length() - 5, ipt.length());
				}
				if (i == 6 && ipt.charAt(ipt.length() - i - 1) != '0') {
					ipt = ipt.substring(0, ipt.length() - 6) + 'm' + ipt.substring(ipt.length() - 6, ipt.length());
				}
				if (i == 8 && ipt.charAt(ipt.length() - i - 1) != '0') {
					ipt = ipt.substring(0, ipt.length() - 8) + 'h' + ipt.substring(ipt.length() - 8, ipt.length());
				}
			}

			if (ipt.length() == 1) {
				if (ipt.charAt(0) == ints[9]) {
					break;
				}
			}
			for (int i = 0; i < ipt.length(); i++) {
				for (int j = 0; j < ints.length; j++) {
					boolean ty = false, teen = false;
					if (i != 0 && ipt.charAt(i - 1) == 'h') {
						ty = true;
						if (ipt.charAt(i - 1) == '1') {
							teen = true;
						}
					}
					if (ipt.charAt(i) == (ints[j]) && ints[j] != '0') {
						if (ty) {
							opt = opt + words2[j] + " ";
						} else if (teen) {
							opt = opt + words3[j] + " ";
						} else {
							opt = opt + words[j] + " ";
						}
					}
				}
			}
			System.out.println(opt);
		}
	}
}
