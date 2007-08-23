package ats_jp.activity.cardgame;
import java.util.Random;
import java.util.ArrayList;

public abstract class CardDeck {
	
	protected ArrayList<Card> store;
	private int count;
	
	protected abstract void initializeDeck();
	
	public CardDeck(){		
		count = 0;
		store = new ArrayList<Card>();
		initializeDeck();		
	}
	
	public Card getCard(){
		if(store.size() == 0)
			return null;
		Random generator = new Random();
		int randomCard = generator.nextInt(store.size());
		Card removedCard = store.get(randomCard);		
		store.remove(randomCard);
		return removedCard;
	}
	
	public Card getCard(Card gCard){
		if(store.size() == 0 || !store.contains(gCard))
			return null;		
		int i = store.indexOf(gCard);		
		Card removedCard = store.get(i);
		store.remove(i);		
		return removedCard;
	}
	
	public boolean put(Card inCard) throws IllegalArgumentException{
		if(inCard == null) 
			throw new IllegalArgumentException("illegal.argument.exception");
		store.add(inCard);		
		return true;		
	}
	
	public int getCurrentCount(){
		return store.size();
	}

}
