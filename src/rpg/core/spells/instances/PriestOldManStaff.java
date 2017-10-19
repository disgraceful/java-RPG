package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.AttackType;
import rpg.core.spells.OffensiveSpell;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;

public class PriestOldManStaff  extends OffensiveSpell{
	
	public PriestOldManStaff() {
		name = "Old Man Staff";
		description = "In heat of the battle, everything used for a victory!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.MELEE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.DAMAGE_MOD, 0), new Stat(StatEnum.ACC, 75),
				new Stat(StatEnum.CRIT_MOD, 5));
		callerRequiredPos = new SpellPositionWrapper(0, 1);
		targetRequiredPos = new SpellPositionWrapper(0, 1);
	}
}
