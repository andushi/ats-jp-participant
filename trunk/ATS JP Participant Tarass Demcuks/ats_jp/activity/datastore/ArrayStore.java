//TODO Activity 4.x
//Implement this class.  Refer to the participant guide for the instructions

/*
 * Created on Aug 11, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
//
package ats_jp.activity.datastore;

public class ArrayStore extends AbstractArrayStore {
    
    //You have a free hand in implementing the requirements of this class.  You may declare any
    //additional members that you deem necessary.  The only restriction again is that you do not
    //violate the encapsulation of the class.
    
    //HINT: This class has direct access to the protected and public members of AbstractArrayStore
    
    public ArrayStore(int size) { 
        super(size);
    }

    public ArrayStore(){
        super();
    }
  
    public boolean add(Object arg) {
    	if (arg == null)
    		throw new IllegalArgumentException();
        if (isFull()) 
        	return false;
        
        store[getCount()] = arg;
        currentCount++;
        return true;
    }
    
    public boolean remove(Object arg) {
    	if (arg == null)
    		throw new IllegalArgumentException();
    	if (isEmpty()) 
        	return false;
    	
        int index = find(arg);
        if (index == NOT_IN_STRUCTURE)
        	return false;
        
        remove(index);
        return true;
    }

    public Object remove (int index) {
    	if (isEmpty()) 
    		return false;
    	
    	Object obj = store[index];
    	
    	for (int i = index; i < currentCount - 1; ++i)
    		if (i != currentCount - 1)
    			store[i] = store[i + 1];
    		else
    			store[i] = null;
    	currentCount--;
    
    	return obj;
    }
    
    public boolean insert(Object arg, int index) {
    	if (arg == null || index < 0 || index > currentCount - 1)
    		throw new IllegalArgumentException();
    	if (isEmpty()) 
        	return false;
    	
    	for (int i = currentCount - 1; i >= index + 1; --i)
        	if (i > 0)
        		store[i] = store[i - 1];
        
    	store[index] = arg;
    	currentCount++;
    	
    	return true;
    }
}
