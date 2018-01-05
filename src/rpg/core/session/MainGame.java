package rpg.core.session;

import rpg.core.characters.heroes.HeroClass;
import rpg.core.characters.heroes.classes.Centurion;
import rpg.core.characters.heroes.classes.Priest;
import rpg.core.characters.shared.Party;
import rpg.core.dungeon.DungeonBuilder;
import rpg.core.dungeon.DungeonSize;
import rpg.core.dungeon.DungeonSizeEnum;
import rpg.core.dungeon.Ruins;
import rpg.core.dungeon.TutorialDungeon;
import rpg.core.factories.CharacterFactory;

public class MainGame {

	private static GameSession gameSession;
	private static DungeonSession currentDungeonSession;

	public static void main(String[] args) {
		startGame();
	}

	public static void startGame() {
		gameSession = GameSession.getSessionInstance();
		Centurion centurion = (Centurion) CharacterFactory.spawnCharByType(HeroClass.CENTURION);
		Priest priest = (Priest) CharacterFactory.spawnCharByType(HeroClass.PRIEST);
		gameSession.hireHero(centurion);
		gameSession.hireHero(priest);
		Party party = new Party();
		party.addMember(centurion);
		party.addMember(priest);

		TutorialDungeon tutorial = new TutorialDungeon();
		DungeonBuilder.build(tutorial);
		currentDungeonSession = DungeonSession.getSession();
		currentDungeonSession.initiateSession(tutorial, party);
		currentDungeonSession.startDungeon();

	}
}
