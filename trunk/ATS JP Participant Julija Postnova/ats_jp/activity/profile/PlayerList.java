package ats_jp.activity.profile;

import ats_jp.activity.cardgame.Card;
import ats_jp.activity.profile.PlayerProfile;

public class PlayerList {

	PlayerProfile list[];
	int maxSize;
	int currentSize;

	public PlayerList(int size) {
		list = new PlayerProfile[size];
		maxSize = size;
	}

	public boolean addPlayer(PlayerProfile pro) {
		if (pro == null)
			throw new IllegalArgumentException("illegal");
		if (currentSize == maxSize)
			return false;
		for (int i = 0; i < currentSize; i++) {
			if (list[i].equals(pro)) {
				return false;

			}

		}
		list[currentSize] = pro;
		currentSize++;
		return true;

	}

	public PlayerProfile findPlayer(int ID) {

		for (int i = 0; i < currentSize; i++) {
			if (list[i].getID() == ID)
				return list[ID];
		}
		return null;

	}

	public PlayerProfile findPlayer(PlayerProfile pro) {
		for (int i = 0; i < currentSize; i++) {
			if (list[i].equals(pro))
				return pro;
		}
		return null;
	}

	public PlayerProfile[] findPlayer(String pro) {
		PlayerProfile list2[];
		list2 = new PlayerProfile[list.length];
		int currentSize2 = 0;
		for (int i = 0; i < currentSize; i++) {
			if (list[i].getName() == pro) {
				list2[currentSize2] = list[i];
				currentSize2++;
			}
		}
		PlayerProfile list3[] = new PlayerProfile[currentSize2];
		for (int j = 0; j < currentSize2; j++) {
			list3[j] = list2[j];
		}

		return list3;

	}

	public PlayerProfile[] getAll() {
		PlayerProfile list2[];
		list2 = new PlayerProfile[currentSize];

		for (int i = 0; i < currentSize; i++) {
			list2[i] = list[i];

		}
		return list2;
	}

	public int getPlayerCount() {

		return currentSize;
	}

	public int getMaxPlayerCount() {
		return maxSize;
	}

	public PlayerProfile removePlayer(int id) {
		PlayerProfile list2[] = new PlayerProfile[list.length ];
		int j = 0;
		int index = -1;
		for (int i = 0; i < currentSize; i++) {
			if (list[i].getID() == id) 
				index = i;
			 else 
				list2[j++] = list[i];
			}PlayerProfile pp=null;
		
		if(index!=-1)
	 pp=list[index];
		list = list2;
		if (index == -1)
			return null;
		currentSize--;
		return pp;
	}
}
