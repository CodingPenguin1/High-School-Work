/* Title: Thirteens Board
 * Author: Ryan Slater
 * Date: 1/23/2018
 */

import java.util.ArrayList;
import java.util.List;

public class ThirteensBoard extends Board {
	private static final int BOARD_SIZE = 10;
	private static final String[] RANKS = { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king" };
	private static final String[] SUITS = { "spades", "hearts", "diamonds", "clubs" };
	private static final int[] POINT_VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	private static final boolean I_AM_DEBUGGING = false;

	public ThirteensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}

	/**
	 * Determines if the selected cards form a valid group for removal. In Elevens, the legal groups are (1) a pair of non-face cards whose values add to 11, and (2) a group of three cards consisting of a jack, a queen, and a king in some order.
	 * 
	 * @param selectedCards
	 *            the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal; false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if (selectedCards.size() == 2) {
			if (findPairSum13(selectedCards).size() == 2) {
				return true;
			}
		} else if (selectedCards.size() == 1) {
			if (findK(selectedCards).size() == 1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean anotherPlayIsPossible() {
		List<Integer> cIndexes = cardIndexes();
		if (findPairSum13(cIndexes).size() == 2) {
			return true;
		} else if (findK(cIndexes).size() == 1) {
			return true;
		}
		return false;
	}

	/**
	 * Look for an 11-pair in the selected cards.
	 * 
	 * @param selectedCards
	 *            selects a subset of this board. It is list of indexes into this board that are searched to find an 11-pair.
	 * @return a list of the indexes of an 11-pair, if an 11-pair was found; an empty list, if an 11-pair was not found.
	 */
	private List<Integer> findPairSum13(List<Integer> cIndexes) {
		List<Integer> x = new ArrayList<Integer>();
		for (int i : cIndexes) {
			for (int j : cIndexes) {
				if (this.cardAt(i).pointValue() + this.cardAt(j).pointValue() == 13) {
					x.add(i);
					x.add(j);
					return x;
				}
			}
		}
		return x;
	}

	/**
	 * Look for a JQK in the selected cards.
	 * 
	 * @param selectedCards
	 *            selects a subset of this board. It is list of indexes into this board that are searched to find a JQK group.
	 * @return a list of the indexes of a JQK, if a JQK was found; an empty list, if a JQK was not found.
	 */
	private List<Integer> findK(List<Integer> selectedCards) {
		List<Integer> x = new ArrayList<Integer>();
		for (int i : selectedCards) {
			if (cardAt(i).rank().equals("king")) {
				x.add(i);
				return x;
			}
		}
		return new ArrayList<Integer>();
	}

	/**
	 * Looks for a legal play on the board. If one is found, it plays it.
	 * 
	 * @return true if a legal play was found (and made); false othewise.
	 */
	public boolean playIfPossible() {
		if (playPairSum13IfPossible()) {
			return true;
		} else if (playKIfPossible()) {
			return true;
		}
		return false;
	}

	/**
	 * Looks for a pair of non-face cards whose values sum to 11. If found, replace them with the next two cards in the deck. The simulation of this game uses this method.
	 * 
	 * @return true if an 11-pair play was found (and made); false othewise.
	 */
	private boolean playPairSum13IfPossible() {
		List<Integer> cIndexes = cardIndexes();
		List<Integer> replace =  findPairSum13(cIndexes);
		if (replace.size() == 2) {
			replaceSelectedCards(replace);
			return true;
		}
		return false;
	}

	/**
	 * Looks for a group of three face cards JQK. If found, replace them with the next three cards in the deck. The simulation of this game uses this method.
	 * 
	 * @return true if a JQK play was found (and made); false othewise.
	 */
	private boolean playKIfPossible() {
		List<Integer> cIndexes = cardIndexes();
		List<Integer> replace =  findK(cIndexes);
		if (replace.size() == 1) {
			replaceSelectedCards(replace);
			return true;
		}
		return false;
	}
}