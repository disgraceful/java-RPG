package ddripoffmodel;

import java.util.ArrayList;

public class BuffAbility extends Ability implements ITemporaryEffect {
	private int abilityDuration;
	private TemporaryEffect effectType = TemporaryEffect.Buff;

	public BuffAbility(String name, ArrayList<Stat> stat, int duration) {
		super(name, stat);
		this.abilityDuration = duration;
	}
	@Override
	public void useAbility(StatWrapper[] targets, StatWrapper user) {
		for (StatWrapper t : targets) {
			t.updateStats(affectedstats);
			System.out.println(t.getOwner().getName() + " has been buffed");
		}
	}

	public void endDuration(StatWrapper[] targets) {
		StatWrapper.reverseStatsValue(affectedstats);
		for (StatWrapper t : targets) {
			t.updateStats(affectedstats);
			System.out.println(getName() + " duration has been expired on " + t.getOwner().getName());
		}
	}

	@Override
	public int getEffectDuration() {
		return abilityDuration;
	}

	@Override
	public void setEffectDuration(int duration) {
		if (duration < 1) {
			abilityDuration = 1;
		} else {
			abilityDuration = duration;
		}
	}

	@Override
	public TemporaryEffect getEffect() {
		return effectType;
	}
	
	@Override
	public void applyEffect() {}
}
