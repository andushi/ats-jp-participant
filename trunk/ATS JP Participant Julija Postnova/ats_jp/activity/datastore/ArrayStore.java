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
	public static void main(String[] args) {
		// Object tmp = new tmp () ;

		// You have a free hand in implementing the requirements of this class.
		// You may declare any
		// additional members that you deem necessary. The only restriction
		// again is that you do not
		// violate the encapsulation of the class.

		// HINT: This class has direct access to the protected and public
		// members of AbstractArrayStore
	}

	public ArrayStore(int size) {
		super(size);
	}

	public ArrayStore() {
		super();
	}

	public boolean add(Object arg) {
		if (arg == null) {
			throw new IllegalArgumentException("method.argument.invalid");
		}
		if (isFull())
			return false;
		else
			store[getCount()] = arg;
		currentCount++;
		return true;

	}

	public boolean remove(Object arg) {
		if (arg == null) {
			throw new IllegalArgumentException("method.argument.invalid");
		}
		if (isEmpty()) return false;
		for (int i = 0; i < getCount(); i++) {
			if (store[i].equals(arg)) {
				for (int j = i; j < getCount()-1; j++)
					store[j] = store[j + 1];
				store[getCount() - 1] = null;
				currentCount--;
				return true;
			} 
		}
		return false;
	}

	public Object remove(int index) {

		if (isEmpty())
			return null;
		
		//if (index < 0 || index >= getCount())
			//throw new IllegalArgumentException("method.argument.invalid");
		Object tm;
		tm = store[index];
		int i;
		for (i = index; i < getCount() - 1; i++)
			store[i] = store[i+1];
		store[getCount()-1] = null;
		currentCount--;
		return tm;
	}

	public boolean insert(Object arg, int index) {
		if (isFull())
			return false;
		if (arg == null || index < 0 || index > getCount()) {
			throw new IllegalArgumentException("method.argument.invalid");
		}
		for (int i = getCount() - 1; i > index; i--)
			store[i + 1] = store[i];
		
		store[index] = arg;
		currentCount++;
		// int i;`
		// for(i=0;i<= getCount(); i++)
		// store[getCount()]=arg;
		return true;
		// else return false;
	}
}
