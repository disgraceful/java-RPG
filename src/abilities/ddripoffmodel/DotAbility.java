package abilities.ddripoffmodel;

import java.util.ArrayList;
import java.util.Random;

import ddripoffmodel.Stat;
import ddripoffmodel.StatEnumeration;
import ddripoffmodel.StatWrapper;

/**
 * 
 * @author Kashapov
 *
 *         describes temporary abilities such as bleed, blight, stun, mindleak
 */
public class DotAbility extends Ability implements ITemporaryEffect {
	
	// duration of ability effect
	private int abilityDuration;
	
	// defines ability type: bleed, blight, etc
	private final TemporaryEffect effectType;

	public DotAbility(String name, ArrayList<Stat> stat, int duration, TemporaryEffect effecttype) {
		super(name, stat);
		effectType = effecttype;
		abilityDuration = duration;
	}

	/**
	 * copies object a
	 * 
	 * @param a
	 *            copied object
	 */
	public DotAbility(DotAbility a) {
		this(a.getName(), a.getStats().getStatsasArrayList(), a.getEffectDuration(), a.getEffectType());
	}

	@Override
	/**
	 * applies when character uses ability
	 */
	public void useAbility(StatWrapper[] targets, StatWrapper user) {
		for (StatWrapper t : targets) {
			if (ifDotApplies(t, user)) {
				// add effect to characters' effect list
				t.getOwner().getEffectsList().add(new DotAbility(this));
				System.out.println(t.getOwner().getName() + " has been dotted");
			}
		}
	}

	@Override
	public int getEffectDuration() {
		return abilityDuration;
	}

	@Override
	public void setEffectDuration(int duration) {
		abilityDuration = duration;
	}

	@Override
	public TemporaryEffect getEffectType() {
		return effectType;
	}

	@Override
	/**
	 * @param t target stats which change every turn, while ability is active
	 */
	public void tickEffect(StatWrapper t) {
		if (abilityDuration >= 0) {
			this.abilityDuration--;
		} else {
			t.updateStats(affectedStats);
		}
	}

	@Override
	/**
	 * works when ability duration ends
	 */
	public void expireEffect(StatWrapper[] targets) {
		for (StatWrapper t : targets) {
			if (effectType == TemporaryEffect.Stun) {
				//boss stunlock protection
				BuffAbility stunLockAbuse = new BuffAbility("StunLockAbuseResistance", new ArrayList<Stat>() {
					{
						add(new Stat(StatEnumeration.StunResist, 60, true));
					}
				}, 1, TemporaryEffect.Buff);
				t.getOwner().learnAbility(stunLockAbuse);
				t.getOwner().useAbility(stunLockAbuse, new StatWrapper[] { t });
			}
			System.out.println(this.getName() + "has been expired on " + t.getOwner().getName());
		}
	}

	/**
	 * check if dot resistance>dot chance
	 * 
	 * @param target
	 *            target of ability(def stats)
	 * @param user
	 *            caster of ability(attack stats)
	 * @return true if target is dotted
	 */
	private boolean ifDotApplies(StatWrapper target, StatWrapper user) {
		Random rand = new Random();
		//int chance = rand.nextInt(100);
		int chance = 100;
		switch (effectType) {
		case Bleed:
			return chance > target.getStatbyName(StatEnumeration.BleedResist).getCurValue();
		case Blight:
			return chance > target.getStatbyName(StatEnumeration.BlightResist).getCurValue();
		case MindLeak:
			return chance > target.getStatbyName(StatEnumeration.StressResist).getCurValue();
		case Stun:
			return chance > target.getStatbyName(StatEnumeration.StunResist).getCurValue();
		default:
			return false;
		}
	}
}
