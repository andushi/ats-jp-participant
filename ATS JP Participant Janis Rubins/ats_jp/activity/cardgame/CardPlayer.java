package ats_jp.activity.cardgame;

import com.sun.org.apache.xpath.internal.operations.Equals;

import ats_jp.activity.profile.PlayerProfile;

public class CardPlayer extends PlayerProfile {
	protected Object index[];
	public int maxcard = 0;
	public int cardount = 0;
	
	public CardPlayer(String name, char gender, int hand) {
		super(name, gender);
		if (hand > 0 && hand < 20) {
			this.index = new Object[hand];
			maxcard = hand;
			cardount = 0;
		}
		/*
		 * System.out.println("Manager::playTone("+name+", "+gender+", "+index);
		 * System.out.println(" NOT IMPLEMENTED");
		 */

	}

	public boolean addCard(Object Card) {
		// Object[this.index];
		if (Card == null) {
			throw new IllegalArgumentException(
					"profile.method.argument.invalid");
		}
		if (isFull()) {
			return false;
		}
		index[cardount] = Card;
		cardount++;
		return true;
	}

	public boolean removeCard(Object Card) {

		if (Card == null) {
			throw new IllegalArgumentException(
					"profile.method.argument.invalid");
		}

		for (int i = 0; i < getCardCount(); i++)

			if (index[i].equals(Card)) {
				for (int j = i; j < getCardCount() - 1; j++) {
					this.index[j] = this.index[j + 1];
				}
				this.index[getCardCount() - 1] = null;
				cardount--;

				return true;
			}
		return false;
	}

	public Object removeCard(int index) {
		Object card;
		card = this.index[index];
		this.index[index] = null;
		for (int i = index; i < getCardCount() - 1; i++) {
			this.index[index] = this.index[index + 1];
		}
		this.index[getCardCount() - 1] = null;
		cardount--;
		return card;
	}

	public boolean isFull() {
		return (cardount == maxcard ? true : false);
	}

	public Object getCard(int index) {
		Object card;
		card = this.index[index];
		return card;

	}

	public int getCardCount() {
		return cardount;
	}

	public int getMaxCardCount() {
		return maxcard;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
