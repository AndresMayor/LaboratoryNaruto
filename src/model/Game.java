package model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Game {

	
	private ArrayList<Clan> clans;
	public static final String ARCHIVE ="datas.txt";
	
	
	public Game() throws ClassNotFoundException, IOException {
		clans = new ArrayList<Clan>();
		loadData();
		
		
		
	}

	public ArrayList<Clan> getClans() {
		return clans;
	}



	public void setClans(ArrayList<Clan> clans) {
		this.clans = clans;
	}
	
	
	
	
	
	public boolean  addClan (Clan clan1) throws EqualName, SameObject {
		boolean added=false;
			
				if (!equalNameCLans(clan1.getName())) {
					
					clans.add(clan1);
					
					added=true;
				}
				else {
				   throw new EqualName();
				 
				}
				return added;
			} 
		
		
	
	public void loadData() throws IOException, ClassNotFoundException {
		try {
			File f = new File(ARCHIVE);
			ObjectInputStream o = new ObjectInputStream(new FileInputStream(f));
			clans = (ArrayList<Clan>)o.readObject();
			o.close();
		}catch(EOFException e) {
			
		}
	}
	public void editarArchive() throws IOException {
		File f = new File(ARCHIVE);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(clans);
		oos.close();
	}
	
	//Add tecnica
	
	public boolean addTechnique(String nameClan,String nameCharacter,Technique tecnica ) throws SameObject {
		boolean encont =  false;
		
		for (int i =0;i<clans.size() && !encont;i++) {
			
			if (clans.get(i).getName().equals(nameClan)) {
				
				clans.get(i).addTecnique(nameCharacter, tecnica);
				encont=true;
				
			}
			
		}
		
		
		
		return encont;
		
		
	}
	
	
	public void orderCharacterPower() throws SameObject {
		for (int i = 0; i < clans.size(); i++) {
			clans.get(i).orderCharacter();
			
		}
	}
	
	
	
	
public boolean  equalNameCLans (String nameClan) throws SameObject {
		boolean centinela = false;
		
		for(int i = 0;i<clans.size() && !centinela;i++) {
			if(clans.get(i).getName().equals(nameClan)) {
				centinela = true;
				String msg = "There is already a clan  with that name!";
				throw new SameObject(msg);
				
			}
			
		}
		return centinela ;
		
	}


public boolean addCharacter(String name,Character1 character) throws SameObject{
	boolean encont =  false;
	
	if (!equalCharacter(character)) {
	for (int i =0;i<clans.size() && !encont;i++) {
		
		if (clans.get(i).getName().equals(name)) {
			
			clans.get(i).addCharacter(character);
			
			encont=true;
			
		}
		
	}
	
	
	}
	return encont;
	
	
}

public boolean equalCharacter(Character1 character) throws SameObject {
	boolean encont =false;
	
	for (int i =0;i<clans.size()&& !encont;i++) {
		if(clans.get(i).equalNameCharacter(character.getName())) {
			encont=true;
			
		}
	}
	return encont ;
}

//Actualizar Name del clan

	public boolean updateNameClan(String nameClan, String newName) throws SameObject, IOException {
		boolean encont =false;
		if(!equalNameCLans(newName)) {
			
		
		for (int i =0;i<clans.size() && !encont ;i++) {
			if (clans.get(i).getName().equals(nameClan)) {
				clans.get(i).setName(newName);
				encont=true;
				editarArchive();
				
			}
		}
		}
		
		return encont;
		
	}

	//Responsabilidad de Actualizar nombre del personaje 
	public boolean updateNameCharacter(String nameClan,String newName,String nameCharacter)  {
		boolean centinela = false;
		for (int i =0;i< clans.size() && !centinela;i++) {
			if (clans.get(i).getName().equals(nameClan)) {
				centinela = clans.get(i).updateNameCharacter(nameCharacter, newName);
				
				centinela = true;
			}
		}
		return centinela ;
	}
	
	//Responsabilidad de Actualizar personalidad del  personaje 
	public boolean updatePersonalityCharacter(String nameClan,String namePersonality ,String nameCharacter) throws IOException {
		boolean centinela = false;
		for (int i =0;i< clans.size() && !centinela;i++) {
			if (clans.get(i).getName().equals(nameClan)) {
				centinela = clans.get(i).updatePersonalityCharacter(nameCharacter, namePersonality);
				centinela = true;
				editarArchive();
			}
		}
		return centinela ;
	}
	
	//Responsabilidad de Actualizar fecha de nacimiento  del  personaje 
	
	public boolean updatecrationDateCharacter(String nameClan,String namePersonality ,String nameCharacter) throws IOException {
		boolean centinela = false;
		for (int i =0;i< clans.size() && !centinela;i++) {
			if (clans.get(i).getName().equals(nameClan)) {
				centinela = clans.get(i).updateCreationDateCharacter(nameCharacter, namePersonality);
				centinela = true;
				editarArchive();
			}
		}
		return centinela ;
	}
	
	//Responsabilidad de Actualizar el poder  del  personaje 
	
	public boolean updatePowerCharacter(String nameClan,double newPower ,String nameCharacter) throws IOException {
		boolean centinela = false;
		for (int i =0;i< clans.size() && !centinela;i++) {
			if (clans.get(i).getName().equals(nameClan)) {
				centinela = clans.get(i).updatePowerCharacter(nameCharacter, newPower);
				centinela = true;
				editarArchive();
			}
		}
		return centinela ;
	}
	
	
	
	//FALTA CONECTARLO AL MAIN
	
	
	//Actualiza el el factor de la tecnica 
	public boolean updateFactorTeccCharacter(String nameClan,double newFactor ,String nameCharacter,String nameTec) throws IOException {
		boolean centinela = false;
		for (int i =0;i< clans.size() && !centinela;i++) {
			if (clans.get(i).getName().equals(nameClan)) {
				centinela = clans.get(i).updateFactorCharacter(nameCharacter, newFactor, nameTec);
				centinela = true;
				editarArchive();
			}
		}
		return centinela ;
	}
	

	//FALTA CONECTARLO AL MAIN
	
	//Responsabilidad para cambiar el nombre de la Tecnica 

	
	public boolean updateNameTeccCharacter(String nameClan,String newNameTec ,String nameCharacter,String nameTec) throws IOException {
		boolean centinela = false;
		for (int i =0;i< clans.size() && !centinela;i++) {
			if (clans.get(i).getName().equals(nameClan)) {
				centinela = clans.get(i).updateNameTecCharacter(nameCharacter, newNameTec, nameTec);
				centinela = true;
				editarArchive();
			}
		}
		return centinela ;
	}
	
	
	// METODOS PARA ELIMINAR 
	
			public boolean eliminateClan(String clan) {
				boolean eliminado = false;
				for (int i = 0;i<clans.size() && !eliminado ; i++) {
					if(clans.get(i).getName().equals(clan)) {
						clans.remove(i);
						eliminado = true;
						
						
					}
									}
				return eliminado;
				
			}
	
	//Eliminate character 
			
			public boolean deleteCharacter(String nameClan,String nameCharacter) throws SameObject, IOException {
				boolean finded = false;
				for (int i =0;i<clans.size() && !finded ; i++) {
					if (clans.get(i).getName().equals(nameClan)) {
						clans.get(i).eliminateCharacter(nameCharacter);
						finded = true;
						editarArchive();
					}
				}
				return finded;
			}
		//Eliminate Tecnique 
			
			public boolean eliminateTec(String nameClan,String nameCharacter ,String nameTec) throws SameObject, IOException {
				boolean centinela = false;
				for (int i =0;i< clans.size() && !centinela;i++) {
					if (clans.get(i).getName().equals(nameClan)) {
						centinela = clans.get(i).eliminateTec(nameCharacter, nameTec);
						centinela = true;
						editarArchive();
						
						
					}
				}
				return centinela ;
			}
	
			
			
			
			
			
			
			@Override
			public String toString() {
				return "Game [clans=" + clans + "]";
			}

			
			public Clan  searchClan (String nameClan)  {
				boolean centinela = false;
			   Clan e =null;
				
				for (int i =0;i< clans.size() && !centinela;i++) {
					
					if (clans.get(i).getName().equals(nameClan)) {
						e=clans.get(i);
						centinela=true;
					}
					}
				
				return e;
			}
			
	//Responsabilidad para buscar personaje 
			public boolean  searchCharacter (String nameClan,String nameCharacter) throws SameObject {
				boolean centinela = false;
			
				
				for (int i =0;i< clans.size() && !centinela;i++) {
					if (clans.get(i).getName().equals(nameClan)) {
						centinela = clans.get(i).searchCharacter(nameCharacter);
						
					}
				}
				return centinela;
			}
			
			//Responsabilidad para buscar tecnica 
			public boolean  searchTec (String nameClan,String nameCharacter,String nameTec) throws SameObject {
				boolean centinela = false;
			
				
				for (int i =0;i< clans.size() && !centinela;i++) {
					if (clans.get(i).getName().equals(nameClan)) {
						clans.get(i).searchTecnique(nameCharacter, nameTec);
						centinela=true;
					}
				}
				return centinela;
			}

	
	//Metodo para Ordenar 
	public void orderClansNames() {
		for (int i = 0; i < clans.size()-1; i++) {
			Clan menor = clans.get(i);
			int cual = i;
			for (int j = i+1; j < clans.size(); j++) {
				if(clans.get(j).compareName(menor)<0) {
					menor = clans.get(j);
					cual = j;
				}
				
			}
			Clan tmp = clans.get(i);
			clans.set(i, menor);
			clans.set(cual, tmp);
		}
	}
	public boolean  clans() {
		boolean finded =false ;
		for (int i=0;i<clans.size();i++) {
			System.out.println(clans.get(i).toString());
			finded =true ;
		}
		return finded;
	}
	
	
	public void init () throws IOException {
		Clan clan = new Clan("The Laker");
		Clan clan1 = new Clan("-");
		Character1 lopita = new Character1("Andres","Fuerte","2018/02/20", 400 );
		clans.add(clan);
		clans.add(clan1);
		Technique tec = new Technique("lupito",40);
		//addTechnique(String nameClan,String nameCharacter,Technique tecnica 
		try {
			addTechnique("The Laker","Andres",tec);
		} catch (SameObject e1) {
			
			e1.getMessage();
		}
		try {
			addCharacter("The Laker", lopita);
		} catch (SameObject e) {
		
			
		}
		
	}
	
}