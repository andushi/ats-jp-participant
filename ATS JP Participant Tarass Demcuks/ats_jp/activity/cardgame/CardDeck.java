package ats_jp.activity.cardgame;
import java.util.*;

public abstract class CardDeck {
	
	protected abstract void initializeDeck();
	private int count;
	private List<Card> cards;
	
	public CardDeck(){
		count = 0;
		cards = new ArrayList<Card>();
		initializeDeck();
	}
	
	public Card getCard(){
		if (count != 0){
			count--;
			return cards.get((int)Math.round(count * Math.random()));
		}
		return null;
	}
	
	public Card getCard(Card card){
		Card findcard = null;
	for (Card indexcard : cards){
		if (indexcard != null && card.equals(indexcard)){
			findcard =indexcard;
			}
		}
		if (findcard != null){
			count--;
			}
		
		return findcard;
	}
	
	public boolean put(Card card)throws IllegalArgumentException {
		if (card == null)
			throw new IllegalArgumentException();
		
		count++;
		cards.add(card);
		return true;
	}
	
	public int getCurrentCount(){
		return count;
	}
	
}
	
	

