package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;

public class GenericUtility extends UtilitySpell {

	@Override
	public void initSpell() {
		super.initSpell();
		spellTargetAmount=SpellTargetQuantity.SINGLE;
	}


}
