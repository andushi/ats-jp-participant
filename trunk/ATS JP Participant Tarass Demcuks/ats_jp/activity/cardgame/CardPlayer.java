package ats_jp.activity.cardgame;
import ats_jp.activity.datastore.*;
import ats_jp.activity.profile.*;


public class CardPlayer extends PlayerProfile {

	private ArrayStore cards;

	public CardPlayer(String str, char ch, int max) {
		super (str, ch);
		cards = new ArrayStore (max);
	}

	public boolean addCard(Card card){
		return cards.add(card);
	}

	public boolean removeCard(Card card){
		return cards.remove(card);
	}

	public Card removeCard(int i){
		return (Card)cards.remove(i);
	}

	public boolean isFull(){
		return cards.isFull();
	}
	
	public Card getCard(int i){
		return (Card)cards.check(i);
	}
	
	public int getCardCount(){
		return cards.getCount();
	}
	
	public int getMaxCardCount(){
		return cards.getSize();
	}
}