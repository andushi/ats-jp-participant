/*
 * Created on Aug 17, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package ats_jp.activity.driver;

import ats_jp.activity.cardgame.PlayingCard;

public class Driver8x extends BaseDriver{

    PlayingCard card[];
    
    public void initialize(){
        card = new PlayingCard[4];
    }
    
    public void start(){
        
        card[0] = PlayingCard.getCard(PlayingCard.ACE, PlayingCard.SPADES);
        compare.compare("Ace of Spades created", "Ace of Spades", card[0].toString());
        card[1] = PlayingCard.getCard(PlayingCard.TWO, PlayingCard.HEARTS);
        compare.compare("Two of Hearts created", "Two of Hearts", card[1].toString());
        card[2] = PlayingCard.getCard(PlayingCard.FOUR, PlayingCard.DIAMONDS);
        compare.compare("Four of Diamonds created", "Four of Diamonds", card[2].toString());
        card[3] = PlayingCard.getCard(PlayingCard.JACK, PlayingCard.CLUBS);
        compare.compare("Jack of Clubs created", "Jack of Clubs", card[3].toString());
        
        compare.compare("Retrieving" + card[0] + " again, checking if same object", true,
                card[0] == PlayingCard.getCard(PlayingCard.ACE, PlayingCard.SPADES)); 
        
        compare.compare("Retrieving" + card[1] + " again, checking if same object", true,
                card[1] == PlayingCard.getCard(PlayingCard.TWO, PlayingCard.HEARTS)); 
    
        
        compare.compare("Retrieving" + card[2] + " again, checking if same object", true,
                card[2] == PlayingCard.getCard(PlayingCard.FOUR, PlayingCard.DIAMONDS)); 
    
        
        compare.compare("Retrieving" + card[3] + " again, checking if same object", true,
                card[3] == PlayingCard.getCard(PlayingCard.JACK, PlayingCard.CLUBS)); 
    
        compare.compare("Checking the equals() method using two similar cards", true, card[0].equals(PlayingCard.getCard(PlayingCard.ACE, PlayingCard.SPADES)));
        compare.compare("Checking the equals() method using two different cards", false, card[3].equals(card[2]));
    
        System.out.println("Creating card with an invalid rank");
        try{
            PlayingCard.getCard(PlayingCard.CLUBS, PlayingCard.CLUBS) ;
            compare.fail("IllegalArgumentException expected", "No exception thrown");
        }catch(Exception ex){
            compare.compare("Passing Invalid rank", IllegalArgumentException.class.getName(), ex.getClass().getName());
        }
        
        System.out.println("Creating card with an invalid suit");
        try{
            PlayingCard.getCard(PlayingCard.ACE, PlayingCard.ACE);
            compare.fail("IllegalArgumentException expected", "No exception thrown");
        }catch(Exception ex){
            compare.compare("Passing Invalid suit", IllegalArgumentException.class.getName(), ex.getClass().getName());
        }
    
    }
    
    
    public static void main(String[] args) {

        Driver8x driver = new Driver8x();
        driver.initialize();
        driver.start();
        driver.printScore();

    }

}
