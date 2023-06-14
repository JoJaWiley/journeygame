package journeygame;

import java.util.Scanner;

public class CrewFight extends CopingEvent {		//non-interactive. That escalated quickly!
	
	String name = "Crew Fight";
	
	public String getName() {
		return name;
	}
	
	public void event(Crew game, Scanner scanner) {
		//welcome user to the event
		System.out.println("A crew fight has broken out!");
		//print out the gamestate
		game.printState();
		//any character to continue, to break up the text output
		game.continuity(scanner);
		
		//space insanity > 5 turns fights deadly
		if (game.getSpaceInsanity() > 5) 
			{
			System.out.println("Oh no! You have killed each other in the fight. You are all dead. Game Over btw.");
			System.exit(0);
			}
			
		//how people respond to fight
		for (Person person : game.getCrew())
		{
			if (person.getAttitude().equals("bad"))									//bad attitude ppl respect a fight
				{
				System.out.println(person.getName() + " respects you! (-1 Space Insanity)");
				game.setSpaceInsanity(game.getSpaceInsanity() - 1);					//respect from crew member decreases space insanity
				}
			
			if (person.getAttitude().equals("good"))								//good attitude ppl are upset
				{
				System.out.println(person.getName() + " is upset with you! (+1 Space Insanity)");
				game.setSpaceInsanity(game.getSpaceInsanity() + 1);					//tension w/ crew member increases space insanity
				}
		}
		//print the game state
		game.printState();							
	}

}
