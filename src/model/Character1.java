package model;

import java.util.Comparator;

public class Character1 implements Comparator<Character1>, Comparable<Character1> {
	
	
	private String name;
	private String personality;
	private String creationDate;
	private double power;
	private double score;
	
	
	//relations
	
	private Technique first;
	private Character1 next;
	private Character1 previous;
	
	public Character1(String name, String personality, String creationDate, double power, double score) {
		
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

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Technique getFirst() {
		return first;
	}

	public void setFirst(Technique techniques) {
		this.first = techniques;
	}
	public Character1 getNext() {
		return next;
	}

	public void setNext(Character1 next) {
		this.next = next;
	}

	public Character1 getPrevious() {
		return previous;
	}

	public void setPrevious(Character1 previous) {
		this.previous = previous;
	}

	
	
	
	//Metodo que para agregar personaje al comienzo 
	public void changeNext (Character1 character1) {
		next=character1;
		
	}
	
	
	
	
	public void addTechniques(Technique technique) {
		
		
		if (first == null) {
			first = technique;
		}else if (!equalNameTechnique(technique)) {
			technique.changeNext(first);
			first=technique;
			
		}
	}
	
	
	
	
	public boolean equalNameTechnique(Technique technique) {
		Technique current =first;
		boolean centinela = false;
		while (current != null && !centinela) {
			if (current.getNameTec()!=technique.getNameTec()) {
				centinela =true;
			}
			current=current.getNext();
		}
		return centinela;
	}
	
	
	
	
	@Override
	public int compareTo(Character1 o) {
	
		return name.compareTo(o.getName());
	}

	@Override
	public int compare(Character1 o1, Character1 o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	

}
