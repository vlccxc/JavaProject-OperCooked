package foodrink;

public abstract class FoodDrink implements Runnable {
	
	private String name;
	private String type;
	private int price;
	private int cookingtime;
	
	public FoodDrink(String name, String type, int price, int cookingtime) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.cookingtime = cookingtime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCookingtime() {
		return cookingtime;
	}

	public void setCookingtime(int cookingtime) {
		this.cookingtime = cookingtime;
	}

	@Override
	public abstract void run();
}
