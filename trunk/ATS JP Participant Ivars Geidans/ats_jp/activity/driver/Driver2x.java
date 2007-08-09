/*
 * Created on Aug 8, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package ats_jp.activity.driver;

import java.util.Calendar;

import ats_jp.activity.datastore.ArrayStack;
import ats_jp.activity.profile.PlayerProfile;


/**
 * Driver class for Activity 2.0
 * 
 * @author eugene.p.lozada
 *
 */
public class Driver2x extends BaseDriver{

    private PlayerProfile data[];
    
    public void initialize() {
        
        data = new PlayerProfile[4];
        data[0] = new PlayerProfile("Eugene", PlayerProfile.MALE);
        data[0].setBirthDate(1977, 9, 13);
        data[1] = new PlayerProfile("Nadja", PlayerProfile.FEMALE);
        data[1].setBirthDate(1981, 8, 11);
        data[2] = new PlayerProfile("Toby", PlayerProfile.MALE);
        data[2].setBirthDate(1980, 5, 19);
        data[3] = new PlayerProfile("The OW", PlayerProfile.MALE);
        data[3].setBirthDate(Calendar.getInstance());
   
        
    }

    public void start() {
        
        ArrayStack stack = new ArrayStack(3);
        
        compare.compare("Stack of 3 created.  Calling Stack.getSize()", 3,stack.getSize());
        compare.compare("Calling Stack.isFull()", false, stack.isFull());
        compare.compare(data[0].getName() + " entering stack", true, stack.push(data[0]));
        compare.compare(data[1].getName() + " entering stack", true, stack.push(data[1]));
        compare.compare(data[2].getName() + " entering stack", true, stack.push(data[2]));
        compare.compare(data[3].getName() + " entering stack", false, stack.push(data[3])); 
        compare.compare("Calling Stack.getCount()", 3, stack.getCount());
        compare.compare("Calling Stack.isFull()", true, stack.isFull());
        compare.compare("Calling Stack.top()", data[2].getName(), ((PlayerProfile)stack.peek()).getName());
        compare.compare("Calling Stack.pop()", "Toby", ((PlayerProfile)stack.pop()).getName());
        compare.compare("Calling Stack.top()", "Nadja", ((PlayerProfile)stack.peek()).getName());
        compare.compare("Calling Stack.pop()", "Nadja", ((PlayerProfile)stack.pop()).getName());
        compare.compare("Calling Stack.pop()", "Eugene", ((PlayerProfile)stack.pop()).getName());
        compare.compare("Calling Stack.pop()", null, stack.pop());
        compare.compare("Calling Stack.hasNext()", null, stack.peek());
        compare.compare("Calling Stack.getCount()", 0, stack.getCount());
    }
    
    public static void main(String arg[]){
	    
	    Driver2x driver = new Driver2x();
	    driver.initialize();
	    driver.start();
	    driver.printScore();
	}
    
    

}
