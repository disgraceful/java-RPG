package com.disgrace.ddripoff.spawn;

import com.disgrace.ddripoff.characters.enemies.Enemy;
import com.disgrace.ddripoff.characters.enemies.EnemyClass;
import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.characters.heroes.HeroClass;
import com.disgrace.ddripoff.characters.shared.CharClass;
import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.main.GameLoader;

public class CharacterFactory {

	private CharacterFactory() {
	}

	public static Party spawnPartyByPattern(PartySpawnPattern pattern) {
		Party p = new Party();
		pattern.getSpawnTypes().stream().forEach(
				e -> p.addMember((Enemy) GameLoader.getDataAsOptional(EnemyClass.getRandomEnemyBySpawnType(e)).get()));
		return p;
	}

	public static Party spawnRandomParty() {
		return spawnPartyByPattern(PartySpawnPatternEnumeration.getRandomPattern());
	}

	public static Hero spawnRandomHero() {
		return (Hero) GameLoader.getDataAsOptional(HeroClass.getRandomValue().getClassToSpawn()).get();
	}

	public static Character spawnCharByType(CharClass cClass) {
		return (Character) GameLoader.getDataAsOptional(cClass.getClassToSpawn()).get();
	}

}
