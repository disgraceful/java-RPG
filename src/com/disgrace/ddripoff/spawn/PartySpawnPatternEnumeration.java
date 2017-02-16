package com.disgrace.ddripoff.spawn;

import java.util.ArrayList;
import java.util.Arrays;

public enum PartySpawnPatternEnumeration {

	STRONG_DEFAULT(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
		add(EnemySpawnType.FRONT);
		add(EnemySpawnType.MIDDLE);
		add(EnemySpawnType.MIDDLE);
		add(EnemySpawnType.BACK);
	}
}, PartyType.STRONG)),
	STRONG_FRONT(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}, PartyType.STRONG)),
	 STRONG_FULL_GLASS(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
			{
				add(EnemySpawnType.MIDDLE);
				add(EnemySpawnType.MIDDLE);
				add(EnemySpawnType.BACK);
				add(EnemySpawnType.BACK);
			}
		}, PartyType.STRONG)),
	 STRONG_MIDDLE(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
			{
				add(EnemySpawnType.MIDDLE);
				add(EnemySpawnType.MIDDLE);
				add(EnemySpawnType.MIDDLE);
				add(EnemySpawnType.BACK);
			}
		}, PartyType.STRONG)),

	 STRONG_BACK (new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
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
	}, PartyType.STRONG)),
	MID_MIDDLE_ONLY (new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
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
	
	WEAK_BALANCED (new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
		}
	}, PartyType.WEAK));
	
	private PartySpawnPattern pattern;
	private PartySpawnPatternEnumeration(PartySpawnPattern pattern){
		this.pattern = pattern;
	}
	


//public static PartySpawnPatternEnumeration getRandomPatternByStrength(PartyType type) {
//		return Arrays.asList(values()).stream().(p->p.pattern.getPartyStrength()==type);
//	}
//	

//	public static PartySpawnPattern getRandomPattern(){
//		return ALL_PATERNS.get(new Random().nextInt(ALL_PATERNS.size()));
//	}
//	
//	public static List<PartySpawnPattern>getPatternByStrength(PartyType type){
//		 List<PartySpawnPattern> patterns = new ArrayList<>();
//		 for(PartySpawnPattern sp : ALL_PATERNS){
//			 if(sp.getPartyStrength()==type){
//				 patterns.add(sp);
//			 }
//		 }
//		 return patterns;
//	}

	enum PartyType {
		STRONG, MID, WEAK;
	}
}
