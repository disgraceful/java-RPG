package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.enemies.EnemyClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class OutcastSwordsmanVileAttackDamage extends DamageSpell {
	public OutcastSwordsmanVileAttackDamage() {
		initSpell();
	}

	@Override
	public void initSpell() {
		restrictionClass = EnemyClass.OUTCAST_SWORDSMAN;
		damageType = DamageType.PHYSICAL;
		range = RangeType.MELEE;
		spellOrientation = TargetType.ENEMY;
		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.ACC_MOD, 75, 100));
				add(new Stat(StatEnumeration.DAMAGE_MOD, 30, 100));
				add(new Stat(StatEnumeration.CRIT_MOD, 13, 100));
			}
		});


		callerRestrictedPos.add(0);
		callerRestrictedPos.add(1);
		callerRestrictedPos.add(2);

		targetsRestrictedPos.add(0);
		targetsRestrictedPos.add(1);
		targetsRestrictedPos.add(2);
		

	}
}
