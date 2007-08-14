package ats_jp.activity.cardgame;

import java.util.*;
import ats_jp.activity.datastore.ArrayStore;

public class PlayingCard implements Card {

	public int rank;
	public int suit;
	// public String str_rank;
	// public String str_suit;
	protected static ArrayStore store = new ArrayStore(52);
	protected static String[] store2 = { "Spades", "Hearts", "Diamonds",
			"Clubs" };
	protected static String[] store3 = { "Ace", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };

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

	private PlayingCard(int rank, int suit) throws IllegalArgumentException {
		// store=new ArrayStore(20);
		if (rank > KING || rank < ACE || suit > CLUBS || suit < SPADES) {
			throw new IllegalArgumentException("illegal");

		}
		this.rank = rank;
		this.suit = suit;
		// this.str_rank=str_rank;
		// this.str_suit=str_suit;
	}

	public Object getCardAttribute(int attribute) throws CardException {
		if (attribute == RANK)
			return rank;
		if (attribute == SUIT)
			return suit;
		if (attribute == STR_RANK) {
			return store3[rank - 8];
		}
		if (attribute == STR_SUIT)
			return store2[suit - 4];
		// TODO Auto-generated method stub

		return null;
	}

	public String toString() {
		String result;
		try {
			result = (String) getCardAttribute(STR_RANK) + " of "
					+ (String) getCardAttribute(STR_SUIT);
		} catch (CardException myexp) {
			result = "";
		}
		return result;
	}

	public boolean equals(Card pro) {
		try {
			if (pro.getCardAttribute(RANK).equals(getCardAttribute(RANK))
					&& pro.getCardAttribute(SUIT)
							.equals(getCardAttribute(SUIT)))
				return true;
		} catch (CardException myexp) {
			return false;
		}
		return false;
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	public static PlayingCard getCard(int rank, int suit) {
		PlayingCard tmp = new PlayingCard(rank, suit);
		for(int i=0;i<store.getCount();i++){
			if(tmp.equals((PlayingCard)(store.check(i))))
					return (PlayingCard)store.check(i);
		}

			store.add(tmp);
			return tmp;

		
	}

}
