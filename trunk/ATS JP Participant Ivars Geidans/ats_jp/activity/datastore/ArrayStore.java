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
        //Asking superclass to create our object;
    	super(size);
    }
    
    public ArrayStore(){
    	//Asking superclass to create our object;
        super();
    }
    
    public boolean add(Object arg) {
    	//Checking if argument is legal and if store not full.
    	if (arg == null)
    		throw new IllegalArgumentException();
        if (isFull()) 
        	return false;
        
        //Storing the element and increasing count.
        store[getCount()] = arg;
        currentCount++;
        
        return true;
    }
    
    public boolean remove(Object arg) {
    	//Checking if argument legal and if array not full.
    	if (arg == null)
    		throw new IllegalArgumentException();
    	if (isEmpty()) 
        	return false;
    	
    	//Finding the element, deleting and returning it or NIS
        int index = find(arg);
        if (index == NOT_IN_STRUCTURE)
        	return false;
        
        remove(index);
        
        return true;
    }

    public boolean insert(Object arg, int index) {
    	//Checking argument and fullness.
    	if (arg == null || index < 0)
    		throw new IllegalArgumentException();
    	if (isEmpty()) 
        	return false;
    	
    	//Moving elements to make space for the new one.
    	for (int i = currentCount - 1; i >= index + 1; --i)
        	if (i > 0)
        		store[i] = store[i - 1];
        
    	//Storing the element.
    	store[index] = arg;
    	currentCount++;
    	
    	return true;
    }
    
    public Object remove (int index) {
    	if (isEmpty()) 
    		return false;
    	
    	//Temporary variable.
    	Object obj = store[index];
    	
    	//Moving elements to remove the hole.
    	for (int i = index; i < currentCount - 1; ++i)
    		if (i != currentCount - 1)
    			store[i] = store[i + 1];
    		else
    			store[i] = null;
    	currentCount--;
    
    	return obj;
    }
}
