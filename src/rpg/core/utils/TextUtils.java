package rpg.core.utils;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Party;
import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.items.Trinket;
import rpg.core.spells.Spell;

public class TextUtils {

	private TextUtils() {
	}

	public static void printCharacterFullInfo(Character character) {
		System.out.println(character.getName());
		for (Stat s : character.getStatWrapper().getStats()) {
			System.out.println(character.getName() + "'s " + s.getType().toString() + ": " + s.getCurValue()); 
		}
		System.out.println(character.getName() + "'s position: " + (character.getPosition()));
	}

	public static void printCharacterShortInfo(Character character) {
		System.out.print(character.getName() + " " + character.getStats().getStatbyName(StatEnum.HEALTH).getCurValue()
				+ "/" + character.getStats().getStatbyName(StatEnum.HEALTH).getMaxValue());
		System.out.println(" position: " + (character.getPosition()));

	}

	public static void printTrinketInfo(Trinket trinket) {
		System.out.println(trinket.getName());
		System.out.print(trinket.getName() + "has:");
		for (Stat c : trinket.getStatWrapper().getStats()) {
			System.out.println(" + " + c.getCurValue() + " " + c.getType());
		}
	}

	public static void printAbilityInfo(Spell spell) {
		System.out.println(spell.getName());
		System.out.println(spell.getDescription());

	}

	public static void printPartyInfo(Party party) {
		for (Character c : party.getMembers()) {
			System.out.println(c.getName() + " " + party.getPosition(c));
		}
	}
}
