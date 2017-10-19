package rpg.core.spells;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.StatWrapper;

public class Disease extends TemporaryEffect {

	public Disease(int duration, StatWrapper stats) {
		super(duration, stats, TemporaryEffectType.DISEASE);
	}

	@Override
	public void applyEffect(Character caller, Character target) {
		if (isEffectApplying(caller, target)) {
			target.addEffect(this);
			target.updateStats(effectStats);
			System.out.println(this.effectType.toString() + " was applied on " + target.toString() + " for "
					+ abilityDuration + " turns");
		} else {
			System.out.println(target.toString() + " resists!");
		}
	}

	@Override
	public void onExpire(Character target) {
		target.updateStats(StatWrapper.reverseStats(effectStats));
	}

	@Override
	public void onTick(Character target) {
		
	}

}
