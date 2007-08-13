package ats_jp.activity.profile;

public class PlayerList {
	int index=0;
	int max;
	PlayerProfile[] list;
	public PlayerList(int Size){
	//	int max;
		this.max=Size;
		list = new PlayerProfile[Size];
	
	}

	public boolean addPlayer(PlayerProfile Profile){
		if (Profile==null)
			throw new IllegalArgumentException("arraystack.method.argument.invalid");
	if (max<=index) return false;
	int i; 
	for (i=0;i<index;i++)
	{
		if(list[i].equals(Profile)) return false;
	}
	list[index]=Profile;
	index++;
	return true;
	}

	
	public PlayerProfile findPlayer(int k){
		if (k>max) return null;
		if (list[k]==null) return null;
		return list[k];
	}

	public PlayerProfile[] findPlayer(String name){
		PlayerProfile[] profile;
	
//		profile = new PlayerProfile[max];
		
		int k,l=0;
		for (k=0;k<index;k++){
			if (list[k].getName().equals(name)){
		//	profile[l]=list[k];
				l++;
			}
		}
				
        	profile = new PlayerProfile[l];
			l=0;
			for (k=0;k<index;k++){
			if (list[k].getName().equals(name)){
					profile[l]=list[k];
						l++;
			}
		}
		
			return profile;
	}
	
	public PlayerProfile findPlayer(PlayerProfile a){
		if(a == null)
            throw new IllegalArgumentException("arraystack.method.argument.invalid");
		
		int i; 
		
		for (i=0;i<index;i++){
			if(list[i].equals(a)) return list[i];
		}
		return null;
	}
	
	public PlayerProfile[] getAll(){
		return list;
	}
	public int getPlayerCount(){
		return index;
	}
	public int getMaxPlayerCount(){
	
		return max;
	}
	public PlayerProfile removePlayer(int id){
		PlayerProfile[] profile;
		PlayerProfile profile2;
		int i,l=0;
		profile = new PlayerProfile[max];
		if (id>max) return null;
		if (list[id]==null) return null;
		
		profile2=list[id];
		list[id]=null;
		index--;
		for (i=0;i<max;i++){
			if (list[i]!=null){
				profile[l]=list[i];
				l++;
			}
		}
		list=profile;
		return profile2;
	}
}
