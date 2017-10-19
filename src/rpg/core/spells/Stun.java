package rpg.core.spells;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.StatWrapper;


public class Stun extends TemporaryEffect {

	public Stun() {
	}

	public Stun(StatWrapper stats) {
		super(1, stats, TemporaryEffectType.STUN);
	}

	@Override
	public void applyEffect(Character caller, Character target) {
		if (isEffectApplying(caller, target)) {
			target.addEffect(this);
			System.out.println(this.effectType.toString() + " was applied on " + target.toString() + " for "
					+ abilityDuration + " turns");
		} else {
			System.out.println(target.toString() + " resists!");
		}
	}

	@Override
	public void onTick(Character target) {
		if (currentDuration > 0) {
			currentDuration--;
		}
	}

	@Override
	public void onExpire(Character target) {
		//TODO new StunLockPerventingBuff().applyEffect(target, target); 
		System.out.println(this.toString() + " has expired");
	}
}
