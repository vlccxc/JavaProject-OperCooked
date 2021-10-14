package foodrink;

public class Beverage extends FoodDrink {

	private String flavor;
	private String size;
	
	public Beverage(String name, String type, int price, int cookingtime, String flavor, String size) {
		super(name, type, price, cookingtime);
		this.flavor = flavor;
		this.size = size;
	}
	
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
