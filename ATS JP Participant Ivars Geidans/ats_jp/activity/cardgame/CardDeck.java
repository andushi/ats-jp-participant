package ats_jp.activity.cardgame;

public abstract class CardDeck {
	protected abstract void initializeDeck();
	
	public CardDeck() {
		
	}

	public Card getCard() {
		return new Card() {
			public Object getCardAttribute(int attribute) {
				return new Object();
			}
		};
	}
	
	public Card getCard(Card card) {
		return new Card() {
			public Object getCardAttribute(int attribute) {
				return new Object();
			}
		};
	}

	public boolean put(Card card) {
		return true;
	}

	public int getCardCount() {
		return 0;
	}

}
