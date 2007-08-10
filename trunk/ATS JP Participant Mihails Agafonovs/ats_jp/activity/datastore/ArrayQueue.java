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
    
    boolean k;
   
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
    	int i=0;
    	if(next == null){
            throw new IllegalArgumentException("arrayqueue.method.argument.invalid");
    	}  
    	
    	 for (i=0; i<getCount(); i++){
        	if (store[i].equals(next)== true) return false;
         }
     
    	//if (currentCount==store.length) return false;
    	 if (getCount()==store.length) return false;
    	 if (last>(store.length-1)) { 
       		last=0;
    	 }

    	 store[last]=next;
    	
         last++;
         currentCount++;
     
        return true;
    }

    public Object dequeue() {
        
        //TODO Activity 3.1
        //This removes the next object from the start of queue and returns it. If there is nothing to return
        //then return null. 
        //int i=0; 
    	
    	Object nextCopy;
    	if (getCount()==0) return null;
    	nextCopy=store[first];
    	store[first]=null;
    	first++;
    	if (first>=store.length) first=0;
    	currentCount--;
    	//store[first]=null;
    	//store[first]=;
    	//store[last]=null;
    	//last--;
    	//if (last>store.length) return null;
   
        return nextCopy;
    }

    public Object checkNext(){
        
        return store[first];
    }
    
    
    public int find(Object arg) {
        
        //TODO Activity 3.2
        //Compares 'arg' using the equals() method and returns its place relative to the start of the queue.
        //If there is no object in the queue that qualifies, then return NOT_IN_STRUCTURE.
        
    	int i=0;
    	boolean bResult;
    	if(arg == null){
            throw new IllegalArgumentException("arrayqueue.method.argument.invalid");
    	} 
    	int j=first;
    	for (i=0; i<currentCount; i++, j++){
    		
    		if (j>=getSize()) j=0;
    		
       			if (store[j].equals(arg)) return i;
       			//if (bResult==true) return i;
    		
    	}
    		//if (store[i].equals(arg)){ 
    		//	return i;
    		//}
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
       //int i=0;
       
      // for (i=0; i<getCount(); i++){
   		if ((index>(store.length-1)) || (index<0))
           throw new IllegalArgumentException("arrayqueue.method.argument.invalid");
   	 
   		if (last>(store.length-1)){
   			return store[index-first];
   		}
       return store[index]; 
   }
   
    
    

    public boolean add(Object arg) {
        return enqueue(arg);
    }

}   