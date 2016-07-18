package ddripoffmodel.abilities;

import java.util.ArrayList;
import java.util.Random;

import ddripoffmodel.Stat;
import ddripoffmodel.StatEnumeration;
import ddripoffmodel.StatWrapper;

public class DotAbility extends Ability implements ITemporaryEffect {

	private int abilityDuration;
	private final TemporaryEffect effectType;

	public DotAbility(String name, ArrayList<Stat> stat, int duration, TemporaryEffect effecttype) {
		super(name, stat);
		effectType = effecttype;
		abilityDuration = duration;
	}

	public DotAbility(DotAbility a) {
		this(a.getName(), a.getStats().getStatsasArrayList(), a.getEffectDuration(), a.getEffectType());
	}

	@Override
	public void useAbility(StatWrapper[] targets, StatWrapper user) {
		for (StatWrapper t : targets) {
			if (ifDotApplies(t, user)) {
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
	public void tickEffect(StatWrapper t) {
		if (abilityDuration >= 0) {
			this.abilityDuration--;
		} else {
			t.updateStats(affectedStats);
		}
	}

	@Override
	public void expireEffect(StatWrapper[] targets) {
		for (StatWrapper t : targets) {
			System.out.println("dot has been expired on " + t.getOwner().getName());
		}
	}

	private boolean ifDotApplies(StatWrapper target, StatWrapper user) {
		Random rand = new Random();
		int chance = rand.nextInt(100);
		if (effectType == TemporaryEffect.Bleed) {
			return chance > user.getStatbyName(StatEnumeration.BleedResist).getCurValue();
		} else if (effectType == TemporaryEffect.Blight) {
			return chance > user.getStatbyName(StatEnumeration.BlightResist).getCurValue();
		} else {
			return chance > user.getStatbyName(StatEnumeration.StressResist).getCurValue();
		}
	}
}
