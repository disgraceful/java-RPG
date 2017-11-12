package rpg.core.items.consumables;

import rpg.core.characters.shared.Character;
import rpg.core.items.Item;


public abstract class Consumable extends Item {
	public abstract void use(Character c);
}
