
/* Title: Main.java
 * Author: Ryan J. Slater
 * Date: Apr 13, 2018
 */

import java.util.*;

public class Main {

	public static void main(String[] args) {

		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		ArrayList<Card> deck = new ArrayList<Card>();
		for (int value = 2; value < 15; value++)
			for (int suit = 0; suit < 4; suit++)
				deck.add(new Card(suits[suit], value));
		deck.add(new Card("Joker", 15));
		deck.add(new Card("Joker", 15));
		Collections.shuffle(deck);

		ArrayList<Card> p1 = new ArrayList<Card>();
		ArrayList<Card> p2 = new ArrayList<Card>();
		for (int i = 0; i < deck.size(); i += 2) {
			p1.add(deck.get(i));
			p2.add(deck.get(i + 1));
		}

		// Game Loop
		boolean game = true;
		int count = 0;
		while (game) {

			if (p1.size() == 0 || p2.size() == 0)
				break;

			int iteration = 0;
			ArrayList<Card> winner = null;
			ArrayList<Card> loser = null;
			while (true) {
				Card c1 = null;
				Card c2 = null;
				if (p1.size() <= iteration) 
					c1 = p1.get(p1.size()-1);
				else
					c1 = p1.get(iteration);
				if (p2.size() <= iteration) 
					c2 = p2.get(p2.size()-1);
				else
					c2 = p2.get(iteration);
				System.out.print((1+count) + ". " + c1.toString() + " / " + c2.toString() + " : ");
				if (c1.compareTo(c2) > 0) {
					System.out.println("p1 wins");
					winner = p1;
					loser = p2;
					count++;
					break;
				} else if (c1.compareTo(c2) < 0) {
					System.out.println("p2 wins");
					winner = p2;
					loser = p1;
					count++;
					break;
				} else {
					System.out.println("war");
					iteration += 3;
				}
			}
			
			for (int i = 0; i <= iteration; i++) {
				if (loser.size() == 0) {
					game = false;
					break;
				}
				winner.add(loser.remove(0));
				winner.add(winner.remove(0));
			}

		}

		System.out.println(count);

	}

}
