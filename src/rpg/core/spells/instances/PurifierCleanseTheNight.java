package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.AttackType;
import rpg.core.spells.OffensiveSpell;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;

public class PurifierCleanseTheNight extends OffensiveSpell {
public PurifierCleanseTheNight() {
	name = "Cleanse the Night";
	description = "Cast the shadows of night and impurity!";
	orientation = SpellOrientation.OFFENSIVE;
	attackType = AttackType.RANGE;
	targetQuantity = SpellTargetQuantity.SINGLE;
	abilityStats = new StatWrapper(new Stat(StatEnum.DAMAGE_MOD, 0), new Stat(StatEnum.ACC, 70),
			new Stat(StatEnum.CRIT_MOD, 5));
	callerRequiredPos = new SpellPositionWrapper(2,3);
	targetRequiredPos = new SpellPositionWrapper(0, 1);
}
}
