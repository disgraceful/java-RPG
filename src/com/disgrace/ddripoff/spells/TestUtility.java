package com.disgrace.ddripoff.spells;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestUtility extends UtilitySpell {
	public TestUtility(){
		initSpell();
	}
	
	@Override
	public void initSpell() {
		super.initSpell();
		name ="Weak Buff";
		description="Description: Buffs an Ally";
		targetQuantity = SpellTargetQuantity.SINGLE;
		//abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE_MOD,-20),new Stat(StatEnumeration.ACC,90),new Stat(StatEnumeration.CRIT_MOD,50));
		applyingEffects.add(new TestBuff());
		//selfApplyingEffects.add(new TestBuff());
		callerRequiredPos = new SpellPositionWrapper(0,1,2,3);
		targetRequiredPos = new SpellPositionWrapper(0,1);		
	}
	
}
