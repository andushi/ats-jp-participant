package ats_jp.activity.cardgame;

import ats_jp.activity.profile.*;
import ats_jp.activity.datastore.*;
public class CardPlayer extends PlayerProfile {


	ArrayStore cards;
	
	public CardPlayer(String name, char sex, int mcards) {
		
		super (name, sex);
		cards = new ArrayStore(mcards);
		
	}
	
	
	
	public boolean addCard(Object Card){
		
	return cards.add(Card);
		
	}
	
	
	
	
	public boolean removeCard(Object Card){
		
	return cards.remove(Card);	
		
	}
	
	
	public Card removeCard(int index) {
		
		return (Card) cards.remove(index);
		
	}
	
	
	public boolean isFull() {
		
		return cards.isFull();
	}
	
	
	
	public Card getCard(int index) {
		return (Card) cards.check(index);
	}
		
	
	
	
	public int getCardCount(){
		
		return cards.getCount();
	}
	
		
	
	
	public int getMaxCardCount(){
		
		return cards.getSize();
	}


	
}


