package model;

import java.io.Serializable;
import java.util.Comparator;

public class Character1 implements Comparator<Character1>, Comparable<Character1>,Serializable  {
	
	
	private String name;
	private String personality;
	private String creationDate;
	private double power;
	private double score;
	
	
	//relations
	
	private Technique first;
	private Character1 next;
	private Character1 previous;
	
	public Character1(String name, String personality, String creationDate, double power) {
		
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		calculatedScore();
		
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

	public void calculatedScore() {
		score = 0;
		Technique actual =first;
		while ( actual!= null) {
				score  += power * actual.getFactor();
				actual =actual.getNext();
			}
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
		}else if (!equalNameTechnique(technique.getNameTec())) {
			technique.changeNext(first);
			first=technique;
			
		}
	}

	
	
	
	public boolean equalNameTechnique(String name ) {
		Technique current =first;
		boolean centinela = false;
		while (current != null && !centinela) {
			if (current.getNameTec().equals(name)) {
				centinela =true;
			}
			current=current.getNext();
		}
		return centinela;
	}
	
	
	
	
	
	@Override
	public int compare(Character1 character1, Character1 character2) {
		int resta = 0;
		double result = character1.getPower()-character2.getPower();
	   if(result<0) {
		   resta=-1;
	   }else if(result>0){
		   resta=1;
		   
	   }
	   return resta;
	}
	
	
	
	//Actualiza el nombre de la tecnica 
	
	public boolean updateNameTecCharacter(String nameCharacter,String newNameTec) {
		Technique  actual = first;
		boolean finded = false;
		
		if (!equalNameTechnique(newNameTec)) {
		while(actual!=null && !actual.getNameTec() .equals(nameCharacter)) {
			actual =actual.getNext();
			
		}
		}
		if(actual!=null) {
			
		actual.setNameTec(newNameTec);
		finded=true;
		
		}
		return finded;
	}

	//Actualiza el Factor de la tecnica 
	
	public boolean updateFactorCharacter(String nameTec,double factor) {
		Technique  actual = first;
		boolean finded = false;
		
		
		while(actual!=null && !actual.getNameTec() .equals(nameTec)) {
			actual =actual.getNext();
			
		}
		
		if(actual!=null) {
			
		actual.setFactor(factor);;
		finded=true;
		
		}
		return finded;
	}
	public Technique localizarAnterior(String nametec) {
		Technique anterior = null;
		Technique actual = first;

		while( actual != null && actual.getNameTec() != nametec )
		{
			anterior = actual;
			actual = actual.getNext();
			}
		
		return actual != null ? anterior : null; 
		}
	
	
	//Elimina una Tecnica 
	
	public boolean eliminateTechnique(String nameTec) throws SameObject {
		
		boolean finded = false;
		
		
		if (first == null) {
			String msg = "The tecnique does not exist!!";
			throw new SameObject(msg);
		}else if (nameTec.equals(first.getNameTec())){
			first=first.getNext();
			
		}else {
			Technique  anterior = localizarAnterior(nameTec);
			if (anterior == null) {
				throw new SameObject("The Chraracter does not exist!!" + nameTec);
				
				
			}
				anterior.desconectarSiguiente();
				finded =true;
		}

		
		
		return finded;
		
		
	}
	
	//Metodo para buscar tecnica del personaje 
	
	public boolean searchTechnique(String nameTec) throws SameObject {
		Technique  actual = first;
		boolean finded = false;
		
		
		while(actual!=null && !actual.getNameTec() .equals(nameTec)) {
			actual =actual.getNext();
			
		}
		
		if(actual!=null) {
		System.out.println(actual.toString());
		finded=true;
		}
		
		
		return finded;
	}

	@Override
	public String toString() {
		return "Character1 [name=" + name + ", personality=" + personality + ", creationDate=" + creationDate
				+ ", power=" + power + ", score=" + score  + "]";
	}
	
	
	
	
	

	@Override
	public int compareTo(Character1 o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
