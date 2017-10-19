package rpg.core.spells;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.StatWrapper;

public class Mark extends TemporaryEffect{
	
	public Mark(int duration, StatWrapper stats, TemporaryEffectType type) {
		super(duration, stats,TemporaryEffectType.MARK);
		
	}

	@Override
	public void onExpire(Character target) {
		
		
	}

	@Override
	public void onTick(Character target) {
		if (currentDuration > 0) {
			currentDuration--;
		}
	}

	@Override
	public void applyEffect(Character caller, Character target) {
		if (isEffectApplying(caller, target)) {
			target.addEffect(this);
			System.out.println(this.effectType.toString() + " was applied on " + target.toString() + " for "
					+ currentDuration + " turns");
		} else {
			System.out.println(target.toString() + " resists!");
		}
		
	}

}
