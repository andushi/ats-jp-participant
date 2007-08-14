package ats_jp.activity.cardgame;

import ats_jp.activity.datastore.ArrayStore;
public abstract class CardDeck {
	protected abstract void initializeDeck();
	//Card list[];
	protected ArrayStore store;
	//int maxSize;
	//int size;
	//int currentSize;
	public CardDeck(){
		//list=new Card[size];
		store = new ArrayStore(100);
		//maxSize=size;
		initializeDeck();
	}
	
	public Card getCard() {
	
		if(store.isEmpty())
		return null;
		int i;
		i=(int)Math.round(store.getCount() * Math.random());
	//	if(currentSize!=0)
		
			return (Card)store.remove(i);
	}
	public Card getCard(Card pro)  {
		if(store.remove(pro))
		return pro;
		
		/*Card list2[] = new Card[list.length];	
		int j=0;
		int index=-1;
		 Card pp=null;
		 if(currentSize==0)
			 return null;
		for(int i=0;i<currentSize;i++)
		{if(list[i].equals(pro)){
		list2[j++] = list[i];
		if(index!=-1)
		{ pp=list[index];
		 list = list2;}
		 currentSize--;}
		 return pp;*/
			
		 return null;
}
	public boolean put(Card pro){
			return store.add(pro);
	
		
//		if()
//		return false	
//		if()
//			throw new 
//		//for(int i=0;i<currentSize;i++){
//		if(currentSize!=maxSize)
//			list[i] = pro;
//		currentCount++;
//		return true;}
	
	}
	public int getCurrentCount() {
		return store.getCount();
	}
//	public int getCurrentCount(){
	//	return store.getCount();
//	}
}
