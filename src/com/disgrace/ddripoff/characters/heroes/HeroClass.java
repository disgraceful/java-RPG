package com.disgrace.ddripoff.characters.heroes;

import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.shared.CharClass;

@XmlRootElement
public enum HeroClass implements CharClass {
	CENTURION {
		@Override
		public Class<Centurion> getClassToSpawn() {
			return Centurion.class;
		}
	},
	DISHONORED {
		@Override
		public Class<Dishonored> getClassToSpawn() {
			return Dishonored.class;
		}
	},
	PRIEST {
		@Override
		public Class<Priest> getClassToSpawn() {
			return Priest.class;
		}
	},
	PURFIER {
		@Override
		public Class<Purifier> getClassToSpawn() {
			return Purifier.class;
		}
	};

	public static HeroClass getRandomValue() {
		return values()[new Random().nextInt(values().length)];
	}

}
