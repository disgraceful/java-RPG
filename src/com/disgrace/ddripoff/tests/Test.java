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
import com.disgrace.ddripoff.spells.SpellEnum;
import com.disgrace.ddripoff.stats.Stat;

public class Test {

	private static int turnCount;
	private static Party currentParty;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Party goodP = new Party();
		goodP.addMember(new Centurion());
		Party badP = new Party();
		badP.addMember(new OutcastSwordsman());
	
		
		while(!badP.isPartyDead()||!badP.isPartyEmpty()){
			battleTurn(goodP, badP);
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
			for (int i = 0; i < c.getAllSpells().size(); i++) {
				System.out.print(i+1+" - ");
				printAbilityInfo(c.getAllSpells().get(i));
			}
			//int input = sc.nextInt();
			//SpellEnum s = c.getAllSpells().get(input-1);
			SpellEnum s = c.getAllSpells().get(0);
			
			List<Character>targets =  s.getSpellClass().getAvaliableTargets(queue,c);
			for (int i = 0; i <targets.size(); i++) {
				System.out.print(i+1+" - ");
				printCharacterShortInfo(targets.get(i));
			}
			//input= sc.nextInt();
			//Character target = targets.get(input-1);
			Character target = targets.get(0);
			//c.useAbility(c.getAllSpells().get(input - 1), new Character[]{target});
			c.useAbility(c.getAllSpells().get(0), new Character[]{target});
			printCharacterFullInfo(target);
			if(target.isCharDead()){
				target.charDied();
			}
		}
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
		System.out.println(character.getName());
		for (Stat s : character.getStatWrapper().getStatsasArrayList()) {
			System.out.println(character.getName() + "'s " + s.getType().toString() + ": " + s.getCurValue());																								// "/"+s.getMaxValue());
			return;
		}
	
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

