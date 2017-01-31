package com.disgrace.ddripoff.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.disgrace.ddripoff.characters.enemies.OutcastSwordsman;
import com.disgrace.ddripoff.characters.enemies.TestingDummy;
import com.disgrace.ddripoff.characters.heroes.Centurion;
import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.characters.heroes.HeroClass;
import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.items.Trinket;
import com.disgrace.ddripoff.spawn.SpawnPattern;
import com.disgrace.ddripoff.spells.Spell;
import com.disgrace.ddripoff.spells.SpellEnum;
import com.disgrace.ddripoff.spells.TemporarySpell;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;

public class Test {

	private static int turnCount;
	private static Party currentParty;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// testSpawns();
		initializeCombat();
	}

	public static void initializeCombat() {
		Party goodP = new Party();
		goodP.addMember(new Centurion());
		Party badP = new Party();
		badP.addMember(new TestingDummy("Dum1"));
		badP.addMember(new TestingDummy("Dum2"));
		badP.addMember(new TestingDummy("Dum3"));
		badP.addMember(new TestingDummy("Dum4"));
		int turnCount =1;
		while (!badP.isPartyDead() || !badP.isPartyEmpty()) {
			System.out.println("Turn #"+turnCount);
			battleTurn(goodP, badP);
			turnCount++;
		}
	}

	public static void battleTurn(Party good, Party bad) {
		List<Character> queue = new ArrayList<>();
		queue.addAll(good.getMembers());
		queue.addAll(bad.getMembers());
		
		Collections.sort(queue);
		for (Character c : queue) {
			System.out.println("Turn of: ");
			printCharacterShortInfo(c);
			for (Iterator iterator = c.getEffectsList().iterator(); iterator.hasNext();) {
				TemporarySpell tempS = (TemporarySpell) iterator.next();
				if (tempS.isExpired()) {
					iterator.remove();
				}
				tempS.onTick(c);
			}
			if (c.isCharStunned()) {
				continue;
			}
			for (int i = 0; i < c.getAllSpells().size(); i++) {
				System.out.print(i + 1 + " - ");
				printAbilityInfo(c.getAllSpells().get(i));
			}
			System.out.println(9 + "- skip");
			int input = sc.nextInt();
			if (input == 9) {
				continue;
			}
			SpellEnum s = c.getAllSpells().get(input - 1);
			// SpellEnum s = c.getAllSpells().get(0);

			List<Character> targets = s.getSpellClass().getAvaliableTargets(queue, c);
			for (int i = 0; i < targets.size(); i++) {
				System.out.print(i + 1 + " - ");
				printCharacterShortInfo(targets.get(i));
			}
			input= sc.nextInt();
			Character target = targets.get(input-1);
			//Character target = targets.get(0);
			c.useAbility(s, new Character[] { target });
			printCharacterFullInfo(target);
			if (target.isCharDead()) {
				target.charDied();
			}
		}
	}

	public static void testSpawns() {
		Party p = Party.spawnRandomParty();
		p.getMembers().stream().forEach(c -> printCharacterShortInfo(c));

		Hero h1 = (Hero) Hero.spawn(HeroClass.CENTURION);
		Hero h2 = (Hero) Hero.spawn(HeroClass.DISHONORED);
		Hero h3 = (Hero) Hero.spawn(HeroClass.PRIEST);
		Hero h4 = (Hero) Hero.spawn(HeroClass.PURFIER);
		printCharacterShortInfo(h1);
		printCharacterShortInfo(h2);
		printCharacterShortInfo(h3);
		printCharacterShortInfo(h4);
	}

	private static void printCharacterFullInfo(Character character) {
		System.out.println(character.getName());
		for (Stat s : character.getStatWrapper().getStatsasArrayList()) {
			System.out.println(character.getName() + "'s " + s.getType().toString() + ": " + s.getCurValue()); // +
																												// "/"+s.getMaxValue());
		}
		System.out.println(character.getName() + "'s position: " + character.getPosition());
	}

	private static void printCharacterShortInfo(Character character) {
		System.out.println(
				character.getName() + " " + character.getStats().getStatbyName(StatEnumeration.HEALTH).getCurValue()
						+ "/" + character.getStats().getStatbyName(StatEnumeration.HEALTH).getMaxValue());

	}

	private static void printTrinketInfo(Trinket trinket) {
		System.out.println(trinket.getName());
		System.out.print(trinket.getName() + "has:");
		for (Stat c : trinket.getStatWrapper().getStatsasArrayList()) {
			System.out.println(" + " + c.getCurValue() + " " + c.getType());
		}
	}

	private static void printAbilityInfo(SpellEnum spell) {
		System.out.println(spell.getName());
		System.out.println(spell.getDescription());

	}

	private static void printPartyInfo(Party party) {
		for (Character c : party.getMembers()) {
			System.out.println(c.getName() + " " + party.getPosition(c));
		}
	}
}
