package journeygame;

import java.util.Scanner;

public class Mars extends LocationEvent {
	String name = "Mars";
	
	public void event(Crew game, Scanner scanner) {
		String answer = "";
		
		//do while loop so saving doesn't skip question
		do {
			//welcome the user to mars, even though you don't want to
		System.out.println("Hooray! You made it! Welcome to Mars! Would you like to explode in celebration? y/n [qq to quit, ss to save]");
		//save their answer from the keyboard
		answer = scanner.next();
		//what if they want to quit?
		game.quit(answer, game, scanner);
		} while (answer.equalsIgnoreCase("ss"));
		
		switch(answer) {
		case "y" -> {System.out.println("You have exploded!"); System.exit(0);} //they want to explode? They do. The end.
		case "n" -> {System.out.println("You have exploded - but you didn't like it!"); System.exit(0);} //they don't want to explode? Tough. They still do. Still the end.
		}
	}
}
