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
    	
    	if(arg==null){
            throw new IllegalArgumentException("arrayqueue.method.argument.invalid");
    	}
    	if (isFull()) return false;
    	store[currentCount]=arg;
    	currentCount++;
        return true;
    }
    
    public boolean remove(Object arg) {
    	
    	int i=0;
    	int k=0;
    	
    	if(arg==null){
            throw new IllegalArgumentException("arrayqueue.method.argument.invalid");
    	}
    	if (isEmpty()) return false;
    	for (i=0; i<(getCount()-1); i++) {
    		if (store[i].equals(arg)) {
    			store[i]=null;
    			k=i;
    		}
    	}
    	for (i=k; i<(getCount()-1); i++) {
    		store[i]=store[i+1];
    	}
  
    	currentCount--;
    	return true;
    }
    
    public Object remove(int index) {
    	
    	Object copyStore;
    	int i=0;
    
    	copyStore=store[index];
    	store[index]=null;
    	for (i=index; i<(getCount()-1); i++) {
    		store[i]=store[i+1];
    	}
    
    	currentCount--;
    	return copyStore;
    }
    
   public boolean insert(Object arg, int index) {
	   
	   if (isFull()) return false;
	   if((arg==null) || (index<0) || (index>(getSize()-1))){
           throw new IllegalArgumentException("arrayqueue.method.argument.invalid");
	   }
	   if (store[index]==null) currentCount++;
	   store[index]=null;
	   store[index]=arg;
	   currentCount++;
	   return true;
	   
   }
    
}
