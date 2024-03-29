/*
 * Created on Aug 5, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package ats_jp.activity.datastore;

/**
 * This class uses arrays to simulate the behavior of a Queue.
 * 
 * @author eugene.p.lozada
 *
 */
public class ArrayQueue extends AbstractArrayStore{
    
    //The following instance variables are accessible by all methods inside this class.  You are not allowed
    //to declare additional class members
    
    //The index of the object in the queue
    private int first;
    
    //The index of the last object in the queue
    private int last;
   
    //HINT: In addition to the above variables, the array 'store' and the integer 'currentCount' are also
    //accessible by this class via inheritance.  The array 'store' is used to represent the queue, and the
    //integer currentCount' counts the number of objects inside the queue.
    
    //HINT: All public or protected variables and methods from AbstractArrayStore can be used here directly.
    
    public ArrayQueue(int size){
        super(size);
    }
    
    public ArrayQueue(){
        super();
    }

    public boolean enqueue(Object next) {
        
        //TODO Activity 3.0
        //This method adds the object 'next' to the end of the queue assuming that the queue is not full 
        //and that a similar object is not already it he queue.  Return true if the queue is successful, and
        //false otherwise.
        
        //If 'next' is a null object, throw an IllegalArgumentException with a descriptive message.
       if(next==null) throw new IllegalArgumentException("illegal.argument.exception");
       if(!isFull()){ 
    	    last++;
    		last%=getSize();
    		store[last]=next;
    		if(isEmpty())first=last;    	  
    	   currentCount++;
    	   return true;
       }          
       return false;
    }

    public Object dequeue() {
        
        //TODO Activity 3.1
        //This removes the next object from the start of queue and returns it. If there is nothing to return
        //then return null.     	 
    	if(!isEmpty()){
    		//ArrayQueue storeElement = new ArrayQueue();    	
    		//if(getSize()==++first)first=0;
    		//else ++first;    		
    		//return storeElement;
    		Object kautkas;
    		kautkas = store[first];
    		store[first]=null;    		
    		++first;
    		first%=getSize();
    		--currentCount;
    		return kautkas;    		
    	}               
        return null;
    }

    public Object checkNext(){
        
        return store[first];
    }
    
    
    public int find(Object arg) {
        
        //TODO Activity 3.2
        //Compares 'arg' using the equals() method and returns its place relative to the start of the queue.
        //If there is no object in the queue that qualifies, then return NOT_IN_STRUCTURE.
        /*for(int i=0;i<getSize();i++){
        	if(store[i].equals(arg)){
        		int skaits=0;
        		for(int j=i;j<getSize();){
        			if(store[j]==store[first])return skaits;
        			if(j==getSize()-1)j=0;
        			else ++j;
        			++skaits;
        		}        			
        	}
        }   */
    	if(arg==null) throw new IllegalArgumentException("illegal.argument.exception");   		
    	int skaits=0;
    	for(int i=first;;skaits++){
    		if(store[i].equals(arg)){
    			return skaits;
    		}
    		++i;
    		i%=getSize();   
    		if(skaits>getSize())break;
    	}
        return NOT_IN_STRUCTURE;        
    }

     
    public void  clear() {
        
        first = 0;
        last = 0;
        
        store = new Object[store.length];
    }
    

    public boolean hasNext() {
        
        if(currentCount == 0){
            return false;
        }
        else{
            return true;
        }
    }
    
    public Object check(int index) {
        
        
        //TODO Activity 3.3
        //Find which object is currently at the specified index relative to the start of the queue.  
        //The start of the queue is index 0    	
    	if(getSize()<=index || index <0) throw new IllegalArgumentException("illegal.argument.exception");   		
    	for(int i=first;i<getSize();index--){
    		if(index==0)return store[i];
    		i++;
    		i%=getSize();
        }    	
                
        return null;
        
    }
    
    

    public boolean add(Object arg) {
        return enqueue(arg);
    }

}   