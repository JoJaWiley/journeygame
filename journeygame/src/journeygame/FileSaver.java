package journeygame;

import java.util.Scanner;
import java.io.*;

public class FileSaver {
	
	public static void fileSaver(Crew game, Scanner scanner) {	
		System.out.println("Would you like to save your progress? y/n");
		String answer = scanner.next();
		
		if (answer.equalsIgnoreCase("y"))
		{
			//String name = scanner.next();
			String path = "save.txt";
			try {
				File file = new File(path);
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				
				//write int attributes
					fw.write(game.getAmountOfTang() + " ");
					fw.write(game.getAmountOfWhiskey() + " ");
					fw.write(game.getSpaceInsanity() + " ");
					fw.write(game.getTravelTime() + " ");
					fw.write(game.getHour() + " ");
					fw.write(game.getEvent() + " ");
				
				//write crew
				for (Person person : game.getCrew())
					fw.write(person.getName() + " ");
				
				System.out.println("The file was successfully saved.");
				
				fw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
