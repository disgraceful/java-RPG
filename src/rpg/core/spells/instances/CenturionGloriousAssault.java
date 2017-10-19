package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.AttackType;
import rpg.core.spells.Move;
import rpg.core.spells.OffensiveSpell;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;

public class CenturionGloriousAssault extends OffensiveSpell {

	public CenturionGloriousAssault() {
		name = "Glorious Assault";
		description = "Centurion swiftly rushes forward, striking the enemy!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.MELEE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.DAMAGE_MOD, 10), new Stat(StatEnum.ACC, 65),
				new Stat(StatEnum.CRIT_MOD, 5));
		selfApplyingEffects.add(new Move(new StatWrapper(new Stat(StatEnum.MOVE_SPELL_POSITION, 2))));
		callerRequiredPos = new SpellPositionWrapper(0, 1, 2);
		targetRequiredPos = new SpellPositionWrapper(0, 1, 2);
	}

}
