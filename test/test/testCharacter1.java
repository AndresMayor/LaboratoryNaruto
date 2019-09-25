package test;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import model.*;
public class testCharacter1 {

	
	private Character1 character;
	
	public void setupEscenario() {
		character = new Character1("Andres","Fuerte","2018/02/20", 400);
	
		}


	
	@Test
	
	public void testEliminateTechnique() {
		setupEscenario();
	
		
		Technique tec = new Technique("lupito",40);
		character.addTechniques(tec);
		try {
			character.eliminateTechnique("lupito");
		} catch (SameObject e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		assertTrue(character.equalNameTechnique("lupito")==false);
	}
	
	@Test
	public void testSearchTechnique() {
		setupEscenario();
		Technique tec = new Technique("maxx",100);
		character.addTechniques(tec);
		
		try {
			character.searchTechnique("maxx");
		} catch (SameObject e) {
			// TODO Auto-generated catch block
			e.getMessage();
			
		}
		
		
		
	}
	@Test
	public void testupdateFacor() {
		setupEscenario();
		Technique tec = new Technique("lupito",40);
		character.addTechniques(tec);
		
		
		character.updateFactorCharacter("lupito",50);
		
		
		assertTrue(character.getFirst().getFactor()==50);
		
	}
	
	
	
}
