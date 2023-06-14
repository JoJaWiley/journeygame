package journeygame;

import java.util.Scanner;
import java.io.*;

public class Journaling extends CopingEvent {
	String name = "Journaling";
	
	public String getName() {
		return name;
	}

	public void event(Crew game, Scanner scanner) {
		String response = "";
		do {
			//welcome user to journaling 
			System.out.println("A time to write in your stupid space journal!");
			game.printState();
			//ask user if they want to write in it
			System.out.println("Would you like to write in your stupid space journal? y/n [qq to quit, ss to save]");
			//set event to journaling in case they save, so it reloads this event instead of randomly generating new one
			game.setEvent(2);
			//store user's answer in variable
			response = scanner.next();
			
			//outcome
			//check for quit or save
			game.quit(response, game, scanner);
			} while (response.equalsIgnoreCase("ss"));
		
		if (response.equalsIgnoreCase("y"))
		{
			System.out.println("Enter DONE on its own line to terminate");
			try {
				File journalFile = new File("journal.txt");
				if (!journalFile.exists()) 
				{
					journalFile.createNewFile();
				}
				FileWriter fw = new FileWriter(journalFile);
				while(true) 
				{	//store input
					String input = scanner.nextLine();
					//DONE to break
					if ("DONE".equalsIgnoreCase(input.trim()))
						break;
					//append input to the end of the journal
					fw.append(input);
				}
				//close the filewriter
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//congratulate the user on good coping skills and decrease their space insanity
			System.out.println("Nice job! Journaling is healthy! (-3 Space Insanity)");
			game.setSpaceInsanity(game.getSpaceInsanity() - 3);
		}
		
		if (response.equalsIgnoreCase("n"))
			System.out.println("Aww. Well, we all get lazy sometimes.");
		
		//print out the game state
		game.printState();
	}
}
