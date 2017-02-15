package com.disgrace.ddripoff.characters.shared;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.spells.TemporaryEffectType;
import com.disgrace.ddripoff.spells.TemporarySpell;

public class CharacterTempEffectsWrapper {
	protected List<TemporarySpell> tempEffects = new ArrayList<>();

	public List<TemporarySpell> getTempEffects() {
		return tempEffects;
	}

	public void setTempEffects(List<TemporarySpell> tempEffects) {
		this.tempEffects = tempEffects;
	}

	public void addEffect(TemporarySpell effect) {
		if (effect == null) {
			return;
		}
		tempEffects.add(effect);
	}

	private boolean isEffectApplied(TemporarySpell effect) {
		return tempEffects.stream().anyMatch(e -> e.getEffectType().equals(effect.getEffectType()));
	}

	private boolean isEffectAppliedByType(TemporaryEffectType type) {
		return tempEffects.stream().anyMatch(e -> e.getEffectType().equals(type));
	}

	public boolean isStunned() {
		return isEffectAppliedByType(TemporaryEffectType.STUN);
	}
}
