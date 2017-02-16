package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;

public abstract class BuffSpell extends TemporarySpell{

	@Override
	public void onTick(Character target) {
		if (currentDuration > 0) {
			currentDuration--;
			return;
		}
		onExpire(target);
	}
}
