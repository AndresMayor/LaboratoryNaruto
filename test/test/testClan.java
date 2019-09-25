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
			Character1 lopita = new Character1("Jaime","Fuerte","2018/02/20", 400 );
				clan.addCharacter(lopita);
		
	
	}
	
	@Test
	public void testEqualNameCharacter() {
		setupEscenario();
			Character1 maximus = new Character1("felipe","Fragil","2018/02/20",500);
				clan.addCharacter(maximus);
					assertTrue(clan.equalNameCharacter(maximus.getName()));
	}	
	
	@Test
	public void testUpdateNameCharacter() {
		setupEscenario();
		Character1 danger = new Character1("richard","fuerte","2018/02/20",500);
		clan.addCharacter(danger);
		clan.updateNameCharacter("richard", "jhonatan");
		assertTrue(clan.equalNameCharacter("jhonatan"));
		
		
	}
	@Test
	public void testEliminateCharacter() {
		setupEscenario();
		Character1 danger = new Character1("richard","fuerte","2018/02/20",500);
		clan.addCharacter(danger);
		try {
			clan.eliminateCharacter("richard");
		} catch (SameObject e) {
			
			e.getMessage();
		}
		
		
		assertTrue(clan.equalNameCharacter("richard")==false);
		
		
	}
	@Test
	public void testOrderNinjas() {
		setupEscenario();
		Character1 a = new Character1("Paolo", "Bravucon", "2019/02/14", 15.0);
		Character1 b = new Character1("Naruto", "Bravucon", "2019/02/14", 2.5);
		Character1 c = new Character1("gfgdgg", "Bravucon", "2019/02/14", 100);
		Character1 d = new Character1("Paogfdbslo", "Bravucon", "2019/02/14", 5);
		
			clan.addCharacter(a);
			clan.addCharacter(b);
			clan.addCharacter(c);
			clan.addCharacter(d);
			
		
		clan.orderCharacter();
		Character1 actual = clan.getCharacters();
		
		while(actual != null) {
			
			if(actual.getNext() != null && actual.getPower() > actual.getNext().getPower()) {
				fail();
			}
			actual = actual.getNext();
		}
	}

}
