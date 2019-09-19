package test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import model.*;
class testClan {

	
	private Clan clan;
	
	
	
	
	public void setupEscenario() {
		clan = new Clan("");
	}
	
	@Test
	
	public void testaddCharacter(){
		
		setupEscenario();
		
			Character1 lopita = new Character1("Jaime","Fuerte","2018/02/20", 400 ,0.23);
		
				clan.addCharacter(lopita);
		
		
	}
	
	@Test
	
	public void testEqualNameCharacter() {
		setupEscenario();
			Character1 maximus = new Character1("Jaime","Fragil","2018/02/20r",500,3.54);
				clan.addCharacter(maximus);
					assertTrue(clan.equalNameCharacter(maximus)==false);
	}	
	

}
