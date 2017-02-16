package com.disgrace.ddripoff.characters.shared;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.characters.enemies.Enemy;
import com.disgrace.ddripoff.characters.enemies.EnemyClass;
import com.disgrace.ddripoff.spawn.EnemySpawnType;
import com.disgrace.ddripoff.spawn.PartySpawnPatternEnueration;
import com.disgrace.ddripoff.spawn.PartySpawnPattern;

public class Party {

	private List<Character> partyMembers = new ArrayList<Character>();

	public Party(List<Character> members) {
		partyMembers = members;
	}

	public Party() {
	}

	public List<Character> getMembers() {
		return partyMembers;
	}

	public void addMember(Character c) {
		partyMembers.add(c);
		c.setParty(this);
	}

	public void addMember(Character c, int position) {
		partyMembers.add(position, c);
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
			if (partyMembers.size() >= 1 && newposition <= partyMembers.size()) {
				partyMembers.remove(partyMembers.get(partyMembers.indexOf(c)));
				addMember(c, newposition);
			} else {
				addMember(c);
			}
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
	
	public boolean isPartyEmpty(){
		return partyMembers.size()<=0?true:false;
	}
	
	public void removeMember(Character c){
		partyMembers.remove(c);
	}

	@Override
	public String toString() {
		return "Party members: " + partyMembers;
	}

	public static Party spawnRandomParty() {
		Party spawningParty = new Party();
		for (EnemySpawnType type : PartySpawnPatternEnueration.getRandomPattern().getSpawnTypes()) {
			for (EnemyClass eClass : EnemyClass.getClassBySpawnType(type)) {
				spawningParty.addMember(Enemy.spawn(eClass));
			}
		}
		return spawningParty;
	}
}
