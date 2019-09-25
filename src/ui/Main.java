package ui;
import model.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	
	
	private Game user;
	private Scanner reader;
	
	
	
	public Main () {
		try {
			user = new Game();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		reader = new Scanner(System.in);
	}
	
	public static void main(String []args) {
		Main m = new Main();
		m.init();
		m.welcome();
		m.showMenu();
		
	}
	public void welcome(){
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("|                             WELCOME TO THE GAME                                            |");
	}
	
	public void showMenu() {
		
		int option = 0;
		while(option != 6){
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println( "1.Add    Object    (Clan,Character,Technique)" );
		System.out.println( "2.Udate  Object    (Clan,Character,Technique)");
		System.out.println( "3.Delete Object    (Clan,Character,Technique)");
		System.out.println( "4.Search Object    (Clan,Character,Technique)");
		System.out.println( "5.Order  Object    (Clan,Character,Technique)");
		System.out.println( "6.Exit. ");
		option =reader.nextInt();
		reader.nextLine();
				
		switch(option) {
		case(1):
			
			try {
				addObject();
			} catch (SameObject e) {
				
				System.out.println(e.getMessage());
			}
		
		break;
		
		case(2):
			
			updateObject();
		
		break;
		
		case(3):
			
			eliminateObject();
		
		break;
		
		case(4):
			
			searchObject();
		
		break;
		
		case(5):
			orderObject();
		break;
		
				
			}	
		
		}
	}

	
	public void addObject() throws SameObject {
		
		System.out.println( "Please select the object you want to add. " );
		System.out.println( "1.Clan ");
		System.out.println( "2.Character ");
		System.out.println( "3.Technique ");
		int options = reader.nextInt();
		reader.nextLine();
		if (options==1) {
			System.out.println("Enter Clan Name");
			String name = reader.nextLine();
			Clan clan1 = new Clan(name);
			
			try {
				try {
					user.addClan(clan1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("The clan was successfully added");
				
			} catch (EqualName e) {	
			System.out.println(	e.getMessage());
			}
			
		}
		else if(options==2) {
			//String name, String personality, String creationDate, double power, double score)
		System.out.println("Type the name of the clan to which you want to add the character");
		String nameClan = reader.nextLine();
		System.out.println("Enter Character Data:");
		System.out.println("Character's name");
		String nameCharacter = reader.nextLine();
		System.out.println("Enter the character's perosnality");
		String personality = reader.nextLine();
		System.out.println("Enter the character creation date AAAA/MM/DD:");
		String  crationDate = reader.nextLine();
		System.out.println("Enter power:");
		double  power = reader.nextDouble();
		reader.nextLine();
		
		
		Character1 character = new Character1(nameCharacter,personality,crationDate,power);
		try {
			try {
				System.out.println( user.addCharacter(nameClan, character));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		} catch (SameObject e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
			
			
		}else if(options==3) {
			
			
			System.out.println("Enter the name of the clan to which the character belongs:");
			String nameClan = reader.nextLine();
			System.out.println("Enter character name: ");
			String nameCharacter = reader.nextLine();
			System.out.println("Enter the name of the technique you want to add");
			String nameTec = reader.nextLine();
			System.out.println("Enter the technical factor: ");
			double factor  = reader.nextDouble();
			reader.nextLine();
			
			Technique tecnica = new Technique (nameTec,factor);
			
			
			try {
				System.out.println(user.addTechnique(nameClan, nameCharacter, tecnica));
			} catch (IOException e) {
			
			}
			
			
			
			
			
		}
		
		
		
		
	}
	public void updateObject() {
	System.out.println("Type the name of the clan to which you want to add the character");
	System.out.println( "1.Clan ");
	System.out.println( "2.Character ");
	System.out.println( "3.Technique ");
	int options = reader.nextInt();
	reader.nextLine();
	if (options == 1) {
		System.out.println("please enter the clan name");
		String nameClan = reader.nextLine();
		System.out.println("please enter the new clan name");
		String newName = reader.nextLine();
		try {
			try {
				System.out.println(user.updateNameClan(nameClan, newName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		} catch (SameObject e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}else if (options==2) {
		
		System.out.println("Enter the criteria by which you want to update the character");
		System.out.println( "1.Name ");
		System.out.println( "2.Personality ");
		System.out.println( "3.creation Date ");
		System.out.println( "4.Power ");
		
		int option = reader.nextInt();
		reader.nextLine();
		
		if(option == 1) {
			
			System.out.println("Enter the name of the clan to which the character belongs: ");
			String nameClan = reader.nextLine();
			System.out.println("Enter character name:");
			String nameCharacter = reader.nextLine();
			System.out.println("Please enter the new character name: ");
			String newNameCharacter = reader.nextLine();
			try {
				System.out.println(user.updateNameCharacter(nameClan, newNameCharacter, nameCharacter));
			} catch (IOException e) {
				
			}
			
			
		}else if (option==2) {
			
			System.out.println("Enter the name of the clan to which the character belongs: ");
			String nameClan = reader.nextLine();
			System.out.println("Enter character name: ");
			String nameCharacter = reader.nextLine();
			System.out.println("Enter the character's new personality");
			String newPersonality = reader.nextLine();
			try {
				System.out.println(user.updatePersonalityCharacter(nameClan, newPersonality, nameCharacter));
			} catch (IOException e) {

			}
		
			
			
			
		}else if(option ==3) {
			
			System.out.println("Enter the name of the clan to which the character belongs: ");
			String nameClan = reader.nextLine();
			System.out.println("Enter character name: ");
			String nameCharacter = reader.nextLine();
			System.out.println("Enter the new character creation date AAAA/MM/DD:");
			String newCreationDate = reader.nextLine();
			try {
				System.out.println(user.updatecrationDateCharacter(nameClan, newCreationDate, nameCharacter));
			} catch (IOException e) {
				e.getMessage();
			}
			
			
		}else if (option ==4) {
			System.out.println("Enter the name of the clan to which the character belongs: ");
			String nameClan = reader.nextLine();
			System.out.println("Enter character name: ");
			String nameCharacter = reader.nextLine();
			System.out.println("Enter the new character power");
			double  newPower = reader.nextDouble();
			reader.nextLine();
			try {
				System.out.println(user.updatePowerCharacter(nameClan,newPower, nameCharacter));
			} catch (IOException e) {
				
				e.getMessage();
			}
			
		}
		
		
		
		
		
	}else if (options==3) {
	System.out.println("Select the criteria by which you want to modify the technique");
	System.out.println( "1.Name of the technique ");
	System.out.println( "2.Factor ");
	int optionss=reader.nextInt();
	reader.hasNextLine();
	if (optionss ==1) {
		System.out.println("Enter the name of the clan to which the character belongs: ");
		String nameClan = reader.nextLine();
		System.out.println("Enter character name: ");
		String nameCharacter = reader.nextLine();
		System.out.println("Enter the name of the technique you want to modify:");
		String nameTec = reader.nextLine();
		System.out.println("enter the new technique name: ");
		String newNameTec = reader.nextLine();
		
		System.out.println(user.updateNameTeccCharacter(nameClan, newNameTec, nameCharacter, nameTec));
	}else if (optionss ==2 ) {
		System.out.println("Enter the name of the clan to which the character belongs: ");
		String nameClan = reader.nextLine();
		System.out.println("Enter character name: ");
		String nameCharacter = reader.nextLine();
		System.out.println("Enter the FACTOR of the technique you want to modify:");
		String nameTec = reader.nextLine();
		System.out.println("enter the new technique FACTOR: ");
		String newFactor = reader.nextLine();
		
		System.out.println(user.updateNameTeccCharacter(nameClan, newFactor, nameCharacter, nameTec));
	}
	}
		
	}
	
	
	
	
	public void eliminateObject() {
		System.out.println("Select the Object you want to delate: ");
		System.out.println( "1.Clan ");
		System.out.println( "2.Character ");
		System.out.println( "3.Technique ");
		int options = reader.nextInt();
		reader.nextLine();
		if (options ==1) {
			System.out.println("Enter the name of the clan you want to delete: ");
			String nameClan= reader.nextLine();
			try {
				System.out.println(user.eliminateClan(nameClan));
			} catch (SameObject e) {
				
				System.out.println(e.getMessage());
			}
		}else if(options ==2) {
			System.out.println("Enter the name of the clan to which the character belongs");
			String nameClan = reader.nextLine();
			System.out.println("Enter the name if the character you want to delete");
			String nameCharacter=reader.nextLine();
			try {
				System.out.println(user.deleteCharacter(nameClan, nameCharacter));
			} catch (SameObject e) {
				
				System.out.println(e.getMessage());
			}
			
		}else if (options==3) {
			System.out.println("Enter the clan to which the character belongs:");
			String nameClan = reader.nextLine();
			System.out.println("Enter the name of the character who wants to remove the technique");
			String nameCgaracter = reader.nextLine();
			System.out.println("Enter the name of the technique you want to delete");
			String nameTec = reader.nextLine();
			
			try {
				System.out.println(user.eliminateTec(nameClan, nameCgaracter, nameTec));
			} catch (SameObject e) {
				
				System.out.println(e.getMessage());
			}
			
		}
	}
	
	
	
	
	public void searchObject() {
		System.out.println("Select the type of object you want to search" );
		System.out.println( "1.Clan ");
		System.out.println( "2.Character ");
		System.out.println( "3.Technique ");
		int options =reader.nextInt();
		reader.nextLine();
		if (options==1) {
			System.out.println("Enter clan name:");
			String nameClan = reader.nextLine();
			try {
				System.out.println(user.searchClan(nameClan));
			} catch (SameObject e) {
				
				System.out.println(e.getMessage());
			}
			
		}else if (options ==2) {
			System.out.println("Enter the name of the clan to which the character belongs: ");
			String nameClan = reader.nextLine();
			System.out.println("enter the name of the character you want to search");
			String nameCharacter = reader.nextLine();
			try {
				System.out.println(user.searchCharacter(nameClan, nameCharacter));
			} catch (SameObject e) {
				
				System.out.println(e.getMessage());
			}
		}else if (options ==3) {

			System.out.println("Enter the name of the clan to which the character belongs");
			String nameCLan = reader.nextLine();
			System.out.println("Enter the name of the character to whom you want to find the technique");
			String nameCharacter = reader.nextLine();
			System.out.println("Enter the name of the technique you want to search:");
			String nameTec = reader.nextLine();
			try {
				System.out.println(user.searchTec(nameCLan, nameCharacter, nameTec));
			} catch (SameObject e) {
				
				System.out.println(e.getMessage());
			}
			
		}
		
	}
	
	
	public void orderObject() {
		
		System.out.println("Select the object you want to order" );
		System.out.println( "1.Clan      (only sorted by name) ");
		System.out.println( "2.Character (only sorted by power) ");
		
		int option = reader.nextInt();
		reader.nextLine();
		if(option==1) {
			user.orderClansNames();
			for (int i = 0; i <user.getClans().size(); i++) {
				System.out.println(user.getClans().get(i).toString());
				
				
			}
		}else if(option==2) {
			
				try {
					user.orderCharacterPower();
				} catch (SameObject e) {
					
					e.printStackTrace();
				}
			
			for (int i = 0; i < user.getClans().size(); i++) {
				user.getClans().get(i).pintar();
			}
		
		}
		
	}
	
	
	public void init () {
		try {
			user.init();
		} catch (IOException e) {
			
		}
	}
	
}
