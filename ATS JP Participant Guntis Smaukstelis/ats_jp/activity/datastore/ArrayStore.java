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
		if(arg==null) throw new IllegalArgumentException("illegal.argument.exception");
		if(isFull()) return false;
		store[getCount()]=arg;
		currentCount++;
		return true;
	}
	
	public boolean remove(Object arg){
		if(arg==null) throw new IllegalArgumentException("illegal.argument.exception");
		if(find(arg) == NOT_IN_STRUCTURE) return false;
		else{			
			remove(find(arg));			
			return true;
		}		
	}
	
	public Object remove(int index){
		if(isEmpty())
			return false;
		Object indexObject;
		indexObject = store[index];
		/*for(int i=index;i<currentCount;i++){
			if(i == currentCount - 1)
				store[i] = null;
			else
				store[i] = store[i+1];
		}
		*/
		int i;
		for(i=index; i<currentCount-1;++i){
			if(i!=currentCount-1) 
				store[i]=store[i+1];
			else 
				store[i]=null;
		}		
		currentCount--;
		return indexObject;		
	}
	
	public boolean insert(Object arg, int index){
		if(arg==null || index<0 || index>currentCount-1) throw new IllegalArgumentException("illegal.argument.exception");
		if(isFull())return false;
		int i;
		for(i=currentCount-1;i>index;i--){			
			store[i]=store[i-1];
		}
		store[i]=arg;
		return true;
	}
	
	
	/////////////////////
    public ArrayStore(int size) { 
        super(size);
    }

    public ArrayStore(){
        super();
    }
  
}
