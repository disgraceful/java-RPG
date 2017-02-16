package com.disgrace.ddripoff.spawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PartySpawnPatternEnueration {
	public static final PartySpawnPattern STRONG_DEFAULT = new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG);

	public static final PartySpawnPattern STRONG_FRONT = new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG);

	public static final PartySpawnPattern STRONG_FULL_GLASS = new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG);

	public static final PartySpawnPattern STRONG_MIDDLE = new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG);

	public static final PartySpawnPattern STRONG_BACK = new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.BACK);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG);

	public static final PartySpawnPattern STRONG_FULL_MIDDLE = new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
		}
	}, PartyType.STRONG);

	public static final PartySpawnPattern MID_MIDDLE_ONLY = new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
		}
	}, PartyType.MID);

	public static final PartySpawnPattern MID_MIDDLE = new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.MID);

	public static final PartySpawnPattern MID_BALANCED = new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.MID);

	public static final PartySpawnPattern WEAK_FRONT_ONLY = new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.FRONT);
		}
	}, PartyType.WEAK);

	public static final PartySpawnPattern WEAK_BALANCED = new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
		}
	}, PartyType.WEAK);

	private static final List<PartySpawnPattern> ALL_PATERNS = new ArrayList<PartySpawnPattern>() {
		{
			add(STRONG_DEFAULT);
			add(STRONG_BACK);
			add(STRONG_FRONT);
			add(STRONG_FULL_GLASS);
			add(STRONG_FULL_MIDDLE);
			add(STRONG_MIDDLE);
			add(WEAK_FRONT_ONLY);
			add(WEAK_BALANCED);
			add(MID_MIDDLE);
			add(MID_BALANCED);
			add(MID_MIDDLE_ONLY);
		}
	};

	public static PartySpawnPattern getRandomPatternByStrength(PartyType type) {
		while (true) {
			PartySpawnPattern pattern = ALL_PATERNS.get(new Random().nextInt(ALL_PATERNS.size()));
			if (pattern.getPartyStrength() == type) {
				return pattern;
			}
		}
		
	}
	
	public static PartySpawnPattern getRandomPattern(){
		return ALL_PATERNS.get(new Random().nextInt(ALL_PATERNS.size()));
	}
	
	public static List<PartySpawnPattern>getPatternByStrength(PartyType type){
		 List<PartySpawnPattern> patterns = new ArrayList<>();
		 for(PartySpawnPattern sp : ALL_PATERNS){
			 if(sp.getPartyStrength()==type){
				 patterns.add(sp);
			 }
		 }
		 return patterns;
	}

	enum PartyType {
		STRONG, MID, WEAK;
	}
}
