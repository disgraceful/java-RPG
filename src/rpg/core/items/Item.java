package rpg.core.items;

public abstract class Item {
	protected String name;
	protected String description;
	protected int cost;
	protected int stackQuantity;
	protected int quantityMultiplier;
	protected int maxSpawnedQuantity;
	protected SpawnableItem itemType;
	protected ItemRarity rarity;

	public String getName() {
		return name;
	}

	void setName(String value) {
		name = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getStackQuantity() {
		return stackQuantity;
	}

	public void setStackQuantity(int stackQuantity) {
		this.stackQuantity = stackQuantity;
	}
	
	public int getQuantityMultiplier() {
		return quantityMultiplier;
	}

	public void setQuantityMultiplier(int quantityMultiplier) {
		this.quantityMultiplier = quantityMultiplier;
	}
	
	public int getMaxSpawnedQuantity() {
		return maxSpawnedQuantity;
	}

	public void setMaxSpawnedQuantity(int maxSpawnedQuantity) {
		this.maxSpawnedQuantity = maxSpawnedQuantity;
	}
	
	public SpawnableItem getItem() {
		return itemType;
	}

	public void setItem(SpawnableItem item) {
		this.itemType = item;
	}

	public ItemRarity getRarity() {
		return rarity;
	}

	public void setRarity(ItemRarity rarity) {
		this.rarity = rarity;
	}

	protected abstract void initItem();

}
