package ats_jp.activity.profile;

public class PlayerList {
	// protected Object store[];
	public int maxPlayer = 0;
	public int playerCount = 0;
	protected	PlayerProfile[] list;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public  PlayerList(int size) {
	// super(size);
	
		this.list = new PlayerProfile[size];
		maxPlayer = size;
		playerCount = 0;
	
	// return size;
	}
	public boolean addPlayer(PlayerProfile PlayerProfile) 
	{		
		if (PlayerProfile == null) {
			throw new IllegalArgumentException(
					"profile.method.argument.invalid");
		}
		if (isFull()) {
			return false;
		}
		for (int i = 0; i < getPlayerCount(); i++)

			if (list[i].equals(PlayerProfile)) {
				return false;
			}
		list[playerCount] = PlayerProfile;
		playerCount++;
		return true;
		
	}
	public PlayerProfile findPlayer(int profileID)
	{
		for (int i = 0; i < getPlayerCount(); i++)

			if (list[i].getID() == profileID) {
				return list[i];
			}
		return null;
	}	

	
	public PlayerProfile findPlayer(PlayerProfile playerProfile) 
	{
		if (playerProfile==null) {
			throw new IllegalArgumentException(
			"profile.method.argument.invalid");
		}
		for (int i = 0; i < getPlayerCount(); i++)
		{ 
			if (list[i].equals(playerProfile))
				{
						return list[i];					
				}
			
		}
		return null;
	}
	
	public PlayerProfile[] findPlayer(String player)
	{   PlayerProfile[] list1;
		int k=0;
		if (player==null) {
			throw new IllegalArgumentException(
			"profile.method.argument.invalid");
		}
		for (int i = 0; i < getPlayerCount(); i++)
		{
			if (list[i].getName().equals(player))
			{
				k=k+1;
			}
			
		}
		list1=new PlayerProfile[k];
		k=0;
		for (int i = 0; i < getPlayerCount(); i++)
		{
			if (list[i].getName().equals(player))
			{
				list1[k]=list[i];				
				k=k+1;
			}
	
			return list1;
		}
		return null;
	}
	public PlayerProfile[] getAll()
	{ 
			return list;
		
	}

	public int getPlayerCount() {
		return playerCount;
	}
	public int getMaxPlayerCount()
	{
	 return maxPlayer;
	 
	}
	public PlayerProfile removePlayer(int ID)
	{	
		PlayerProfile[] list1;
		PlayerProfile[] list2;
		for (int i = 0; i < getPlayerCount(); i++)
		{
		if (list[i]== null) {
		continue;	
		}
 			if (list[i].getID()==ID){
 				PlayerProfile k; 	
 								
				k=list[i];
				list[i]=null;
				for (int j = i; i < getPlayerCount()-1; i++)
				{
					list[i]=list[i+1];
				}
				playerCount--;
				list2=new PlayerProfile[getPlayerCount()];
				for (int i1 = 0; i1 < getPlayerCount(); i1++)
				{ 
					list2[i1] = list[i1];
				}
				list = list2;
				return k;
//				System.arraycopy(store, 0, newStore, 0, marker);
//				System.arraycopy(store, marker + 1, newStore, marker, store.length - (marker + 1));
 			}				
		}	
		
		return null;
	}
	public boolean isFull() {
		return (playerCount == maxPlayer ? true : false);
	}


	public int getMaxPlayer() {
		return maxPlayer;
	}

}
