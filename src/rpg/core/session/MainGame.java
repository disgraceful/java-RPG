package rpg.core.session;

import rpg.core.characters.heroes.HeroClass;
import rpg.core.characters.heroes.classes.Centurion;
import rpg.core.characters.heroes.classes.Priest;
import rpg.core.characters.shared.Party;
import rpg.core.dungeon.DungeonBuilder;
import rpg.core.dungeon.DungeonSize;
import rpg.core.dungeon.DungeonSizeEnum;
import rpg.core.dungeon.Ruins;
import rpg.core.factories.CharacterFactory;

public class MainGame {

	private static GameSession gameSession;
	private static DungeonSession currentDungeonSession;

	public static void main(String[] args) {

	}

	public void startGame() {
		gameSession = GameSession.getSessionInstance();
		Centurion centurion = (Centurion) CharacterFactory.spawnCharByType(HeroClass.CENTURION);
		Priest priest = (Priest) CharacterFactory.spawnCharByType(HeroClass.PRIEST);
		gameSession.hireHero(centurion);
		gameSession.hireHero(priest);
		Party party = new Party();
		party.addMember(centurion);
		party.addMember(priest);

		Ruins ruins = new Ruins(new DungeonSize(DungeonSizeEnum.SMALL, 1, 2, 2, 1));
		DungeonBuilder.build(ruins);
		currentDungeonSession = DungeonSession.getSession();
		currentDungeonSession.initiateSession(ruins, party);
		currentDungeonSession.startDungeon();

	}
}
