package ddripoffmodel;

import java.util.ArrayList;

public class BuffAbility extends Ability implements ITemporaryEffect,Cloneable {
	
	private int abilityDuration;
	private TemporaryEffect effectType = TemporaryEffect.Buff;

	public BuffAbility(String name, ArrayList<Stat> stat, int duration) {
		super(name, stat);
		this.abilityDuration = duration;
	}

	public BuffAbility(BuffAbility a){
		this(a.getName(),a.getStats().getStatsasArrayList(),a.getEffectDuration());
	}
	
	@Override
	public void useAbility(StatWrapper[] targets, StatWrapper user) {
		for (StatWrapper t : targets) {
			t.updateStats(affectedstats);
			t.getOwner().getEffectsList().add(new BuffAbility(this));
			System.out.println(t.getOwner().getName() + " has been buffed");
		}
	}
	
	@Override
	public void expireEffect(StatWrapper[] targets) {
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
	public TemporaryEffect getEffectType() {
		return effectType;
	}

	@Override
	public void tickEffect() {
		if (abilityDuration >= 0) {
			this.abilityDuration--; 
		}
		
	}
	
	@Override
	protected BuffAbility clone()throws CloneNotSupportedException{
		return (BuffAbility) super.clone();
	}
}
 