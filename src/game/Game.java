package game;

import java.util.ArrayList;
import java.util.Iterator;

import ddripoffmodel.Character;
import ddripoffmodel.Hero;
import ddripoffmodel.Party;
import ddripoffmodel.Stat;
import ddripoffmodel.StatEnumeration;
import ddripoffmodel.StatWrapper;
import ddripoffmodel.Trinket;
import ddripoffmodel.abilities.Ability;
import ddripoffmodel.abilities.Curse;
import ddripoffmodel.abilities.DotAbility;
import ddripoffmodel.abilities.ITemporaryEffect;
import ddripoffmodel.abilities.TemporaryEffect;

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
				add(new Stat(StatEnumeration.BleedResist, 0, 100));
			}
		});
		hero2.getStatWrapper().setOwner(hero2);

		printHeroInfo(hero1);
		printHeroInfo(hero2);
		DotAbility dot1 = new DotAbility("Bleeding ass", new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.Health, -1, false));
			}
		}, 3, TemporaryEffect.Bleed);

		hero2.learnAbility(dot1);
		hero2.useAbility(dot1, new StatWrapper[] { hero1.getStatWrapper() });
		Curse curse1 = new Curse();
		curse1.affectCurse(new StatWrapper[]{hero1.getStatWrapper()});
		currentParty = new Party();
		currentParty.addMember(hero1);
		newTurn();
		newTurn();
		newTurn();
		printHeroInfo(hero1);

	}

	private static void printHeroInfo(Hero hero) {
		System.out.println(hero.getName());
		for (Stat s : hero.getStatWrapper().getStatsasArrayList()) {
			System.out.println(hero.getName() + "'s " + s.getType().toString() +": "+ s.getCurValue()); //+ "/"+s.getMaxValue());
		}
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