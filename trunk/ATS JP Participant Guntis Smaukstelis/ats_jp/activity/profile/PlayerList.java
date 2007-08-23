package ats_jp.activity.profile;

public class PlayerList{
	private int size, count;
	private PlayerProfile[] playerProfile;
	
	public PlayerList(int size){
		this.size = size;		
		count = 0;
		playerProfile = new PlayerProfile[size];
	}

	public boolean addPlayer(PlayerProfile newProfile){
		if(newProfile == null)
			throw new IllegalArgumentException("illegal.argument.exception");
		if(count < size && findPlayer(newProfile)==null){
			playerProfile[count++] = newProfile;
			return true;
		}
		else 
			return false;
	}

	public PlayerProfile findPlayer(int id){
		if(id < 0 || id > count-1 || playerProfile[id] == null) return null;
		return playerProfile[id];
	}

	public PlayerProfile findPlayer(PlayerProfile name){
		if(name == null)
			throw new IllegalArgumentException("illegal.argument.exception");
		for(int i=0; i<count; i++){
			if(playerProfile[i].equals(name)) 
				return playerProfile[i];
		}
		return null;
	}
	
	public PlayerProfile[] findPlayer(String name){
		PlayerProfile matches[];
		matches = new PlayerProfile[size];
		int j=0;
		for(int i=0; i<count; i++){
			if(playerProfile[i].getName() == name)
				matches[j++] = playerProfile[i];
		}		
		PlayerProfile[] matches2 = new PlayerProfile[j];
		for(int i=0; i<j; i++){
			matches2[i] = matches[i];			
		}
		return matches2;		
	}
	
	public PlayerProfile[] getAll(){
		PlayerProfile[] all = new PlayerProfile[count];
		for(int i=0; i<count; i++){
			all[i] = playerProfile[i];
		}
		return all;
	}
	
	public int getPlayerCount() {
		return count;
	}
	
	public int getMaxPlayerCount(){
		return size;
	}
	
	public PlayerProfile removePlayer(int id) {
		if(id<0 || id>count-1) return null;
		PlayerProfile[] deletedObject = new PlayerProfile[1];
		deletedObject[0] = playerProfile[id];
		playerProfile[id] = null;
		for(int i=id; i<count; i++){
			if(i == count-1) 
				playerProfile[i] = null;
			else
				playerProfile[i] = playerProfile[i+1];
		}
		count--;
		return deletedObject[0];		
	}
}
