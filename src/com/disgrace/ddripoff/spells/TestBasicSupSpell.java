package com.disgrace.ddripoff.spells;

import java.io.Serializable;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class TestBasicSupSpell extends BasicSpell implements Serializable {
	public TestBasicSupSpell() {
		initSpell();
	}

	@Override
	public void initSpell() {
		name = "Just Supporting Spell for Enemies";
		description = "Description: Heals target! ";
		attackType = AttackType.SUPPORT;
		orientation = SpellOrientation.DEFFENSIVE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE, 0), new Stat(StatEnumeration.ACC, 0),
				new Stat(StatEnumeration.CRIT_CHANCE, 0));
		applyingEffects.add(new HealEffect() {
			protected StatWrapper effectStats = new StatWrapper(new Stat(StatEnumeration.HEALTH, 6));

			public StatWrapper getEffectStats() {
				return effectStats;
			}

			public void setEffectStats(StatWrapper effectStats) {
				this.effectStats = effectStats;

			}
		});
		System.out.println("------------------------"+applyingEffects.get(0).getEffectStats().getStatbyName(StatEnumeration.HEALTH).getCurValue());
		callerRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
		targetRequiredPos = new SpellPositionWrapper(0, 1);
	}
}
