package rpg.core.characters.heroes.classes;

import java.util.ArrayList;

import rpg.core.characters.heroes.Hero;
import rpg.core.characters.heroes.HeroClass;
import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.instances.PriestBanishingLight;
import rpg.core.spells.instances.PriestDivineSpirit;
import rpg.core.spells.instances.PriestOldManStaff;
import rpg.core.spells.instances.PriestSaviorGrace;


public class Priest extends Hero {

	public Priest() {
		name = "Priest";
		heroClass = HeroClass.PRIEST;
		stats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnum.HEALTH, 30, 30));
				add(new Stat(StatEnum.STRESS,0,200));
				add(new Stat(StatEnum.CURSE_LEVEL,0,5));
				
				add(new Stat(StatEnum.VIRTUE_CHANCE,25,100));
				add(new Stat(StatEnum.TRAP_DISARM_CHANCE,50,100));
				
				add(new Stat(StatEnum.DODGE, 4, 50));
				add(new Stat(StatEnum.PROT, 5, 999));
				add(new Stat(StatEnum.DAMAGE, 7, 999));
				add(new Stat(StatEnum.SPEED, 4, 99));
				add(new Stat(StatEnum.ACC_MOD, 0, 99));
				add(new Stat(StatEnum.CRIT_CHANCE, 0, 100));

				add(new Stat(StatEnum.DEATH_RES, 66, 100));
				add(new Stat(StatEnum.MOVE_RES, 50, 220));
				add(new Stat(StatEnum.BLEED_RES, 40, 220));
				add(new Stat(StatEnum.BLIGHT_RES, 30, 220));
				add(new Stat(StatEnum.DEBUFF_RES, 30, 220));
				add(new Stat(StatEnum.STUN_RES, 50, 220));
				add(new Stat(StatEnum.CURSE_RES, 66, 220));
				add(new Stat(StatEnum.DISEASE_RES, 66, 220));
				add(new Stat(StatEnum.STRESS_RES,0,220));

				add(new Stat(StatEnum.RANGE_MOD, 0, 100));
				add(new Stat(StatEnum.MELEE_MOD, 0, 100));
				add(new Stat(StatEnum.DAMAGE_MOD, 0, 100));

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
		allAbilities.add(new PriestOldManStaff());
		allAbilities.add(new PriestBanishingLight());
		allAbilities.add(new PriestDivineSpirit());
		allAbilities.add(new PriestSaviorGrace());
		learnedAbilities.addAll(allAbilities);
	}
}
