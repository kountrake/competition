package app;

public class Competitor {
	
	private String name;
	private int strength;
	
	/* Constructors */
	public Competitor() {
		name = "no-name";
		strength = 1;
	}
	
	public Competitor(String name) {
		this.name = name;
		this.strength = 1;
	}
	
	public Competitor (String name, int strength) {
		this.name = name;
		this.strength = strength;
	}
	
	/* Getters and Setters */
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
}
