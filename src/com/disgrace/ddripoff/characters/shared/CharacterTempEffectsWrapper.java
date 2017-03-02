package com.disgrace.ddripoff.characters.shared;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.spells.Effect;
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
		if(isEffectApplied(effect)){
			switch(effect.getEffectType()){
			case BLEED:
			case BLIGHT:
				TemporaryEffect currentEffect = getEffectByType(effect.getEffectType());
				//add tickDamage and currentDuration to the current Dot;
				break;
			}
		}
		else{
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
	
	public TemporaryEffect getEffectByType(TemporaryEffectType type){
		return isEffectAppliedByType(type)?tempEffects.stream().filter(e->e.getEffectType()==type).findFirst().get():null;
	}
}
