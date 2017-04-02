package com.disgrace.ddripoff.characters.heroes;

import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.characters.shared.SpawnableChar;
@XmlRootElement
public enum HeroClass implements SpawnableChar{
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
		public Hero getCharacterToSpawn() {
			return new Purifier();
		}	
	};

	private String name;

	private HeroClass(String name) {
		this.name = name;
	}

	public static HeroClass getRandomValue() {
		return values()[new Random().nextInt(values().length)];
	}

	@Override
	public String toString() {
		return name;
	}

	

}
