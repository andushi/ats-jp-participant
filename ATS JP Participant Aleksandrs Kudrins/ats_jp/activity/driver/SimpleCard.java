package ats_jp.activity.driver;

import ats_jp.activity.cardgame.Card;
import ats_jp.activity.cardgame.CardException;

public class SimpleCard implements Card{

    protected int cardAttribute;
    
    public Object getCardAttribute(int attribute) throws CardException {
       // local variable attribute is irrelevant
        return "Card" + cardAttribute;
    }
    
    public String toString(){
        
        return "Card"+cardAttribute;
    }
}
