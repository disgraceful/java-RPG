package com.disgrace.ddripoff.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.enemies.OutcastCrossbowman;
import com.disgrace.ddripoff.characters.enemies.OutcastKnight;
import com.disgrace.ddripoff.characters.enemies.OutcastSwordsman;
import com.disgrace.ddripoff.characters.enemies.TestingDummy;
import com.disgrace.ddripoff.characters.heroes.Centurion;
import com.disgrace.ddripoff.characters.heroes.Dishonored;
import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.characters.heroes.HeroClass;
import com.disgrace.ddripoff.characters.heroes.Priest;
import com.disgrace.ddripoff.characters.heroes.Purifier;
import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.dungeon.Desert;
import com.disgrace.ddripoff.dungeon.DungeonBuilder;
import com.disgrace.ddripoff.dungeon.DungeonEventSpawner;
import com.disgrace.ddripoff.dungeon.DungeonSize;
import com.disgrace.ddripoff.items.ConsumableType;
import com.disgrace.ddripoff.items.Item;
import com.disgrace.ddripoff.items.Trinket;
import com.disgrace.ddripoff.main.GameLoader;
import com.disgrace.ddripoff.spawn.CharacterFactory;
import com.disgrace.ddripoff.spawn.ItemFactory;
import com.disgrace.ddripoff.spawn.PartySpawnPatternEnumeration;
import com.disgrace.ddripoff.spawn.PartyType;
import com.disgrace.ddripoff.spells.Spell;
import com.disgrace.ddripoff.spells.TemporaryEffect;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.utils.SaveHelper;

public class Test {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TestEntityDerived e = new TestEntityDerived();
		// e.setAge(13);
		// e.setName("entity1");
		//
		// TestEmbededEntity eslave1 = new TestEmbededEntity();
		// eslave1.setAge(5);
		// eslave1.setName("eslave1");
		// TestEmbededEntity eslave2 = new TestEmbededEntity();
		// eslave2.setAge(99);
		// eslave2.setName("eslave2");
		// TestEmbededEntity eslave3 = new TestEmbededEntity();
		// eslave3.setAge(8);
		// eslave3.setName("eslave3");
		// List<TestEmbededEntity> list = new ArrayList<>();
		// list.add(eslave1);
		// list.add(eslave2);
		// list.add(eslave3);
		// e.setEntities(list);
		// SaveHelper.saveToXml(e, "test");

		Centurion c = new Centurion();
		Dishonored d = new Dishonored();
		Priest pr = new Priest();
		Purifier p = new Purifier();
		OutcastCrossbowman oc = new OutcastCrossbowman();
		OutcastKnight ok = new OutcastKnight();
		OutcastSwordsman os = new OutcastSwordsman();
		SaveHelper.saveCharToXml(oc, "outcast_crossbowman");
		SaveHelper.saveCharToXml(ok, "outcast_knight");
		SaveHelper.saveCharToXml(os, "outcast_swordsman");
		SaveHelper.saveCharToXml(c, "centurion");
		SaveHelper.saveCharToXml(d, "dishonored");
		SaveHelper.saveCharToXml(pr, "priest");
		SaveHelper.saveCharToXml(p, "purifier");
		GameLoader.loadHeroData();
		c = (Centurion) CharacterFactory.spawnCharByClass(Centurion.class);
		printCharacterShortInfo(c);
	}

	@XmlRootElement
	private static abstract class TestEntity {
		private int age;
		private String name;
		private List<TestEmbededEntity> entities;

		@XmlElement
		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@XmlElement
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@XmlElement
		public List<TestEmbededEntity> getEntities() {
			return entities;
		}

		public void setEntities(List<TestEmbededEntity> entities) {
			this.entities = entities;
		}
	}

	@XmlRootElement
	private static class TestEntityDerived extends TestEntity {
		private String kekField;

	}

	@XmlRootElement
	private static class TestEmbededEntity {
		private int age;
		private String name;

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public static void testDungeonBuilder() {
		Desert d = new Desert(DungeonSize.SMALL);
		DungeonBuilder dBuilder = new DungeonBuilder(d);
		dBuilder.build();
		DungeonEventSpawner dSpawner = new DungeonEventSpawner(d);
		dSpawner.generate();
		d.displayEnterablesValue();
	}

	public static void testSpawns() {
		Party p = CharacterFactory.spawnRandomParty();
		System.out.println("Random Party: ");
		printPartyInfo(p);

		Party p2 = CharacterFactory
				.spawnPartyByPattern(PartySpawnPatternEnumeration.getRandomPatternByStrength(PartyType.WEAK));
		System.out.println("Weak Party: ");
		printPartyInfo(p2);
		Hero h = CharacterFactory.spawnRandomHero();
		printCharacterFullInfo(h);
		Hero h1 = (Hero) CharacterFactory.spawnCharByType(HeroClass.CENTURION);
		printCharacterFullInfo(h1);
	}

	public static void testItemSpawning() {
		List<Item> result = ItemFactory.spawnLoot(3);
		Item i = ItemFactory.spawnConcreteItem(ConsumableType.FOOD);
		System.out.println(result);
	}

	public static void testAvaliableMovements() {
		// Party p = new Party();
		// p.addMember(new UberHeroTest("Henry0"));
		// p.addMember(new UberHeroTest("Henry1"));
		// p.addMember(new UberHeroTest("Henry2"));
		// p.addMember(new UberHeroTest("Henry3"));
		// p.getAvaliableMovements(p.getMemberByPos(0));
	}

	public static void testEquipping() {
		// TestTrinketCommon tt = new TestTrinketCommon();
		// UberHeroTest uber = new UberHeroTest("Henry");
		// uber.equip(tt);
		// printCharacterFullInfo(uber);
		// uber.unequip(tt);
		// printCharacterFullInfo(uber);
	}

	public static void initializeCombat() {
		// Party goodP = new Party();
		// goodP.addMember(new UberHeroTest("Hero1"));
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
			// battleTurn(goodP, badP);
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
					tempS.onExpire(c);
					iterator.remove();
				} else {
					tempS.onTick(c);
				}

			}
			if (c.isCharStunned()) {
				continue;
			}
			int input = 0;
			while (true) {
				System.out.println("Choose action: ");
				printCharacterShortInfo(c);
				for (int i = 0; i < c.getAllSpells().size(); i++) {
					System.out.print(i + 1 + " - ");
					printAbilityInfo(c.getAllSpells().get(i));
				}
				boolean ischarAlone = c.getParty().isCharAlone();
				int spellamount = c.getAllSpells().size();
				if (ischarAlone) {
					System.out.println(8 + "- move (not avaliable)");
				} else {
					System.out.println(8 + "- move");
				}
				System.out.println(9 + "- skip");
				input = sc.nextInt();
				if (input == 8 && !ischarAlone) {
					c.getParty().getAvaliableMovements(c).forEach(e -> System.out.println("Move to position #" + e));
					input = sc.nextInt();
					c.move(input);
					continue;
				} else if (input == 8) {
					System.out.println("Not avaliable");
				} else if (input == 9) {
					continue;
				} else if (input > spellamount) {
					System.out.println("Invalid action");
				} else {
					break;
				}
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

	private static void printCharacterFullInfo(Character character) {
		System.out.println(character.getName());
		for (Stat s : character.getStatWrapper().getStatsasArrayList()) {
			System.out.println(character.getName() + "'s " + s.getType().toString() + ": " + s.getCurValue()); // +
																												// "/"+s.getMaxValue());
		}
		System.out.println(character.getName() + "'s position: " + (character.getPosition()));
	}

	private static void printCharacterShortInfo(Character character) {
		System.out.print(
				character.getName() + " " + character.getStats().getStatbyName(StatEnumeration.HEALTH).getCurValue()
						+ "/" + character.getStats().getStatbyName(StatEnumeration.HEALTH).getMaxValue());
		System.out.println(" position: " + (character.getPosition()));

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
