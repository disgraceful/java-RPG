package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;

public abstract class UtilitySpell extends Spell {

	@Override
	public void useSpell(Character caller, Character... targets) {
		for(Character target:targets){
			applyingEffects.stream().forEach(e->e.applyEffect(target));
			selfApplyingEffects.stream().forEach(e->e.applyEffect(caller));
		}
	}
}
