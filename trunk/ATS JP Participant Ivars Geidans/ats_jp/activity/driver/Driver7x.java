/*
 * Created on Aug 16, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package ats_jp.activity.driver;

import ats_jp.activity.cardgame.Card;


public class Driver7x extends BaseDriver{

    private SimpleDeck deck;
    private Card card[];
       
    public void initialize() {
    	
        deck = new SimpleDeck();
        card = deck.store;
    }


    public void start() {
        
        compare.compare("Removing " + card[2], card[2], deck.getCard(card[2]));
        compare.compare("Checking current count count", 4, deck.getCurrentCount());
        compare.compare("Putting " + card[2], true, deck.put(card[2]));
        compare.compare("Getting nonexistent card", null,  deck.getCard(card[5]));
        
        System.out.println("Dealing all cards randomly");
        compare.compare("Checking current count count", 5, deck.getCurrentCount());
        int count=0;
        Card temp[] = new Card[deck.getCurrentCount()];
        
        for(int i = 0; i <temp.length; i++){
            temp[i] = deck.getCard();
            System.out.println(temp[i]);
            if(temp[i]  != card[i]){
                count++;
            }
        }
        
        if(count >= 2){
            compare.pass("Cards were dealt randomly");
        }else{
            compare.fail("Dealing cards randomly", "Cards must be dealt randomly");
        }
        
        System.out.println("Adding a null card");
        try{
            deck.put(null);
            compare.fail("IllegalArgumentException expected", "No exception thrown");
        }catch(Exception ex){
            compare.compare("Tried to insert in an invalid index", IllegalArgumentException.class.getName(), ex.getClass().getName());
        }
        
        
        compare.compare("Checking card count", 0, deck.getCurrentCount());
        compare.compare("Getting from an empty deck", null, deck.getCard());
        
        
        
        
    }
    
    public static void main(String[] args) {

        Driver7x driver = new Driver7x();
        driver.initialize();
        driver.start();
        driver.printScore();
       
    }


}
