package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class DOTSpell extends TemporarySpell {

//	@Override
//	public void onTick(Character target) {
//		if (currentDuration > 0) {
//			int tickDamage = abilityStats.getStatbyName(StatEnumeration.DAMAGE).getCurValue();
//			affectedStats = new StatWrapper(new ArrayList<Stat>() {
//				{
//					add(new Stat(StatEnumeration.HEALTH, -tickDamage, false));
//				}
//			});
//			target.getStats().updateStats(affectedStats);
//			currentDuration--;
//			System.out.println("Dot is ticking...");
//			return;
//		}
//		onExpire(target);
//	}
//
//	@Override
//	public void onExpire(Character target) {
//		System.out.println(this.toString()+ " has expired");
//	}
//
//	
	
}
