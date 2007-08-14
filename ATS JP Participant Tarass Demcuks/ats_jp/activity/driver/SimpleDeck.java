package ats_jp.activity.driver;
import ats_jp.activity.cardgame.CardDeck;

public class SimpleDeck extends CardDeck{
	
	SimpleCard card[];

	protected void initializeDeck() {
		   
		
        card = new SimpleCard[6];
        
        for(int i = 0; i < 6; i++){
            card[i] = new SimpleCard();
            card[i].cardAttribute=i;
        }
        
		   for(int i =0; i < 5; i ++){             
            put(card[i]);
            
        }		
	}
	
	
}
