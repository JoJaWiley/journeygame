package journeygame;

import java.util.Scanner;

public class Earth extends LocationEvent {
	
	String name = "Earth";
	
	public void event(Crew game, Scanner scanner) {
		
		//Earth is a busy place. Just give the user some more game info and say goodbye.
		System.out.println("Goodbye from Earth! You will have 10 bottles of Tang to drink. When you run out of Tang, you will have to drink space whiskey!");
		System.out.println("This will speed your descent into space insanity! Space insanity triggers events you and your crew use to cope with the space life!");
		
		//print out the game state
		game.printState();
	}

}
