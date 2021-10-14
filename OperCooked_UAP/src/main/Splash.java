package main;

import java.util.Scanner;

public class Splash {
	Scanner scan = new Scanner(System.in);
	
	public void clear() {
		for(int i = 0 ; i < 30 ; i++) {
			System.out.println();
		}
	}
	
	public void enter() {
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
}
