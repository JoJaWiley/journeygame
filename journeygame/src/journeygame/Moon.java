package journeygame;

import java.util.Scanner;

public class Moon extends LocationEvent {
	
	String name = "the moon";

	public void event(Crew game, Scanner scanner) {
		String answer = "";
		
		//do while loop so saving doesn't skip question
		do {
			//ask the user if they want to drill for tang
		System.out.println("Welcome to the moon! Would you like to try to drill into the moon's delicious cheezy surface for Tang? y/n [qq to quit, ss to save]");
		//print out game state so user can make an informed decision
		game.printState();
		//store user's answer in a variable
		answer = scanner.next();
		//in case they want to save or quit
		game.quit(answer, game, scanner);
		} while (answer.equalsIgnoreCase("ss"));
		
		switch(answer) {
		//if yes, tell user they struck tang and give them 3 tang, if no thank them for visiting
		case "y" -> {System.out.println("You have struck Tang! (+ 3 Tang)"); game.setAmountOfTang(game.getAmountOfTang() + 3);}
		case "n" -> {System.out.println("Thank you for visiting the moon! Have a nice day!");}
		}
		
		//print out the game state
		game.printState();
	}
}
