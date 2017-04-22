package com.disgrace.ddripoff.spells.instance;

import com.disgrace.ddripoff.spells.AttackType;
import com.disgrace.ddripoff.spells.DamageType;
import com.disgrace.ddripoff.spells.OffensiveSpell;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class PurifierCleanseTheNight extends OffensiveSpell {
public PurifierCleanseTheNight() {
	name = "Cleanse the Night";
	description = "Cast the shadows of night and impurity!";
	orientation = SpellOrientation.OFFENSIVE;
	attackType = AttackType.RANGE;
	damageType = DamageType.PHYSICAL;
	targetQuantity = SpellTargetQuantity.SINGLE;
	abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE_MOD, 0), new Stat(StatEnumeration.ACC, 70),
			new Stat(StatEnumeration.CRIT_MOD, 5));
	callerRequiredPos = new SpellPositionWrapper(2,3);
	targetRequiredPos = new SpellPositionWrapper(0, 1);
}
}
