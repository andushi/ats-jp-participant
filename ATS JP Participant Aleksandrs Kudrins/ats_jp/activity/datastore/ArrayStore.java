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
    	store2 = new Object[store.length];
    	
    	if(arg == null)
            throw new IllegalArgumentException("arraystack.method.argument.invalid");
     	int i=0,k=0,l=0;
     	for(i=0;i<currentCount;i++)
     	{
     		if (store[i].equals(arg)){ 
     			store[i]=null;
     			 for(k=0;k<store.length;k++){
     				 if (store[k]!=null){
     					 store2[l]=store[k];
     					 l++;
     				 }
     			 }
     		store=store2;
     		currentCount--;
     		return true;
     		}
     	}
     	return false;
    }
    public Object remove(int index){
    	int i=0,k=0,l=0;
    	Object store2;
    	Object store3[];
    	
    	store2=store[index];
    	store[index]=null;
    	
    	store3 = new Object[store.length];
    	
    	for (i=0;i<store.length;i++){
    		if (store[i]!=null){
    			store3[k]=store[i];
    			k++;
    		}
    	}
    	store=store3;
    	currentCount--;
    	return store2;
    }
    public boolean insert(Object arg, int index){
     	if(arg == null || index<=-1 || index>=store.length)
            throw new IllegalArgumentException("arraystack.method.argument.invalid");
     	Object store2[];
     	store2 = new Object[store.length];
     	
     	if (currentCount>=store.length) return false;
     	
     	int i,k=0,l=0;
    	for (i=0;i<store.length;i++){
    			
    		if (index==i) {store2[k]=arg;k++;store2[k]=store[i];k++;continue;}
    		if (store[i]!=null) {
    			store2[k]=store[i];
    			k++;
    		}
    	}
    		
    	store=store2;
    	currentCount++;
    	return true;
    }
}
