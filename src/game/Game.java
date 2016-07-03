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
		currentTurn = new Turn();
		test();
	}

	private static void newTurn() {
		turnCount++;
		System.out.println("new turn. turncount: " + turnCount);
		for (Character c : currentParty.getMembers()) {
			Iterator<ITemporaryEffect> iter = c.getEffectsList().iterator();
			while (iter.hasNext()) {
				ITemporaryEffect temp = iter.next();
				temp.tickEffect();
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
				add(new Stat("Health", 10, 10));
				add(new Stat("Armor", 2, 10));
				add(new Stat("Damage", 5, 100));
				add(new Stat("Speed", 3, 20));
			}
		});
		hero1.getStatWrapper().setOwner(hero1);
		Hero hero2 = new Hero("Hero2", new ArrayList<Stat>() {
			{
				add(new Stat("Health", 20, 20));
				add(new Stat("Armor", 5, 10));
				add(new Stat("Damage", 1, 100));
				add(new Stat("Speed", 1, 100));
			}
		});
		hero2.getStatWrapper().setOwner(hero2);

		printHeroInfo(hero1);
		printHeroInfo(hero2);

		currentParty = new Party();
		currentParty.addMember(hero2, 0);
		currentParty.addMember(hero1, 1);

		// Trinket item1 = new Trinket("Item1", new ArrayList<Stat>() {
		// {
		// add(new Stat("Health", 5, true));
		// add(new Stat("Armor", -1, true));
		// }
		// });
		// printTrinketInfo(item1);
		// hero1.equip(item1);
		// printHeroInfo(hero1);
		// hero1.unequip(item1);
		// printHeroInfo(hero1);

		// printHeroInfo(hero2);
		//
		// DamageAbility ability1 = new DamageAbility("dealdmg", new
		// ArrayList<Stat>() {
		// {
		// add(new Stat("Damage", 2, false));
		// }
		// });
		// ability1.setDecsription("Deal 2 damage to target hero");
		// printAbilityInfo(ability1);
		// hero1.learnAbility(ability1);
		// hero1.useAbility(ability1, new StatWrapper[] { hero2.getStatWrapper()
		// });
		// printHeroInfo(hero2);
		//
		// DamageAbility ability2 = new DamageAbility("heal", new
		// ArrayList<Stat>() {
		// {
		// add(new Stat("Damage", -5, false));
		// }
		// });
		// ability2.setDecsription("Heal 5 hp to target hero");
		// printAbilityInfo(ability2);
		// hero2.learnAbility(ability2);
		// hero2.useAbility(ability2, new StatWrapper[] {
		// hero1.getStatWrapper(), hero2.getStatWrapper() });
		// printHeroInfo(hero1);
		// printHeroInfo(hero2);
		//
		BuffAbility ability3 = new BuffAbility("buff", new ArrayList<Stat>() {
			{
				add(new Stat("Damage", -1, false));
				add(new Stat("Armor", 2, false));
			}
		}, 3);

		hero2.learnAbility(ability3);
		hero2.useAbility(ability3, new StatWrapper[] { hero1.getStatWrapper(), hero2.getStatWrapper() });

		printHeroInfo(hero1);
		printHeroInfo(hero2);
		newTurn();
		newTurn();
		newTurn();
		// newTurn();
		printHeroInfo(hero1);
		printHeroInfo(hero2);

	}

	private static void printHeroInfo(Hero hero) {
		System.out.println(hero.getName());
		System.out.println(hero.getName() + "'s health: " + hero.getStatWrapper().getStatbyName("Health").getCurValue()
				+ " / " + hero.getStatWrapper().getStatbyName("Health").getMaxValue());
		System.out.println(hero.getName() + "'s armor: " + hero.getStatWrapper().getStatbyName("Armor").getCurValue());
		System.out
				.println(hero.getName() + "'s damage: " + hero.getStatWrapper().getStatbyName("Damage").getCurValue());
	}

	private static void printTrinketInfo(Trinket trinket) {
		System.out.println(trinket.getName());
		System.out.print(trinket.getName() + "has:");
		for (Stat c : trinket.getStatWrapper().getStatsasArrayList()) {
			System.out.println(" + " + c.getCurValue() + " " + c.getName());
		}
	}

	private static void printAbilityInfo(Ability ability) {
		System.out.println(ability.getName());
		System.out.println(ability.getDescription());

	}
}
