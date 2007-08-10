package ats_jp.activity.cardgame;

public class PlayingCard implements Card {
	public static final int RANK = 0,
					  		SUIT = 1,
					  		STR_RANK = 2,
					  		STR_SUIT = 3;
	
	public static final int SPADES = 14,
							HEARTS = 15,
							DIAMONDS = 16,
							CLUBS = 17,
							ACE = 1,
							TWO = 2,
							THREE = 3,
							FOUR = 4,
							FIVE = 5,
							SIX = 6,
							SEVEN = 7,
							EIGHT = 8,
							NINE = 9,
							TEN = 10,
							JACK = 11,
							QUEEN = 12,
							KING = 13;
	
	private int rank, suit;
	private static PlayingCard[][] pcards = new PlayingCard[13][4];
	private static final String[] strrep = {
		"Ace",
		"Two",
		"Three",
		"Four",
		"Five",
		"Six",
		"Seven",
		"Eeight",
		"Nine",
		"Ten",
		"Jack",
		"Queen",
		"King",
		"Spades",
		"Hearts",
		"Diamonds",
		"Clubs"
	};
	
	private PlayingCard(int rank, int suit) throws IllegalArgumentException {
		if(rank > 13 || rank < 1 || suit > 17 || suit < 14) {
			throw new IllegalArgumentException();
		}
		
		this.rank = rank;
		this.suit = suit;
	}
	
	public String toString() {
		return strrep[rank - 1] + " of " + strrep[suit - 1];
	}

	public boolean equals(Card card) {
		try {
			if(card.getCardAttribute(0) == getCardAttribute(0) &&
					card.getCardAttribute(1) == getCardAttribute(1)){
				return true;
			}
		} catch(Exception e) {}
		return false;
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	public Object getCardAttribute(int attribute) throws CardException {
		switch(attribute) {
		case 0:
			return getRank();
		case 1:
			return getSuit();
		case 2:
			return strrep[rank - 1];
		case 3:
			return strrep[suit - 1];
		default:
			throw new CardException("Invalid card!");
		}
	}
	
	public static PlayingCard getCard(int rank, int suit) throws IllegalArgumentException {
		if(rank > 13 || rank < 1 || suit > 17 || suit < 14) {
			throw new IllegalArgumentException();
		}
		
		if(pcards[rank - 1][suit - 14] == null) {
			pcards[rank - 1][suit - 14] = new PlayingCard(rank, suit);
		}
		
		return pcards[rank - 1][suit - 14];
	}
}
