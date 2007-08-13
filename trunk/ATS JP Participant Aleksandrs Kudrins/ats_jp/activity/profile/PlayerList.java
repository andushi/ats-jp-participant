package ats_jp.activity.profile;

public class PlayerList {
	int index;
	PlayerProfile[] list;
	PlayerList(int Size){
		 PlayerProfile[] list;
		 list = new PlayerProfile[Size];
	}

	public boolean add(PlayerProfile Profile){
		if (Profile==null)
			throw new IllegalArgumentException("arraystack.method.argument.invalid");
	if (list.length==index) return false;
	int i; boolean bresult;
	for (i=0;i<list.length;i++)
	{
		bresult= list.equals(Profile);
		if (bresult==true) return false;
	}
	list[index]=Profile;
	index++;
	return true;
	}
	
	public PlayerProfile findPlayer(int k){
		PlayerProfile profile;
		if (list[k]==null) return null;
		profile=list[k];
		return profile;
	//	else return null;
		
		
	}
	public PlayerProfile[] findPlayer(String name){
		PlayerProfile[] profile;
		profile = new PlayerProfile[list.length];
		int k,l=0; boolean bResult;
		for (k=0;k<list.length;k++){
			bResult = list.equals(name);
			if (bResult==true) {
				profile[l]=list[k];
				l++;
			}
		}
		return profile;
	}
	public PlayerProfile[] getAll(){
		return list;
	}
	public int getPlayerCount(){
		return index;
	}
	public int getMaxPlayerCount(){
	
		return list.length;
	}
	public PlayerProfile removePlayer(int id){
		PlayerProfile[] profile;
		PlayerProfile profile2;
		int i,l=0;
		profile = new PlayerProfile[list.length];
		if (list[id]==null) return null;
		index--;
		profile2=list[id];
		for (i=0;i<index;i++){
			if (list[i]!=null){
				profile[l]=list[i];
				l++;
			}
		}
		list=profile;
		return profile2;
	}
}
