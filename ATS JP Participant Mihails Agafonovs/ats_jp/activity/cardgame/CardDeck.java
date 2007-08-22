package ats_jp.activity.cardgame;

import java.util.*;

public abstract class CardDeck {
	private int cardCount=0;
	private ArrayList<Card> deck;
	protected abstract void initializeDeck();

	public CardDeck() {
		deck = new ArrayList<Card>();
		initializeDeck();
	}
	
	public Card getCard() {
		if (cardCount==0) return null;
		cardCount--;
		return deck.get((int)Math.round(Math.random()));
		
	}
	
	public Card getCard(Card card) {
		Card card2;
		int i;
		if (cardCount==0) return null;
		for (i=0; i<cardCount; i++) {
			if (deck.get(i).equals(card)) {
				card2=card;
				deck.remove(i);
				cardCount--;
				return card2;
			}	
		}
		return null;
	}
	
	public boolean put(Card card) {
		if(card==null) {
            throw new IllegalArgumentException("CardDeck.method.argument.invalid");
    	}
		deck.add(card);
		cardCount++;
		return true;
	}
	
	public int getCurrentCount() {
		return cardCount;
	}

}
