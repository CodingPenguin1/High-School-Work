/* Title: Card.java
 * Author: Ryan J. Slater
 * Date: Apr 13, 2018
 */

public class Card implements Comparable<Card> {

	private String suit;
	private int value;

	public Card(String s, int v) {
		suit = s;
		value = v;
	}

	public int getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}

	public int compareTo(Card c) {
		return value - c.getValue();
	}

	public String toString() {
		String[] names = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace", "Joker" };
		int[] vals = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		int index = 0;
		for (int i = 0; i < vals.length; i++)
			if (value == vals[i]) {
				index = i;
				break;
			}
		if (names[index].equals("Joker"))
			return "Joker";
		return (names[index] + " of " + suit);
	}

}
