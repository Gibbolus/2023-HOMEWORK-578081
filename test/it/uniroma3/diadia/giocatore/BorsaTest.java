package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

class BorsaTest {
	
	private Borsa borsa;
	private Attrezzo attrezzo = new Attrezzo("attrezzo", 1);
	private Attrezzo attrezzoPesante = new Attrezzo("attrezzoPesante", 21);
	
	@BeforeEach
	public void setUp() {
		this.borsa = new Borsa();
		
	}
	
	@Test
	void testAddAttrezzo() {
		assertFalse(this.borsa.addAttrezzo(attrezzoPesante));
	}
	
	@Test
	void testGetAttrezzo() {
		this.borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo, this.borsa.getAttrezzo("attrezzo"));
	}

	@Test
	void testGetPeso() {
		this.borsa.addAttrezzo(attrezzo);
		assertEquals(1, this.borsa.getPeso());
	}

	@Test
	void testIsEmpty() {
		assertTrue(borsa.isEmpty());
	}

	@Test
	void testHasAttrezzo() {
		this.borsa.addAttrezzo(attrezzo);
		assertTrue(this.borsa.hasAttrezzo("attrezzo"));
	}

	@Test
	void testRemoveAttrezzo() {
		this.borsa.addAttrezzo(attrezzo);
		assertTrue(this.borsa.removeAttrezzo("attrezzo"));
	}

}
