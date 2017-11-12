package rpg.core.items;

public abstract class Item {
	protected String name;
	protected String description;
	protected int cost;
	protected int maxSpawnQuanitity;
	protected int quantity;
	protected int stackQuantity;

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

	public int getSpawnQuanitity() {
		return maxSpawnQuanitity;
	}

	public void setSpawnQuanitity(int spawnQuanitity) {
		this.maxSpawnQuanitity = spawnQuanitity;
	}

	public int getInventoryFitQuantity() {
		return stackQuantity;
	}

	public void setInventoryFitQuantity(int inventoryFitQuantity) {
		this.stackQuantity = inventoryFitQuantity;
	}

	protected abstract void initItem();

}
