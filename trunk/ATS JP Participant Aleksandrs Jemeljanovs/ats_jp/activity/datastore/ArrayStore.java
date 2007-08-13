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
	
	
	
	
    
	public boolean add(Object arg){ 	
	
		if (arg == null)throw new IllegalArgumentException();
		if (isFull()) return false;
	
		    		
		store[currentCount]=arg;
		currentCount++;
		
		return true;
	}
	
	public boolean remove(Object arg) {
		
		if (arg == null)throw new IllegalArgumentException();	
		if (isEmpty()) {return false;}
		
		int a=currentCount-1;
		int i=currentCount-1;
		
		do {
    		if(store[i].equals(arg)) {
    			
    			
    			a=i; 
    			store[a]=null;
    			while (a<currentCount-1){ store[a]=store[a+1];a++;
    			    			
    	    	} 
    			store[currentCount-1]=null;
    			currentCount--;
    			return true;
    		}
    		
    	
    		i--;   		   		  		
    		    			
    	} while (i>0);
		
		return false;
		
	
	}
	
	
	public Object remove(int index) {
	
		Object a;
	
		if (isEmpty()) {return null;}	
	
		a=store[index];
		store[index]=null;
	
	
		store[index]=null;
		while (index<currentCount-1){ store[index]=store[index+1];index=index+1;
		    			
    	} 
		store[currentCount-1]=null;
		currentCount--;
		return a;
		
		

	}
	
	
	
	
	public boolean insert (Object arg, int index){ 
	
		if (arg == null | index<0 | index > currentCount-1)throw new IllegalArgumentException();
		if (isFull()) return false;
		
		int i=currentCount-1;
		do { store[i+1]=store[i];
		i--;	
		} while (index<i+1);
		
		store[index]=arg;
		currentCount++;
		return true;
	}
	
	
	
	
    public ArrayStore(int size) { 
        super(size);
    }

    public ArrayStore(){
        super();
    }
  
}
