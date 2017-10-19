package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.AttackType;
import rpg.core.spells.OffensiveSpell;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;

public class PurifierSpearOfLight extends OffensiveSpell {
	public PurifierSpearOfLight() {
		name = "Spear of Light";
		description = "Sun always rises!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.RANGE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.DAMAGE_MOD, 50), new Stat(StatEnum.ACC, 65),
				new Stat(StatEnum.CRIT_MOD, 5));
		callerRequiredPos = new SpellPositionWrapper(3, 4);
		targetRequiredPos = new SpellPositionWrapper(0, 1, 2);
	}
}
