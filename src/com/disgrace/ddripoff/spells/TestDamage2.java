package com.disgrace.ddripoff.spells;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public class TestDamage2 extends OffensiveSpell {
	public TestDamage2(){
		initSpell();
	}
	
	@Override
	public void initSpell() {
		super.initSpell();
		name ="Just Damaging Spell";
		description="Description: Damages an opponent! And reduces armor!";
		attackType = AttackType.MELEE;
		damageType = DamageType.PHYSICAL;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE_MOD,-20),new Stat(StatEnumeration.ACC,90),new Stat(StatEnumeration.CRIT_MOD,50));
		applyingEffects.add(new TestDebuff());
		//selfApplyingEffects.add(new TestMove());
		callerRequiredPos = new SpellPositionWrapper(0,1,2,3);
		targetRequiredPos = new SpellPositionWrapper(0,1);		
	}
}
