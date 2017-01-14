package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.enemies.EnemyClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class OutcastSwordsmanSlashOfExile extends DamageSpell {
	public OutcastSwordsmanSlashOfExile() {
		initSpell();
	}

	@Override
	public void initSpell() {
		name = "Slash Of Exile";
		description = "Cool description";
		restrictionClass = EnemyClass.OUTCAST_SWORDSMAN;
		damageType = DamageType.PHYS;
		range = RangeType.MELEE;
		spellClass = SpellEnum.OUTCAST_SWORDSMAN_SLASH_OF_EXILE;
		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.ACC_MOD, 90, 100));
				add(new Stat(StatEnumeration.DAMAGE_MOD, 110, 100));
				add(new Stat(StatEnumeration.CRIT_MOD, 5, 100));
			}
		});

		callerRestrictedPos.add(new Integer(1));
		callerRestrictedPos.add(new Integer(2));
		callerRestrictedPos.add(new Integer(3));

		targetsRestrictedPos.add(new Integer(1));
		targetsRestrictedPos.add(new Integer(2));
		targetsRestrictedPos.add(new Integer(3));

	}
}