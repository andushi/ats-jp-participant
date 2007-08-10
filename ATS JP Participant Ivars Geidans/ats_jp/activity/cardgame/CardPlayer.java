/*
 * Created on Aug 9, 2007
 * Accenture Riga Delivery Center
 */

package ats_jp.activity.cardgame;
import ats_jp.activity.profile.*;
import ats_jp.activity.datastore.*;

public class CardPlayer extends PlayerProfile {
	private ArrayStore cards;
	
	//Initializing the new CardPlayer.
	public CardPlayer(String str, char ch, int max) {
		super(str, ch);
		cards = new ArrayStore(max);
	}
	
	//Simply using ArrayStore methods.
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
		return cards.getSize();
	}
}
