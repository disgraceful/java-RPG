package rpg.core.tests;

import org.junit.Before;
import org.junit.Test;

import rpg.core.factories.LootFactory;
import rpg.core.items.Loot;
import rpg.core.items.treasure.TreasureType;
import rpg.core.session.DungeonSessionInventory;

public class DungeonSessionInventoryTests {

	private DungeonSessionInventory inventory;

	@Before
	public void init() {
		inventory = new DungeonSessionInventory();
	}

	public void testLootAdding() {
		Loot loot1 = LootFactory.spawnSpecificLoot(1600, TreasureType.GOLD);
		inventory.addLoot(loot1);
		inventory.displayInventory();
	}

	@Test
	public void testLootAdding2() {
		Loot loot1 = LootFactory.spawnSpecificLoot(1600, TreasureType.GOLD);
		inventory.addLoot(loot1);
		inventory.displayInventory();
		Loot loot2 = LootFactory.spawnSpecificLoot(10, TreasureType.BATTLE_TROPHIES);
		inventory.addLoot(loot2);
		inventory.displayInventory();
		Loot loot3 = LootFactory.spawnSpecificLoot(22, TreasureType.BATTLE_TROPHIES);
		inventory.addLoot(loot3);
		inventory.displayInventory();
		Loot loot4 = LootFactory.spawnSpecificLoot(new int[]{5,1500}, TreasureType.BATTLE_TROPHIES,TreasureType.GOLD);
		inventory.addLoot(loot4);
		inventory.displayInventory();
	}
}
