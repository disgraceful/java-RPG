package rpg.core.spells;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;

public class DOT extends TemporaryEffect {
	protected Stat tickDamage;
	protected Stat currentTick;

	public DOT() {

	}

	public DOT(int duration, StatWrapper stats, TemporaryEffectType type) {
		super(duration, stats,type);
		tickDamage = effectStats.getStatbyName(StatEnum.HEALTH);
		currentTick = tickDamage;
	}

	public Stat getCurrentTick() {
		return currentTick;
	}

	public void setCurrentTick(int currentTickDamage) {
		this.currentTick.setValue(currentTickDamage);
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

	@Override
	public void onTick(Character target) {
		if (currentDuration > 0) {
			currentDuration--;
			target.updateStats(currentTick);
			System.out.println(target.getName() + " suffers for " + currentTick.getCurValue());
		}
	}

	@Override
	public void onExpire(Character target) {
		System.out.println(this.toString() + " has expired");
	}
}
