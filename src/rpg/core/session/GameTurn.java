package rpg.core.session;

import java.util.Collections;
import java.util.List;

import rpg.core.characters.enemies.Enemy;
import rpg.core.characters.shared.Character;

public class GameTurn {
	private List<Character> turnSequence;
	
	public GameTurn(List<Character> characters) {
		Collections.sort(characters);
		turnSequence = characters;
	}
	
	public void turn() {
		for(Character character:turnSequence) {
			if(character instanceof Enemy) {
				
			}
		}
	}
}
