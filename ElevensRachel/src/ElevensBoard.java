import java.util.List;
import java.util.ArrayList;

public class ElevensBoard extends Board {

	private static final int BOARD_SIZE = 9;
	private static final String[] RANKS = { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king" };
	private static final String[] SUITS = { "spades", "hearts", "diamonds", "clubs" };
	private static final int[] POINT_VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0 };

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
		if (findPairSum11(cIndexes) != null) {
			return true;
		}
		if (findJQK(cIndexes) != null) {
			return true;
		}
		return false;
	}

	private List<Integer> findPairSum11(List<Integer> cIndexes) {
		List<Integer> x = new ArrayList<Integer>();
		for (int sk1 = 0; sk1 < cIndexes.size(); sk1++) {
			int k1 = cIndexes.get(sk1).intValue();
			for (int sk2 = sk1 + 1; sk2 < cIndexes.size(); sk2++) {
				int k2 = cIndexes.get(sk2).intValue();
				if (cardAt(k1).pointValue() + cardAt(k2).pointValue() == 11) {
					x.add(k1);
					x.add(k2);
					return x;
				}
			}
		}
		return null;
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
		if (jack && queen && king) {
			return x;
		}
		return null;
	}

	public boolean playIfPossible() {
		if (playPairSum11IfPossible()) {
			return true;
		}
		if (playJQKIfPossible()) {
			return true;
		}
		return false;
	}

	private boolean playPairSum11IfPossible() {
		List<Integer> cIndexes = cardIndexes();
		if (findPairSum11(cIndexes) != null) {
			replaceSelectedCards(findPairSum11(cIndexes));
			return true;
		}
		return false;
	}

	private boolean playJQKIfPossible() {
		List<Integer> cIndexes = cardIndexes();
		if (findJQK(cIndexes) != null) {
			replaceSelectedCards(findJQK(cIndexes));
			return true;
		}
		return false;
	}
}
