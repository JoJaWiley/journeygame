package journeygame;

import java.util.Scanner;

public class ISS extends LocationEvent {
	
	String name = "ISS";
	
	public void event(Crew game, Scanner scanner) {
		String answer = "";
		
		//do while loop so saving doesn't skip question
		do {
		//ask the user if they want to raid the ISS crew's Tang, or just ask them for some tang
		System.out.println("Welcome to the ISS! Would you like to raid the ISS crew's Tang [r], or ask them for some Tang[a]? [qq to quit, ss to save]");
		//print the game state so the user can make an informed decision
		game.printState();
		//store their answer in a variable
		answer = scanner.next();
		//in case they want to quit
		game.quit(answer, game, scanner);
		} while (answer.equalsIgnoreCase("ss"));
		
		//if user raids
		if (answer.equalsIgnoreCase("r"))
		{
			System.out.println("You got their Tang (+5) but your space insanity has increased (+2)!"); 		//user gets some Tang, but their space insanity increases
			game.setAmountOfTang(game.getAmountOfTang() + 5);
			game.setSpaceInsanity(game.getSpaceInsanity() + 2);
		}
		
		//if user asks
		if (answer.equalsIgnoreCase("a"))																	//ISS crew says no. User gets nothing.
			System.out.println("They said no.");
		
		//print out the game state
		game.printState();
	}
}
