/* Title: Find shortest path
 * Author: Ryan J Slater
 * Date: 2/14/2018
 */
package findShortestPath;

public class pathfinder {

	public static void main(String[] args) {
		for (int i = 2; i < 21; i++) {
			System.out.println(i + ": " + (fact(2*i)/(fact(i)*fact(i))));
		}
	}

	public static double fact(double n) {
		if (n == 1) {
			return n;
		}
		return n * fact(n - 1);
	}
}
