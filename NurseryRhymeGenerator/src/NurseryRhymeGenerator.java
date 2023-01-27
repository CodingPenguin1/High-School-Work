/* Title: Nursery Rhyme Generator
 * Author: Ryan Slater
 * Date: 10/8/2017
 * Purpose: Mr. Schultz APCSA Midterm Project 2017-2018
 */

import java.util.*;

public class NurseryRhymeGenerator {

	static Scanner kb = new Scanner(System.in);

	public static String[] getArray(String type) {
		String[] x = new String[10];
		int log = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print("Enter " + type + " #" + (i + 1) + ":");
			String in = kb.nextLine();
			if(in.toLowerCase().equals("stop")) {
				break;
			}
			x[i] = in;
			log++;
		}
		x = Arrays.copyOfRange(x, 0, log);
		return x;
	}

	public static String[] sort(String[] array) {
		String[] x = array;
		for (int i = 1; i < x.length; i++) {
			String tmp = x[i];
			int j = i;
			while (j > 0 && x[j - 1].compareTo(tmp) > 0) {
				x[j] = x[j - 1];
				j--;
			}
			x[j] = tmp;
		}
		return x;
	}

	public static int getMaxLength(String[] x) {
		int len = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i].length() > len) {
				len = x[i].length();
			}
		}
		return len;
	}

	public static void display(String[] n, String[] v, String[] e, String[] a) {
		int nlen = getMaxLength(n), vlen = getMaxLength(v), elen = getMaxLength(e), alen = getMaxLength(a);
		if (nlen < 5) {
			nlen = 5;
		}
		if (vlen < 5) {
			vlen = 5;
		}
		if (elen < 5) {
			elen = 5;
		}
		if (alen < 5) {
			alen = 5;
		}
		System.out.println("Nouns\tVerbs\tExclamations\tAdjectives");
		System.out.println("-----\t-----\t------------\t----------");
		int maxLen = 0;
		if (n.length > maxLen)
			maxLen = n.length;
		if (v.length > maxLen)
			maxLen = v.length;
		if (e.length > maxLen)
			maxLen = e.length;
		if (a.length > maxLen)
			maxLen = a.length;
		for (int i = 0; i < maxLen; i++) {
			if (i < n.length) {
				System.out.print(n[i] + "\t");
			} else {
				for (int j = 0; j < 5; j++) {
					System.out.print(" ");
				}
				System.out.print("\t");
			}
			
			if (i < v.length) {
				System.out.print(v[i] + "\t");
			} else {
				for (int j = 0; j < 5; j++) {
					System.out.print(" ");
				}
				System.out.print("\t");
			}
			
			if (i < e.length) {
				System.out.print(e[i]);
				for (int j = 0; j < 12 - e[i].length(); j++) {
					System.out.print(" ");
				}
				System.out.print("\t");
			} else {
				for (int j = 0; j < 12; j++) {
					System.out.print(" ");
				}
				System.out.print("\t");
			}
			
			if (i < a.length) {
				System.out.print(a[i]);
				for (int j = 0; j < 12 - a[i].length(); j++) {
					System.out.print(" ");
				}
				System.out.println("\t");
			} else {
				for (int j = 0; j < 12; j++) {
					System.out.print(" ");
				}
				System.out.println("\t");
			}
			
		}
	}

	public static void main(String[] args) {

		Random rand = new Random();
		String[] n = sort(getArray("noun"));
		String[] v = sort(getArray("verb"));
		String[] e = sort(getArray("exclamation"));
		String[] a = sort(getArray("adjective"));
		System.out.println();
		display(n, v, e, a);
		System.out.println();
		for (int i = 5; i >= 0; i--) {
			System.out.println(i + " " + a[rand.nextInt(a.length)] + " " + n[rand.nextInt(n.length)] + "s " + v[rand.nextInt(v.length)] + "ing in a " + n[rand.nextInt(n.length)]);
			System.out.println("All of a sudden, one went " + e[rand.nextInt(e.length)] + "!\n");
		}
	}
}