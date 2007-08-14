package ats_jp.activity.cardgame;

import ats_jp.activity.profile.PlayerProfile;

public class CardPlayer extends PlayerProfile {
	Card cardList[];
	int maxSize;
	int currentSize;

	public CardPlayer(String name, char dt, int count) {
		super(name, dt);
		cardList = new Card[count];
		maxSize = count;
		currentSize = 0;

	}

	// CardPlayer= new CardPlayer();

	public boolean addCard(Card card) { // int []Card;
		// Card[] Hand;
		// int Maxsize;
		if (card == null)
			throw new IllegalArgumentException("illegal");
		if (isFull())
			return false;
		cardList[getCardCount()] = card;
		currentSize++;
		return true;
	}

	public boolean removeCard(Card card) {
		if (card == null) {
			throw new IllegalArgumentException("invalid");
		}
		if(currentSize==0)
			return false;
		for (int i = 0; i < currentSize; i++) {
			if (cardList[i].equals(card)){
				cardList[i]=null;
				for(int j=i;j<currentSize-1;j++)
					cardList[j]=cardList[j+1];
				cardList[getCardCount()-1]=null;
				currentSize--;
				return true;
			}
			
				
		}
		return false;
	}

	public Card removeCard(int card) {
		Card cardobj = cardList[card];
		for(int j=card;j<currentSize-1;j++)
			cardList[j]=cardList[j+1];
		cardList[getCardCount()-1]=null;
		currentSize--;
		return cardobj;
	}

	public boolean isFull() {
		if (maxSize == currentSize)
			return true;
		else
			return false;
	}

	public Card getCard(int card) {

		return cardList[card];

	}

	public int getCardCount() {
		return currentSize;
	}

	public int getMaxCardCount() {
		return maxSize;
	}

}
