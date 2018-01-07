package rpg.core.game;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import rpg.core.characters.enemies.Enemy;
import rpg.core.characters.shared.Character;
import rpg.core.spells.TemporaryEffect;

public class GameTurn {
	private GameTurn() {
	}

	public static void turn(List<Character> turnSequence) {
		Collections.sort(turnSequence);
		for (Character character : turnSequence) {
			for (Iterator<TemporaryEffect> iterator = character.getTempEffects().iterator(); iterator.hasNext();) {
				TemporaryEffect tempS = iterator.next();
				if (tempS.isExpired()) {
					tempS.onExpire(character);
					iterator.remove();
				} else {
					tempS.onTick(character);
				}
			}
			if (character.isCharStunned()) {
				continue;
			}
			PlayerDecision decision;
			if (character instanceof Enemy) {
				Enemy enemy = (Enemy) character;
				decision = enemy.getDecision(turnSequence);
			} else {
				System.out.println("display all decisions");
				decision = new Pass(character);
			}
			decision.performDecision();
		}
	}
}
