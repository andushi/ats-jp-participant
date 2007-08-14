/*
 * Created on Aug 5, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package ats_jp.activity.driver;

import ats_jp.activity.datastore.ArrayQueue;
import ats_jp.activity.profile.PlayerProfile;

/**
 * Driver for activity 2.1
 * 
 * @author eugene.p.lozada
 */
public class Driver3x extends BaseDriver{

    	private PlayerProfile data[];
    	
    	
    	public void initialize(){
    	    
    	    data = new PlayerProfile[5];
    	
            data[0] = new PlayerProfile("Eugene", PlayerProfile.MALE);
            data[0].setBirthDate(1977, 9, 13);
            data[1] = new PlayerProfile("Nadja", PlayerProfile.FEMALE);
            data[1].setBirthDate(1981, 8, 11);
            data[2] = new PlayerProfile("Toby", PlayerProfile.MALE);
            data[2].setBirthDate(1980, 5, 19);
            data[3] = new PlayerProfile("Mr. Procrastinator", PlayerProfile.MALE);
            data[3].setBirthDate(1, 1, 1);
            data[4] = new PlayerProfile("Ms. Last In Line", PlayerProfile.MALE);
            data[4].setBirthDate(9999, 12, 31);
    	}
    
    	public void start(){
    	 
    	    ArrayQueue q = new ArrayQueue(3);    	
    	    compare.compare("Queue of 3 created. Calling Queue.getSize()", 3, q.getSize());
    	    compare.compare("Calling Queue.isFull()", false, q.isFull());	
    	    
    	    compare.compare(data[0].getName() + " entering queue. ", true, q.enqueue(data[0]));
    	    compare.compare(data[1].getName() + " entering queue. ", true, q.enqueue(data[1]));
    	    compare.compare(data[2].getName() + " entering queue. ", true, q.enqueue(data[2]));
    	    compare.compare(data[3].getName() + " entering queue. ", false, q.enqueue(data[3]));
    	    compare.compare("Calling Queue.isFull()", true, q.isFull());	
            compare.compare(data[2].getName() + " entering queue. ", false, q.enqueue(data[2]));
                   
    	    compare.compare("Getting queue count",3, q.getCount());
    	    
    	    compare.compare("Finding " + data[1].getName(), 1, q.find(data[1]));
    	    compare.compare("Finding " + data[3].getName(), ArrayQueue.NOT_IN_STRUCTURE, q.find(data[3]));
    	    compare.compare("Calling Queue.check(2)", data[2].getName(), ((PlayerProfile)q.check(2)).getName());
            
            
    	    compare.compare("Checking next in queue", "Eugene", ((PlayerProfile)q.checkNext()).getName());
    	    compare.compare("Getting next in queue", "Eugene", ((PlayerProfile)q.dequeue()).getName());
    	    compare.compare("Getting next in queue", "Nadja", ((PlayerProfile)q.dequeue()).getName());
    	    compare.compare("Finding " + data[2].getName(), 0, q.find(data[2]));
    	    compare.compare("Calling Queue.hasNext()",true, q.hasNext());
    	    
    	    compare.compare("Getting queue count", 1, q.getCount());
    	    compare.compare("Getting next in queue", "Toby", ((PlayerProfile)q.dequeue()).getName());
    	    compare.compare("Getting next in queue", null, q.dequeue());
    	    compare.compare("Calling Queue.hasNext()",false, q.hasNext());
    	    
    	    compare.compare(data[3].getName() + " entering queue. ", true, q.enqueue(data[3]));
            compare.compare(data[2].getName() + " entering queue. ", true, q.enqueue(data[2]));
            compare.compare(data[1].getName() + " entering queue. ", true, q.enqueue(data[1]));
    	    compare.compare("Getting queue count",3, q.getCount());
            compare.compare("Calling Queue.check(2)", data[1].getName(), ((PlayerProfile)q.check(2)).getName());
        
            System.out.println("Null entering queue");
            try{
                q.enqueue(null); // Skatit
                compare.fail("IllegalArgumentException expected", "No exception thrown");
            }catch(Exception ex){
                compare.compare("null entered", IllegalArgumentException.class.getName(), ex.getClass().getName());
            }
            
            System.out.println("Find a null");
            try{
                q.find(null);
                compare.fail("IllegalArgumentException expected", "No exception thrown");
            }catch(Exception ex){
                compare.compare("Looking for a null", IllegalArgumentException.class.getName(), ex.getClass().getName());
            }
            
            System.out.println("Checking index 100000");
            try{
                q.check(100000);
                compare.fail("IllegalArgumentException expected", "No exception thrown");
            }catch(Exception ex){
                compare.compare("Checing index 100000", IllegalArgumentException.class.getName(), ex.getClass().getName());
            }
            
            System.out.println("Checking negative index");
            try{
                q.check(-1);
                compare.fail("IllegalArgumentException expected", "No exception thrown");
            }catch(Exception ex){
                compare.compare("Checing index -1", IllegalArgumentException.class.getName(), ex.getClass().getName());
            }
        }
    	
    	public static void main(String arg[]){
    	    
    	    Driver3x driver = new Driver3x();
    	    driver.initialize();
    	    driver.start();
    	    driver.printScore();
    	}
}
