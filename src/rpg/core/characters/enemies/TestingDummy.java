package rpg.core.characters.enemies;

import java.util.ArrayList;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.instances.TestBasicOffSpell;
import rpg.core.spells.instances.TestBasicSupSpell;

public class TestingDummy extends Enemy {
	public TestingDummy() {
		name = "Dummy";
		eClass = EnemyClass.TESTING_DUMMY;
		subTypes = new ArrayList<EnemySubType>() {
			{
				add(EnemySubType.HUMAN);
			}
		};
		this.stats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnum.HEALTH, 30, 30));

				add(new Stat(StatEnum.DODGE, 4, 50));
				add(new Stat(StatEnum.PROT, 5, 999));
				add(new Stat(StatEnum.SPEED, 4, 99));

				add(new Stat(StatEnum.MOVE_RES, 50, 220));
				add(new Stat(StatEnum.BLEED_RES, 40, 220));
				add(new Stat(StatEnum.BLIGHT_RES, 30, 220));
				add(new Stat(StatEnum.DEBUFF_RES, 30, 220));
				add(new Stat(StatEnum.STUN_RES, 50, 220));

				add(new Stat(StatEnum.MOVE_CHANCE, 0, 220));
				add(new Stat(StatEnum.BLIGHT_CHANCE, 0, 220));
				add(new Stat(StatEnum.BLEED_CHANCE, 0, 220));
				add(new Stat(StatEnum.STUN_CHANCE, 0, 220));
				add(new Stat(StatEnum.DEBUFF_CHANCE, 0, 220));

				add(new Stat(StatEnum.BEHEMOTH_DMG_MOD, 0, 220));
				add(new Stat(StatEnum.DARKIN_DMG_MOD, 0, 220));
				add(new Stat(StatEnum.DRAGON_DMG_MOD, 0, 220));
				add(new Stat(StatEnum.HUMAN_DMG_MOD, 0, 220));
				add(new Stat(StatEnum.VOIDBORN_DMG_MOD, 0, 220));
			}
		});
		allAbilities.add(new TestBasicOffSpell());
		allAbilities.add(new TestBasicSupSpell());
	}

	public TestingDummy(String name) {
		this();
		this.name = name;

	}

}
