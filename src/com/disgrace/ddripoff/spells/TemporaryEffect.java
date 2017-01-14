package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;

public interface TemporaryEffect{

	public void onTick(Character target);
	public void onExpire(Character target);
}
