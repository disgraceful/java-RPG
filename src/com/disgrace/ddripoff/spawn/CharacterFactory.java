package com.disgrace.ddripoff.spawn;

import com.disgrace.ddripoff.characters.enemies.EnemyClass;
import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.characters.heroes.HeroClass;
import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.characters.shared.SpawnableChar;

public class CharacterFactory {

	private CharacterFactory() {
	}

	public static Party spawnPartyByPattern(PartySpawnPattern pattern) {
		Party p = new Party();
		for (EnemySpawnType type : pattern.getSpawnTypes()) {
				p.addMember(EnemyClass.getRandomEnemyBySpawnType(type));
		}
		return p;
	}

	public static Party spawnRandomParty() {
		return spawnPartyByPattern(PartySpawnPatternEnumeration.getRandomPattern());
	}

	public static Hero spawnRandomHero() {
		return (Hero) Hero.spawn(HeroClass.getRandomValue());
	}

	public static Character spawnConcreteCharacter(SpawnableChar cClass) {
		return Character.spawn(cClass);
	}
}
