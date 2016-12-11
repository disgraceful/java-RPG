package com.disgrace.ddripoff.characters.shared;

import java.util.ArrayList;

import com.disgrace.ddripoff.enemies.EnemyClass;
import com.disgrace.ddripoff.spawn.EnemySpawnFactory;
import com.disgrace.ddripoff.spawn.EnemySpawnType;
import com.disgrace.ddripoff.spawn.SpawnPattern;
import com.disgrace.ddripoff.spawn.SpawnableEnemy;
import com.disgrace.ddripoff.spawn.SpawnableParty;

public class Party implements SpawnableParty {

	private ArrayList<Character> partyMembers = new ArrayList<Character>();

	public Party(ArrayList<Character> members) {
		partyMembers = members;
	}

	public Party() {
	}

	public ArrayList<Character> getMembers() {
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

	@Override
	public String toString() {
		return "Party members: " + partyMembers;
	}
	

	@Override
	public SpawnableParty spawnParty(SpawnPattern pattern) {
		Party spawningParty = new Party();
		for(EnemySpawnType type : pattern.getSpawnTypes()){
			for(EnemyClass eClass: EnemyClass.getClassBySpawnType(type)){
				spawningParty.addMember(EnemySpawnFactory.getEnemy(eClass));
			}
		}
		return spawningParty;
	}
}
