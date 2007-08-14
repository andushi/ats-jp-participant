package ats_jp.activity.cardgame;
import java.util.*;
import ats_jp.activity.datastore.ArrayStore;



public abstract class CardDeck {

	protected ArrayStore store;
	
	
	protected abstract void initializeDeck();
	
	
	
	
	public CardDeck(){
		
		store = new ArrayStore();
	
		initializeDeck();	
		
	}
	
	
	
	
	
	public Card getCard() {
		
		int k=0;
		
		Random gen = new Random();
		k=store.getCount();
		if (k==0) return null;
		
		
		
		Card card = (Card)store.remove(gen.nextInt(k));
		
	return card;	
		
		
	}
	
	
	
	
	
	
	public Card getCard(Card c){
		
		if (store.getCount()==0) return null;
		
		int i=store.find(c);
		
		return (Card)store.remove(i);
		
		
	}
	
	
	
	
	
	
	public boolean put(Card ca) {
		
		if (store.getCount()==0) throw new IllegalArgumentException();
		return store.add(ca);
	}
	
	
	
	
	
	
	
	
	public int getCurrentCount(){
		
		return store.getCount();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
