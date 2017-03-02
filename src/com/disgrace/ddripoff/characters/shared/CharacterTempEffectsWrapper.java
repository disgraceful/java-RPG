package com.disgrace.ddripoff.characters.shared;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.spells.DOT;
import com.disgrace.ddripoff.spells.TemporaryEffect;
import com.disgrace.ddripoff.spells.TemporaryEffectType;

public class CharacterTempEffectsWrapper {
	protected List<TemporaryEffect> tempEffects = new ArrayList<>();

	public List<TemporaryEffect> getTempEffects() {
		return tempEffects;
	}

	public void setTempEffects(List<TemporaryEffect> tempEffects) {
		this.tempEffects = tempEffects;
	}

	public void addEffect(TemporaryEffect effect) {
		if (effect == null) {
			return;
		}
		if (effect instanceof DOT&&isEffectAppliedByType(effect.getEffectType())) {
			DOT oldDOT = (DOT) getEffectByType(effect.getEffectType());
			DOT currentDOT = (DOT) effect;
			int oldDOTTickDamage = oldDOT.getCurrentTick().getCurValue();
			int oldDOTDuration = oldDOT.getCurrentDuration();
			System.out.println("Old DOT : current DURATION: " + oldDOTDuration );
			System.out.println("Current DOT current DURATION: "+currentDOT.getCurrentDuration());
			oldDOT.setCurrentDuration(currentDOT.getCurrentDuration() + oldDOTDuration);
			oldDOT.setCurrentTick(currentDOT.getCurrentTick().getCurValue() + oldDOTTickDamage);
			System.out.println(oldDOT.toString() + " was stacked up with " + currentDOT.toString() + " for " + oldDOT.getCurrentDuration());
		}else{
			tempEffects.add(effect);
		}
	}

	private boolean isEffectApplied(TemporaryEffect effect) {
		return tempEffects.stream().anyMatch(e -> e.getEffectType().equals(effect.getEffectType()));
	}

	private boolean isEffectAppliedByType(TemporaryEffectType type) {
		return tempEffects.stream().anyMatch(e -> e.getEffectType().equals(type));
	}

	public boolean isStunned() {
		return isEffectAppliedByType(TemporaryEffectType.STUN);
	}

	public TemporaryEffect getEffectByType(TemporaryEffectType type) {
		return isEffectAppliedByType(type)
				? tempEffects.stream().filter(e -> e.getEffectType() == type).findFirst().get() : null;
	}
}
