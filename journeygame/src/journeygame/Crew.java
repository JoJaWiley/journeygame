package journeygame;

import java.util.ArrayList;
import java.util.Scanner;

public class Crew { //an incredibly mature Kubrikian space adventure with terrible gameplay and space whiskey
	
	//attributes - amount of tang, amount of space whiskey, amount of space insanity, travel time, and an array
	private int amountOfTang;	//crew drinks this. switch to space whiskey at 0.
	private int amountOfWhiskey;  //crew drinks this after Tang runs out. Makes space insanity increase faster. Triggers death at 0.
	private int spaceInsanity;		//triggers "coping event" at 4. 
	private int travelTime;	//indexes the Tang/whiskey usage, increase in space insanity, and triggers location events
	private int[] stateInts = {amountOfTang, amountOfWhiskey, spaceInsanity, travelTime};
	private int hour;	//helps order the daily triggering of possible events
	private int event;	//helps to recall the coping event if saved during a randomly generated coping event, so it doesn't randomly generate a new one on load
	
	private Person person1;
	private Person person2;
	private Person person3;
	private Person[] crew = {person1, person2, person3};
	
	
	//constructors
	public Crew() {
		
	}
	public Crew(int amountOfTang, int amountOfWhiskey, int spaceInsanity, int travelTime, Person person1, Person person2, Person person3) {
		this.amountOfTang = amountOfTang;
		this.amountOfWhiskey = amountOfWhiskey;
		this.spaceInsanity = spaceInsanity;
		this.travelTime = travelTime;
		this.person1 = person1;
		this.person2 = person2;
		this.person3 = person3;
	}
	public Crew(int amountOfTang, int amountOfWhiskey, int spaceInsanity, int travelTime) {
		this.amountOfTang = amountOfTang;
		this.amountOfWhiskey = amountOfWhiskey;
		this.spaceInsanity = spaceInsanity;
		this.travelTime = travelTime;
	}
	
	//getters
	public int getAmountOfTang() {
		return amountOfTang;
	}
	public int getAmountOfWhiskey() {
		return amountOfWhiskey;
	}
	public int getSpaceInsanity() {
		return spaceInsanity;
	}
	public int getTravelTime() {
		return travelTime;
	}
	public int[] getStateInts() {
		return stateInts;
	}
	public int getHour() {
		return hour;
	}
	public int getEvent() {
		return event;
	}
	public Person getPerson1() {
		return person1;
	}
	public Person getPerson2() {
		return person2;
	}
	public Person getPerson3() {
		return person3;
	}
	public Person[] getCrew() {
		return crew;
	}
	
	//setters
	public void setAmountOfTang(int amountOfTang) {
		this.amountOfTang = amountOfTang;
	}
	public void setAmountOfWhiskey(int amountOfWhiskey) {
		this.amountOfWhiskey = amountOfWhiskey;
	}
	public void setSpaceInsanity(int spaceInsanity) {
		this.spaceInsanity = spaceInsanity;
	}
	public void setTravelTime(int travelTime) {
		this.travelTime = travelTime;
	}
	public void setStateInts(int[] stateInts) {
		this.stateInts = stateInts;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public void setEvent(int event) {
		this.event = event;
	}
	public void setPerson1(Person person1) {
		this.person1 = person1;
	}
	public void setPerson2(Person person2) {
		this.person2 = person2;
	}
	public void setPerson3(Person person3) {
		this.person3 = person3;
	}
	public void setCrew(Person[] crew) {
		this.crew = crew;
	}
	
	public void initCrew() {
		//initialize crew
		//from arraylist<String> of names of possible crew members
		ArrayList<String> names = new ArrayList<String>();
		names.add("Jason");
		names.add("Susan");
		names.add("Penny");
		names.add("Vlad");
		
		//to arraylist<string> of randomly selected crew members to use
		ArrayList<String> namesUsed = new ArrayList<String>();
				
		//randomly select 3 crew members. print out who got selected. move from possible to selected arraylist. 
		int random = 0;
		int initSize = 3;
			for(int i = 0; i < initSize; i++)
			{
				random = (int)((Math.random()*(names.size())));
				System.out.println("Crew member " + (i + 1) + ": " + names.get(random));
				namesUsed.add(names.get(random));
				names.remove(random);
			}
		//create a crew array of Person type, and create a Person for each selected name. Print out their attitudes.
		Person[] crew = new Person[3];
		for (int i = 0; i < crew.length; i++)
			crew[i] = new Person(namesUsed.get(i));
		//initialize person variables with crew array
		this.setPerson1(crew[0]);
		this.setPerson2(crew[1]);
		this.setPerson3(crew[2]);
		
		//set crew attribute array
		this.setCrew(crew);
		//print out the crew
		this.printCrew();
	}
	
	//for printing of the crew
	public void printCrew() {
		for (int i = 0; i < this.getCrew().length; i++)
			System.out.println("Crew member" + " " + this.getCrew()[i].getName() + " has a " + this.getCrew()[i].getAttitude() + " attitude." );
	}
	
	//less final than it sounds. quit() can also be a save without quit
	public void quit(String answer, Crew game, Scanner scanner) {
		//call filesaver if user wants to save or quit
		if ((answer.equalsIgnoreCase("qq")) || answer.equalsIgnoreCase("ss"))
		{
			FileSaver.fileSaver(game, scanner); 
		}
		
		//if they want to quit, exit
		if (answer.equalsIgnoreCase("qq"))
			System.exit(0);
	}
		
	//print the game state
	public void printState() {
		System.out.println("Tang: " + this.getAmountOfTang() + "\nSpace Whiskey: " + this.getAmountOfWhiskey() + "\nSpace Insanity: " + this.getSpaceInsanity() + "\nDay: " + this.getTravelTime() + "\nHour: " + this.getHour());
	}
	
	//enter any character to continue
	public void continuity(Scanner scanner) {
		System.out.println("Enter any character to continue.");
		String something = scanner.next();
	}
	
	//start main method
	public static void main(String[] args) {
		
		//create the scanner object & initialize answer
		Scanner scanner = new Scanner(System.in);
		String answer = "";
		
		//create new game
		Crew game = new Crew(10, 10, 3, 1);
		
		//welcome to game 
		System.out.println("Welcome to Crew, a Kubrikian space adventure! You will be on your way to Mars in a realistic 21 days!");
		game.continuity(scanner);
		System.out.println("Your crew will be selected for you momentarily! Each crew member has an attitude, which determines how they respond to certain events!");
		System.out.println("Let's meet them now!");
	
		//initialize the crew
		game.initCrew();
	
		//load any saved progress if desired
		game.setEvent(4);
		FileLoader.fileLoader(game, scanner);
	
		//quit at any time, plus fileSaver stuff (put the quit & saver methods everywhere scanner goes. qq for quit, ss for save)
		System.out.println("You can save or quit at almost any prompt! Look for [enter qq or ss]!");
		game.continuity(scanner);

		//while loop makes quit() end at qq and cycles through a day of travel time
		while(!answer.equalsIgnoreCase("qq") && (game.getTravelTime() != 22))
		{	
			//tell user about today
			System.out.println("You are on day " + game.getTravelTime() + "!");
			game.printState();
			game.continuity(scanner);
			
			//location events
			//create locations
			LocationEvent earth = new Earth();
			LocationEvent iss = new ISS();
			LocationEvent moon = new Moon();
			LocationEvent asteroid = new Asteroid();
			LocationEvent spaceNebraska = new SpaceNebraska();
			LocationEvent mars = new Mars();
			
			//initialize events array
			//check if space insanity above threshold
			CopingEvent meeting = new CrewMeeting();
			CopingEvent fight = new CrewFight();
			CopingEvent journaling = new Journaling();
			CopingEvent[] events = {meeting, fight, journaling};
			
			//create daily hydration event
			Drink drink = new Drink();
		
			//location events triggered by if statements for corresponding days
			//check if day 1 (Earth), day 3 (ISS), day 5 (Moon), day 8 (asteroid), day 12 (space nebraska), or day 24 (Mars)
			if (game.getHour()%3 == 0)			//first part of the day is for location events
			{
				if (game.getTravelTime()  == 1) //earth event on day one. leaving Earth and just finding out about the pee thing.
					{
					earth.event(game, scanner);
					game.continuity(scanner);
					}
				if (game.getTravelTime()  == 3) //ISS event on day 3. Can try to steal their Tang.
					{
					iss.event(game, scanner);
					game.continuity(scanner);
					}
				if (game.getTravelTime()  == 5)	//Moon event on day 4. Mine for Tang or something.
					{
					moon.event(game, scanner);
					game.continuity(scanner);
					}
				if (game.getTravelTime()  == 8) //Asteroid, can visit.
					{
					asteroid.event(game, scanner);
					game.continuity(scanner);
					}
				if (game.getTravelTime()  == 12) //Space Nebraska.
					{
					spaceNebraska.event(game, scanner);
					game.continuity(scanner);
					}
				if (game.getTravelTime()  == 21) //Mars! Oops. Forgot to pack civilization.
					{
					mars.event(game, scanner);
					game.continuity(scanner);
					}
				//update the hour
				game.setHour(game.getHour() + 1);
			}
			
			if (game.getHour()%3 == 1)							//second part of the day is for coping events
			{	
				if (game.getEvent() != 4)						//4 is an out of events[] bounds default. if event is not 4, game was saved during coping event & then loaded.
					{
					events[game.getEvent()].event(game, scanner);	//recall the coping event that was happening when the game was saved.
					game.continuity(scanner);
					}
				//if space insanity above threshold
				else if (game.getEvent() == 4 && game.getSpaceInsanity() >= 3)
				{			
					//randomly generate some crap these people do to react or respond or otherwise deal with insanity in space
					int random = (int)((Math.random()*(events.length)));
					System.out.println("Event: " + events[random].getName());
					game.setEvent(random);
					events[random].event(game, scanner);
					game.continuity(scanner);
				}
				//set event to default
				game.setEvent(4);						
				//update hour
				game.setHour(game.getHour() + 1);
			}
			
			if (game.getHour()%3 == 2)					//third part of the day is for drinking tang or whiskey.
			{
				//daily hydration event
				drink.drink(game, scanner);
				game.continuity(scanner);
				
				//update hour and day
				game.setHour(game.getHour() + 1);
				game.setTravelTime(game.getTravelTime() + 1);
			}
		}
		//close the scanner
		scanner.close();
	}
}

	