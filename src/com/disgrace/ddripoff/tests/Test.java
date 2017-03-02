package com.disgrace.ddripoff.tests;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang.SerializationUtils;

import com.disgrace.ddripoff.characters.enemies.TestingDummy;
import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.characters.heroes.HeroClass;
import com.disgrace.ddripoff.characters.heroes.UberHeroTest;
import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.items.Trinket;
import com.disgrace.ddripoff.spells.Spell;
import com.disgrace.ddripoff.spells.TemporaryEffect;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;

public class Test {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// testSpawns();
		initializeCombat();
	}

	public static void initializeCombat() {
		Party goodP = new Party();
		goodP.addMember(new UberHeroTest("Hero1"));
		// goodP.addMember(new UberHeroTest("Hero2"));
		// goodP.addMember(new UberHeroTest("Hero3"));
		// goodP.addMember(new UberHeroTest("Hero4"));
		Party badP = new Party();
		badP.addMember(new TestingDummy("Dum1"));
		// badP.addMember(new TestingDummy("Dum2"));
		// badP.addMember(new TestingDummy("Dum3"));
		// badP.addMember(new TestingDummy("Dum4"));
		int turnCount = 1;

		while (!badP.isPartyDead() || !badP.isPartyEmpty()) {
			System.out.println("Turn #" + turnCount);
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
			System.out.println(c.getName());
			for (Iterator<TemporaryEffect> iterator = c.getTempEffects().iterator(); iterator.hasNext();) {
				TemporaryEffect tempS = iterator.next();
				System.out.println(tempS.toString() + " time left: " + tempS.getCurrentDuration());
				if (tempS.isExpired()) {
					iterator.remove();
				}
				tempS.onTick(c);
			}
			if (c.isCharStunned()) {
				continue;
			}
			printCharacterShortInfo(c);
			for (int i = 0; i < c.getAllSpells().size(); i++) {
				System.out.print(i + 1 + " - ");
				printAbilityInfo(c.getAllSpells().get(i));
			}
			System.out.println(9 + "- skip");
			int input = sc.nextInt();
			if (input == 9) {
				continue;
			}
			Spell s = c.getAllSpells().get(input - 1);

			List<Character> targets = s.getAvaliableTargets(c, queue);
			for (int i = 0; i < targets.size(); i++) {
				System.out.print(i + 1 + " - ");
				printCharacterShortInfo(targets.get(i));
			}
			input = sc.nextInt();
			Character target = targets.get(input - 1);
			if (s.isSpellAOE()) {
				c.useAbility(s, targets.toArray(new Character[targets.size()]));
				targets.stream().forEach(e -> printCharacterFullInfo(e));
			} else {
				c.useAbility(s, target);
				printCharacterFullInfo(target);
			}
			targets.stream().forEach(e -> {
				if (e.isCharDead())
					e.charDied();
			});
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
		System.out.println(character.getName() + "'s position: " + (character.getPosition() + 1));
	}

	private static void printCharacterShortInfo(Character character) {
		System.out.print(
				character.getName() + " " + character.getStats().getStatbyName(StatEnumeration.HEALTH).getCurValue()
						+ "/" + character.getStats().getStatbyName(StatEnumeration.HEALTH).getMaxValue());
		System.out.println(" position: " + (character.getPosition() + 1));

	}

	private static void printTrinketInfo(Trinket trinket) {
		System.out.println(trinket.getName());
		System.out.print(trinket.getName() + "has:");
		for (Stat c : trinket.getStatWrapper().getStatsasArrayList()) {
			System.out.println(" + " + c.getCurValue() + " " + c.getType());
		}
	}

	private static void printAbilityInfo(Spell spell) {
		System.out.println(spell.getName());
		System.out.println(spell.getDescription());

	}

	private static void printPartyInfo(Party party) {
		for (Character c : party.getMembers()) {
			System.out.println(c.getName() + " " + party.getPosition(c));
		}
	}
}
