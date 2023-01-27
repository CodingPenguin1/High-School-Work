
/* Title: Problem F
 * Author: Ryan J Slater
 * Date: 3/28/2018
 */

import java.util.*;

public class problemF {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			int[] bounds;
			int[] times;
			System.out.print("Enter germination bounds: ");
			String boundsIn = input.nextLine();
			System.out.print("Enter observed times: ");
			String timesIn = input.nextLine();
			bounds = getInts(boundsIn, 10);
			times = getInts(timesIn, 5);

			boolean breaking = false;
			for (int i : bounds)
				if (i == 0)
					breaking = true;
			for (int i : times)
				if (i == 0)
					breaking = true;
			if (breaking)
				break;

			for (int i : times) {
				for (int j = 0; j < 10; j += 2) {
					if (i > times[j] && i < times[j + 1]) {
						
					}
				}
			}

		}
		input.close();
	}

	public static int[] getInts(String s, int size) {
		s = " " + s + " ";
		int[] ints = new int[size];
		int count = 0;
		int[] starts = new int[size];
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == ' ') {
				starts[count] = i;
				count++;
			}
		}

		count = 0;
		for (int i : starts) {
			ints[count] = Integer.parseInt(s.substring(i + 1, s.indexOf(' ', i + 2)));
			count++;
		}

		return ints;
	}

}
