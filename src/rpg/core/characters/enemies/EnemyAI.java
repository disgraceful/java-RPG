package rpg.core.characters.enemies;

import java.util.List;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Party;
import rpg.core.spells.Spell;
import rpg.core.utils.CalcHelper;

public class EnemyAI {
	private List<Spell> spells;
	private Character caller;

	public EnemyAI(List<Spell> spells) {
		this.spells = spells;
	}

	public Spell chooseSpellToUse(Party target) {
		for (Spell spell : spells) {
			if (!spell.getAvaliableTargets(caller, target.getMembers()).isEmpty()) {
				return spell;
			}
		}
		return null;// pass the turn
	}

	public Character getTargetForSpell(Spell spell, Party target) {
		if (!spells.contains(spell)) {
			return null;
		}
		List<Character> targets = spell.getAvaliableTargets(caller, target.getMembers());
		return targets.get(CalcHelper.randInt(targets.size()));
	}

}
