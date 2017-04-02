package com.disgrace.ddripoff.spells;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.SerializationUtils;

import com.disgrace.ddripoff.characters.shared.Character;

@XmlRootElement
public abstract class UtilitySpell extends Spell implements Serializable {

	@Override
	public void initSpell() {
		orientation = SpellOrientation.UTILITY;
	}

	@Override
	public void useSpell(Character caller, Character... targets) {
		for (Character target : targets) {
			applyingEffects.stream().forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller,target));
		}
		selfApplyingEffects.stream().forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller, caller));
	}
}
