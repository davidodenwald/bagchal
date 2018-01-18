import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSpielFeld {
	SpielFeld s;

	@BeforeEach
	void setUp() throws Exception {
		s = new SpielFeld();
	}

	@Test
	void testGetZiegenGesetzt() {
		assertEquals(s.getZiegenGesetzt(), 0);
		
		s.setzteZiege(new Position(1, 1));
		assertEquals(s.getZiegenGesetzt(), 1);
	}
	
	@Test
	void testGetZiegenGefressen() {
		assertEquals(s.getZiegenGefressen(), 0);
		
		s.setzteZiege(new Position(0, 1));
		s.bewegeTiger(new Position(0, 0),  new Position(0, 2));
		assertEquals(s.getZiegenGefressen(), 1);
	}
	
	@Test
	void testSetzteZiege() {
		s.setzteZiege(new Position(1, 1));
		assertTrue(s.getZiegen()[0].getPosition().equals(new Position(1, 1)));

		try {
			s.setzteZiege(new Position(0, 0));
			fail();
			
			s.setzteZiege(new Position(2, -1));
			fail();
		} catch (IllegalArgumentException e) {
			// Test passed
		}
	}
	
	@Test
	void bewegeZiege() {
		s.setzteZiege(new Position(1, 1));
		s.bewegeZiege(s.getZiegen()[0].getPosition(), new Position(1, 2));
		
		assertTrue(s.getZiegen()[0].getPosition().equals(new Position(1, 2)));
		
		try {
			s.bewegeZiege(s.getZiegen()[0].getPosition(), new Position(2,3));
			fail();
		} catch (IllegalArgumentException e) {
			// Test passed
		}
	}
	
	@Test
	void testBewegeTiger() {
		s.bewegeTiger(new Position(0, 0), new Position(0, 1));
		assertTrue(s.getTiger()[0].getPosition().equals(new Position(0, 1)));
		
		s.setzteZiege(new Position(0, 2));
		s.bewegeTiger(s.getTiger()[0].getPosition(), new Position(0, 0));
		assertTrue(s.getTiger()[0].getPosition().equals(new Position(0, 0)));
		
		try {
			s.bewegeTiger(s.getTiger()[0].getPosition(), new Position(0, 2));
			fail();
			s.bewegeTiger(s.getTiger()[0].getPosition(), new Position(2, -1));
			fail();
		} catch (IllegalArgumentException e) {
			// Test passed
		}
	}
	
	@Test
	void testTigerGefangen() {
		assertEquals(s.tigerGefangen(), 0);

		s.setzteZiege(new Position(0, 1));
		s.setzteZiege(new Position(0, 2));
		s.setzteZiege(new Position(1, 0));
		s.setzteZiege(new Position(2, 0));
		s.setzteZiege(new Position(1, 1));
		s.setzteZiege(new Position(2, 2));
		assertEquals(s.tigerGefangen(), 1);
	}

}
