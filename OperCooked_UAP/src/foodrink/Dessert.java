package foodrink;

public class Dessert extends FoodDrink {

	private String topping;
	private float calories;
	
	public Dessert(String name, String type, int price, int cookingtime, String topping, float calories) {
		super(name, type, price, cookingtime);
		this.topping = topping;
		this.calories = calories;
	}
	
	public String getTopping() {
		return topping;
	}
	public void setTopping(String topping) {
		this.topping = topping;
	}
	public float getCalories() {
		return calories;
	}
	public void setCalories(float calories) {
		this.calories = calories;
	}
	
	@Override
	public void run() {
		while(getCookingtime() > 0) {
			
			setCookingtime(getCookingtime() - 1);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
