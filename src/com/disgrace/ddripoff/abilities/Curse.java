package com.disgrace.ddripoff.abilities;

import com.disgrace.ddripoff.characters.Stat;
import com.disgrace.ddripoff.characters.StatWrapper;

public class Curse implements ITemporaryEffect {

	public void affectCurse(StatWrapper[] targets){
		for(StatWrapper t : targets){
			for(Stat s :t.getStatsasArrayList()){
				s.setValue((int)s.getCurValue()/2);
			}
		}
	}
	
	private void cureCurse(StatWrapper[]targets){
		System.out.println("Curse has been cured");
		for(StatWrapper t : targets ){
			for(Stat s :t.getStatsasArrayList()){
				s.setValue(s.getBaseValue());
			}
		}
	}

	@Override
	public TemporaryEffect getEffectType() {
			return TemporaryEffect.Curse;
	}

	@Override
	public void tickEffect(StatWrapper t) {	}
	
	@Override
	public void expireEffect(StatWrapper[] targets) {
		cureCurse(targets);
	}

	@Override
	public int getEffectDuration() {
		return 1;
	}

	@Override
	public void setEffectDuration(int duration) {}
}
