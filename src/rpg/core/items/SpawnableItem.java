package rpg.core.items;

@FunctionalInterface
public interface SpawnableItem {
	public  Item getItemToSpawn();
}
