package rpg.core.items;

import javax.xml.bind.annotation.XmlRootElement;

import rpg.core.characters.shared.Character;


public abstract class Consumable extends Item {
	public abstract void use(Character c);
}
