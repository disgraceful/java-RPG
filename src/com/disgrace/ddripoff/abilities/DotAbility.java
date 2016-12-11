package com.disgrace.ddripoff.abilities;

import java.util.List;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class DotAbility extends Ability implements TemporaryEffect {

	private int abilityDuration;
	private final TemporaryEffectType effectType;

	public DotAbility(String name, List<Stat> stat, int duration, TemporaryEffectType effecttype) {
		effectType = effecttype;
		abilityDuration = duration;
	}

	/**
	 * copies object a
	 * 
	 * @param a
	 *            copied object
	 */
	public DotAbility(DotAbility a) {
		this(a.getName(), a.getAffectingStats().getStatsasArrayList(), a.getEffectDuration(), a.getEffectType());
	}

	@Override
	public void useAbility(Character[] targets, Character caller) {
		for (Character t : targets) {
			if (ifDotApplies(t, caller)) {
				// add effect to characters' effect list
				// t.getOwner().getEffectsList().add(new DotAbility(this));
				System.out.println(t.getName() + " has been dotted");
			}
		}
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

	@Override
	public void onTick(Character target) {
		if (abilityDuration >= 0) {
			this.abilityDuration--;
		} else {
			target.getStats().updateStats(affectedStats);
		}
	}

	@Override
	public void onExpire(Character targets) {
		if (effectType == TemporaryEffectType.STUN) {
			// boss stunlock protection
			// BuffAbility stunLockAbuse = new BuffAbility("StunLockAbuseResistance", new ArrayList<Stat>() {
			// {
			// add(new Stat(StatEnumeration.STUNRES, 60, true));
			// }
			// }, 1, TemporaryEffect.Buff);
			// t.getOwner().learnAbility(stunLockAbuse);
			// t.getOwner().useAbility(stunLockAbuse, new StatWrapper[] { t });
		}
		//System.out.println(this.getName() + "has been expired on " + t.getName());
	}


	private boolean ifDotApplies(Character target, Character caller) {
		// int chance = (int)(Math.random()*100);
		int chance = 100;
		switch (effectType) {
		case BLEED:
			return chance > target.getStats().getStatbyName(StatEnumeration.BLEED_RES).getCurValue();
		case BLIGHT:
			return chance > target.getStats().getStatbyName(StatEnumeration.BLIGHT_RES).getCurValue();
		case MIND_LEAK:
			return chance > target.getStats().getStatbyName(StatEnumeration.STRESS_PROT).getCurValue();
		case STUN:
			return chance > target.getStats().getStatbyName(StatEnumeration.STUN_RES).getCurValue();
		default:
			return false;
		}
	}
}
