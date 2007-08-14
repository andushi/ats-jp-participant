package ats_jp.activity.cardgame;

public abstract class CardDeck {
	Card[] CardDeck;
	int index;
	int max;
	protected abstract void initializeDeck();
	public CardDeck(){
		Card[] CardDeck;
		CardDeck = new Card[max];
		initializeDeck();
		index++;
	}
	public Card getCard(){
		if (index==0) return null;
		
	}
	public Card getCard(Card card1){
		Card[] CardDeck2;
		Card CardDeck3;
		int i,k=0,l=0;
		CardDeck2 = new Card[max-1];
		for (i=0;i<max;i++){
			if(CardDeck[i].equals(card1)) {
				CardDeck3=CardDeck[i];
				CardDeck[i]=null;
				index--;
				for (k=0;k<max-1;k++){
					if (CardDeck[k]!=null){
						CardDeck2[l]=CardDeck[k];
						l++;
					}
				}
			CardDeck=CardDeck2;
			return CardDeck3;
			}
		}
		
		return null;
	}
	public boolean put(Card card1){
		if(card1 == null)
            throw new IllegalArgumentException("arraystack.method.argument.invalid");
		if (max==index) return false;
		CardDeck[index]=card1;
		index++;
		return true;
	}
	
	public int getCardCount(){
		return index;
	}
}
