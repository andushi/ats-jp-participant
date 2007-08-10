/*
 * Created on Aug 9, 2007
 * Accenture Riga Delivery Center
 */

package ats_jp.activity.cardgame;
import java.util.*;

public abstract class CardDeck {
	protected abstract void initializeDeck();
	
	//Card count.
	private int count;
	//Storage for the cards.
	private List<Card> cards;
	
	public CardDeck() {
		count = 0;
		cards = new ArrayList<Card>();
		initializeDeck();
	}

	public Card getCard() {
		//Generating a random number and using it to return a random card.
		if (count != 0) {
			count--;
			return cards.get((int)Math.round(count * Math.random()));
		}
	
		return null;
	}
	
	public Card getCard(Card card) {
		Card scard = null;
		
		//Finding the card.
		for (Card icard : cards) {
			if(icard != null && card.equals(icard)) {
				scard = icard;
			}
		}
		
		//If not found scard will be equal to null.
		if (scard != null){
			count--;
		}
		
		return scard;
	}

	public boolean put(Card card) throws IllegalArgumentException {
		if (card == null)
			throw new IllegalArgumentException();
		
		count++;
		cards.add(card);
		
		//Success!
		return true;
	}

	public int getCurrentCount() {
		return count;
	}

}
