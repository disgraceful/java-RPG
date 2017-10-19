package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatAffectStrategy;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.AttackType;
import rpg.core.spells.Debuff;
import rpg.core.spells.OffensiveSpell;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;

public class PriestBanishingLight extends OffensiveSpell {

	public PriestBanishingLight() {
		name = "Banishing Light";
		description = "The hand which heals, can also banish!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.RANGE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.DAMAGE_MOD, -60), new Stat(StatEnum.ACC, 80),
				new Stat(StatEnum.CRIT_MOD, 0));
		applyingEffects.add(new Debuff(3,
				new StatWrapper(new Stat(StatEnum.DAMAGE, -90,false,StatAffectStrategy.MULTIPLYING), new Stat(StatEnum.DEBUFF_CHANCE, 90))));
		callerRequiredPos = new SpellPositionWrapper(1, 2, 3);
		targetRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
	}

}
