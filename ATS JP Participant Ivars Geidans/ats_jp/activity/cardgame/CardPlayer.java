package ats_jp.activity.cardgame;
import ats_jp.activity.profile.*;
import ats_jp.activity.datastore.*;

public class CardPlayer extends PlayerProfile {
	private int max;
	private ArrayStore cards;
	
	public CardPlayer(String str, char ch, int max) {
		super(str, ch);
		this.max = max;
		cards = new ArrayStore(max);
	}

	public boolean addCard(Card card) {
		return cards.add(card);
	}
	
	public boolean removeCard(Card card) {
		return cards.remove(card);
	}
	
	public Card removeCard(int i) {
		return  (Card)cards.remove(i);
	}
	
	public boolean isFull() {
		return cards.isFull();
	}
	
	public Card getCard(int i) {
		return (Card)cards.check(i);
	}
	
	public int getCardCount() {
		return cards.getCount();
	}
	
	public int getMaxCardCount() {
		return max;
	}
}
