package com.disgrace.ddripoff.spawn;

import com.disgrace.ddripoff.items.Item;
import com.disgrace.ddripoff.items.ItemType;

public class ItemFactory {

	public static Item getItem(ItemType item){
 		return item.getItemToSpawn();
	}
}
