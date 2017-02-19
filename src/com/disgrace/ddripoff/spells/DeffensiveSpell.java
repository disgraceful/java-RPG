package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;

public abstract class DeffensiveSpell extends Spell {

	@Override
	public void useSpell(Character caller, Character target) {
		
	}

	@Override
	public void initSpell() {
		spellType = SpellType.DEFFENSIVE;
		
	}

}
