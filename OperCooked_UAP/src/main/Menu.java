package main;

import java.util.Scanner;

import foodrink.AddViewOrder;

public class Menu {
	Scanner scan = new Scanner(System.in);
	
	Splash splash = new Splash();
	AddViewOrder AVO = new AddViewOrder();

	public Menu() {

		int choose = -1;
		
		do {
			splash.clear();
			
			AVO.Profit();
			System.out.println("1. Add Desert or Beverage");
			System.out.println("2. View Cooking Process");
			System.out.println("3. View Order History");
			System.out.println("4. Order Dessert or Beverage");
			System.out.println("5. Exit");
			
			System.out.print(">> ");
			try {
				choose = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				choose = 0;
			}
			
			switch (choose) {
			case 1:
				AVO.Add();
				break;
			case 2: 
				AVO.ViewCook();
				break;
			case 3:
				AVO.ViewHistory();
				break;
			case 4:
				AVO.Order();
				break;
			case 5:
				new Exit();
				System.exit(0);
				break;
			}
		}while(choose < 1 || choose > 5 || choose != 5);
	}

}
