package ui;
import model.*;
import java.util.Scanner;

public class Main {

	
	
	private Game user;
	private Scanner reader;
	
	
	
	public Main () {
		user = new Game();
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
		while(option != 4){
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println( "1.Add Objectp (Clan,Character,Technique)" );
		System.out.println( "2.");
		System.out.println( "3.");
		System.out.println( "4.Exit");
		
		option =reader.nextInt();
		reader.nextLine();
				
		switch(option) {
		case(1):
			addObject();
		break;
		
		case(2):
		
		break;
		
		case(3):
			
		break;
		
				
			}	
		
		}
	}
	
	
	public void addObject() {
		
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
				user.addClan(clan1);
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
		System.out.println("Character's date of birth AAAA/MM/DD:");
		String  crationDate = reader.nextLine();
		System.out.println("Enter power:");
		double  power = reader.nextDouble();
		reader.nextLine();
		System.out.println("Score of the character:");
		double score =reader.nextDouble();
		reader.nextLine();
		
		Character1 character = new Character1(nameCharacter,personality,crationDate,power,score);
		user.addCharacter(nameClan, character);
		
		
		
		
		
		
		
			
			
		}
		
		
		
		
	}
	
	public void init () {
		user.init();
	}
	
}
