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
			if(effectType == TemporaryEffect.Stun){
				int curValue = t.getStatbyName(StatEnumeration.StressResist).getCurValue();
				t.getStatbyName(StatEnumeration.StressResist).setValue(curValue+60);
				abilityDuration=0;
			}
			t.updateStats(affectedStats);
		}
	}

	@Override
	public void expireEffect(StatWrapper[] targets) {
		for (StatWrapper t : targets) {
			if(effectType == TemporaryEffect.Stun){
				BuffAbility stunLockAbuse = new BuffAbility("StunLockAbuseResistance",new ArrayList<Stat>(){
					{
						add(new Stat(StatEnumeration.StunResist,60,false));
					}
				},1,TemporaryEffect.Buff);
				t.getOwner().learnAbility(stunLockAbuse);
				t.getOwner().useAbility(stunLockAbuse, new StatWrapper[] {t});
			}
			System.out.println(this.getName()+ "has been expired on " + t.getOwner().getName());
		}
	}

	private boolean ifDotApplies(StatWrapper target, StatWrapper user) {
		Random rand = new Random();
		int chance = rand.nextInt(100);
		switch (effectType) {
		case Bleed:
			return chance> user.getStatbyName(StatEnumeration.BleedResist).getCurValue();
		case Blight:
			return chance> user.getStatbyName(StatEnumeration.BlightResist).getCurValue();
		case MindLeak:
			return chance> user.getStatbyName(StatEnumeration.StressResist).getCurValue();
		case Stun:
			return chance> user.getStatbyName(StatEnumeration.StunResist).getCurValue();
		default:
			return false;
		}
	}		
}
