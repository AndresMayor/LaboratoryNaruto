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
	
	
	public Game() {
		clans = new ArrayList<Clan>();
		
		
		
		
	}

	public ArrayList<Clan> getClans() {
		return clans;
	}



	public void setClans(ArrayList<Clan> clans) {
		this.clans = clans;
	}
	
	
	
	public void  addClan (Clan clan1) throws EqualName {
		if (equalNameCLans(clan1) == false) {
			clans.add(clan1);
			
			
		}else {
		   throw new EqualName();
		}
		
	}
	
	
	
	
public boolean  equalNameCLans (Clan clan1) {
		boolean centinela = false;
		
		for(int i = 0;i<clans.size() && !centinela;i++) {
			if(clans.get(i).getName().equals(clan1.getName())) {
				centinela = true;
			}
			else if (clans.get(i).getName() != clan1.getName()) {
				centinela =false;
				
			}
		}
		return centinela ;
		
	}



public void addCharacter(String name,Character1 character) {
	boolean encont =  false;
	for (int i =0;i<clans.size() && !encont;i++) {
		if (clans.get(i).getName().equals(name)) {
			clans.get(i).addCharacter(character);
			encont=true;
		}
		
	}
	
	
}
//Actualizar Name del clan

	public boolean updateNameClan(String nameClan, String newName) {
		boolean encont =false;
		for (int i =0;i<clans.size() && !encont ;i++) {
			if (clans.get(i).getName().equals(nameClan)) {
				clans.get(i).setName(newName);
				encont=true;
			}
		}
		
		return encont;
		
	}


	public void loadData() throws IOException, ClassNotFoundException {
		try {
			File file = new File(ARCHIVE);
			ObjectInputStream object = new ObjectInputStream(new FileInputStream(file));
			try {
				Clan clan = (Clan)object.readObject();
				while(clan!=null) {
					clans.add(clan);
					clan=(Clan)object.readObject();
					System.out.println(clan.getName());
				}
				object.close();
			}catch(IOException e) {
				object.close();	
			}
		}catch(EOFException e) {
				
		}
			
	}
	
	public void edit() throws IOException {
		new File (ARCHIVE).delete();
		new File (ARCHIVE).createNewFile();
		File filee = new File(ARCHIVE);
		ObjectOutputStream object = new ObjectOutputStream(new FileOutputStream(filee));
		for (int i =0;i<clans.size();i++) {
			object.writeObject(clans.get(i));
		}
		object.close();
	}
	
	public void init () {
		Clan clan = new Clan("The Laker");
		Clan clan1 = new Clan("The Lakr");
		clans.add(clan);
		clans.add(clan1);
	}
	
}