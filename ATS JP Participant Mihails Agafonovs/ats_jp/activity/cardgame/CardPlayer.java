package ats_jp.activity.cardgame;

import ats_jp.activity.profile.PlayerProfile;

public class CardPlayer extends PlayerProfile {
	public int maxCards;
	public int cardCount=0;
	Card[]hand;
	
	public CardPlayer(String name, char gender, int maxCards) {
		super(name, gender);
		this.maxCards = maxCards;
		hand=new Card[maxCards];
	}

	public boolean addCard(Card Card) {
		if(Card==null) {
            throw new IllegalArgumentException("PlayerProfile.method.argument.invalid");
    	}
    	if (isFull()) return false;
    	hand[cardCount]=Card;
    	cardCount++;
        return true;
	}
	
	public boolean removeCard(Card Card) {
		int i=0;
		int k=0;
		if(Card==null) {
            throw new IllegalArgumentException("PlayerProfile.method.argument.invalid");
    	}
		for (i=0; i<(getCardCount()); i++) {
    		if (hand[i].equals(Card)) {
    			hand[i]=null;
    			cardCount--;
    			k=i;
    			for (i=k; i<(getCardCount()-1); i++) {
    	    		hand[i]=hand[i+1];
    	    	}
    			return true;
    		}
    	}
		return false;
	}
	
	public Card removeCard(int index) {
		int i=0;
		Card hand2;
		hand2=hand[index];
		hand[index]=null;
		cardCount--;
		for (i=index; i<(getCardCount()-1); i++) {
    		hand[i]=hand[i+1];
    	} 
		return hand2;
	}
	  
	  public boolean isFull() {
		  if (cardCount==maxCards) { 
			  return true;
		  }
		  else { return false;
		  }
	  }
	  
	  public Card getCard(int index) {
		  return hand[index];
	  }
	  
	  public int getCardCount() {
		  return cardCount;
	  }
	  
	  public int getMaxCardCount() {
		  return maxCards;
	  }

}





