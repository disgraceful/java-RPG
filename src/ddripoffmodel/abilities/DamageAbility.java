package ddripoffmodel.abilities;

import java.util.ArrayList;

import ddripoffmodel.Stat;
import ddripoffmodel.StatEnumeration;
import ddripoffmodel.StatWrapper;

public class DamageAbility extends Ability {
	public DamageAbility(String name, ArrayList<Stat> stat) {
		super(name, stat);
	}

	public void useAbility(StatWrapper[] targets, StatWrapper user) {
		for (StatWrapper t : targets) {
			int dmg = calculateDmg(t, user);
			StatWrapper s = new StatWrapper(new ArrayList<Stat>() {
				{
					add(new Stat(StatEnumeration.Health, -dmg,false));
				}
			});
			t.updateStats(s);
			if (dmg > 0) {
				System.out.println(user.getOwner().getName() + " used " + this.getName() + " and dealed " + dmg
						+ " damage to " + t.getOwner().getName());
			} else {
				System.out.println(user.getOwner().getName() + " used " + this.getName() + " and restored " + -dmg
						+ " health to " + t.getOwner().getName());
			}
		}
	}

	private int calculateDmg(StatWrapper target, StatWrapper user) {
		// int potdmg = user.getStatbyName("Damage").getValue()*
		// affectedstats.getStatbyName("Damage").getValue();
		int potdmg = user.getStatbyName(StatEnumeration.Damage).getCurValue();
		int realdmg;
		if (affectedStats.getStatbyName(StatEnumeration.Damage).getCurValue() > 0) {
			potdmg += affectedStats.getStatbyName(StatEnumeration.Damage).getCurValue();
			int targetdef = target.getStatbyName(StatEnumeration.Armor).getCurValue();
			realdmg = potdmg - targetdef;// potdmg*(100-targetdef);
		} else {
			potdmg = affectedStats.getStatbyName(StatEnumeration.Damage).getCurValue();
			realdmg = potdmg;
		}
		return realdmg;
	}
}
