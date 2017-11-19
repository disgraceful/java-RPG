package rpg.core.items.questitems;

import rpg.core.items.Item;
import rpg.core.items.ItemRarity;
import rpg.core.items.SpawnableItem;

public enum QuestItemType implements SpawnableItem {
	HEAD_OF_THE_BLACK_PIT_MOTHER {
		@Override
		public Item getItemToSpawn() {
			return new HeadOfTheBlackPitMother();
		}

	},
	HEAD_OF_THE_EXECUTIONER {
		@Override
		public Item getItemToSpawn() {
			return new HeadOfTheExecutioner();
		}

	},
	HEAD_OF_THE_LAST_ELDER {
		@Override
		public Item getItemToSpawn() {
			return new HeadOfTheLastElder();
		}

	},
	HEAD_OF_THE_ROYAL_TWINS {
		@Override
		public Item getItemToSpawn() {
			return new HeadsOfTheRoyalTwins();
		}

	},
	MEDALLION_OF_THE_TRANSGRESSOR {
		@Override
		public Item getItemToSpawn() {
			return new MedallionOfTheTransgressor();
		}

	};

	@Override
	public Item getItemByRarity(ItemRarity rarity) {
		return null;
	}
}
