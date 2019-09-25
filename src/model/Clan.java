package model;

import java.io.Serializable;

public class Clan implements Serializable {
	
	

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
	
	
	
	public int compareName(Clan o) {
		return name.compareTo(o.getName());
	}
	
	
	//Responsabilidad para agregar una tecnica 
	
	
	public boolean addTecnique (String nameCharacter,Technique tecnique ) throws SameObject {
		Character1 actual = first;
		boolean finded = false;
		while (actual!=null && !actual.getName().equals(nameCharacter)) {
			actual=actual.getNext();
			
		}if (actual != null) {
			actual.addTechniques(tecnique);
			finded =true;
		}
		return finded;
	}

	

	public void addCharacter(Character1 character1) {	
		 
		if (first ==null) {			
			first =character1;	
		}
		
		else if(!equalNameCharacter(character1.getName())){
			character1.changeNext(first);
			first.setPrevious(character1);
			first=character1;
			
		}
		
	
	}
	
	
	
	public boolean  equalNameCharacter (String  nameCharacter ) {
		
		boolean centinela =false ;
		Character1 actual = first;
		
		while( actual != null && !centinela  ){
			if (actual.getName() .equals(nameCharacter)) {		
				
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
		
		if (!equalNameCharacter(newName)) {
		while(actual!=null && !actual.getName() .equals(nameCharacter)) {
			actual =actual.getNext();
			
		}
		}
		if(actual!=null) {
			
		actual.setName(newName);
		finded=true;
		
		}
		return finded;
	}
	

	//Actualiza La Personalidad del perosnaje 
	
	public boolean updatePersonalityCharacter(String nameCharacter,String newPersonality) {
		Character1 actual = first;
		boolean finded = false;
		
		
		while(actual!=null && !actual.getName() .equals(nameCharacter)) {
			actual =actual.getNext();
			
		}
		if(actual!=null) {
			
		actual.setPersonality(newPersonality);
		finded=true;
		
		}
		return finded;
	}
	
	//Actualiza la fecha de nacimiento del personaje 
	
	
	public boolean updateCreationDateCharacter(String nameCharacter,String creationDate) {
		Character1 actual = first;
		boolean finded = false;
		
		
		while(actual!=null && !actual.getName() .equals(nameCharacter)) {
			actual =actual.getNext();
			
		}
		if(actual!=null) {
			
		actual.setCreationDate(creationDate);;
		finded=true;
		
		}
		return finded;
	}
	
	
	//Actualiza el poder del personaje 
	
	public boolean updatePowerCharacter(String nameCharacter,double  power) {
		Character1 actual = first;
		boolean finded = false;
		
		
		while(actual!=null && !actual.getName() .equals(nameCharacter)) {
			actual =actual.getNext();
			
		}
		if(actual!=null) {
			
		actual.setPower(power);
		finded=true;
		
		}
		return finded;
	}
	
	
	
	
	//Responsabilidad para actualizar el factor de una tecnica  del personaje 
	
	
	public boolean updateFactorCharacter(String nameCharacter,double factor,String nameTec) {
		Character1  actual = first;

		boolean finded = false;
		
		
		while(actual!=null && !actual.getName() .equals(nameCharacter)) {
			actual =actual.getNext();
			
		}
		if(actual!=null) {
			
		actual.updateFactorCharacter(nameTec, factor);
		finded=true;
		
		}
		return finded;
	}


	
	//Responsabilidad para actualizar el nombre de una tecnica  del personaje 
	
	
	public boolean updateNameTecCharacter(String nameCharacter,String  newNameTec,String nameTec) {
		
		Character1  actual = first;

		boolean finded = false;
		
		
		while(actual!=null && !actual.getName() .equals(nameCharacter)) {
			actual =actual.getNext();
			
		}
		if(actual!=null) {
			
		actual.updateNameTecCharacter(nameCharacter, newNameTec);
		finded=true;
		
		}
		return finded;
	}

	//Elimina el perosnaje 
	public boolean eliminateCharacter(String nameCharacter) throws SameObject{
		
		boolean finded = false;
		
		Character1 actual =first;
		Character1 prev =null;
		if (first ==null) {
			
			throw new SameObject("The Chraracter "+ nameCharacter + " does not exist!!");
		}
		while (actual!=null && !finded) {
			if (actual.getName().equals(nameCharacter)) {
				if (prev != null) {
					prev.setNext(actual.getNext());
					prev.getNext().setPrevious(prev);
				}
				else{
					this.first=actual.getNext();
				}
				finded = true;
			}else {
				actual =actual.getNext();
				prev=actual.getPrevious();
			}
		
		
		}
		
		
		
		return finded;
		
		
	}
	//Responsabilidad para eliminar tecnique 
	public boolean eliminateTec(String nameCharacter,String nameTec) throws SameObject {
		
		Character1  actual = first;

		boolean finded = false;
		
		
		while(actual!=null && !actual.getName() .equals(nameCharacter)) {
			actual =actual.getNext();
			
		}
		if(actual!=null) {
			
		actual.eliminateTechnique(nameTec);
		finded=true;
		
		}
		return finded;
	}
	
	//Metodo que busca el perosnaje 
	public boolean searchCharacter(String nameCharacter) throws SameObject {
		
		Character1  actual = first;

		boolean finded = false;
		
		
		while(actual!=null && !actual.getName() .equals(nameCharacter)) {
			actual =actual.getNext();
			
		}
		if(actual!=null) {
			
		System.out.println(actual.toString());
		finded=true;
		
		}
		return finded;
	}
	//Responsabilidad para buscar tecnica de un personaje 
	public boolean searchTecnique(String nameCharacter,String nameTec) throws SameObject {
		
		Character1  actual = first;

		boolean finded = false;
		
		
		while(actual!=null && !actual.getName() .equals(nameCharacter)) {
			actual =actual.getNext();
			
		}
		if(actual!=null) {
			
		actual.searchTechnique(nameTec);
		finded=true;
		
		}
		return finded;
	}


	@Override
	public String toString() {
		return "Clan [name=" + name + "]";
	}
	//Metodo de ordenamiento para el personaje 
	public void orderCharacter() {
		int conta = 0;
		Character1 actual = first;
		while(actual != null) {
			Character1 next = actual.getNext();
	while(next != null) {
		if(actual.compare(actual, next) > 0) {
			if(actual.getPrevious() != null) {
				actual.getPrevious().setNext(next);
					}
		if(next.getNext() != null) {
			next.getNext().setPrevious(actual);
			
		}
		actual.setNext(next.getNext());
			next.setPrevious(actual.getPrevious());
				actual.setPrevious(next);
					next.setNext(actual);
					 next = actual.getNext();
				}
		else {
		actual = actual.getNext();
		next = next.getNext();
				}
			} 
	conta++;
	if(conta < longitud()) {
		firtsactual();
		actual = first;
				if(actual.getNext() != null) {
					next = actual.getNext();
				}
			}
			else {
				actual = null;
			}
		}
		firtsactual();
	}
	
	
	
	
	public int longitud() {
		Character1  actual = first;
	
		int contador=0;
		while(actual!=null ) {
			contador++;
			actual =actual.getNext();
			
		}
		return contador;
		
	}
	
	
	public void firtsactual() {
		Character1  actual = first;
		Character1  previos = null;
		while(actual!=null ) {
			previos = actual;
			actual =actual.getNext();
			
		}
		first=previos;
	}
	
	

	
	
	public void  pintar()  {
		
		Character1  actual = first;
		
		
		
		while(actual!=null ) {
			System.out.println(actual.toString()+"\n");
			actual =actual.getNext();
			
		}
		
		System.out.println();
		
		

}
	
	
	
}
