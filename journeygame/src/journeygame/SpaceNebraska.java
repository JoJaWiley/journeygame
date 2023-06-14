package journeygame;

import java.util.Scanner;

public class SpaceNebraska extends LocationEvent {
	String name = "Space Nebraska";

	public void event(Crew game, Scanner scanner) {
		String answer = "";
		
		//do while loop so saving doesn't skip question
		do {
		//welcome user to space nebraska. ask if they agree that it sucks
		System.out.println("Welcome to Space Nebraska! This sucks! Do you agree? y/n [qq to quit, ss to save]");
		//print out the gamestate so user can make an informed decision
		game.printState();
		//store user's answer in a variable
		answer = scanner.next();
		//in case they want to save or quit
		game.quit(answer, game, scanner);
		} while (answer.equalsIgnoreCase("ss"));
		
		//yes is the sane answer. no space insanity increase for this
		if (answer.equalsIgnoreCase("y"))
			{
			System.out.println("Sane answer! Way to maintain your current level of space sanity!");
			}
		//no is an insane answer. Space Nebraska sucks. +1 space insanity.
		if (answer.equalsIgnoreCase("n"))
		{
			System.out.println("Insane answer! (+1 Space Insanity)");
			game.setSpaceInsanity(game.getSpaceInsanity() + 1);
		}
		
		//print out the game state
		game.printState();
	}
}
