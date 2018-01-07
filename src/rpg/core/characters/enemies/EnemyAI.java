package rpg.core.characters.enemies;

import java.util.List;

import rpg.core.characters.shared.Character;
import rpg.core.game.PlayerDecision;

public interface EnemyAI {
	
	PlayerDecision getDecision(List<Character> target);
	
}
