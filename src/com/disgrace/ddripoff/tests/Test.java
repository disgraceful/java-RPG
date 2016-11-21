package com.disgrace.ddripoff.tests;

import java.util.Iterator;

import com.disgrace.ddripoff.abilities.Ability;
import com.disgrace.ddripoff.abilities.ITemporaryEffect;
import com.disgrace.ddripoff.characters.Character;
import com.disgrace.ddripoff.characters.Party;
import com.disgrace.ddripoff.dungeon.Desert;
import com.disgrace.ddripoff.dungeon.DungeonBuilder;
import com.disgrace.ddripoff.dungeon.DungeonSize;
import com.disgrace.ddripoff.heroes.Hero;
import com.disgrace.ddripoff.items.Trinket;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatWrapper;

public class Test {

	private static int turnCount;
	private static Party currentParty;

	public static void main(String[] args) {
		// TestTown.testCoach();
		 TestDungeon.testDung();
		//Desert d = new Desert(DungeonSize.SMALL);
		//DungeonBuilder db = new DungeonBuilder(d);
		//db.build();
		//d.displayRooms();
		
		
		
	}
	
	
	
	
	

	/**
	 * need to test that shit
	 */
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

	// private static void test() {
	// Hero hero1 = new Hero("Hero1", new ArrayList<Stat>() {
	// {
	// add(new Stat(StatEnumeration.HEALTH, 10, 10));
	// add(new Stat(StatEnumeration.Armor, 2, 10));
	// add(new Stat(StatEnumeration.DAMAGE, 5, 100));
	// add(new Stat(StatEnumeration.SPEED, 3, 20));
	// }
	// });
	// hero1.getStatWrapper().setOwner(hero1);
	// Hero hero2 = new Hero("Hero2", new ArrayList<Stat>() {
	// {
	// add(new Stat(StatEnumeration.HEALTH, 20, 20));
	// add(new Stat(StatEnumeration.Armor, 5, 10));
	// add(new Stat(StatEnumeration.DAMAGE, 1, 100));
	// add(new Stat(StatEnumeration.SPEED, 1, 100));
	// add(new Stat(StatEnumeration.BLEEDRES, 0, 100));
	// add(new Stat(StatEnumeration.STUNRES, 20, 100));
	// }
	// });
	// hero2.getStatWrapper().setOwner(hero2);

	// currentParty = new Party();
	// currentParty.addMember(hero1);
	// currentParty.addMember(hero2, 0);
	// printPartyInfo(currentParty);
	//
	// DotAbility dot = new DotAbility("stun", new ArrayList<Stat>() {
	// {
	// add(new Stat(StatEnumeration.Health, 0, false));
	// }
	// }, 1, TemporaryEffect.Stun);
	//
	// hero1.learnAbility(dot);
	// hero1.useAbility(dot, new StatWrapper[] { hero2.getStatWrapper() });
	//
	//
	// MoveAbility move = new MoveAbility("Move shit", new ArrayList<Stat>(){
	// {
	// add(new Stat(StatEnumeration.POSITION,-1,4));
	// }
	// });
	//
	// hero1.learnAbility(move);
	// hero1.useAbility(move, new StatWrapper[]{hero1.getStatWrapper()});
	//
	// printPartyInfo(currentParty);
	// newTurn();
	// newTurn();
	// printHeroInfo(hero2);
	// newTurn();
	// printHeroInfo(hero2);
	//
	// }

	private static void printHeroInfo(Hero hero) {
		System.out.println(hero.getName());
		for (Stat s : hero.getStatWrapper().getStatsasArrayList()) {
			System.out.println(hero.getName() + "'s " + s.getType().toString() + ": " + s.getCurValue()); // +
																											// "/"+s.getMaxValue());
		}
		System.out.println(hero.getName() + "'s position: " + hero.getPosition());
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
