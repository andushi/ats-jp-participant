package ats_jp.activity.driver;
import ats_jp.activity.cardgame.*;

public class SimpleDeck extends CardDeck{
	
	SimpleCard store[];

	protected void initializeDeck() {
        store = new SimpleCard[6];
        
        for(int i = 0; i < 6; i++){
        	store[i] = new SimpleCard();
        	store[i].cardAttribute = i;
        }
        
		for(int i =0; i < 5; i ++){             
			put(store[i]);
		}		
	}
	
	
}
