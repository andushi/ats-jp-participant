package ats_jp.activity.cardgame;
import java.util.*;

import ats_jp.activity.datastore.ArrayStore;
public abstract class CardDeck {
	//protected List<Card> cards;
	protected ArrayStore store;

	protected abstract void initializeDeck();
	public CardDeck()
	{ 
		store=new ArrayStore(100) ;
		initializeDeck();
	}
		
	public Card getCard()
	{int k;
		
		k=store.getCount();		
		if (k==0)
		{
			return null;
		}
		Random generator = new Random();
		Card card;		
		card=(Card)store.remove(generator.nextInt(k));
		return card;
		
	}
	public Card getCard(Card myCard)
	{ 
		if (store.isEmpty()) {
			return null;
		}
		if (!store.remove(myCard)) return null;
		return myCard;
	}
	public boolean put(Card card)
	{
		/*if (card == null) {
			throw new IllegalArgumentException(
					"arraystack.method.argument.invalid");
		}
		if (store.isFull()) return false;*/
		return store.add(card);
	}
	public int getCardCount()
	{ 
	return store.getCount();
	
	}
	public int getCurrentCount() {
		return store.getCount();
	}

}
