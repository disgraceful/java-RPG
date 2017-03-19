package com.disgrace.ddripoff.spawn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum PartySpawnPatternEnumeration {

	STRONG_DEFAULT(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG)), STRONG_FRONT(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG)), STRONG_FULL_GLASS(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG)), STRONG_MIDDLE(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG)),

	STRONG_BACK(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.BACK);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG)),

	STRONG_FULL_MIDDLE(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
		}
	}, PartyType.STRONG)), MID_MIDDLE_ONLY(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
		}
	}, PartyType.MID)),

	MID_MIDDLE(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.MID)),

	MID_BALANCED(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.MID)),

	WEAK_FRONT_ONLY(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.FRONT);
		}
	}, PartyType.WEAK)),

	WEAK_BALANCED(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
		}
	}, PartyType.WEAK));

	private PartySpawnPattern pattern;

	public PartySpawnPattern getPattern() {
		return pattern;
	}

	private PartySpawnPatternEnumeration(PartySpawnPattern pattern) {
		this.pattern = pattern;
	}

	public static PartySpawnPattern getRandomPatternByStrength(PartyType type) {
		List<PartySpawnPatternEnumeration> list = Arrays.asList(values());
		Collections.shuffle(list);
		 PartySpawnPattern pat =list.stream().filter(p -> p.pattern.getPartyStrength() == type).findFirst().get().getPattern();
		 return pat;
	}
	
	public static PartySpawnPattern getRandomPattern() {
		return values()[new Random().nextInt(values().length)].getPattern();
	}

	
}
