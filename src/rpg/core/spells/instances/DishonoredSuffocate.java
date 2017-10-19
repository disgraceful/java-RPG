package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.AttackType;
import rpg.core.spells.OffensiveSpell;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;
import rpg.core.spells.Stun;

public class DishonoredSuffocate extends OffensiveSpell {
	public DishonoredSuffocate() {
		name = "Suffocate";
		description = "Suffocate, as he once did!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.RANGE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.DAMAGE_MOD, -40), new Stat(StatEnum.ACC, 85),
				new Stat(StatEnum.CRIT_MOD, 5));
		applyingEffects.add(new Stun(new StatWrapper(new Stat(StatEnum.STUN_CHANCE, 90))));
		callerRequiredPos = new SpellPositionWrapper(0, 1,2);
		targetRequiredPos = new SpellPositionWrapper(1, 2);
	}
}
