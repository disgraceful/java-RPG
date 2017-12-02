package rpg.core.factories;

import rpg.core.characters.enemies.EnemyClass;
import rpg.core.characters.heroes.Hero;
import rpg.core.characters.heroes.HeroClass;
import rpg.core.characters.shared.CharClass;
import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Party;
import rpg.core.dungeon.DungeonType;
import rpg.core.loader.GameLoader;
import rpg.core.spawn.PartySpawnPattern;

public class CharacterFactory {

	private CharacterFactory() {
	}

	public static Party spawnParty(PartySpawnPattern pattern, DungeonType restriction) {
		Party p = new Party();
		pattern.getSpawnTypes().forEach(
				e -> p.addMember(GameLoader.getInstance().getDataByClass(EnemyClass.getRandomEnemy(e, restriction))));
		return p;
	}

	public static Hero spawnRandomHero() {
		return (Hero) GameLoader.getInstance().getDataByClass(HeroClass.getRandomValue().getClassToSpawn());
	}

	public static Character spawnCharByType(CharClass cClass) {
		return (Character) GameLoader.getInstance().getDataByClass(cClass.getClassToSpawn());
	}
}
