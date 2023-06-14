package journeygame;

import java.util.Scanner;

public class Drink {
	
	public Drink() {
		
	}

	public void drink(Crew game, Scanner scanner) {
		String answer = "";
		
		//do while loop so saving doesn't skip question
		do {
		System.out.println("Would you like to consume some Tang (enter t), or drink your space whiskey (enter p)? [qq to quit, ss to save]");
		game.printState();
		answer = scanner.next();
		game.quit(answer, game, scanner);
		} while (answer.equalsIgnoreCase("ss"));
	
	//if they choose to drink tang
		if (answer.equalsIgnoreCase("t"))
			{
			if (game.getAmountOfTang() == 0)	//but if they have no Tang
			{									//tell them they have no Tang & will have to drink whiskey now
				System.out.println("Oh but you are out of Tang! Looks like you will have to drink space whiskey!");  
				if (game.getAmountOfWhiskey() == 0) //but if they have no whiskey 
				{									//they're dead.
					System.out.println("Oh it looks like you are out of whiskey as well! Then you are actually dead. So yeah.");
					System.exit(0);
				}
				
				//if they're not out of whiskey, they drink it. They've been notified.
				if (game.getAmountOfWhiskey() != 0)
				{
					game.setSpaceInsanity(game.getSpaceInsanity() + 1);
					game.setAmountOfWhiskey(game.getAmountOfWhiskey() - 1);
				}
			}
			
			//if they're not out of Tang, they can drink that.
			if (game.getAmountOfTang() != 0)
			{
				System.out.println("MMM! (-1 Space Insanity, - 1 Tang)");
				game.setSpaceInsanity(game.getSpaceInsanity() - 1);
				game.setAmountOfTang(game.getAmountOfTang() - 1);
			}
		}
		
		//if they choose to drink whiskey
		if (answer.equalsIgnoreCase("p"))
		{
			if (game.getAmountOfWhiskey() == 0)	//but if they have no whiskey
			{									//tell them they have no whiskey & will have to drink tang now
				System.out.println("Oh but you are out of whiskey! Looks like you will have to dip into your Tang, if you have any!");  
				if (game.getAmountOfTang() == 0) //but if they have no Tang
				{									//they're dead.
					System.out.println("It looks like you are out of Tang as well! Then you are actually dead. So yeah.");
					System.exit(0);
				}
				
				//if they have Tang, they can drink it. They've been notified.
				if (game.getAmountOfTang() != 0) 
				{
					game.setSpaceInsanity(game.getSpaceInsanity() - 1);
					game.setAmountOfTang(game.getAmountOfTang() - 1);
				}
			}
			
			//if they have whiskey, then lucky-ish them: they can drink it.
			if (game.getAmountOfWhiskey() != 0)
			{
				System.out.println("Yar! (+1 Space Insanity, - 1 Whiskey)");
				game.setSpaceInsanity(game.getSpaceInsanity() + 1);
				game.setAmountOfWhiskey(game.getAmountOfWhiskey() - 1);
			}
		}
		//print out the gamestate so user knows what is even going on
		game.printState();
	}	
}
