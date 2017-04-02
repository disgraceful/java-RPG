package com.disgrace.ddripoff.items;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.shared.Character;

@XmlRootElement
public abstract class Consumable extends Item {
	public abstract void use(Character c);
}
