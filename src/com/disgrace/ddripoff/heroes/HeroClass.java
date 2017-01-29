package com.disgrace.ddripoff.heroes;

import java.util.ArrayList;
import java.util.Random;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.characters.shared.CharacterClass;
import com.disgrace.ddripoff.enemies.Enemy;
import com.disgrace.ddripoff.enemies.OutcastKnight;

public enum HeroClass implements CharacterClass{
	CENTURION("Centurion"){
		@Override
		public Hero getCharacterToSpawn() {
			return new Centurion();
		}
	},
	DISHONORED("Dishonored"){
		@Override
		public Hero getCharacterToSpawn() {
			return new Dishonored();			
		}
	},
	PRIEST("Priest"){
		@Override
		public Hero getCharacterToSpawn() {
			return new Priest();
		}	
	}, 
	PURFIER("Purifier"){
		@Override
		public Character getCharacterToSpawn() {
			return new Purifier();
		}	
	};

	private String name;
	private final static Random RANDOM = new Random();
	public static final ArrayList<HeroClass> VALUES = new ArrayList<HeroClass>() {
		{
			add(HeroClass.CENTURION);
			add(HeroClass.DISHONORED);
			add(HeroClass.PRIEST);
			add(HeroClass.PURFIER);
		}
	};
	private static final int SIZE = VALUES.size();

	private HeroClass(String name) {
		this.name = name;
	}

	public static HeroClass getRandomValue() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

	@Override
	public String toString() {
		return name;
	}

	

}
