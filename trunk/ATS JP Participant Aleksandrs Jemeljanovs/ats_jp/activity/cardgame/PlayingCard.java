package ats_jp.activity.cardgame;

import java.util.HashMap;
import java.util.Map;

import ats_jp.activity.datastore.ArrayStore;

public class PlayingCard implements Card {
	
	private int rank;
	private int suit;
	private static Map list=new HashMap();
	
	public static final int RANK = 101;
	public static final int SUIT = 102;
	public static final int STR_RANK = 103;
	public static final int STR_SUIT  = 104;
	
	
	
	public static final int SPADES = 201;
	public static final int HEARTS = 202;
	public static final int DIAMONDS = 203;
	public static final int CLUBS  = 204;
	
	
	
	
	
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
	
	private static final String STR_SPADES = "Spades";
	private static final String STR_HEARTS = "Hearts";
	private static final String STR_DIAMONDS = "Diamonds";
	private static final String STR_CLUBS  = "Clubs";
	
	
	private static final String STR_ACE = "Ace";
	private static final String STR_TWO = "Two";
	private static final String STR_THREE = "Three";
	private static final String STR_FOUR = "Four";
	private static final String STR_FIVE = "Five";
	private static final String STR_SIX = "Six";
	private static final String STR_SEVEN = "Seven";
	private static final String STR_EIGHT = "Eight";
	private static final String STR_NINE = "Nine";		
	private static final String STR_TEN = "Ten";
	private static final String STR_JACK = "Jack";
	private static final String STR_QUEEN = "Queen";
	private static final String STR_KING = "King";
	
	
	
	
	//private CardDeck pc;
	//private static ArrayStore ppc;
	
	
	private PlayingCard(int rank, int suit){
			
		if (rank > 13 || rank < 1 || (suit !=201 && suit !=202 && suit !=203 && suit !=204)) throw new IllegalArgumentException("hgfhgf");
		
		this.rank = rank;
		this.suit = suit;		
		
	}
	
	
	
	public Object getCardAttribute(int attribute){ //throws CardException {
		// TODO Auto-generated method stub
	
		if (attribute==101){			
		return rank;}	
		
		if (attribute==102){			
			return suit;}	
			
		if (attribute<20){			
			switch (rank) {
			
			case 1: return STR_ACE;
			case 2: return STR_TWO;
			case 3: return STR_THREE;
			case 4: return STR_FOUR;
			case 5: return STR_FIVE;
			case 6: return STR_SIX;
			case 7: return STR_SEVEN;
			case 8: return STR_EIGHT;
			case 9: return STR_NINE;
			case 10: return STR_TEN;
			case 11: return STR_JACK;
			case 12: return STR_QUEEN;
			case 13: return STR_KING;
			}			
			
		}	
				
		if (attribute>109){
			
			switch (suit) {
			
			case 201: return STR_SPADES;
			case 202: return STR_HEARTS;
			case 203: return STR_DIAMONDS;
			case 204: return STR_CLUBS;			
			}			
			
		}	
	return null;		
	}

	public String toString(){
		
	String r,s;
	
	r=(String)getCardAttribute(rank);
	
	s=(String)getCardAttribute(suit);
	
	return (r+" of "+s);
		
	}
	
	public boolean equals(Card cd) {
	try {	
	if (cd.getCardAttribute(RANK).equals( new Integer(rank))&& cd.getCardAttribute(SUIT).equals(new Integer(suit))) return true;
	return false;
	}	
	catch(CardException myex){
		return false;
	}
	
	}
		
	public static PlayingCard getCard(int rank, int suit)
	{
		PlayingCard temp = new PlayingCard(rank, suit);
		PlayingCard temp2;
		String id=temp.toString();
		temp2=(PlayingCard)list.get(id);
		if (temp2==null) {
			list.put(id, temp); return temp;
			
		}else return temp2;
	}
	
	
	public int getRank(){
		
		return rank;		
	}
		
	
	
	
	public int getSuit(){
		
		return suit;
	}
	
	
	
	
	
	
	
	
}
