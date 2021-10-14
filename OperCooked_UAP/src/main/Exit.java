package main;

public class Exit {
	Splash splash = new Splash();
	
	public Exit() {
		
		splash.clear();
		
		String exit = " ______  __ __   ____  ____   __  _      __ __   ___   __ __ \r\n" + 
				"|      ||  |  | /    ||    \\ |  |/ ]    |  |  | /   \\ |  |  |\r\n" + 
				"|      ||  |  ||  o  ||  _  ||  ' /     |  |  ||     ||  |  |\r\n" + 
				"|_|  |_||  _  ||     ||  |  ||    \\     |  ~  ||  O  ||  |  |\r\n" + 
				"  |  |  |  |  ||  _  ||  |  ||     \\    |___, ||     ||  :  |\r\n" + 
				"  |  |  |  |  ||  |  ||  |  ||  .  |    |     ||     ||     |\r\n" + 
				"  |__|  |__|__||__|__||__|__||__|\\_|    |____/  \\___/  \\__,_|\r\n" + 
				"                                                             ";
		
		for(int i = 0 ; i < exit.length() ; i++) {
			try {
				Thread.sleep(3);
				System.out.print(exit.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println();
		
		splash.enter();
	}
}
