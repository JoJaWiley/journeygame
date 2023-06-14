package journeygame;

import java.util.Scanner;

public class Asteroid extends LocationEvent {
	
	String name = "a asteroid!";
	
	public void event(Crew game, Scanner scanner) {
		String answer = "";
		
		//do while loop so saving doesn't skip question
		do {
		//ask the user if they want to land on the asteroid
		System.out.println("A asteroid is passing by! Would you like to land on it? y/n [qq to quit, ss to save]");
		//print the game state so user can make an informed decision
		game.printState();
		//store user's answer in a variable
		answer = scanner.next();
		//in case they want to save or quit
		game.quit(answer, game, scanner);
		} while (answer.equalsIgnoreCase("ss"));
		
		if (answer.equalsIgnoreCase("y"))
			{
			System.out.println("What a beautiful sight fr- oops, you're dead.");					//if yes, user dies. Asteroids are dangerous
			System.exit(0);
			}
		if (answer.equalsIgnoreCase("n"))														
			System.out.println("Smart move playing it safe! You get nothing. Bye.");				//if no, user lives. That's it.
		
		//print out the game state
		game.printState();
	}

}
