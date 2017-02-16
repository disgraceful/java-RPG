package com.disgrace.ddripoff.spawn;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.spawn.PartySpawnPatternEnumeration.PartyType;

public class PartySpawnPattern {
	private List<EnemySpawnType> spawnTypes = new ArrayList<>();
	private PartyType partyStrength;

	public PartySpawnPattern(List<EnemySpawnType> spawns, PartyType strength) {
		spawnTypes = spawns;
		partyStrength = strength;
	}
	
	public List<EnemySpawnType> getSpawnTypes() {
		return spawnTypes;
	}

	public void setSpawnTypes(List<EnemySpawnType> spawnTypes) {
		if (spawnTypes == null) {
			return;
		}
		this.spawnTypes = spawnTypes;
	}

	public PartyType getPartyStrength() {
		return partyStrength;
	}

	public void setPartyStrength(PartyType partyStrength) {
		if (partyStrength != null)
			this.partyStrength = partyStrength;
	}


}