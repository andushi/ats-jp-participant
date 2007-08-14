package ats_jp.activity.cardgame;
import java.util.*;

public abstract class CardDeck {
	 private List<Card> CardDeck;
	 private int index;
	 protected abstract void initializeDeck();
	 public CardDeck(){

		CardDeck = new ArrayList<Card>();
		initializeDeck();
	}
	public Card getCard(){
		
		if (index!=0){
		index--;
		return CardDeck.get((int)Math.round(Math.random()));
		}
		return null;
	}
	
	public Card getCard(Card card1){
		Card card2;
		
		if (index==0) return null;
		int i;
		for (i=0;i<index;i++){
			if (CardDeck.get(i).equals(card1)){
				card2=CardDeck.get(i);
				index--;
				CardDeck.remove(i);
				
				return card2;
			}
		}
		
		return null;
	}
	public boolean put(Card card1) throws IllegalArgumentException{
		if(card1 == null)
            throw new IllegalArgumentException("arraystack.method.argument.invalid");
	
		CardDeck.add(index, card1);
		
		index++;
		return true;
	}
	
	public int getCurrentCount(){
		return index;
	}
}
