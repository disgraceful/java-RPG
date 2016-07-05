package game;

import java.util.ArrayList;
import java.util.Iterator;

import ddripoffmodel.Ability;
import ddripoffmodel.BuffAbility;
import ddripoffmodel.Character;
import ddripoffmodel.Hero;
import ddripoffmodel.ITemporaryEffect;
import ddripoffmodel.Party;
import ddripoffmodel.Stat;
import ddripoffmodel.StatEnumeration;
import ddripoffmodel.StatWrapper;
import ddripoffmodel.Trinket;

public class Game {

	private static Turn currentTurn;
	private static int turnCount;
	private Battle battle;
	private static Party currentParty;
	private ArrayList<Room> roomlist;

	public static void main(String[] args) {
		// MainMenu.launchMenu(null);
		test();
		printPartyInfo(currentParty);
	}

	private static void newTurn() {
		turnCount++;
		System.out.println("new turn. turncount: " + turnCount);
		for (Character c : currentParty.getMembers()) {
			Iterator<ITemporaryEffect> iter = c.getEffectsList().iterator();
			while (iter.hasNext()) {
				ITemporaryEffect temp = iter.next();
				temp.tickEffect(c.getStatWrapper());
				if (temp.getEffectDuration() <= 0) {
					temp.expireEffect(new StatWrapper[] { c.getStatWrapper() });
					iter.remove();
				}
			}
		}
	}

	private static void test() {
		Hero hero1 = new Hero("Hero1", new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.Health, 10, 10));
				add(new Stat(StatEnumeration.Armor, 2, 10));
				add(new Stat(StatEnumeration.Damage, 5, 100));
				add(new Stat(StatEnumeration.Speed, 3, 20));
			}
		});
		hero1.getStatWrapper().setOwner(hero1);
		Hero hero2 = new Hero("Hero2", new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.Health, 20, 20));
				add(new Stat(StatEnumeration.Armor, 5, 10));
				add(new Stat(StatEnumeration.Damage, 1, 100));
				add(new Stat(StatEnumeration.Speed, 1, 100));
			}
		});
		hero2.getStatWrapper().setOwner(hero2);

		// printHeroInfo(hero1);
		// printHeroInfo(hero2);

		currentParty = new Party();
		currentParty.addMember(hero2, 0);
		currentParty.addMember(hero1, 1);
		currentParty.reposition(hero1, 0);
	}

	private static void printHeroInfo(Hero hero) {
		System.out.println(hero.getName());
		System.out.println(hero.getName() + "'s health: "
				+ hero.getStatWrapper().getStatbyName(StatEnumeration.Health).getCurValue() + " / "
				+ hero.getStatWrapper().getStatbyName(StatEnumeration.Health).getMaxValue());
		System.out.println(hero.getName() + "'s armor: "
				+ hero.getStatWrapper().getStatbyName(StatEnumeration.Armor).getCurValue());
		System.out.println(hero.getName() + "'s damage: "
				+ hero.getStatWrapper().getStatbyName(StatEnumeration.Damage).getCurValue());
	}

	private static void printTrinketInfo(Trinket trinket) {
		System.out.println(trinket.getName());
		System.out.print(trinket.getName() + "has:");
		for (Stat c : trinket.getStatWrapper().getStatsasArrayList()) {
			System.out.println(" + " + c.getCurValue() + " " + c.getType());
		}
	}

	private static void printAbilityInfo(Ability ability) {
		System.out.println(ability.getName());
		System.out.println(ability.getDescription());
	}

	private static void printPartyInfo(Party party) {
		for (Character c : party.getMembers()) {
			System.out.println(c.getName() + " " + party.getPosition(c));
		}
	}
}
