package rpg.core.items;

public interface SpawnableItem {
	public Item getItemToSpawn();
	public Item getItemByRarity(ItemRarity rarity);
}
