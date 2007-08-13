package ats_jp.activity.cardgame;

import ats_jp.activity.profile.PlayerProfile;

	
public class CardPlayer extends PlayerProfile {

	Card[] inHand;
	int counterID;
	int Maxcount;
	public CardPlayer(String name, char str, int count){
		super(name,str);
	//	int counterID;
		Maxcount=count;
		 inHand = new Card[count];
	}
    
	public boolean addCard(Card Cards){
		if (Cards==null)
			throw new IllegalArgumentException("arraystack.method.argument.invalid");
		
			if (counterID>=(inHand.length)) return false;
			
			inHand[counterID]=Cards;
			counterID++;
			return true;
	}
	public boolean removeCard(Card Cards){
		if (Cards==null)
			throw new IllegalArgumentException("arraystack.method.argument.invalid");
		int i,k=0,l=0;
		boolean bResult;
		Object Card2;
		Card[] inHand2;
		inHand2 = new Card[inHand.length];

		for (i=0;i<counterID;i++){
			bResult=inHand.equals(Cards);
			if (bResult==true)
			{
				inHand[i]=null;
				counterID--;
				for (k=0;k<counterID;k++){
					if (inHand[k]!=null){
					inHand2[l]=inHand[k];
					l++;}
				}
				inHand=inHand2;
				return true;
			}
		}
		return false;
	}
	public Card removeCard(int index){
		
		Card card2;
		Card[] inHand2;
		inHand2 = new Card[inHand.length];
		int l=0,k=0;
		card2= inHand[index];
		inHand[index]=null;
		counterID--;
		for (k=0;k<counterID;k++){
			if (inHand[k]!=null){
			inHand2[l]=inHand[k];
			l++;}
		}
		inHand=inHand2;

		return card2;
	}
	public Card getCard(int k) {
		return inHand[k];
	}
	public boolean isFull(){
		if (Maxcount==counterID)
		return true;
		else 
		return false;
	}
	public int getCardCount() {
		return counterID;
	}
	public int getMaxCardCount(){
		return Maxcount;
	}
}
