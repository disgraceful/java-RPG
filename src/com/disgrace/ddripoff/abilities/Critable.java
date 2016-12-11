package com.disgrace.ddripoff.abilities;

import com.disgrace.ddripoff.characters.shared.Character;

public interface Critable {
	boolean criticalStrike(Character target, Character caller);
}
