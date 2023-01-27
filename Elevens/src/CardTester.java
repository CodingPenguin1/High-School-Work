/* Title: Card Tester
 * Author: Ryan Slater
 * Date: 1/17/2018
 */
public class CardTester {

	public static void main(String[] args) {
		Card a = new Card("King", "Hearts", 13);
		Card b = new Card("Ace", "Diamonds", 1);
		Card c = new Card("Five", "Spades", 5);
		System.out.println(a.rank());
		System.out.println(a.suit());
		System.out.println(a.pointValue());
		System.out.println(a.toString());
		System.out.println(b.rank());
		System.out.println(b.suit());
		System.out.println(b.pointValue());
		System.out.println(b.toString());
		System.out.println(c.rank());
		System.out.println(c.suit());
		System.out.println(c.pointValue());
		System.out.println(c.toString());
		Card d = new Card("King", "Hearts", 13);
		System.out.println(a.matches(d));
	}
}
