package ats_jp.activity.cardgame;

public class PlayingCard implements Card {
	
	public static final int ACE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final int SIX = 6;
	public static final int SEVEN = 7;
	public static final int EIGHT = 8;
	public static final int NINE = 9;
	public static final int TEN = 10;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	
	public static final int SPADES = 14;
	public static final int HEARTS = 15;
	public static final int DIAMONDS = 16;
	public static final int CLUBS = 17;
	
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
	
	public int suit, rank;
	private static PlayingCard[][] masivs = new PlayingCard[13][4];	
	//public String str_suit, str_rank;
	public static final int SUIT = 18;
	public static final int RANK = 19;
	public static final int STR_SUIT = 20;
	public static final int STR_RANK = 21;

	
	private PlayingCard(int rank, int suit){
		if(rank<1 || rank>13 || suit<14 || suit>17)
			throw new IllegalArgumentException("illegal.argument.exception");		
		setRank(rank);
		setSuit(suit);		
	}
	
	public Object getCardAttribute(int attribute){
		switch(attribute){
		case SUIT:
			/*switch(suit){
			case SPADES: return new Integer(SPADES);
			case HEARTS: return new Integer(HEARTS);
			case DIAMONDS: return new Integer(DIAMONDS);
			case CLUBS: return new Integer(CLUBS);
			
			}
			*/
			return new Integer(suit);
		case RANK:
			return new Integer(rank);
			/*switch(suit){
			switch(rank){
			case ACE: return new Integer(ACE);
			case TWO: return new Integer(TWO);
			case THREE: return new Integer(THREE);
			case FOUR: return new Integer(FOUR);
			case FIVE: return new Integer(FIVE);
			case SIX: return new Integer(SIX);
			case SEVEN: return new Integer(SEVEN);
			case EIGHT: return new Integer(EIGHT);
			case NINE: return new Integer(NINE);
			case TEN: return new Integer(TEN);
			case JACK: return new Integer(JACK);
			case QUEEN: return new Integer(QUEEN);
			case KING: return new Integer(KING);			
			}*/
		case STR_SUIT:
			switch(suit){
			case SPADES: return STR_SPADES;
			case HEARTS: return STR_HEARTS;
			case DIAMONDS: return STR_DIAMONDS;
			case CLUBS: return STR_CLUBS;
			}
		case STR_RANK:
			switch(rank){
			case ACE: return STR_ACE;
			case TWO: return STR_TWO;
			case THREE: return STR_THREE;
			case FOUR: return STR_FOUR;
			case FIVE: return STR_FIVE;
			case SIX: return STR_SIX;
			case SEVEN: return STR_SEVEN;
			case EIGHT: return STR_EIGHT;
			case NINE: return STR_NINE;
			case TEN: return STR_TEN;
			case JACK: return STR_JACK;
			case QUEEN: return STR_QUEEN;
			case KING: return STR_KING;
			}
		}
		return null;
	}	
	
	public String toString(){
		return this.getCardAttribute(21)+" of "+this.getCardAttribute(20);
	}
	
	public boolean equals(Card newCard){		
		try {
		if(newCard.getCardAttribute(18).equals(getCardAttribute(18)) &&
				newCard.getCardAttribute(19).equals(getCardAttribute(19)))
			return true;
		} catch(CardException e){}
		return false;
	}
	
	public int getRank(){
		return rank;
	}
	
	public int getSuit(){
		return suit;
	}
	
	public void setRank(int rank){
		this.rank=rank;
	}
	
	public void setSuit(int suit){
		this.suit=suit;
	}
	
	public static PlayingCard getCard(int rank, int suit){
		if(rank<1 || rank>13 || suit<14 || suit>17)
			throw new IllegalArgumentException("illegal.argument.exception");
		if(masivs[rank-1][suit-14] == null){
			masivs[rank-1][suit-14] = new PlayingCard(rank, suit);
		}
		return masivs[rank-1][suit-14];		
	}
	
}
