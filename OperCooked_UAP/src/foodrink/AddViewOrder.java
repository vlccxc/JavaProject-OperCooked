package foodrink;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import main.Splash;

public class AddViewOrder {
	Scanner scan = new Scanner(System.in);
	Vector<FoodDrink> foodrinklist = new Vector<FoodDrink>();
	Vector<FoodDrink> orderlist = new Vector<FoodDrink>();
	Vector<FoodDrink> historylist = new Vector<FoodDrink>();
	Vector<String> ordertime = new Vector<String>();
	Random rand = new Random();
	
	Splash splash = new Splash();
	
	int profit = 0;
	public void Profit() {
		System.out.println("Welcome to OperCooked");
		System.out.println("Today Profit : $ " + profit);
		System.out.println("==============================");
	}
	
	String OrderTime;
	public void DateTime() {
		LocalDateTime DateTime = LocalDateTime.now();
		DateTimeFormatter DateFormat = DateTimeFormatter.ofPattern("yyyy/mm/dd hh:mm:ss");
		OrderTime = DateTime.format(DateFormat);
	}
	
	String name;
	int price;
	public void FoodDrink() {
		
		splash.clear();
		
		do {
			System.out.print("Input the name [at least 5 characters]: ");
			name = scan.nextLine();
		}while(name.length() < 5);
		
		do {
			System.out.print("Input the price [10-500]: $ ");
			try {
				price = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				price = 0;
			}
		}while(price < 10 || price > 500);
		
	}
	
	String topping;
	float calories;
	int cooktime;
	String type;
	public void Dessert() {
		FoodDrink();
		
		type = "Dessert";
		
		do {
			System.out.print("Input the topping ['Caramel' | 'Honey' | 'Syrup](Case Insensitive): ");
			topping = scan.nextLine();
		}while(!topping.equalsIgnoreCase("Caramel") && !topping.equalsIgnoreCase("Honey") && !topping.equalsIgnoreCase("Syrup"));
		
		do {
			System.out.print("Insert calories [1.00 - 99.00]: ");
			try {
				calories = scan.nextFloat();
			} catch (Exception e) {
				calories = 0;
			}
		}while(calories < 1.00 || calories > 99.00);
		
		cooktime = rand.nextInt(41) + 50;
		
		if(topping.equalsIgnoreCase("Caramel")) cooktime += 10;
		else if(topping.equalsIgnoreCase("Honey")) cooktime += 15;
		else cooktime += 20;
		
		FoodDrink foodrink = new Dessert(name, type, price, cooktime, topping, calories);
		foodrinklist.add(foodrink);
		
		System.out.println();
		System.out.println("Successfully added a new menu!");
		
		splash.enter();
	}
	
	String flavor;
	String size;
	public void Drink() {
		FoodDrink();
		
		type = "Drink";
		
		do {
			System.out.print("Input the name ['Mint' | 'Mix Berry' | 'Cheese'](Case Sensitive): ");
			flavor = scan.nextLine();
		}while(!flavor.equals("Mint") && !flavor.equals("Mix Berry") && !flavor.equals("Cheese"));
		
		do {
			System.out.print("Input the size [S | M | L](Case Sensitive): ");
			size = scan.nextLine();
		}while(!size.equals("S") && !size.equals("M") && !size.equals("L"));
		
		cooktime = rand.nextInt(41) + 10; 
		
		if(flavor.equalsIgnoreCase("Mint")) cooktime += 10;
		else if(flavor.equalsIgnoreCase("Mix Berry")) cooktime += 20;
		else cooktime += 30;
		
		FoodDrink foodrink = new Beverage(name, type, price, cooktime, size, flavor);
		foodrinklist.add(foodrink);
		
		System.out.println();
		System.out.println("Successfully add a new menu!");
		
		splash.enter();
	}
	
	public void Add() {
		int choose = -1;
		
		do {
			splash.clear();
			
			System.out.println("What do you want to add?");
			System.out.println("1. Dessert");
			System.out.println("2. Drink");
			System.out.print("choose : ");
			
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				choose = 0;
			}
			scan.nextLine();
			
			switch (choose) {
			case 1:
				Dessert();
				break;
			case 2:
				Drink();
				break;
			}
			
		}while(choose < 1 || choose > 2);
	}
	
	public void ViewCook() {
		
		splash.clear();
		
		if(orderlist.isEmpty()) {
			System.out.println("There is no cooking process recently!");
		}
		else {
			System.out.printf("| %-3s | %-8s | %-15s | %-8s | %-6s |\n", "No", "Type", "Name", "Price", "Time Left");
			System.out.println("-----------------------------------------------------------");
			for(int i = 0 ; i < orderlist.size() ; i++) {
				if(orderlist.get(i).getCookingtime() == 0) {
					profit += orderlist.get(i).getPrice();
					
					if(orderlist.get(i) instanceof Beverage) {
						FoodDrink FD = new Beverage(orderlist.get(i).getName(), orderlist.get(i).getType(), orderlist.get(i).getPrice(), orderlist.get(i).getCookingtime(), ((Beverage)orderlist.get(i)).getFlavor(), ((Beverage)orderlist.get(i)).getSize());
						
						historylist.add(FD);
					}
					else {
						FoodDrink FD = new Dessert(orderlist.get(i).getName(), orderlist.get(i).getType(), orderlist.get(i).getPrice(), orderlist.get(i).getCookingtime(), ((Dessert)orderlist.get(i)).getTopping(), ((Dessert)orderlist.get(i)).getCalories());

						historylist.add(FD);
					}
					
					orderlist.remove(i);
					
				}
				else {
					System.out.printf("| %-3s | %-8s | %-15s | %-8s | %-7s s |\n", (i+1), orderlist.get(i).getType(), orderlist.get(i).getName(), orderlist.get(i).getPrice(), orderlist.get(i).getCookingtime());
				}
			}
		}
		
		System.out.println();
		splash.enter();
	}
	
	public void ViewHistory() {
		
		splash.clear();
		
		if(historylist.isEmpty()) {
			System.out.println("There is no order history!");
		}
		else {
			System.out.printf("| %-3s | %-15s | %-8s | %-10s | %-10s | %-10s | %-6s | %-22s |\n", "No", "Name", "Price", "Topping", "Callories", "Flavor", "Size", "Order Time");
			System.out.println("-------------------------------------------------------------------------------------------------------------");
			for(int i = 0 ; i < historylist.size() ; i++) {
				if(historylist.get(i) instanceof Dessert) {
					System.out.printf("| %-3s | %-15s | %-8s | %-10s | %-10s | %-10s | %-6s | %s AM |\n", (i+1), historylist.get(i).getName(), historylist.get(i).getPrice(), ((Dessert)historylist.get(i)).getTopping(), ((Dessert)historylist.get(i)).getCalories(), "-", "-", ordertime.get(i));
				}
				else {
					System.out.printf("| %-3s | %-15s | %-8s | %-10s | %-10s | %-10s | %-6s | %s AM |\n", (i+1), historylist.get(i).getName(), historylist.get(i).getPrice(), "-", "-", ((Beverage)historylist.get(i)).getSize(), ((Beverage)historylist.get(i)).getFlavor(), ordertime.get(i));
				}
			}
		}
		
		System.out.println();
		splash.enter();
	}
	
	int pilih;
	public void Order() {
		
		splash.clear();
		
		if(foodrinklist.isEmpty()) {
			System.out.println("There is no Dessert or Drink on the list!");
		}
		else {
			System.out.printf("| %-3s | %-15s | %-5s | %-8s | %-8s | %-9s | %-5s |\n", "No", "Name", "Price", "Topping", "Callories", "Flavor", "Size");
			System.out.println("----------------------------------------------------------------------------");
			for(int i = 0 ; i < foodrinklist.size() ; i++) {
				if(foodrinklist.get(i) instanceof Dessert) {
					System.out.printf("| %-3s | %-15s | %-5s | %-8s | %-9s | %-9s | %-5s |\n", (i+1), foodrinklist.get(i).getName(), foodrinklist.get(i).getPrice(), ((Dessert)foodrinklist.get(i)).getTopping(), ((Dessert)foodrinklist.get(i)).getCalories(), "-", "-");
				}
				else {
					System.out.printf("| %-3s | %-15s | %-5s | %-8s | %-9s | %-9s | %-5s |\n", (i+1), foodrinklist.get(i).getName(), foodrinklist.get(i).getPrice(), "-", "-", ((Beverage)foodrinklist.get(i)).getSize(), ((Beverage)foodrinklist.get(i)).getFlavor());
				}
			}
			
			System.out.println();
			do {
				System.out.printf("Choose a menu to order [1-%d]: ", foodrinklist.size());
				try {
					pilih = scan.nextInt();
				} catch (Exception e) {
					pilih = 0;
				}
				scan.nextLine();
			}while(pilih < 1 || pilih > foodrinklist.size());
			
			DateTime();
			
			ordertime.add(OrderTime);
			
			if(foodrinklist.get(pilih-1) instanceof Beverage) {
				FoodDrink FD = new Beverage(foodrinklist.get(pilih-1).getName(), foodrinklist.get(pilih-1).getType(), foodrinklist.get(pilih-1).getPrice(), foodrinklist.get(pilih-1).getCookingtime(), ((Beverage)foodrinklist.get(pilih-1)).getFlavor(), ((Beverage)foodrinklist.get(pilih-1)).getSize());
				
				Thread thread = new Thread(FD);
				thread.start();
				
				orderlist.add(FD);
			}
			else {
				FoodDrink FD = new Dessert(foodrinklist.get(pilih-1).getName(), foodrinklist.get(pilih-1).getType(), foodrinklist.get(pilih-1).getPrice(), foodrinklist.get(pilih-1).getCookingtime(), ((Dessert)foodrinklist.get(pilih-1)).getTopping(), ((Dessert)foodrinklist.get(pilih-1)).getCalories());
				
				Thread thread = new Thread(FD);
				thread.start();
				
				orderlist.add(FD);
			}
			System.out.println();
			System.out.println("Successfully add to order list!");
		}
		
		System.out.println();
		splash.enter();
	}
}
