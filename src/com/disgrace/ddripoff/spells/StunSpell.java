package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;

public abstract class StunSpell extends TemporarySpell {

	@Override
	public void useSpell(Character[] targets, Character caller) {
		super.useSpell(targets, caller);
		for(Character t: targets){
			t.getStats().updateStats(affectedStats);
		}
	}
	
	@Override
	public void onTick(Character target) {
		if (currentDuration > 0) {
			currentDuration--;
			return;
		}
		onExpire(target);
	}

	
}
