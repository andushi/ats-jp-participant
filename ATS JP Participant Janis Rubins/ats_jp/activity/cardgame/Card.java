/*
 * Created on Aug 12, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package ats_jp.activity.cardgame;

import ats_jp.activity.profile.PlayerProfile;


	
	public interface Card {

    public Object getCardAttribute(int attribute) throws CardException;
    
}

