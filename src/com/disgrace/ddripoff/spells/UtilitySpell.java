package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;

public abstract class UtilitySpell extends Spell {

	@Override
	public void initSpell() {
		spellType = SpellType.UTILITY;
	}

	@Override
	public void useSpell(Character caller, Character target) {
		for (Effect e : applyingEffects) {
			if (spellTargetAmount == SpellTargetQuantity.ALL) {
				for (Integer in : targetRequiredPos.getRequiredPosition()) {
					e.applyEffect(target.getParty().getMembers().get(in));
				}
			}
		}

	}

}
