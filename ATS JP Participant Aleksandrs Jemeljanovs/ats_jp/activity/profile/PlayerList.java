package ats_jp.activity.profile;

import ats_jp.activity.datastore.ArrayStore;


 
public class PlayerList {
	
	ArrayStore plist;
	PlayerProfile[] pp1,pp2;	
	
	public 	PlayerList (int size){

	plist = new ArrayStore(size);
			
	}


	public boolean addPlayer(PlayerProfile Player){
		
		return plist.add(Player);
		
	}

	public PlayerProfile findPlayer(int index) {
		
		return (PlayerProfile) plist.check(index);
		
	}


	public PlayerProfile findPlayer(PlayerProfile Player){
		
		int i=0;
		
		i= plist.find(Player);
		if (i==-1) return null;
		return (PlayerProfile) plist.check(i);			
	}
	
	public PlayerProfile[] findPlayer(String name) {
		
		
		ArrayStore result = new ArrayStore(plist.getSize());
		for (int i=plist.getCount()-1; i>=0; i-- ){
		
		if (((PlayerProfile)(plist.check(i))).getName().equals(name)){ result.add(plist.check(i));}  
	
		
		}
		
		PlayerProfile[] pp1;
		pp1 = new PlayerProfile[result.getCount()];
		//if (result.getCount()<=0) return null;
		System.arraycopy(result.toArray(), 0, pp1, 0, result.getCount());
		
		return pp1;
	}
	
	
	public PlayerProfile[] getAll() {
		//return (PlayerProfile[])plist.toArray();
		
		PlayerProfile[] pp1;
		pp1 = new PlayerProfile[plist.getCount()];
		//if (result.getCount()<=0) return null;
		System.arraycopy(plist.toArray(), 0, pp1, 0, plist.getCount());
		
		return pp1;
		
	}
	
	public int getPlayerCount(){
		
		return plist.getCount();
	}

	
	public int getMaxPlayerCount(){
		
		return plist.getSize();
	}
	
	public PlayerProfile removePlayer(int id) {
		;
		return (PlayerProfile)plist.remove(id);
	}
	



}
