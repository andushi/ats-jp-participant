package ats_jp.activity.cardgame;

import java.util.*;
import ats_jp.activity.datastore.ArrayStore;

public class PlayingCard implements Card {
	private int suit;
	private int rank;
	private static Map cardMap = new HashMap();
	public static final int RANK = 0;
	public static final int SUIT = 1;
	public static final int STR_RANK = 2;
	public static final int STR_SUIT = 3;

	public static final int SPADES = 4;
	public static final int HEARTS = 5;
	public static final int DIAMONDS = 6;
	public static final int CLUBS = 7;

	public static final int ACE = 8;
	public static final int TWO = 9;
	public static final int THREE = 10;
	public static final int FOUR = 11;
	public static final int FIVE = 12;
	public static final int SIX = 13;
	public static final int SEVEN = 14;
	public static final int EIGHT = 15;
	public static final int NINE = 16;
	public static final int TEN = 17;
	public static final int JACK = 18;
	public static final int QUEEN = 19;
	public static final int KING = 20;

	public static final String STR_ACE = "Ace";
	public static final String STR_TWO = "Two";
	public static final String STR_THREE = "Three";
	public static final String STR_FOUR = "Four";
	public static final String STR_FIVE = "Five";
	public static final String STR_SIX = "Six";
	public static final String STR_SEVEN = "Seven";
	public static final String STR_EIGHT = "Eight";
	public static final String STR_NINE = "Nine";
	public static final String STR_TEN = "Ten";
	public static final String STR_JACK = "Jack";
	public static final String STR_QUEEN = "Queen";
	public static final String STR_KING = "King";

	public static final String STR_SPADES = "Spades";
	public static final String STR_HEARTS = "Hearts";
	public static final String STR_DIAMONDS = "Diamonds";
	public static final String STR_CLUBS = "Clubs";

	private Card card[];

	public Object getCardAttribute(int attribute) throws CardException {

		switch (attribute) {
		case RANK:
			return new Integer(rank);
		case SUIT:
			return new Integer(suit);
		case STR_RANK:
			return getRankAsString(rank);
		case STR_SUIT:
			return getSuitAsString(suit);
		}

		// return getCard(rank, suit);

		// TODO Auto-generated method stub
		// return null;
	}

	private PlayingCard(int rank, int suit) {

		if (rank < 8 || suit < 4 || rank > 20 || suit > 7) {
			throw new IllegalArgumentException(
					"profile.method.argument.invalid");
		}
		setRank(rank);
		setSuit(suit);
	}

	public String getRankAsString(int rank) {
		switch (rank) {
		case 8:
			return STR_ACE;
		case 9:
			return STR_TWO;
		case 10:
			return STR_THREE;
		case 11:
			return STR_FOUR;
		case 12:
			return STR_FIVE;
		case 13:
			return STR_SIX;
		case 14:
			return STR_SEVEN;
		case 15:
			return STR_EIGHT;
		case 16:
			return STR_NINE;
		case 17:
			return STR_TEN;
		case 18:
			return STR_JACK;
		case 19:
			return STR_QUEEN;
		case 20:
			return STR_KING;
		}
		throw new IllegalArgumentException("profile.method.argument.invalid");
	}

	public String getSuitAsString(int suit) {
		switch (suit) {
		case 4:
			return STR_SPADES;
		case 5:
			return STR_HEARTS;
		case 6:
			return STR_DIAMONDS;
		case 7:
			return STR_CLUBS;
		}
		throw new IllegalArgumentException("profile.method.argument.invalid");
	}


	public String toString() 
	{	
		return getRankAsString(rank) + " of " + getSuitAsString(suit);
	}

	public boolean equals(PlayingCard playingCard) {
		if (rank == playingCard.getRank() && suit == playingCard.getSuit()) {
			return true;
		}
		return false;
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	public void setRank(int rank)
	{
		this.rank = rank;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public static PlayingCard getCard(int rank, int suit)
	{
		String id = generateID(rank, suit);
		PlayingCard temp = (PlayingCard) cardMap.get(id);
		if (temp==null)
		{
			temp = new PlayingCard(rank,suit);
			cardMap.put(id, temp);
		}
			return temp;
		}	
	private static String generateID(int rank, int suit)
	{
		return "ID"+rank+suit; 
	}
	
	/*
	 * public Object getCardAttribute(int a) { a=0; return a; }
	 */
}
