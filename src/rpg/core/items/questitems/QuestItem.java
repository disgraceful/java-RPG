package rpg.core.items.questitems;

import rpg.core.items.Item;

public abstract class QuestItem extends Item {
	
	@Override
	protected void initItem() {
		stackQuantity = 1;
	}

}
