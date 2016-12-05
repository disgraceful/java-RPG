package com.disgrace.ddripoff.abilities;

import com.disgrace.ddripoff.characters.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatWrapper;

public class Curse implements TemporaryEffect {

	public void affectCurse(StatWrapper[] targets) {
		for (StatWrapper t : targets) {
			for (Stat s : t.getStatsasArrayList()) {
				s.setValue(s.getCurValue() / 2);
			}
		}
	}

	// private void cureCurse(StatWrapper[]targets){
	// System.out.println("Curse has been cured");
	// for(StatWrapper t : targets ){
	// for(Stat s :t.getStatsasArrayList()){
	// s.setValue(s.getBaseValue());
	// }
	// }
	// }

	public TemporaryEffectType getEffectType() {
		return TemporaryEffectType.CURSE;
	}

	@Override
	public void onTick(Character target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onExpire(Character target) {
		// TODO Auto-generated method stub

	}

	public int getEffectDuration() {
		return 1;
	}

	public void setEffectDuration(int duration) {
	}
}
