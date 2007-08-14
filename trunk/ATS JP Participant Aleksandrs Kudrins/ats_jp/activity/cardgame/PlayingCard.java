package ats_jp.activity.cardgame;

public class PlayingCard implements Card {

	public static final int RANK=0, SUIT=1, STR_RANK=2, STR_SUIT=3;
	public  static final  int SPADES=15, HEARTS=16, DIAMONDS=17, CLUBS=18;
	public  static final int ACE=14, TWO=2, THREE=3, FOUR=4, FIVE=5, SIX=6, SEVEN=7, EIGHT=8, NINE=9, TEN=10, JACK=11, QUEEN=12, KING=13; 
	 private int rank, suit;
	// PlayingCard Kard;
	 private static PlayingCard[][] Kard2 = new PlayingCard[13][4];
	  
	 private static final String[] sRank = new String[]{"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
	  private static final String[] sSuit = new String[]{"Spades","Hearts","Diamonds","Clubs"};
	
	 private PlayingCard(int rank, int suit){
			if (rank<2 || rank>14 || suit<15 || suit>18)
				throw new IllegalArgumentException("arraystack.method.argument.invalid");
		//	PlayingCard Kard;
			this.rank=rank;
			this.suit=suit;
	//		Kard = new PlayingCard(rank, suit);
	 
	 }
	 public Object getCardAttribute(int attribute) throws CardException {
			// TODO Auto-generated method stub
			switch (attribute){
			case (0): {getRank();}
			case (1): {getSuit();}
			case (2): { return sRank[rank-2];}
			case (3): {return sSuit[suit-15];}
			default : throw new CardException("");
			}
		//	return null;
		}
	 public String toString(){
		String Cardname;
		Cardname = sRank[rank-2]+" of "+ sSuit[suit-15];
		return Cardname;
	 }
	 
	 public boolean equals(Card strCard){
		 try{
		 if (strCard.getCardAttribute(0)==getCardAttribute(0) && strCard.getCardAttribute(1)==getCardAttribute(1)){
			 return true;
		 }
		 } catch (CardException e){}
		 return false;
	 }


	int getRank(){
		return rank;
	}
	int getSuit(){
		return suit;
	}
	
	public static PlayingCard getCard(int rank, int suit) throws IllegalArgumentException{
		if (rank<2 || rank>14 || suit<15 || suit>18)
			throw new IllegalArgumentException("arraystack.method.argument.invalid");
		//	PlayingCard Kard2;
			if (Kard2[rank-2][suit-15]==null){ 
				Kard2[rank-2][suit-15] = new PlayingCard(rank, suit); 
				
			}
			
			return Kard2[rank-2][suit-15];	
	}
}
