package model;

public class Character {
	
	
	private String name;
	private String personality;
	private String creationDate;
	private String power;
	private int score;
	
	
	//relations
	
	private Technique techniques;
	
	public Character(String name, String personality, String creationDate, String power, int score) {
		
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		this.score = score;
	}

}
