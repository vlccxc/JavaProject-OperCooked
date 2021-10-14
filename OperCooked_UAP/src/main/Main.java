package main;

public class Main {	
	Splash splash = new Splash();
	
	public Main() {
		
		new Logo();
		
		splash.enter();
		
		new Menu();
		
		splash.enter();
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
