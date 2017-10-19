package rpg.core.spells.instances;

import java.io.Serializable;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.AttackType;
import rpg.core.spells.BasicSpell;
import rpg.core.spells.HealEffect;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;

public class TestBasicSupSpell extends BasicSpell implements Serializable {
	public TestBasicSupSpell() {
		name = "Just Supporting Spell for Enemies";
		description = "Description: Heals target! ";
		attackType = AttackType.SUPPORT;
		orientation = SpellOrientation.DEFFENSIVE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.DAMAGE, 0), new Stat(StatEnum.ACC, 0),
				new Stat(StatEnum.CRIT_CHANCE, 0));
		applyingEffects.add(new HealEffect(new StatWrapper(new Stat(StatEnum.HEALTH, 6))));
		callerRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
		targetRequiredPos = new SpellPositionWrapper(0, 1);
	}


}
