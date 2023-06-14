package journeygame;

import java.io.*;
import java.util.Scanner;

public class FileLoader {
	
	public static void fileLoader(Crew game, Scanner scanner) {
		
		try {
			//create file object
			String path = "save.txt";
			File file = new File(path);
			
			if (file.exists())
			{
			//create scanner
			Scanner fileScanner = new Scanner(file);
			
			System.out.println("Would you like to load the saved file progress? y/n");
			String answer = scanner.next();
				
			if (answer.equalsIgnoreCase("y"))
			{
				//while loop to read attributes and set game state
				while (fileScanner.hasNext()) {
				
					//read attributes
					int tang = fileScanner.nextInt();
					int pee = fileScanner.nextInt();
					int insanity = fileScanner.nextInt();
					int time = fileScanner.nextInt();
					int hour = fileScanner.nextInt();
					int event = fileScanner.nextInt();
					
					String name1 = fileScanner.next();
					String name2 = fileScanner.next();
					String name3 = fileScanner.next();				
					
					//construct people
					Person person1 = new Person(name1);
					Person person2 = new Person(name2);
					Person person3 = new Person(name3);
					
						
					//set game state
					game.setAmountOfTang(tang);
					game.setAmountOfWhiskey(pee);
					game.setSpaceInsanity(insanity);
					game.setTravelTime(time);
					game.setHour(hour);
					game.setEvent(event);
					game.setPerson1(person1);
					game.setPerson2(person2);
					game.setPerson3(person3);
					Person[] c = {game.getPerson1(), game.getPerson2(), game.getPerson3()};
					game.setCrew(c);
					
				}
				//tell user the game was loaded
				System.out.println("The game was successfully loaded.");
				//remind user of the crew
				game.printCrew();
				//close scanners
				fileScanner.close();
			}
			else
				fileScanner.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
