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

public class DishonoredChainedDeath extends OffensiveSpell {
	public DishonoredChainedDeath() {
		name = "Chained Death";
		description = "Noone will escape the hook of the unforgiven!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.RANGE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.DAMAGE_MOD, -55), new Stat(StatEnum.ACC, 80),
				new Stat(StatEnum.CRIT_MOD, 0));
		applyingEffects.add(new Move(new StatWrapper(new Stat(StatEnum.MOVE_CHANCE, 120),
				new Stat(StatEnum.MOVE_SPELL_POSITION, 2))));
		callerRequiredPos = new SpellPositionWrapper(1, 2);
		targetRequiredPos = new SpellPositionWrapper(1, 2, 3);
	}
}
