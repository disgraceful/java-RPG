package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.AttackType;
import rpg.core.spells.OffensiveSpell;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;

public class PurifierCulling extends OffensiveSpell {
	public PurifierCulling() {
		name = "Culling";
		description = "Cull the darkin!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.RANGE;
		targetQuantity = SpellTargetQuantity.MULTIPLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.DAMAGE_MOD, -40), new Stat(StatEnum.ACC, 60),
				new Stat(StatEnum.CRIT_MOD, 5));
		callerRequiredPos = new SpellPositionWrapper(2,3);
		targetRequiredPos = new SpellPositionWrapper(0, 1,2);
	}
}
