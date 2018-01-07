package rpg.core.game;

import java.util.List;

import rpg.core.spells.Spell;
import rpg.core.characters.shared.Character;

public class UseSpell implements PlayerDecision{

	private Character caller;
	private Spell spell;
	private List<Character> targets;

	public UseSpell(Character caller, Spell spell, List<Character> targets) {
		this.caller = caller;
		this.spell = spell;
		this.targets = targets;
	}
	
	@Override
	public void performDecision() {
		spell.useSpell(caller, targets.toArray(new Character[0]));
		
	}
	
}
