package com.disgrace.ddripoff.characters.shared;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.characters.enemies.Enemy;
import com.disgrace.ddripoff.characters.enemies.EnemyClass;
import com.disgrace.ddripoff.spawn.EnemySpawnType;
import com.disgrace.ddripoff.spawn.PartySpawnPatternEnumeration;
import com.disgrace.ddripoff.spawn.PartySpawnPattern;

public class Party {

	private List<Character> partyMembers = new ArrayList<>();

	public Party(List<Character> members) {
		partyMembers = members;
	}

	public Party() {}

	public List<Character> getMembers() {
		return partyMembers;
	}

	public void addMember(Character c) {
		if (isPartyFull()) {
			System.err.println("Only 4 members in party");
			return;
		}
		partyMembers.add(c);
		c.setParty(this);
	}

	public void addMember(Character c, int position) {
		if (isPartyFull()) {
			System.err.println("Only 4 members in party");
			return;
		}
		if (position > 3) {
			addMember(c, 3);
		} else if (position < 0) {
			addMember(c, 0);
		} else {
			partyMembers.add(position, c);
		}
		c.setParty(this);
	}

	private boolean ifCharExists(Character c) {
		return partyMembers.contains(c);
	}

	public int getPosition(Character c) {
		return partyMembers.indexOf(c);
	}

	public void reposition(Character c, int newposition) {
		if (ifCharExists(c)) {
			removeMember(c);
			addMember(c, newposition);
		}
	}

	public boolean isPartyDead() {
		for (Character character : partyMembers) {
			if (!character.isCharDead()) {
				return false;
			}
		}
		return true;
	}

	public boolean isPartyEmpty() {
		return partyMembers.isEmpty() ? true : false;
	}

	public void removeMember(Character c) {
		partyMembers.remove(c);
	}

	private boolean isPartyFull() {
		return partyMembers.size() >= 4 ? true : false;
	}

	@Override
	public String toString() {
		return "Party members: " + partyMembers;
	}

	public static Party spawnRandomParty() {
		Party spawningParty = new Party();
		// for (EnemySpawnType type :
		// PartySpawnPatternEnumeration.getRandomPattern().getSpawnTypes()) {
		// for (EnemyClass eClass : EnemyClass.getClassBySpawnType(type)) {
		// spawningParty.addMember(Enemy.spawn(eClass));
		// }
		// }
		return spawningParty;
	}
}
