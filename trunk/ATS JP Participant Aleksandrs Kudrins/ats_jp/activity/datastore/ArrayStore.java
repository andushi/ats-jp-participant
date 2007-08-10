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
    
    public boolean add(Object arg){
    
    	if(arg == null)
            throw new IllegalArgumentException("arraystack.method.argument.invalid");
    	
    	if (currentCount==store.length) return false;
    	store[currentCount]=arg;
    	currentCount++;
    	return true;
    }
    public boolean remove(Object arg){
    	
    	Object store2[];
   
    	if(arg == null)
            throw new IllegalArgumentException("arraystack.method.argument.invalid");
     	int i=0,k=0,l=0;
     	for(i=0;i<currentCount;i++)
     	{
     		if (store[i].equals(arg)){ 
     			store[i]=null;
     			 for(k=0;k<getSize();k++){
     				 if (store[k]!=null){
     					 store2[l]=store[k];
     					 l++;
     				 }
     			 }
     		store=store2;
     		return true;
     		}
     	}
     	return false;
    	}
}
