
/* Title: Elevens Board
 * Author: Ryan Slater
 * Date: 1/19/2018
 */

import java.util.List;
import java.util.ArrayList;

public class ElevensBoard extends Board {

	private static final int BOARD_SIZE = 9;
	private static final String[] RANKS = { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king" };
	private static final String[] SUITS = { "spades", "hearts", "diamonds", "clubs" };
	private static final int[] POINT_VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

	public ElevensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}

	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if (selectedCards.size() == 2) {
			if (findPairSum11(selectedCards).size() == 2) {
				return true;
			}
		} else if (selectedCards.size() == 3) {
			if (findJQK(selectedCards).size() == 3) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean anotherPlayIsPossible() {
		List<Integer> cIndexes = cardIndexes();
		if (findPairSum11(cIndexes).size() == 2) {
			return true;
		} else if (findJQK(cIndexes).size() == 3) {
			return true;
		}
		return false;
	}

	private List<Integer> findPairSum11(List<Integer> cIndexes) {
		List<Integer> x = new ArrayList<Integer>();
		for (int i : cIndexes) {
			for (int j : cIndexes) {
				if (this.cardAt(i).pointValue() + this.cardAt(j).pointValue() == 11) {
					x.add(i);
					x.add(j);
					return x;
				}
			}
		}
		return x;
	}

	private List<Integer> findJQK(List<Integer> selectedCards) {
		List<Integer> x = new ArrayList<Integer>();
		boolean jack = false;
		boolean queen = false;
		boolean king = false;
		for (int i : selectedCards) {
			if (cardAt(i).rank().equals("jack") && jack == false) {
				x.add(i);
				jack = true;
			} else if (cardAt(i).rank().equals("queen") && queen == false) {
				x.add(i);
				queen = true;
			} else if (cardAt(i).rank().equals("king") && king == false) {
				x.add(i);
				king = true;
			}
		}
		if (x.size() == 3) {
			return x;
		}
		return new ArrayList<Integer>();
	}

	public boolean playIfPossible() {
		if (playPairSum11IfPossible()) {
			return true;
		} else if (playJQKIfPossible()) {
			return true;
		}
		return false;
	}

	private boolean playPairSum11IfPossible() {
		List<Integer> cIndexes = cardIndexes();
		List<Integer> replace =  findPairSum11(cIndexes);
		if (replace.size() == 2) {
			replaceSelectedCards(replace);
			return true;
		}
		return false;
	}

	private boolean playJQKIfPossible() {
		List<Integer> cIndexes = cardIndexes();
		List<Integer> replace =  findJQK(cIndexes);
		if (replace.size() == 3) {
			replaceSelectedCards(replace);
			return true;
		}
		return false;
	}
}
