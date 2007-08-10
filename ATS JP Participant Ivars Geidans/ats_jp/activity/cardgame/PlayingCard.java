/*
 * Created on Aug 9, 2007
 * Accenture Riga Delivery Center
 */

package ats_jp.activity.cardgame;

//Interface for the constants.
interface PlayingCardConsts {
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
}

public class PlayingCard implements Card, PlayingCardConsts {
	
	private int rank, suit;
	
	//Stores the created cards.
	private static PlayingCard[][] pcards = new PlayingCard[13][4];

	//String representations mapped on the constants.
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
		if (rank > 13 || rank < 1 || suit > 17 || suit < 14) {
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
			//Checking if attributes are equal.
			if (card.getCardAttribute(0) == getCardAttribute(0) &&
					card.getCardAttribute(1) == getCardAttribute(1)){
				return true;
			}
		} catch(CardException e) {
			//This method should throw it up bu then the
			//test suite doesn't accept it.
		}
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
		//Integer representations.
		case 0:
			return getRank();
		case 1:
			return getSuit();
		//String representations.
		case 2:
			return strrep[rank - 1];
		case 3:
			return strrep[suit - 1];
		//No such attribute!
		default:
			throw new CardException("Invalid attribute!");
		}
	}
	
	public static PlayingCard getCard(int rank, int suit) throws IllegalArgumentException {
		if (rank > 13 || rank < 1 || suit > 17 || suit < 14) {
			throw new IllegalArgumentException();
		}
		
		//Creating card if it doesn't exist;
		if (pcards[rank - 1][suit - 14] == null) {
			pcards[rank - 1][suit - 14] = new PlayingCard(rank, suit);
		}
		
		return pcards[rank - 1][suit - 14];
	}
}
