/*
 * Created on Aug 9, 2007
 * Accenture Riga Delivery Center
 */

package ats_jp.activity.profile;

public class PlayerList {
	private int size, pcount;
	private PlayerProfile[] playerProfiles;
	
	public PlayerList(int size) {
		this.size = size;
		pcount = 0;
		playerProfiles = new PlayerProfile[size];
	}
	
	public boolean addPlayer(PlayerProfile pp) {
		if(pp == null)
			throw new IllegalArgumentException();
		
		if(pcount == size || findPlayer(pp) != null) {
			return false;
		}
		
		playerProfiles[pcount++] = pp;
		
		return true;
	}
	
	public PlayerProfile findPlayer(int id) {
		int i;
		for(i = 0; i < pcount; ++i) {
			if(playerProfiles[i].getID() == id) {
				return playerProfiles[i];
			}
		}
		return null;
	}
	
	public PlayerProfile findPlayer(PlayerProfile pp) {
		int i;
		for(i = 0; i < pcount; ++i) {
			if(playerProfiles[i].equals(pp)) {
				return playerProfiles[i];
			}
		}
		return null;
	}
	
	public PlayerProfile[] findPlayer(String name) {
		int i, j = 0, len = 0;
		PlayerProfile[] pps2 = new PlayerProfile[size];
		
		for(i = 0; i < pcount; ++i) {
			if(playerProfiles[i].getName() == name) {
				pps2[j++] = playerProfiles[i];
				len++;
			}
		}
		
		PlayerProfile[] pps3 = new PlayerProfile[len];
		for(i = 0; i < len; ++i)
			pps3[i] = pps2[i];
		
		return pps3;
	}
	
	public PlayerProfile[] getAll() {

		PlayerProfile[] pps2 = new PlayerProfile[pcount];
		for(int i = 0; i < pcount; ++i)
			pps2[i] = playerProfiles[i];
		return pps2;
	}
	
	public int getPlayerCount() {
		return pcount;
	}

	public int getMaxPlayerCount() {
		return size;
	}

	public PlayerProfile removePlayer(int id) {
		int i, index = -1;
		PlayerProfile pp;
		for(i = 0; i < pcount; ++i) {
			if(playerProfiles[i].getID() == id) {
				index = i;
			}
		}
		
		if(index < 0) 
			return null;
		
		pp = playerProfiles[index];
		
		for(i = index; i < pcount - 1;  ++i) {
			playerProfiles[i] = playerProfiles[i + 1];
		}
		
		
		pcount--;
		
		return pp;
	}
}
