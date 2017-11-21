package rpg.core.factories;

import rpg.core.characters.enemies.EnemyClass;
import rpg.core.characters.heroes.Hero;
import rpg.core.characters.heroes.HeroClass;
import rpg.core.characters.shared.CharClass;
import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Party;
import rpg.core.loader.GameLoader;
import rpg.core.spawn.PartySpawnPattern;
import rpg.core.spawn.PartySpawnPatternEnumeration;

public class CharacterFactory {

	private CharacterFactory() {
	}

	public static Party spawnPartyByPattern(PartySpawnPattern pattern) {
		Party p = new Party();
		pattern.getSpawnTypes().forEach(
				e -> p.addMember(GameLoader.getInstance().getDataByClass(EnemyClass.getRandomEnemyBySpawnType(e))));
		return p;
	}

	public static Party spawnRandomParty() {
		return spawnPartyByPattern(PartySpawnPatternEnumeration.getRandomPattern());
	}
	

	public static Hero spawnRandomHero() {
		return (Hero) GameLoader.getInstance().getDataByClass(HeroClass.getRandomValue().getClassToSpawn());
	}

	public static Character spawnCharByType(CharClass cClass) {
		return (Character) GameLoader.getInstance().getDataByClass(cClass.getClassToSpawn());
	}
}
