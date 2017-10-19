package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatAffectStrategy;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.Buff;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;
import rpg.core.spells.UtilitySpell;

public class PurifierLightslinger extends UtilitySpell {
	public PurifierLightslinger() {
		name = "Lightslinger";
		description = "Double the gun, double the hurt!";
		orientation = SpellOrientation.UTILITY;
		targetQuantity = SpellTargetQuantity.SINGLE;
		applyingEffects.add(new Buff(1, new StatWrapper(new Stat(StatEnum.DAMAGE, 100,false,StatAffectStrategy.MULTIPLYING))));
		callerRequiredPos = new SpellPositionWrapper(2, 3);
		targetRequiredPos = new SpellPositionWrapper(2, 3);
	}
}
