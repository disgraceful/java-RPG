package ddripoffmodel;

import java.util.ArrayList;
import java.util.Random;

public class DotAbility extends Ability implements ITemporaryEffect {

	private int abilityDuration;
	private final TemporaryEffect effectType;
	private int tickDamage;

	public DotAbility(String name, ArrayList<Stat> stat, int duration, TemporaryEffect effecttype) {
		super(name, stat);
		effectType = effecttype;
		abilityDuration = duration;
	}

	public void setTickDamage(int value) {
		if (value < 0) {
			tickDamage = 0;
		}
		tickDamage = value;
	}

	public int getTickDamage() {
		return tickDamage;
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
		int curValue = t.getStatbyName(StatEnumeration.Health).getCurValue();
		t.getStatbyName(StatEnumeration.Health).setValue(curValue - tickDamage);
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
		}
		else if(effectType == TemporaryEffect.Blight){
			return chance> user.getStatbyName(StatEnumeration.BlightResist).getCurValue();
		}
		else{
			 return chance>user.getStatbyName(StatEnumeration.StressResist).getCurValue();
		}
	}
}
