package rpg.core.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import rpg.core.characters.enemies.OutcastCrossbowman;
import rpg.core.characters.enemies.OutcastKnight;
import rpg.core.characters.enemies.OutcastSwordsman;
import rpg.core.characters.enemies.TestingDummy;
import rpg.core.characters.heroes.classes.Centurion;
import rpg.core.characters.heroes.classes.Dishonored;
import rpg.core.characters.heroes.classes.Priest;
import rpg.core.characters.heroes.classes.Purifier;
import rpg.core.characters.heroes.classes.UberHeroTest;
import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Party;
import rpg.core.dungeon.Desert;
import rpg.core.dungeon.DungeonBuilder;
import rpg.core.dungeon.DungeonEventSpawner;
import rpg.core.dungeon.DungeonSize;
import rpg.core.hub.MercenaryCoach;
import rpg.core.items.Item;
import rpg.core.items.consumables.ConsumableType;
import rpg.core.spawn.ItemFactory;
import rpg.core.spells.Spell;
import rpg.core.spells.TemporaryEffect;
import rpg.core.utils.SaveHelper;
import rpg.core.utils.TextUtils;

public final class Test {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// initializeCombat();
		// testXml();

	}

	public static void testXml() {
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
		MercenaryCoach coach = new MercenaryCoach();
		coach.spawnVenturers();
		SaveHelper.saveToExtrasToXml(coach, "example");
		coach = (MercenaryCoach) SaveHelper.loadExtraFromXml("example", MercenaryCoach.class);
	}

	public static void initializeCombat() {
		Party goodP = new Party();
		goodP.addMember(new UberHeroTest() {
			@Override
			public String getName() {
				return "Henry1";
			}
		});
		goodP.addMember(new UberHeroTest() {
			@Override
			public String getName() {
				return "Henry2";
			}
		});
		goodP.addMember(new UberHeroTest() {
			@Override
			public String getName() {
				return "Henry3";
			}
		});
		goodP.addMember(new UberHeroTest() {
			@Override
			public String getName() {
				return "Henry4";
			}
		});
		Party badP = new Party();
		badP.addMember(new TestingDummy("Dum1"));
		badP.addMember(new TestingDummy("Dum2"));
		badP.addMember(new TestingDummy("Dum3"));
		badP.addMember(new TestingDummy("Dum4"));
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
				TextUtils.printCharacterShortInfo(c);
				for (int i = 0; i < c.getAllAbilities().size(); i++) {
					System.out.print(i + 1 + " - ");
					TextUtils.printAbilityInfo(c.getAllAbilities().get(i));
				}
				boolean ischarAlone = c.getParty().isCharAlone();
				int spellamount = c.getAllAbilities().size();
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
					break;
				} else if (input > spellamount) {
					System.out.println("Invalid action");
				} else {
					break;
				}
			}

			Spell s = c.getAllAbilities().get(input - 1);

			List<Character> targets = s.getAvaliableTargets(c, queue);
			for (int i = 0; i < targets.size(); i++) {
				System.out.print(i + 1 + " - ");
				TextUtils.printCharacterShortInfo(targets.get(i));
			}
			input = sc.nextInt();
			Character target = targets.get(input - 1);
			if (s.isSpellAOE()) {
				c.useAbility(s, targets.toArray(new Character[targets.size()]));
				targets.stream().forEach(e -> TextUtils.printCharacterFullInfo(e));
			} else {
				c.useAbility(s, target);
				TextUtils.printCharacterFullInfo(target);
			}
			targets.stream().forEach(e -> {
				if (e.isCharDead())
					e.charDied();
			});
		}
	}

}
