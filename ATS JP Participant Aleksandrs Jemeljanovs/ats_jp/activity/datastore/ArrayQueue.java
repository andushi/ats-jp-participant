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
    private int last=-1;
   
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
       
    	if (next == null)throw new IllegalArgumentException();
    	if (isFull()/*| store[currentCount-1]== next*/) {return false;}
    	//if (getCount() == getSize()/*| store[currentCount-1]== next*/) {return false;}
    	//if (next == null){throw new IllegalArgumentException();}
    	
    		    		
    	store[(last+1)%getSize()]=next;
    	
    	currentCount++;
    		
    	last=(last+1)%getSize();
    	
    	return true;
    	
       
    }

    public Object dequeue() {
        
        //TODO Activity 3.1
        //This removes the next object from the start of queue and returns it. If there is nothing to return
        //then return null. 
            
    	
    	Object a;
    	
    	if (isEmpty()) {return null;}
    	
    	a=store[first];
    	
    	store[first]=null;
    	
    	first=(first+1)%getSize();
    	
    	currentCount--;
    	
    	return a;
	
		 

    }

    public Object checkNext(){
        
        return store[first];
    }
    
    
    public int find(Object arg) {
        
        //TODO Activity 3.2
        //Compares 'arg' using the equals() method and returns its place relative to the start of the queue.
        //If there is no object in the queue that qualifies, then return NOT_IN_STRUCTURE.
        
        
    	if (arg == null)throw new IllegalArgumentException();
    	
    	int i; 
    	i=first; 
    	
    	int c; 
    	c=NOT_IN_STRUCTURE;
    	if (isEmpty()) return c;
    	
    	do {
    		if(store[i].equals(arg)) {
    			c = (i - first + getSize())%getSize();
    			break;
    		}
    		i=(i+1)%getSize();
    	} while (i!=last);
    			
    								//if (i>first) {c=i-first;}
    								//c=i-first+getSize();
    								//return c;    		
    								//} 
    return c;
    }

     
    public void  clear() {
        
        first = 0;
        last = -1;
        
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
        
    	if (index<0 | index>getSize()) {throw new IllegalArgumentException();}
    	if (isEmpty()) return null;
        
    	Object b = store[(index + first)%getSize()];
        
        return b;
    }
    
    

    public boolean add(Object arg) {
        return enqueue(arg);
    }

}   