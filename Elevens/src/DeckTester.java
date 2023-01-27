/* Title: Deck Tester
 * Author: Ryan Slater
 * Date: 1/18/2018
 */
public class DeckTester {

	public static void main(String[] args) {
		String[] ranks = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
		String[] suits = {"hearts", "diamonds", "spades", "clubs"};
		int[] pointValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		Deck d = new Deck(ranks, suits, pointValues);
		
		System.out.println(d.toString());
		d.shuffle();
		System.out.println(d.toString());
	}
}
