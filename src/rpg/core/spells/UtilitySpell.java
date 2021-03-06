package rpg.core.spells;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.SerializationUtils;

import rpg.core.characters.shared.Character;


public abstract class UtilitySpell extends Spell {

	@Override
	public void useSpell(Character caller, Character... targets) {
		for (Character target : targets) {
			applyingEffects.stream().forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller,target));
		}
		selfApplyingEffects.stream().forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller, caller));
	}
}
