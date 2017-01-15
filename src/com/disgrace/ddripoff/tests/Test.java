package com.disgrace.ddripoff.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.enemies.OutcastSwordsman;
import com.disgrace.ddripoff.heroes.Centurion;
import com.disgrace.ddripoff.items.Trinket;
import com.disgrace.ddripoff.spells.Spell;
import com.disgrace.ddripoff.spells.SpellEnum;
import com.disgrace.ddripoff.stats.Stat;

public class Test {

	private static int turnCount;
	private static Party currentParty;

	public static void main(String[] args) {
		Party goodP = new Party();
		goodP.addMember(new Centurion());
		Party badP = new Party();
		badP.addMember(new OutcastSwordsman());
		while(badP.isPartyDead()){
			battleTurn(goodP, badP);
		}
		
	}

	public static void battleTurn(Party good, Party bad) {
		Scanner sc = new Scanner(System.in);
		List<Character> queue = new ArrayList<>();
		queue.addAll(good.getMembers());
		queue.addAll(bad.getMembers());

		Collections.sort(queue);
		for (Character c : queue) {
			printCharacterInfo(c);
			for(SpellEnum spell:c.getAllSpells()){
				System.out.print("1 - ");
				printAbilityInfo(spell.getSpellClass());
			}
			int i = sc.nextInt();
			SpellEnum s = c.getAllSpells().get(i-1);
			
			List<Character>targets =  s.getSpellClass().getAvaliableTargets(queue,c);
			for(Character target :targets){
				System.out.print("1 - ");
				printCharacterInfo(target);
			}
			int j = sc.nextInt();
			c.useAbility(c.getAllSpells().get(i - 1), new Character[]{targets.get(j-1)});
		}
	}

	private static void printCharacterInfo(Character character) {
		System.out.println(character.getName());
		for (Stat s : character.getStatWrapper().getStatsasArrayList()) {
			System.out.println(character.getName() + "'s " + s.getType().toString() + ": " + s.getCurValue()); // +
																												// "/"+s.getMaxValue());
		}
		System.out.println(character.getName() + "'s position: " + character.getPosition());
	}

	private static void printTrinketInfo(Trinket trinket) {
		System.out.println(trinket.getName());
		System.out.print(trinket.getName() + "has:");
		for (Stat c : trinket.getStatWrapper().getStatsasArrayList()) {
			System.out.println(" + " + c.getCurValue() + " " + c.getType());
		}
	}

	 private static void printAbilityInfo(Spell ability) {
	 System.out.println(ability.getName());
	 System.out.println(ability.getDescription());
	 
	 }

	private static void printPartyInfo(Party party) {
		for (Character c : party.getMembers()) {
			System.out.println(c.getName() + " " + party.getPosition(c));
		}
	}
}
