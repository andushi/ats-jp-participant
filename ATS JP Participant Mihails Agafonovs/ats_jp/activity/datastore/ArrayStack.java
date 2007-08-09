/*
 * Created on Aug 8, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package ats_jp.activity.datastore;

/**
 * This class implemennts the behavior of a stack as an array
 * 
 * @author eugene.p.lozada
 *  
 */
public class ArrayStack extends AbstractArrayStore{
    
    
    //You are not allowed declare any additional member variables or methods 
    
    //HINT: In addition to the above variables, the array 'store' and the integer 'currentCount' from the
    //class AbstractArrayStore are also accessible by this class via inheritance.  The array 'store' is used
    //to represent the stack, and the integer 'currentCount' represents how many objects are currently in the
    //stack
    
    //HINT: The methods isFull() and contains() from AbstractArrayStore can be used here directly.
    
    public ArrayStack(int size) {
        super(size);
    }

    public ArrayStack(){
        super();
    }
    
    public boolean push(Object arg) {

        //TODO Activity 2.4
        
        //Implement this method so that it 'pushes' the object 'arg' onto the top of the stack assuming
        //that the stack is not full, and that a similar object is not already inside the stack. Return 
        //true if the push is successful, false otherwise 
        
   
        //HINT: Remember that the bottom of the stack is index 0
    	int i=0;
        if(arg == null){
            throw new IllegalArgumentException("arraystack.method.argument.invalid");
        }
        boolean bResult=false;
      //  start solution
        for (i=0; i<getCount(); i++){
        	bResult=store[i].equals(arg);
        	if (bResult==true) return false;
        }
        
        if (currentCount==store.length) return false;
        store[currentCount]=arg;
        currentCount++;
        
   //      if (store[currentCount]==arg) return false;
  //      if (currentCount==store.length) return false;
  //      if (currentCount==0) { store[0]=arg; currentCount++; return true;
   //     }
    //    else {store[currentCount]=arg; currentCount++;
       
        return true;
        }

  
   

    public Object pop() {

        //TODO Activity 2.5
        //Implement this method so that it 'pops' the topmost object 'arg' in the stack.  This also
        //removes the object (place a 'null' in the index) from the stack and returns it.  
        //Return null if the pop fails for any reason (ie stack is empty... )
        
        //HINT: Remember that the bottom of the stack is index 0
      
        //start solution
    	Object store2;
    	/*for (i=0; i<currentCount; i++){
    		if (store[currentCount]==null) return null ;
    	 	if (store[i]!=null) max=max++;
    	}*/
    	if (getCount()==0) return null;
    	store2=store[currentCount-1];
 //   	if (store[currentCount-1]==null) return null;
    	store[currentCount-1]=null;
    	currentCount--;
      
        return store2;

    }

    public Object peek() {

        //TODO Activity 2.6
        //Implement this method so that it takes a look at the top most object of the stack.  It 
        //returns the object, but does not remove it from the stack.  Return null if the peek fails.
        
        //HINT: Remember that the bottom of the stack is index 0
      
        //start solution
    	
    	/*for (i=0; i<currentCount; i++){
    	 	if (store[i]!=null) max=max++;
    		}
    	*/
    	 if (getCount()==0) return null;
    	
    	 else return store[currentCount-1];

    }

    public boolean add(Object arg) {
        return push(arg);
    }



}
