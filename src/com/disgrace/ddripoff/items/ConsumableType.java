package com.disgrace.ddripoff.items;
import com.disgrace.ddripoff.items.Consumable;
import com.disgrace.ddripoff.items.Food;
import com.disgrace.ddripoff.items.SpawnableItem;

public enum ConsumableType implements SpawnableItem{
FOOD{
	@Override
	public Consumable getItemToSpawn() {
		return new Food();
	}
}
}
