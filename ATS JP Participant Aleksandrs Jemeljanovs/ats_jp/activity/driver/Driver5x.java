/*
 * Created on Aug 16, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package ats_jp.activity.driver;

import ats_jp.activity.cardgame.Card;
import ats_jp.activity.cardgame.CardException;
import ats_jp.activity.cardgame.CardPlayer;
import ats_jp.activity.profile.PlayerProfile;

public class Driver5x extends BaseDriver{

    private SimpleCard card[];
   
    private class SimpleCard implements Card{
        
        protected int cardAttribute;
        
        public Object getCardAttribute(int attribute) throws CardException {
           // local variable attribute is irrelevant
            return "Card" + cardAttribute;
        }
        
    }
    
    
    public void initialize() {
                
        card = new SimpleCard[6];
        for(int i =0; i < card.length; i++){
            card[i] = new SimpleCard();
            card[i].cardAttribute = i;
        }
        
        
    }
    
    public void start() {
        
        CardPlayer player = new CardPlayer("Stupendous Man", PlayerProfile.MALE, 5);
        player.setBirthDate(1977, 9, 13);

        compare.compare("Creating Stupendous man with an empty 5 card hand", "Stupendous Man", player.getName());
        compare.compare("Checking card hand count", 0, player.getCardCount());
        compare.compare("Checking maxmimum number of cards", 5, player.getMaxCardCount());
        
        for(int i =0; i < 5; i++){
            try{
                player.addCard(card[i]);
                compare.pass("Adding " + card[i].getCardAttribute(0));
            }
            catch(Exception ex){
                compare.fail("Exception thrown", "No exceptions expected");
            }
        }
        
        compare.compare("Checking card hand count", 5, player.getCardCount());
        compare.compare("Adding a card to a full hand", false, player.addCard(card[5]));
  
        
        
        try{
            player.addCard(null);
            compare.fail("Exception expected", "No expections thrown");
            
            
        }
        catch(Exception ex){
            compare.pass("Exception thrown when adding a null card");
        }
        
        compare.compare("Checking if full", true, player.isFull());
        compare.compare("Checking 3rd card", "Card"+card[2].cardAttribute, "Card"+((SimpleCard)player.getCard(2)).cardAttribute);
        compare.compare("Removing 3rd card", "Card"+card[2].cardAttribute, "Card"+((SimpleCard)player.removeCard(2)).cardAttribute);
        
        
        compare.compare("Removing a card that is not in hand", false, player.removeCard(card[2]));
        
        
        compare.compare("Getting card count", 4, player.getCardCount());
        compare.compare("Checking if full", false, player.isFull());
        

   
    }

    public static void main(String arg[]){
        
        Driver5x driver = new Driver5x();
        driver.initialize();
        driver.start();
        driver.printScore();
    }


}
