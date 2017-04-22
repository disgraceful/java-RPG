package com.disgrace.ddripoff.characters.heroes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.spells.instance.PriestBanishingLight;
import com.disgrace.ddripoff.spells.instance.PriestDivineSpirit;
import com.disgrace.ddripoff.spells.instance.PriestOldManStaff;
import com.disgrace.ddripoff.spells.instance.PriestSaviorGrace;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public class Priest extends Hero {

	public Priest() {
		name = "Priest";
		heroClass = HeroClass.PRIEST;
		stats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.HEALTH, 16, 16));
				add(new Stat(StatEnumeration.DODGE, 6, 50));
				add(new Stat(StatEnumeration.PHYS_PROT, 5, 100));
				add(new Stat(StatEnumeration.DAMAGE, 4, 100));
				add(new Stat(StatEnumeration.SPEED, 5, 20));
				add(new Stat(StatEnumeration.ACC, 0, 100));
				add(new Stat(StatEnumeration.CRIT_CHANCE, 5, 100));

				add(new Stat(StatEnumeration.DEATH_RES, 66, 100));
				add(new Stat(StatEnumeration.MOVE_RES, 40, 220));
				add(new Stat(StatEnumeration.BLEED_RES, 45, 220));
				add(new Stat(StatEnumeration.BLIGHT_RES, 25, 220));
				add(new Stat(StatEnumeration.DEBUFF_RES, 30, 220));
				add(new Stat(StatEnumeration.STUN_RES, 40, 220));

				add(new Stat(StatEnumeration.RANGE_MOD, 0, 100));
				add(new Stat(StatEnumeration.MELEE_MOD, 0, 100));
				add(new Stat(StatEnumeration.PHYS_MOD, 0, 100));

				add(new Stat(StatEnumeration.MOVE_CHANCE, 0, 220));
				add(new Stat(StatEnumeration.BLIGHT_CHANCE, 0, 220));
				add(new Stat(StatEnumeration.BLEED_CHANCE, 0, 220));
				add(new Stat(StatEnumeration.STUN_CHANCE, 0, 220));
				add(new Stat(StatEnumeration.DEBUFF_CHANCE, 0, 220));
			}
		});
		allAbilities.add(new PriestOldManStaff());
		allAbilities.add(new PriestBanishingLight());
		allAbilities.add(new PriestDivineSpirit());
		allAbilities.add(new PriestSaviorGrace());
		learnedAbilities.addAll(allAbilities);
	}
}
