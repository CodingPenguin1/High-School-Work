
/* Title: Deck
 * Author: Someone at College Board, but borrowed by Ryan Slater
 * Date: 1/18/2018
 */

import java.util.List;
import java.util.ArrayList;

public class Deck {

	private List<Card> cards;
	private int size;

	public Deck(String[] ranks, String[] suits, int[] values) {
		cards = new ArrayList<Card>();
		for (int i = 0; i < ranks.length; i++) {
			for (String suitString : suits) {
				cards.add(new Card(ranks[i], suitString, values[i]));
			}
		}
		size = cards.size();
		shuffle();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void shuffle() {
		size = cards.size();
		for (int k = size - 1; k >= 0; k--) {
			int r = (int) (Math.random() * (k + 1));
			Card tmp = cards.get(k);
			cards.set(k, cards.get(r));
			cards.set(r, tmp);
		}
	}

	public Card deal() {
		if (isEmpty()) {
			return null;
		}
		size--;
		Card c = cards.get(size);
		return c;
	}

	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
