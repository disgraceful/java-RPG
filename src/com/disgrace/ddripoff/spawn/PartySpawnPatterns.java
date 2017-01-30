package com.disgrace.ddripoff.spawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PartySpawnPatterns {
	public static final SpawnPattern STRONG_DEFAULT = new SpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG);

	public static final SpawnPattern STRONG_FRONT = new SpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG);

	public static final SpawnPattern STRONG_FULL_GLASS = new SpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG);

	public static final SpawnPattern STRONG_MIDDLE = new SpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG);

	public static final SpawnPattern STRONG_BACK = new SpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.BACK);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG);

	public static final SpawnPattern STRONG_FULL_MIDDLE = new SpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
		}
	}, PartyType.STRONG);

	public static final SpawnPattern MID_MIDDLE_ONLY = new SpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
		}
	}, PartyType.MID);

	public static final SpawnPattern MID_MIDDLE = new SpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.MID);

	public static final SpawnPattern MID_BALANCED = new SpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.MID);

	public static final SpawnPattern WEAK_FRONT_ONLY = new SpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.FRONT);
		}
	}, PartyType.WEAK);

	public static final SpawnPattern WEAK_BALANCED = new SpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
		}
	}, PartyType.WEAK);

	private static final List<SpawnPattern> ALL_PATERNS = new ArrayList<SpawnPattern>() {
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

	public static SpawnPattern getRandomPatternByStrength(PartyType type) {
		while (true) {
			SpawnPattern pattern = ALL_PATERNS.get(new Random().nextInt(ALL_PATERNS.size()));
			if (pattern.getPartyStrength() == type) {
				return pattern;
			}
		}
		
	}
	
	public static SpawnPattern getRandomPattern(){
		return ALL_PATERNS.get(new Random().nextInt(ALL_PATERNS.size()));
	}
	
	public static List<SpawnPattern>getPatternByStrength(PartyType type){
		 List<SpawnPattern> patterns = new ArrayList<>();
		 for(SpawnPattern sp : ALL_PATERNS){
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
