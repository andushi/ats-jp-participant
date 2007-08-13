package ats_jp.activity.profile;

public class PlayerList {
	private int size, pcount;
	private PlayerProfile[] playerprofiles;
	
	public PlayerList(int size){
		this.size = size;
		pcount = 0;
		playerprofiles = new PlayerProfile[size];
	}

	public boolean addPlayer(PlayerProfile pp){
		if (pp == null)
			throw new IllegalArgumentException();
		if (pcount == size || findPlayer(pp) !=null){
			return false;
		}
		playerprofiles[pcount++] = pp;
		return true;
	}

	public PlayerProfile findPlayer(int id){
		int i;
		for (i=0; i < pcount; ++i){
			if (playerprofiles[i].getID()== id) {
				return playerprofiles[i];
			}
		}
		return null;
	}

	public PlayerProfile findPlayer(PlayerProfile pp){
		int i;
		for (i = 0; i < pcount; ++i){
			if (playerprofiles[i].equals(pp)){
				return playerprofiles[i];
				}
			}
			return null;
	}

	public PlayerProfile[] findPlayer(String name){
		int i, j = 0, garums = 0;
		PlayerProfile[] ppsize = new PlayerProfile[size];
		
		for (i = 0; i < pcount; ++i){
			if (playerprofiles[i].getName()==name){
				ppsize[j++] = playerprofiles[i];
					garums++;
			}
		}
		
		PlayerProfile[] ppsize2 = new PlayerProfile[garums];
			for (i=0; i< garums; ++i)
				ppsize2[i]=ppsize[i];
				return ppsize2;
	}

	public PlayerProfile[] getAll(){
		PlayerProfile[] ppsize = new PlayerProfile[pcount];
		for (int i = 0; i < pcount; ++i)
			ppsize[i] = playerprofiles[i];
		return ppsize;
	}

	public int getPlayerCount(){
		return pcount;
	}

	public int getMaxPlayerCount(){
		return size;
	}
	
	public PlayerProfile removePlayer(int id) {
		int i, index = -1;
		PlayerProfile pp;
		for(i = 0; i < pcount; ++i) {
			if(playerprofiles[i].getID() == id) {
				index = i;
			}
		}
		
		if(index < 0) 
			return null;
		
		pp = playerprofiles[index];
		
		for(i = index; i < pcount - 1;  ++i) {
			playerprofiles[i] = playerprofiles[i + 1];
		}

		pcount--;
		
		return pp;
	}
}
