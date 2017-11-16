package rpg.core.items;

public enum LootType {

	SMALL_LOOT(1000), MEDIUM_LOOT(2500), LARGE_LOOT(5000);

	private int goldEqv;

	private LootType(int goldEqv) {
		this.goldEqv = goldEqv;
	}

	public int getGoldEqv() {
		return goldEqv;
	}
}
