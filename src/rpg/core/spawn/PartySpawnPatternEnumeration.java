package rpg.core.spawn;

import java.util.ArrayList;
import java.util.Random;

public enum PartySpawnPatternEnumeration {

	STRONG_DEFAULT(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	}))

	, STRONG_FRONT(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	})), STRONG_FULL_GLASS(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
			add(EnemySpawnType.BACK);
		}
	})), STRONG_MIDDLE(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	})),

	STRONG_BACK(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.BACK);
			add(EnemySpawnType.BACK);
		}
	})),

	STRONG_FULL_MIDDLE(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
		}
	})), MID_MIDDLE_ONLY(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
		}
	})),

	MID_MIDDLE(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	})),

	MID_BALANCED(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
			add(EnemySpawnType.BACK);
		}
	})),

	WEAK_FRONT_ONLY(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.FRONT);
		}
	})),

	WEAK_BALANCED(new PartySpawnPattern(new ArrayList<EnemySpawnType>() {
		{
			add(EnemySpawnType.FRONT);
			add(EnemySpawnType.MIDDLE);
		}
	}));

	private PartySpawnPattern pattern;

	public PartySpawnPattern getPattern() {
		return pattern;
	}

	private PartySpawnPatternEnumeration(PartySpawnPattern pattern) {
		this.pattern = pattern;
	}

	public static PartySpawnPattern getRandomPattern() {
		return values()[new Random().nextInt(values().length)].getPattern();
	}

}
