package model;

public class Character {
	
	
	private String name;
	private String personality;
	private String creationDate;
	private String power;
	private int score;
	
	
	//relations
	
	private Technique techniques;
	private Character next;
	private Character previous;
	
	public Character(String name, String personality, String creationDate, String power, int score) {
		
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Technique getTechniques() {
		return techniques;
	}

	public void setTechniques(Technique techniques) {
		this.techniques = techniques;
	}

	public Character getNext() {
		return next;
	}

	public void setNext(Character next) {
		this.next = next;
	}

	public Character getPrevious() {
		return previous;
	}

	public void setPrevious(Character previous) {
		this.previous = previous;
	}
	

}
