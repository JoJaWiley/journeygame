package journeygame;

public class Person {
	private String name;
	private String attitude;					//interacts with coping events
	
	public Person() {
		
	}
	
	//person constructor takes a name and sets the corresponding attitude
	public Person(String name) {
		this.name = name;
		if (name.equals("Jason"))
			attitude = "bad";
		if (name.equals("Susan"))
			attitude = "bad";
		if (name.equals("Penny"))
			attitude = "good";
		if (name.equals("Vlad"))
			attitude = "good";
	}
	
	//getters and setters
	public String getName() {
		return name;
	}
	public String getAttitude() {
		return attitude;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAttitude(String attitude) {
		this.attitude = attitude;
	}
	
}
