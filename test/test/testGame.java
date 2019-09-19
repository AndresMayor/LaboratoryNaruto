package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.*;
class testGame {
	
	
	private Game game;


	public void setupEscenario() {
		game = new Game();
	
		}

	@Test
	public void addClubs() {
		
		try {
			setupEscenario();	
				Clan clan1 = new Clan("The Lakers");
					game.addClan(clan1);
			}
		catch (EqualName e) {	
			e.getMessage();
		}

	}
	
	@Test
	
	
	public void testEqualNAme() throws EqualName {
		setupEscenario();
			Clan clan1 = new Clan("Albert");
				game.addClan(clan1);
					Clan clan2 = new Clan("Albert");
						assertTrue(game.equalNameCLans(clan2)==true);
	}
	
	
}
