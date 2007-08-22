package ats_jp.activity.cardgame;

public class PlayingCard implements Card {
	
	public int  RANK=0, SUIT=1, STR_RANK=2, STR_SUIT=3;
	private int rank, suit;
	public static final int  SPADES=13, HEARTS=14, DIAMONDS=15, CLUBS=16;
	public static final int ACE=12, TWO=0, THREE=1, FOUR=2, FIVE=3, SIX=4, SEVEN=5,
			EIGHT=6, NINE=7, TEN=8, JACK=9, QUEEN=10, KING=11;
	
	private static final String[] ranks= {
		"Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
		"Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	
	private static final String[] suits = {
		"Spades", "Hearts", "Diamonds", "Clubs"};
	
	private static PlayingCard[][] allCards = new PlayingCard[13][4]; 
	
	private PlayingCard(int rank, int suit) {
		if (rank>12 || rank<0 || suit>16 || suit<13) {
			throw new IllegalArgumentException("CardDeck.method.argument.invalid");
		}
		this.rank=rank;
		this.suit=suit;
	}

	public Object getCardAttribute(int attribute) throws CardException {
		// TODO Auto-generated method stub
		switch (attribute) {
		case 0: getRank(); 
		case 1: getSuit(); 
		case 2: return ranks[rank]; 
		case 3:	return suits[suit-13]; 
		default: throw new CardException("CardDeck.method.argument.invalid");
		}
	}
	
	public String toString() {
		return (ranks[rank]+" of "+suits[suit-13]);
	}
	
	public boolean equals(Card card) {
		try {
		if (getCardAttribute(0)==card.getCardAttribute(0) && 
			getCardAttribute(1)==card.getCardAttribute(1))
		return true;
		}
		catch  (CardException e){}
		return false;
	}
	
	public static PlayingCard getCard(int rank, int suit) throws IllegalArgumentException {
		if (rank>12 || rank<0 || suit>16 || suit<13) {
			throw new IllegalArgumentException("CardDeck.method.argument.invalid");
		}
		if (allCards[rank][suit-13]==null) {
			allCards[rank][suit-13] = new PlayingCard(rank, suit);
		}
		return allCards[rank][suit-13];
	}
	
	public int getRank() {
		return rank;
	}
	
	public int getSuit() {
		return suit;
	}
	
}
