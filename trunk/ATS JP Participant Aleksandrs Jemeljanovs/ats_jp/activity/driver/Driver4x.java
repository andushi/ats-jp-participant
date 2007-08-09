/*
 * Created on Aug 11, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package ats_jp.activity.driver;

import ats_jp.activity.datastore.ArrayStore;
import ats_jp.activity.profile.PlayerProfile;

public class Driver4x extends BaseDriver{

    PlayerProfile data[];
    
    public void initialize() {
        data = new PlayerProfile[5];
        
        
        data[0] = new PlayerProfile("Stupendous Man", PlayerProfile.MALE);
        data[0].setBirthDate(1977, 9, 13);
        data[1] = new PlayerProfile("The Homemaker", PlayerProfile.FEMALE);
        data[1].setBirthDate(1981, 8, 11);
        data[2] = new PlayerProfile("Captain Obvious", PlayerProfile.MALE);
        data[2].setBirthDate(1980, 5, 19);
        data[3] = new PlayerProfile("The Procrastinator", PlayerProfile.MALE);
        data[3].setBirthDate(1, 1, 1);
        data[4] = new PlayerProfile("The Amazing Narcoleptic", PlayerProfile.MALE);
        data[4].setBirthDate(9999, 12, 31);
    
        
    }

    public void start() {
        ArrayStore store = new ArrayStore(4);
        System.out.println("Creating a 4 index structure");
        compare.compare("Adding " + data[0].getName(), true, store.add(data[0]));
        compare.compare("Adding " + data[1].getName(), true, store.add(data[1]));
        compare.compare("Adding " + data[2].getName(), true, store.add(data[2]));
        compare.compare("Adding " + data[3].getName(), true, store.add(data[3]));
        compare.compare("Adding " + data[4].getName(), false, store.add(data[4]));
        compare.compare("Finding " + data[2].getName(), 2, store.find(data[2]));
        compare.compare("Removing " + data[2].getName(), true, store.remove(data[2]));
        compare.compare("Inserting in index 1 " + data[4].getName(), true, store.insert(data[4], 1));
        compare.compare("Removing first object", data[0].getName(), ((PlayerProfile)store.remove(0)).getName());
        compare.compare("Removing last object", data[3].getName(), ((PlayerProfile)store.remove(2)).getName());
        compare.compare("Adding object already present: " + data[4].getName(), true, store.add(data[4]));
        compare.compare("Checking first index", data[4].getName(),  ((PlayerProfile)store.check(0)).getName());
        compare.compare("Checking object count ", 3, store.getCount());
        
        System.out.println("Null entering store ");
        try{
            store.add(null);
            compare.fail("IllegalArgumentException expected", "No exception thrown");
        }catch(Exception ex){
            compare.compare("null entered", IllegalArgumentException.class.getName(), ex.getClass().getName());
        }
        
        System.out.println("Removing a null");
        try{
            store.remove(null);
            compare.fail("IllegalArgumentException expected", "No exception thrown");
        }catch(Exception ex){
            compare.compare("Tried to remove a null", IllegalArgumentException.class.getName(), ex.getClass().getName());
        }
        
        System.out.println("Removing using an invalid index");
        try{
            store.remove(-1);
            compare.fail("ArrayIndexOutOfBoundsException expected", "No exception thrown");
        }catch(Exception ex){
            compare.compare("Tried to remove a non existent index", ArrayIndexOutOfBoundsException.class.getName(), ex.getClass().getName());
        }
        
        System.out.println("Inserting a null");
        try{
            store.insert(null, 0);
            compare.fail("IllegalArgumentException expected", "No exception thrown");
        }catch(Exception ex){
            compare.compare("Tried to insert a null", IllegalArgumentException.class.getName(), ex.getClass().getName());
        }
        
        System.out.println("Inserting in an invalid index");
        try{
            store.insert(data[0], -1);
            compare.fail("IllegalArgumentException expected", "No exception thrown");
        }catch(Exception ex){
            compare.compare("Tried to insert in an invalid index", IllegalArgumentException.class.getName(), ex.getClass().getName());
        }
        
        
    }
    
    public static void main(String arg[]){
        
        Driver4x driver = new Driver4x();
        driver.initialize();
        driver.start();
        driver.printScore();
    }

}
