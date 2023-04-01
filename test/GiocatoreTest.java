

import it.uniroma3.diadia.giocatore.Giocatore;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

class GiocatoreTest {
	
	private Giocatore giocatore;
	private int cfu = 20;
	
	@BeforeEach
	private void setUp() {
		this.giocatore = new Giocatore();
		this.giocatore.setCfu(cfu);
	}
	
	@Test
	void testGiocatoreNotNull() {
		assertNotNull(this.giocatore);
	}


	@Test
	void testGetCfu() {
		assertEquals(cfu, this.giocatore.getCfu());
	}

	@Test
	void testSetCfu() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBorsa() {
		fail("Not yet implemented");
	}

}
