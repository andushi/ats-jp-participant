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
	//	protected Object store[];

	//You have a free hand in implementing the requirements of this class.  You may declare any
	//additional members that you deem necessary.  The only restriction again is that you do not
	//violate the encapsulation of the class.

	//HINT: This class has direct access to the protected and public members of AbstractArrayStore	
	//protected int currentCount;
	protected static final int DEFAULT_SIZE = 5;
	public static final int NOT_IN_STRUCTURE = -1;
	private int first;
	private int last;

	public ArrayStore(int size) {
		super(size);
		// TODO Auto-generated constructor stub
	}

	// add funkcija    
	public boolean add(Object arg) {
		if (isFull()) {
			return false;
		}

		if (arg == null || getCount()>getSize()) {
			throw new IllegalArgumentException(
					"arraystack.method.argument.invalid");
		} else {
			if (getCount()<getSize())
			{
			store[getCount()] = arg;
			currentCount++;
			
			return true;
			}
		}
return true;
	}

	public boolean remove(Object arg) {

		if (arg == null) {
			throw new IllegalArgumentException(
					"arraystack.method.argument.invalid");
		}

		int k = -1;
		for (int i = 0; i < getSize(); i++) {
			if (arg.equals(store[i])) {
				store[i] = null;			
				k = i;
				currentCount--;
				break;
			}
			
		}
		if (k == -1) {
			return false;
		}
		for (int i = k; i < getCount(); i++)
		{							
			store[i]=store[i+1];						
		}
		store[getCount()]=null;
		return true;
	}

	
	
	public Object remove(int index) {
		/*if (index<0 || index>=getCount()) 
		{
			throw new IllegalArgumentException(
			"arraystack.method.argument.invalid");

		}*/
		  Object k=null;
	        if (isEmpty()) {
	        	return k;
	        }
	        else
	        {
	        	k=store[index];
	        	store[index]=null;
	        	currentCount--;	        
	 //       	if (getCount()-1!=index)
	 //       {
        		for (int i = index; i < (getCount()); i++) 
        			{	        			
	        			store[i]=store[i+1];
	        			
	        		}
        		//store[getCount()]=null;
	        }		        	
	   //     }
		return k;
	}

	public boolean insert(Object arg, int index) {
//|| currentCount==getSize()
		if (arg==null || index<0 || index>getCount()) 
		{
			throw new IllegalArgumentException(
			"arraystack.method.argument.invalid");

		}
		if (isFull())
		{
			return false;
		}
//	   	k=store[index];

		for (int i = getCount()-1; i >= index; i--) 
		{	        			
			store[i+1]=store[i];			
		}
    	store[index]=arg;
    	currentCount++;	        
		return true;
	}

/*	public int getSize() {

		return store.length;
	}
*/
	public int getCount() {

		return currentCount;
	}

	public boolean isEmpty() {

		if (getCount() == 0) {
			return true;
		}

		return false;
	}

	public ArrayStore() {
		super();

	}

	public int getFirst() {
		return first;
	}

}
