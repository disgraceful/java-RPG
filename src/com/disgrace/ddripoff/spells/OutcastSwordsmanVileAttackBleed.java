package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.enemies.EnemyClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class OutcastSwordsmanVileAttackBleed extends DOTSpell {
	public OutcastSwordsmanVileAttackBleed() {
		initSpell();
	}

	@Override
	public void initSpell() {
		restrictionClass = EnemyClass.OUTCAST_SWORDSMAN;
		range = RangeType.MELEE;
		spellOrientation = TargetType.ENEMY;
		abilityDuration = 3;
		currentDuration = abilityDuration;
		effectType = TemporaryEffectType.BLEED;
		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.DAMAGE, 1, 100));
				add(new Stat(StatEnumeration.BLEED_CHANCE,100,220));
			}
		});

		callerRestrictedPos.add(0);
		callerRestrictedPos.add(1);
		callerRestrictedPos.add(2);


		targetsRestrictedPos.add(2);
		targetsRestrictedPos.add(3);

	}
}
