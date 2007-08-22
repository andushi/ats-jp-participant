package ats_jp.activity.profile;

import ats_jp.activity.cardgame.Card;

public class PlayerList {
	
	int listSize=0;
	int playerCount=0;
	PlayerProfile[] list;
	
	public PlayerList(int listSize) {
		//super(name, gender);
		this.listSize = listSize;
		list = new PlayerProfile[listSize];
	}

	public boolean addPlayer(PlayerProfile playerProfile) {
		int i;
		if(playerProfile==null) {
            throw new IllegalArgumentException("PlayerProfile.method.argument.invalid");
    	}
    	if (playerCount==list.length) return false;
    	for (i=0; i<playerCount; i++) {
    		if (list[i].equals(playerProfile)) return false;
    	}
    	list[playerCount]=playerProfile;
    	playerCount++;
		return true;
	}
	
	public PlayerProfile findPlayer(int id) {
		int i;
		if ((id<0) || (id>(list.length-1))) return null;
		for (i=0; i<getPlayerCount(); i++) {
			if (list[i].equals(list[id])) return list[id];
		}
		return null;
	}
	
	public PlayerProfile findPlayer(PlayerProfile playerProfile) {
		int i;
		if(playerProfile==null) {
            throw new IllegalArgumentException("PlayerProfile.method.argument.invalid");
    	}
		for (i=0; i<getPlayerCount(); i++) {
			if (list[i].equals(playerProfile)) return list[i];
		}
		return null;
	}
	
	public PlayerProfile[] findPlayer(String name) {
		int i;
		int j=0;
		PlayerProfile[] list2 = new PlayerProfile[list.length]; 
		for (i=0; i<getPlayerCount(); i++) {
			if ((list[i].getName()).equals(name)) {
				list2[j]=list[i];
				j++;
			}
			if (j==0) {
				PlayerProfile[] list3 = new PlayerProfile[j];
				return list3;
			}
		}
		return list2;
	}
	
	public PlayerProfile[] getAll() {
		return list;
	}
	
	public int getPlayerCount() {
		return playerCount;
	}
	
	public int getMaxPlayerCount() {
		return listSize;
	}
	
	public PlayerProfile removePlayer(int id) {
		int i=0;
		int k=0;
		PlayerProfile list2;
		PlayerProfile[] list3;
		list3 = new PlayerProfile[listSize-1];
		if ((id<0) || (id>listSize) || (list[id]==null)) return null; 
    	list2=list[id];
    	list[id]=null;
    	playerCount--;
    	for (i=0; i<listSize; i++) {
    		if (list[i]!=null) {
    			list3[k]=list[i];
    			k++;
    		}
    	}
    list=list3;
    /*
	if ((id<0) || (id>listSize) || (list[id]==null)) return null; 
	list2=list[id];
	list[id]=null;
	playerCount--;
	for (i=id; i<(list.length-1); i++) {
		list[i]=list[i+1];
		k++;
	}
	list[id+k]=null;
    listSize--;
    */
	return list2;
	}
}
