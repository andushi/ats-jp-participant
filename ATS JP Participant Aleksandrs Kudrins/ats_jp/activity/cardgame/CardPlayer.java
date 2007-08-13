package ats_jp.activity.cardgame;

import ats_jp.activity.profile.PlayerProfile;

	
public class CardPlayer extends PlayerProfile {

	Object[] inHand;
	int counterID;
	
	public CardPlayer(String name, char str, int count){
		super(name,str);
	}
    
	public boolean addCard(Card){
		if (Card==null)
			throw new IllegalArgumentException("arraystack.method.argument.invalid");
		
			
			
			return true;
	}
//	public boolean removeCard(Card){
	//	return ture;
//	}
	//public Card removeCard(int){
		
//	}
	public boolean isFull(){
		return true;
	}
	public Card getCard(int) {
		
	}
	public int getCardCount(){
		
	}
	public int getMaxCardCount(){
		
	}
}
