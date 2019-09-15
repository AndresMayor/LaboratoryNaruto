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
		m.welcome();
		
	}
	public void welcome(){
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("|                             WELCOME TO THE GAME                                      |");
	}
	
	public void showMenu() {
		
		int option = 0;
		while(option != 4){
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("1.");
		System.out.println("2.");
		System.out.println("3.");
		System.out.println("4.Exit");
		
		option =reader.nextInt();
		reader.nextLine();
				
		switch(option) {
		case(1):
				
		break;
		
		case(2):
			
		break;
		
		case(3):
			
		break;
		
				
		}
		
		
		
		
		}
	}
	
}
