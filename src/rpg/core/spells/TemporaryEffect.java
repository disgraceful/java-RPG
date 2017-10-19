package rpg.core.spells;

import java.util.Random;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.StatWrapper;


public abstract class TemporaryEffect extends Effect {
	protected int abilityDuration;
	protected int currentDuration;
	protected TemporaryEffectType effectType;

	
	public TemporaryEffect(){
		
	}
	
	public TemporaryEffect(int duration, StatWrapper stats,TemporaryEffectType type){
		abilityDuration = duration;
		currentDuration = abilityDuration;
		effectType = type;
		effectStats = stats;
	}
	
	public int getCurrentDuration() {
		return currentDuration;
	}

	public void setCurrentDuration(int currentDuration) {
		if (currentDuration < 0) {
			return;
		}
		this.currentDuration = currentDuration;
	}

	public int getEffectDuration() {
		return abilityDuration;
	}

	public void setEffectDuration(int duration) {
		abilityDuration = duration;
	}

	public TemporaryEffectType getEffectType() {
		return effectType;
	}

	protected boolean isEffectApplying(Character caller, Character target) {
		int targetResist = target.getStats().getProperResistValue(effectType);
		int callerDotChanceMultiplier = caller.getStats().getProperMultiplierValue(effectType);
		int abilityChance = effectStats.getProperMultiplierValue(effectType);
		int total = abilityChance + callerDotChanceMultiplier - targetResist;
		if(total>90){
			total=90;
		}
		int chance = new Random().nextInt(101);
		System.out.println(target.toString() + " resist: " + targetResist + " " + caller.toString() + " callerMod "
				+ callerDotChanceMultiplier + " abilityChance " + abilityChance + " Chance: " + chance);
		return chance < total;
	}

	public boolean isExpired() {
		return currentDuration <= 0 ? true : false;
	}

	public abstract void onExpire(Character target);

	public abstract void onTick(Character target);

}
