package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.AttackType;
import rpg.core.spells.BasicSpell;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;

public class TestBasicOffSpell extends BasicSpell {

	public TestBasicOffSpell() {
		name = "Just Damaging Spell for Enemies";
		description = "Description: Damages an opponent!";
		attackType = AttackType.MELEE;
		orientation = SpellOrientation.OFFENSIVE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.DAMAGE, 5), new Stat(StatEnum.ACC, 60),
				new Stat(StatEnum.CRIT_CHANCE, 5));
		callerRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
		targetRequiredPos = new SpellPositionWrapper(0, 1);
	}
}
