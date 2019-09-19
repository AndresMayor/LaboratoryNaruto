package model;

public class Clan {
	
	
	private Character1 first;
	private String name;
	
	
	
	public Clan(String name) {
		this.name=name;
		
	}



	public Character1 getCharacters() {
		return first;
	}



	public void setCharacters(Character1 first) {
		this.first = first;
	}
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	
	

	public void addCharacter(Character1 character1) {	
		 
		if (first ==null) {			
			first =character1;	
		}
		
		else if(!equalNameCharacter(character1)){
			character1.changeNext(first);
			first.setPrevious(character1);
			first=character1;
			
		}
		
	
	}
	
	
	
	public boolean  equalNameCharacter (Character1 character ) {
		
		boolean centinela =false ;
		Character1 actual = first;
		
		while( actual != null && !centinela  ){
			if (actual.getName() != character.getName()) {		
				
				centinela =true ;
			}
			actual = actual.getNext();
		}
		return centinela ; 
		}
	
	
	
	
	
	//Actualizar Name of tthe Character
	
	public boolean updateNameCharacter(String nameCharacter,String newName) {
		Character1 actual = first;
		boolean finded = false;
		
		
		while(actual!=null && actual.getName() != name) {
			actual =actual.getNext();
			
		}
		if(actual!=null) {
		actual.setName(newName);
		finded=true;
		}
		return finded;
	}
	
	
	
	
	
	
	
}
