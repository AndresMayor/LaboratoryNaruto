package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import model.*;
class testGame {
	
	
	private Game game;


	public void setupEscenario() {
		try {
			game = new Game();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}

	@Test
	public void addClubs() throws SameObject {
		
		try {
			setupEscenario();	
				Clan clan1 = new Clan("The Lakers");
					try {
						game.addClan(clan1);
					} catch (IOException e) {
					
					}
			}
		catch (EqualName e) {	
			e.getMessage();
		}

	}
	
	@Test
	
	
	public void testEqualNAme() throws EqualName {
		setupEscenario();
			Clan clan1 = new Clan("Albert");
				try {
					try {
						game.addClan(clan1);
					} catch (IOException e) {
						
					}
				} catch (SameObject e) {
					e.getMessage();
					
				}
					try {
						assertTrue(game.equalNameCLans("Albert"));
					} catch (SameObject e) {
						e.getMessage();
					}
	}
	@Test
	
	
	
	
	public void testUpdateNameClan()  {
		setupEscenario();
		Clan clan2 = new Clan("Albert");
		
			try {
				try {
					game.addClan(clan2);
				} catch (IOException e) {
					
				}
			} catch (EqualName e) {
				
				e.getMessage();
			} catch (SameObject e) {
				e.getMessage();
			}
			try {
				try {
					game.updateNameClan("Albert", "The clos");
				} catch (IOException e) {
					
				}
			} catch (SameObject e) {
				
				e.getMessage();
			}
			try {
				assertTrue(game.equalNameCLans("The clos"));
			} catch (SameObject e) {
				e.getMessage();
			}
	}
	
	
}
