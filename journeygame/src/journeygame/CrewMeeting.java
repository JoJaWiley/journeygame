package journeygame;

import java.util.Scanner;

public class CrewMeeting extends CopingEvent {
	String name = "Crew Meeting";
	//constructor
	public CrewMeeting() {
	}

	public String getName() {
		return name;
	}
	//what is said at meeting & outcome
	public void event(Crew game, Scanner scanner) {
		
		String response = "";
		//do while loop so saving doesn't skip the meeting
		do {
		//welcome user to crew meeting
		System.out.println("A Crew Meeting has begun!");
		game.printState();
		//ask user if they want to be friendly or mean
		System.out.println("Enter f to Engage your crew with a friendly demeaner, or m to engage with a mean demeanor. [qq to quit, ss to save]");
		//set event to crew meeting in case they save, so it restarts here
		game.setEvent(0);
		//store user's answer in variable
		response = scanner.next();
		
		//outcome
		//check for quit or save
		game.quit(response, game, scanner);
		} while (response.equalsIgnoreCase("ss"));
		
		//if user chooses friendly demeanor
		if (response.equalsIgnoreCase("f")) 
		{
			for (Person person : game.getCrew())
			{
				if (person.getAttitude().equals("bad"))										//bad attitude people get upset
					{
					System.out.println(person.getName() + " is upset with you!");
					game.setSpaceInsanity(game.getSpaceInsanity() + 1);						//tension increases space insanity
					}
				
				if (person.getAttitude().equals("good"))									//good attitude people are pleased
					{
					System.out.println(person.getName() + " is pleased with you!");
					game.setSpaceInsanity(game.getSpaceInsanity() - 1);							//good vibes decrease space insanity
					}
			}
		}
		
		//if user chooses mean demeanor
		if (response.equalsIgnoreCase("m")) 
		{
			for (Person person : game.getCrew())
			{
				if (person.getAttitude().equals("good"))
				{
					System.out.println(person.getName() + " is upset with you!");				//good attitude ppl get upset
					game.setSpaceInsanity(game.getSpaceInsanity() + 1);							//bad vibes increase space insanity
				}
				if (person.getAttitude().equals("bad"))
				{
					System.out.println(person.getName() + " respects you!");					//bad attitude people respect the mean demeanor
					game.setSpaceInsanity(game.getSpaceInsanity() - 1);							//space insanity goes down, due to respect
				}
			}
		}
		//print the gamestate
		game.printState();
	}
}
